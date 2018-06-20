/**
 * 
 */
package com.example.demo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.app.DemoApplication;
import com.example.demo.entity.Group;
import com.example.demo.entity.HisJob;
import com.example.demo.entity.User;
import com.example.demo.service.IGroupService;
import com.example.demo.service.IHisJobService;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author Stronger
 *
 */
@RunWith(SpringRunner.class) //14.版本之前用的是SpringJUnit4ClassRunner.class
@SpringBootTest(classes = DemoApplication.class) //1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)
public class test {
 
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IHisJobService hisJobService;
	
	@Test
	public void list(){
		PageInfo<Group> pages =groupService.getGroups(0, 100);
		for(Group g:pages.getList()){
			System.out.println(g.getGNAME());
		}
	}
	
	@Test
	public void listUser(){
		PageInfo<User> pages =userService.getUsers(0, 100);
		for(User u:pages.getList()){
			System.out.println(u.getUNAME());
		}
	}
	
	@Test
	public void getUsesByGid(){
		List<User> users =userService.getUsersByGid(1);
		for(User u:users){
			System.out.println(u.getUNAME());
		}
	}
	@Test
	public void listHis(){
		PageInfo<HisJob> page = hisJobService.getHisJobs(1,10);
		for(HisJob h:page.getList()){
			System.out.println(h.getJOB_NAME()+"HIS");
		}
	}
	
	@Test
	public void saveHis(){
		HisJob hisJob = new HisJob();
		hisJob.setDESCRIPTION("aa");
		hisJob.setJOB_CLASS_NAME("aaa");
		hisJob.setJOB_NAME("你好");
		hisJob.setJOB_GROUP("#####");
		hisJobService.save(hisJob);
	}
}
