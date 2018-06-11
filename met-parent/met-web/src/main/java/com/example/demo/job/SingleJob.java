/**
 * 
 */
package com.example.demo.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.common.SendSMSUtil;
import com.example.demo.entity.HisJob;
import com.example.demo.test.CommonsEmailTest;
import com.example.demo.utils.JdbcUtil;

/**
 * @author Stronger
 * 只执行一次的任务
 */
public class SingleJob implements BaseJob{
	private static Logger _log = LoggerFactory.getLogger(SingleJob.class);  
    
	public SingleJob() {  

    }  

    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
    	JobDetail jobDetail = context.getJobDetail();
    	HisJob hisJob = new HisJob();
    	hisJob.setJOB_NAME(jobDetail.getKey().getName());
    	hisJob.setJOB_GROUP(jobDetail.getKey().getGroup());
    	hisJob.setDESCRIPTION(jobDetail.getDescription());
    	Persistence(hisJob);
		 SendSMSUtil.sendSms("17667848667");
        _log.error("New Job执行时间: " + new Date());  

    }  
    
    /**     
	 * @discription 统计结果持久化到数据库
	 * @author jizhuang.wang       
	 * @created 2017年10月10日 下午1:34:17     
	 * @param row     
	 */
	public static void Persistence(HisJob row) {
		JdbcUtil jdbcUtil = null;
		String sql = "INSERT INTO TB_HISJOB(JOB_NAME,JOB_GROUP,JOB_CLASS_NAME,DESCRIPTION) VALUES(?,?,?,?);";
		jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection(); // 获取数据库链接
		try {
			// 创建填充参数的list
			List<Object> paramList = new ArrayList<Object>();
			// 填充参数
			paramList.add(row.getJOB_NAME());
			paramList.add(row.getJOB_GROUP());
			paramList.add(row.getJOB_CLASS_NAME());
			paramList.add(row.getDESCRIPTION());
			// UTC时间（8位）统一进行存储
			jdbcUtil.updateByPreparedStatement(sql, paramList);
			_log.info("---hisjob:save ---操作成功!----"); 
		} catch (Exception e) {
			_log.error("-----hisjob:save ---操作抛出异常!" + e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
	}
}
