package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.JobDTO;
import com.example.demo.entity.JobAndTrigger;
@Component
public interface JobAndTriggerMapper {
	public List<JobAndTrigger> getJobAndTriggerDetails();

	/**
	 * @param jobDto
	 * @return
	 */
	public List<JobAndTrigger> getJobs(JobDTO jobDto);
}
