   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:34:29    
 * tags     
 * see_to_target     
 */

package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.GroupMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Group;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**        
 * Title: UserServiceImpl.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:34:29    
 */

public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper; 
	/** 
	 * @discription 在此输入一句话描述作用
	 * @author jizhuang.wang       
	 * @created 2018年5月30日 下午5:34:44      
	 * @param pageNum
	 * @param pageSize
	 * @return     
	 * @see com.example.demo.service.IUserService#getUsersByGid(int, int)     
	 */  
	
	@Override
	public PageInfo<User> getUsers(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = userMapper.getUsers();
		PageInfo<User> page = new PageInfo<User>(list);
		return page;
	}
	  
	/** 
	 * @discription 在此输入一句话描述作用
	 * @author jizhuang.wang       
	 * @created 2018年5月30日 下午5:39:15      
	 * @param groupid
	 * @return     
	 * @see com.example.demo.service.IUserService#getUsersByGid(long)     
	 */  
	
	@Override
	public List<User> getUsersByGid(int groupid) {
		List<User> list = userMapper.getUsersByGid(groupid);
		return list;
	}

}
