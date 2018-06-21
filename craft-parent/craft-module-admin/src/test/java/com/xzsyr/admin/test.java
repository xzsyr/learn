package com.xzsyr.admin;

/**
 * 
 */


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xzsyr.core.entity.UserInfo;
import com.xzsyr.core.service.UserInfoService;


/**
 * @author Stronger
 *
 */
@RunWith(SpringRunner.class) //14.版本之前用的是SpringJUnit4ClassRunner.class
@SpringBootTest(classes = AdminApplication.class) //1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)
public class test {
 
	
	@Autowired
	private UserInfoService userService;
	
	
	@Test
	public void list(){
		UserInfo pages =userService.findByUsername("admin");
			System.out.println("========================"+pages.getUsername());
	}
	 
}
