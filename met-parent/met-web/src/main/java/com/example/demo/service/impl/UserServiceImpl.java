   
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
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.utils.Dto2Entity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**        
 * Title: UserServiceImpl.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:34:29    
 */
@Service
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

	/* (non-Javadoc)
	 * @see com.example.demo.service.IUserService#save(com.example.demo.dto.UserDTO)
	 */
	@Override
	public int save(UserDTO user) {
		User target = new User();
		Dto2Entity.copyProperties(user, target);
		userMapper.insert(target);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.IUserService#remove(int)
	 */
	@Override
	public int remove(int uid) {
		userMapper.delete(uid);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.IUserService#edit(com.example.demo.dto.UserDTO)
	 */
	@Override
	public int edit(UserDTO user) {
		User target = new User();
		Dto2Entity.copyProperties(user, target);
		userMapper.update(target);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.IUserService#getUserById(int)
	 */
	@Override
	public UserDTO getUserById(int uid) {
		return userMapper.getUserById(uid);
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.IUserService#getUserDTOs(int, int)
	 */
	@Override
	public PageInfo<UserDTO> getUserDTOs(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<UserDTO> list = userMapper.getUserDTOs();
		PageInfo<UserDTO> page = new PageInfo<UserDTO>(list);
		return page;
	}

}
