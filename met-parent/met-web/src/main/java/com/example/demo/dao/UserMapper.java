   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:21:55    
 * tags     
 * see_to_target     
 */

package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.User;

/**        
 * Title: UserMapper.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:21:55    
 */

public interface UserMapper {
	public List<User> getUsers();
	public List<User> getUsersByGid(int groupid);
}
