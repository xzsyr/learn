   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:30:33    
 * tags     
 * see_to_target     
 */

package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.dto.GroupDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Group;
import com.example.demo.entity.User;
import com.example.demo.service.IGroupService;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageInfo;

/**        
 * Title: UserController.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:30:33    
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	 @Autowired
	 private IUserService userService;
	 @Autowired
	 private IGroupService groupService;
	 private static Logger log = LoggerFactory.getLogger(JobController.class); 
	  
	  
	 /**
	  * 获取用户列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method={RequestMethod.POST, RequestMethod.GET})
	 public Map<String, Object> list(@RequestParam(value="pageNum") int pageNum, 
	            @RequestParam(value="pageSize") int pageSize) throws Exception{     
		PageInfo<User> users = userService.getUsers(pageNum, pageSize);
		PageInfo<Group> groups = groupService.getGroups(1, 100);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Users", users.getList());
        map.put("category", groups.getList());
        log.info("-------user:list---------");
        return map;
	 }
	 
	 /**
	  * 获取用户dto列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listdto",method={RequestMethod.POST, RequestMethod.GET})
	 public Map<String, Object> listDTO(@RequestParam(value="pageNum") int pageNum, 
	            @RequestParam(value="pageSize") int pageSize) throws Exception{     
	   PageInfo<UserDTO> users = userService.getUserDTOs(pageNum, pageSize);
	   PageInfo<Group> groups = groupService.getGroups(1, 100);
       Map<String, Object> map = new HashMap<String, Object>();
       map.put("Users", users.getList());
       map.put("category", groups.getList());
       log.info("-------user:listdto---------");
       return map;
	 }
	
	 /**
	 * 根据组编号获取用户信息
	 * @param groupid 组编号
	 * @throws Exception
	 */
	@PostMapping(value="/getUsersByGid")
     public Map<String, Object> getUsersByGid(@RequestParam(value="groupid") int groupid) throws Exception{     
		List<User> users = userService.getUsersByGid(groupid);
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Users", users);
    	log.info("-------user:getUsersByGid---------");
		return map;
     }
	
	 @RequestMapping(value="/save",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> save(UserDTO user) throws Exception{     
		int i = userService.save(user);
		PageInfo<UserDTO> users = userService.getUserDTOs(0, 100);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Users", users.getList());
        log.info("-------user:save---------");
        return map;
     }
	 
	 @RequestMapping(value="/remove",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> delete(int uid) throws Exception{     
		int i = userService.remove(uid);
		PageInfo<UserDTO> users = userService.getUserDTOs(0, 100);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Users", users.getList());
        log.info("-------user:remove---------");
        return map;
     }
	 
	 @RequestMapping(value="/edit",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> edit(UserDTO user) throws Exception{     
		int i = userService.edit(user);
		PageInfo<UserDTO> users = userService.getUserDTOs(0, 100);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Users", users.getList());
        log.info("-------user:edit---------");
        return map;
     }
	 
	 
	 @RequestMapping(value="/enable",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> enable(int uid) throws Exception{     
		 UserDTO user = userService.getUserById(uid);
		 user.setISABLE("0");
		int i = userService.edit(user);
		PageInfo<UserDTO> users = userService.getUserDTOs(0, 100);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Users", users.getList());
        log.info("-------user:enable---------");
        return map;
     }
	 
	 @RequestMapping(value="/disable",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> disable(int uid) throws Exception{     
		UserDTO user = userService.getUserById(uid);
		user.setISABLE("1");
		int i = userService.edit(user);
		PageInfo<UserDTO> users = userService.getUserDTOs(0, 100);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Users", users.getList());
        log.info("-------user:disable---------");
        return map;
     }
}
