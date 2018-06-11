/**
 * 
 */
package com.example.demo.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.common.SendEMailUtil;



/**
 * @author Stronger
 * 执行循环调用的任务
 */
public class LoopJob implements BaseJob{
	 private static Logger _log = LoggerFactory.getLogger(LoopJob.class);  
	/* (non-Javadoc)
	 * @see com.example.demo.job.BaseJob#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		_log.info(context.getJobDetail().getDescription());
		_log.info(context.getJobDetail().getKey().getGroup());
		SendEMailUtil test =new SendEMailUtil();
		 try {
			test.sendTextMail(context.getJobDetail().getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 _log.error("Hello Job执行时间: " + new Date());  
	}
	public LoopJob() {  

    }  
 

}
