/**
 * 
 */
package com.example.demo.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

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
		 _log.error("Hello Job执行时间: " + new Date());  
	}
	public LoopJob() {  

    }  
 

}
