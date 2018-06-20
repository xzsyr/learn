   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:32:09    
 * tags     
 * see_to_target     
 */

package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;

/**        
 * Title: IUserService.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:32:09    
 */

public interface IUserService {
	public PageInfo<User> getUsers(int pageNum, int pageSize);
	public PageInfo<UserDTO> getUserDTOs(int pageNum, int pageSize);
	public List<User> getUsersByGid(int groupid);
	/**
	 * @param user
	 * @return
	 */
	public int save(UserDTO user);
	/**
	 * @param uid
	 * @return
	 */
	public int remove(int uid);
	/**
	 * @param user
	 * @return
	 */
	public int edit(UserDTO user);
	/**
	 * @param gid
	 * @return
	 */
	public UserDTO getUserById(int gid);
}
