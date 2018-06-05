/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HisJobMapper;
import com.example.demo.entity.HisJob;
import com.example.demo.service.IHisJobService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author Stronger
 *
 */
@Service
public class HisJobServiceImpl implements IHisJobService{

	@Autowired
	private HisJobMapper hisJobMapper;
	
	@Override
	public PageInfo<HisJob> getHisJobs(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<HisJob> hisJobs =hisJobMapper.getHisJobs();
		PageInfo<HisJob> page = new PageInfo<>(hisJobs);
		return page;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.IHisJobService#save(com.example.demo.entity.HisJob)
	 */
	@Override
	public void save(HisJob hisJob) {
		hisJobMapper.save(hisJob);
	}

}
