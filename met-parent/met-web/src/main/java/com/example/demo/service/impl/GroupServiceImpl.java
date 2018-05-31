   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:34:59    
 * tags     
 * see_to_target     
 */

package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.GroupMapper;
import com.example.demo.dao.JobAndTriggerMapper;
import com.example.demo.entity.Group;
import com.example.demo.entity.JobAndTrigger;
import com.example.demo.service.IGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**        
 * Title: GroupServiceImpl.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:34:59    
 */

public class GroupServiceImpl implements IGroupService{

	@Autowired
	private GroupMapper groupMapper; 
	
	
	/** 
	 * @discription 在此输入一句话描述作用
	 * @author jizhuang.wang       
	 * @created 2018年5月30日 下午5:35:10      
	 * @param pageNum
	 * @param pageSize
	 * @return     
	 * @see com.example.demo.service.IGroupService#getGroups(int, int)     
	 */  
	
	@Override
	public PageInfo<Group> getGroups(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Group> list = groupMapper.getGroups();
		PageInfo<Group> page = new PageInfo<Group>(list);
		return page;
	}

}
