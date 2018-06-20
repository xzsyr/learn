/**
 * 
 */
package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HisJob;
import com.example.demo.service.IGroupService;
import com.example.demo.service.IHisJobService;
import com.github.pagehelper.PageInfo;

/**
 * @author Stronger
 *
 */
@RestController
@RequestMapping(value="/hisjob")
public class HisJobController {
 
  private static Logger log = LoggerFactory.getLogger(HisJobController.class); 
  @Autowired
  private IHisJobService hisJobService;
  @Autowired
  private IGroupService groupService;
  /**
   * 已完成任务列表
 * @param pageNum
 * @param pageSize
 * @return
 * @throws Exception
 */
  @RequestMapping(value="/list",method={RequestMethod.POST, RequestMethod.GET})
  public Map<String, Object> list(@RequestParam(value="pageNum") int pageNum, 
          @RequestParam(value="pageSize") int pageSize) throws Exception{     
		 PageInfo<HisJob> hisJobs = hisJobService.getHisJobs(pageNum, pageSize);
	     Map<String, Object> map = new HashMap<String, Object>();
	     for(HisJob h:hisJobs.getList()){
	    	 h.setJOB_GROUP(groupService.getGroupById(Integer.parseInt(h.getJOB_GROUP())).getGNAME());
	     }
	     map.put("HisJobs", hisJobs.getList());
	     log.info("-------hisJobs:list---------");
	     return map;
  }
}
