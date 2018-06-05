package com.example.demo.service;


import com.example.demo.dto.JobDTO;
import com.example.demo.entity.JobAndTrigger;
import com.github.pagehelper.PageInfo;

public interface IJobAndTriggerService {
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);

	/**
	 * @param jobDto
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<JobAndTrigger> getJobs(JobDTO jobDto, Integer pageNum, Integer pageSize);
}
