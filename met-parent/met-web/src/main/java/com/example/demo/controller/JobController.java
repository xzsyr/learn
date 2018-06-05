package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.dto.JobDTO;
import com.example.demo.entity.Group;
import com.example.demo.entity.JobAndTrigger;
import com.example.demo.job.BaseJob;
import com.example.demo.service.IGroupService;
import com.example.demo.service.IJobAndTriggerService;
import com.example.demo.service.IUserService;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.QuartzCronDateUtils;
import com.example.demo.utils.SerialNumberUtils;
import com.github.pagehelper.PageInfo;


@RestController
@RequestMapping(value="/job")
public class JobController 
{
    @Autowired
    private IJobAndTriggerService JobAndTriggerService;
    @Autowired
	private IGroupService groupService;
    @Autowired
	private IUserService userService;
    static String jobClassName = "com.example.demo.job.LoopJob";
    //加入Qulifier注解，通过名称注入bean
    @Autowired 
    @Qualifier("Scheduler")
    private Scheduler scheduler;
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    private static Logger log = LoggerFactory.getLogger(JobController.class);  

    /**
     * 任务列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value="/queryjob")
    public Map<String, Object> queryjob(JobDTO jobDto,@RequestParam(value="pageNum")Integer pageNum, @RequestParam(value="pageSize")Integer pageSize) 
    {           
        PageInfo<JobAndTrigger> jobAndTrigger = JobAndTriggerService.getJobs(jobDto,pageNum, pageSize);
        List<JobDTO> jobs = new ArrayList<JobDTO>();
        PageInfo<Group> groups = groupService.getGroups(1, 100);
        Map<String, Object> map = new HashMap<String, Object>();
        JobDTO jb = null;
        for(JobAndTrigger job:jobAndTrigger.getList()){
        	jb = new JobDTO();
        	//任务名称
        	jb.setJobName(job.getJOB_NAME());
        	//所属组
    		Group group = groupService.getGroupById(Integer.parseInt(job.getJOB_GROUP()));
        	jb.setJobGroupId(job.getJOB_GROUP());
        	jb.setJobGroupName(null!=group?group.getGNAME():job.getJOB_GROUP());
        	//组成员
        	String[] jobName =job.getJOB_NAME().split("_");
    		int uid = Integer.parseInt(jobName[1]);
        	jb.setJobUserId(job.getJOB_NAME().split("_")[1]);
        	jb.setJobUserName(userService.getUserById(uid).getUNAME());
        	//执行时间
        	jb.setCronExpression(job.getCRON_EXPRESSION());
        	//描述
        	jb.setJobDescription(job.getDESCRIPTION());
        	//时区
        	jb.setTimeZoneId(job.getTIME_ZONE_ID());
        	jb.setTriggerState(job.getTRIGGER_STATE());
        	jobs.add(jb);
        }
        map.put("Jobs", jobs);
        map.put("category", groups.getList());
        map.put("number", jobAndTrigger.getTotal());
        return map;
    }
    
    /**
     * 添加任务
     * @param jobGroupName 组名
     * @param jobUserName 用户名称
     * @param jobDescription 任务描述
     * @param cronExpression 任务触发规则
     * @throws Exception
     */
    @PostMapping(value="/addjobExt")
    public void addjobExt(@RequestParam(value="jobName")String jobName,
    		@RequestParam(value="jobGroupName")String jobGroupName, 
            @RequestParam(value="jobUserName")String jobUserName, 
            @RequestParam(value="jobDescription",required=false)String jobDescription, 
            @RequestParam(value="cronExpression")String cronExpression) throws Exception
    {     
    	 
    		addJobExt(jobName,jobGroupName, jobUserName,cronExpression,jobDescription);
    		log.info("addJobExt:"+jobGroupName+"-"+jobUserName);
    }
      
      
    /**     
     * @discription 在此输入一句话描述作用
     * @author jizhuang.wang       
     * @created 2018年5月30日 下午1:42:57     
     * @param jobGroupName
     * @param jobUserName
     * @param cronExpression
     * @param jobDescription
     * @param key
     * @param value
     * @throws Exception     
     */
    public void addJobExt(String jobName,String jobGroupName, String jobUserName,String cronExpression,String jobDescription)throws Exception{
        // 启动调度器  
        scheduler.start(); 
        //重置任务用户
        jobName = jobName+"_"+jobUserName+"_"+SerialNumberUtils.Getnum();
        if(!cronExpression.contains("?")&&!cronExpression.contains("*")){
        	jobClassName ="com.example.demo.job.SingleJob";
        	cronExpression = QuartzCronDateUtils.getCron(DateUtils.stringToDate(cronExpression, DateUtils.DATE_TO_STRING_DETAIAL_PATTERN));
        }
        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass())
        		.withIdentity(jobName,jobGroupName)
        		.withDescription(jobDescription)
        		.build();
        
        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName,jobGroupName)
            .withSchedule(scheduleBuilder).build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败"+e);
            throw new Exception("创建定时任务失败");
        }
    }

    /**
     * 暂停任务
     * @param jobName
     * @param jobGroupName
     * @throws Exception
     */
    @PostMapping(value="/pausejob")
    public void pausejob(@RequestParam(value="jobName")String jobName, 
    		@RequestParam(value="jobGroupName")String jobGroupName) throws Exception
    {           
        jobPause(jobName, jobGroupName);
    }

    public void jobPause(String jobName, String jobGroupName) throws Exception
    {   
        scheduler.pauseJob(JobKey.jobKey(jobName, jobGroupName));
    }


    /**
     * 恢复任务
     * @param jobName
     * @param jobGroupName
     * @throws Exception
     */
    @PostMapping(value="/resumejob")
    public void resumejob(@RequestParam(value="jobName")String jobName, 
    		@RequestParam(value="jobGroupName")String jobGroupName) throws Exception
    {           
        jobresume(jobName, jobGroupName);
    }

    public void jobresume(String jobName, String jobGroupName) throws Exception
    {
        scheduler.resumeJob(JobKey.jobKey(jobName, jobGroupName));
    }


    /**
     * 编辑任务
     * @param jobName
     * @param jobGroupName
     * @param cronExpression
     * @throws Exception
     */
    @PostMapping(value="/reschedulejob")
    public void rescheduleJob(@RequestParam(value="jobName")String jobName, 
            @RequestParam(value="jobGroupName")String jobGroupName,
            @RequestParam(value="cronExpression")String cronExpression) throws Exception
    {           
        jobreschedule(jobName, jobGroupName, cronExpression);
    }

    public void jobreschedule(String jobName, String jobGroupName, String cronExpression) throws Exception
    {               
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            System.out.println("更新定时任务失败"+e);
            throw new Exception("更新定时任务失败");
        }
    }

    /**
     * 删除任务
     * @param jobName
     * @param jobGroupName
     * @throws Exception
     */
    @PostMapping(value="/deletejob")
    public void deletejob(@RequestParam(value="jobName")String jobName, 
    		@RequestParam(value="jobGroupName")String jobGroupName) throws Exception
    {           
        jobdelete(jobName, jobGroupName);
    }

    public void jobdelete(String jobName, String jobGroupName) throws Exception
    {       
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, jobGroupName));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, jobGroupName));
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));             
    }

   
    /** 
     *  
     * 功能：启动所有定时任务 
     */  
    public static void startAllJobs() {  
        try {  
            Scheduler scheduler = schedulerFactory.getScheduler();  
            scheduler.start();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
    
    /** 
     * 功能：关闭所有定时任务 
     */  
    public static void shutdownAllJobs() {  
        try {  
            Scheduler scheduler = schedulerFactory.getScheduler();  
            if (!scheduler.isShutdown()) {  
                scheduler.shutdown();  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    } 
    
    public static BaseJob getClass(String classname) throws Exception 
    {
        Class<?> class1 = Class.forName(classname);
        return (BaseJob)class1.newInstance();
    }


}
