   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:30:23    
 * tags     
 * see_to_target     
 */

package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GroupDTO;
import com.example.demo.entity.Group;
import com.example.demo.service.IGroupService;
import com.github.pagehelper.PageInfo;

/**        
 * Title: GroupController.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:30:23    
 */
@RestController
@RequestMapping(value="/group")
public class GroupController {
	 @Autowired
	 private IGroupService groupService;
	 private static Logger log = LoggerFactory.getLogger(JobController.class); 
	  
	  
	 @RequestMapping(value="/list",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> list() throws Exception{     
		PageInfo<Group> Groups = groupService.getGroups(0, 100);;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Groups", Groups.getList());
        log.info("-------group:list---------");
        return map;
     }
	 
	 @RequestMapping(value="/save",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> save(GroupDTO group) throws Exception{   
		 group.setISABLE("0");
		int i = groupService.save(group);
		PageInfo<Group> Groups = groupService.getGroups(0, 100);;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Groups", Groups.getList());
        log.info("-------group:save---------");
        return map;
     }
	 
	 @RequestMapping(value="/remove",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> delete(int gid) throws Exception{     
		int i = groupService.remove(gid);
		PageInfo<Group> Groups = groupService.getGroups(0, 100);;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Groups", Groups.getList());
        log.info("-------group:remove---------");
        return map;
     }
	 
	 @RequestMapping(value="/edit",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> edit(GroupDTO group) throws Exception{     
		int i = groupService.edit(group);
		PageInfo<Group> Groups = groupService.getGroups(0, 100);;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Groups", Groups.getList());
        log.info("-------group:edit---------");
        return map;
     }
	 
	 @RequestMapping(value="/enable",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> enable(int gid) throws Exception{     
		GroupDTO group = groupService.getGroupById(gid);
		group.setISABLE("0");
		int i = groupService.edit(group);
		PageInfo<Group> Groups = groupService.getGroups(0, 100);;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Groups", Groups.getList());
        log.info("-------group:enable---------");
        return map;
     }
	 
	 @RequestMapping(value="/disable",method={RequestMethod.POST, RequestMethod.GET})
     public Map<String, Object> disable(int gid) throws Exception{     
		 GroupDTO group = groupService.getGroupById(gid);
		group.setISABLE("1");
		int i = groupService.edit(group);
		PageInfo<Group> Groups = groupService.getGroups(0, 100);;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("static",1);
        map.put("Groups", Groups.getList());
        log.info("-------group:disable---------");
        return map;
     }
}
