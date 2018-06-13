package com.xzsyr.admin.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xzsyr.common.ResponseBean;
import com.xzsyr.core.entity.UserInfo;
import com.xzsyr.core.service.UserInfoService;
import com.xzsyr.core.utils.JWTUtil;
@RestController
public class AdminController {
	
	@Autowired
    private UserInfoService userService;
    
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean login(
    		@RequestParam("username") String username,
    		@RequestParam("password") String password) {
		UserInfo userBean =new UserInfo();
		userBean.setPassword("admin");
		userBean.setUsername("admin");
		//UserInfo userBean = userService.findByUsername(username);
		System.out.println(userBean.getUid());
        if (userBean.getPassword().equals(password)) {
            return new ResponseBean(200, "Login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }
}
