   
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
import org.springframework.stereotype.Service;

import com.example.demo.dao.GroupMapper;
import com.example.demo.dto.GroupDTO;
import com.example.demo.entity.Group;
import com.example.demo.service.IGroupService;
import com.example.demo.utils.Dto2Entity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**        
 * Title: GroupServiceImpl.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:34:59    
 */
@Service
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
		//Example example = new Example(Group.class);
		//example.createCriteria().andEqualTo("ISABLE",0);
		List<Group> list = groupMapper.getGroups();
		PageInfo<Group> page = new PageInfo<Group>(list);
		return page;
	}


	/* (non-Javadoc)
	 * @see com.example.demo.service.IGroupService#save(com.example.demo.dto.GroupDTO)
	 */
	@Override
	public int save(GroupDTO group) {
		Group target =new Group();
		Dto2Entity.copyProperties(group, target);
		groupMapper.insert(target);
		return 0;
	}


	/* (non-Javadoc)
	 * @see com.example.demo.service.IGroupService#delete(int)
	 */
	@Override
	public int remove(int gid) {
		groupMapper.delete(gid);
		return 0;
	}


	/* (non-Javadoc)
	 * @see com.example.demo.service.IGroupService#edit(com.example.demo.dto.GroupDTO)
	 */
	@Override
	public int edit(GroupDTO group) {
		Group target =new Group();
		Dto2Entity.copyProperties(group, target);
		groupMapper.update(target);
		return 0;
	}


	/* (non-Javadoc)
	 * @see com.example.demo.service.IGroupService#getGroupById(int)
	 */
	@Override
	public GroupDTO getGroupById(int gid) {
		GroupDTO group = groupMapper.getGroupByKey(gid);
		return group;
	}

}
