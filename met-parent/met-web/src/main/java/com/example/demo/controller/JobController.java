package com.example.demo.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.entity.JobAndTrigger;
import com.example.demo.job.BaseJob;
import com.example.demo.service.IJobAndTriggerService;
import com.github.pagehelper.PageInfo;


@RestController
@RequestMapping(value="/job")
public class JobController 
{
    @Autowired
    private IJobAndTriggerService JobAndTriggerService;

    //加入Qulifier注解，通过名称注入bean
    @Autowired 
    @Qualifier("Scheduler")
    private Scheduler scheduler;
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    private static Logger log = LoggerFactory.getLogger(JobController.class);  


    @PostMapping(value="/addjob")
    public void addjob(@RequestParam(value="jobClassName")String jobClassName, 
            @RequestParam(value="jobGroupName")String jobGroupName, 
            @RequestParam(value="jobDescription",required=false)String jobDescription, 
            @RequestParam(value="dataKey",required=false)String dataKey, 
            @RequestParam(value="value",required=false)String value, 
            @RequestParam(value="cronExpression")String cronExpression) throws Exception
    {     
    	if(!StringUtils.isEmpty(dataKey))
    	{
    		addJob(jobClassName, jobGroupName, cronExpression,jobDescription,dataKey,value);
    		log.info("addJob:"+jobClassName+"-"+jobGroupName+"###"+dataKey);
    	}
    	else{
    		addJob(jobClassName, jobGroupName, cronExpression,jobDescription);
    		log.info("addJob:"+jobClassName+"-"+jobGroupName);
    	}
    }

      
    /**     
     * @discription 在此输入一句话描述作用
     * @author jizhuang.wang       
     * @created 2018年5月30日 下午1:37:46     
     * @param jobClassName
     * @param jobGroupName
     * @param cronExpression
     * @throws Exception     
     */
    public void addJob(String jobClassName, String jobGroupName, String cronExpression)throws Exception{

        // 启动调度器  
        scheduler.start(); 

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass()).withIdentity(jobClassName, jobGroupName).build();

        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
            .withSchedule(scheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
        	log.error("创建定时任务失败"+e);
            throw new Exception("创建定时任务失败");
        }
    }
      
    /**     
     * @discription 在此输入一句话描述作用
     * @author jizhuang.wang       
     * @created 2018年5月30日 下午1:37:38     
     * @param jobClassName
     * @param jobGroupName
     * @param cronExpression
     * @param jobDescription
     * @throws Exception     
     */
    public void addJob(String jobClassName, String jobGroupName, String cronExpression,String jobDescription)throws Exception{

        // 启动调度器  
        scheduler.start(); 

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass())
        		.withIdentity(jobClassName, jobGroupName)
        		.withDescription(jobDescription)
        		.build();

        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
            .withSchedule(scheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败"+e);
            throw new Exception("创建定时任务失败");
        }
    }
    
      
    /**     
     * @discription 在此输入一句话描述作用
     * @author jizhuang.wang       
     * @created 2018年5月30日 下午1:42:57     
     * @param jobClassName
     * @param jobGroupName
     * @param cronExpression
     * @param jobDescription
     * @param key
     * @param value
     * @throws Exception     
     */
    public void addJob(String jobClassName, String jobGroupName, String cronExpression,String jobDescription,String dataKey,String value)throws Exception{

        // 启动调度器  
        scheduler.start(); 

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass())
        		.withIdentity(jobClassName, jobGroupName)
        		.withDescription(jobDescription)
        		.usingJobData(dataKey, value)
        		.build();

        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
            .withSchedule(scheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败"+e);
            throw new Exception("创建定时任务失败");
        }
    }

    @PostMapping(value="/pausejob")
    public void pausejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception
    {           
        jobPause(jobClassName, jobGroupName);
    }

    public void jobPause(String jobClassName, String jobGroupName) throws Exception
    {   
        scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
    }


    @PostMapping(value="/resumejob")
    public void resumejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception
    {           
        jobresume(jobClassName, jobGroupName);
    }

    public void jobresume(String jobClassName, String jobGroupName) throws Exception
    {
        scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
    }


    @PostMapping(value="/reschedulejob")
    public void rescheduleJob(@RequestParam(value="jobClassName")String jobClassName, 
            @RequestParam(value="jobGroupName")String jobGroupName,
            @RequestParam(value="cronExpression")String cronExpression) throws Exception
    {           
        jobreschedule(jobClassName, jobGroupName, cronExpression);
    }

    public void jobreschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception
    {               
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
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

    @PostMapping(value="/deletejob")
    public void deletejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception
    {           
        jobdelete(jobClassName, jobGroupName);
    }

    public void jobdelete(String jobClassName, String jobGroupName) throws Exception
    {       
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
        scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));             
    }


    @GetMapping(value="/queryjob")
    public Map<String, Object> queryjob(@RequestParam(value="pageNum")Integer pageNum, @RequestParam(value="pageSize")Integer pageSize) 
    {           
        PageInfo<JobAndTrigger> jobAndTrigger = JobAndTriggerService.getJobAndTriggerDetails(pageNum, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("JobAndTrigger", jobAndTrigger);
        map.put("number", jobAndTrigger.getTotal());
        return map;
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
