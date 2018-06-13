/**  
* @Title: MyShiroRealm.java  
* @Package com.xzsyr.shirocas.reaml  
* @Description: TODO 
* @author jizhuang.wang 
* @date 2018年6月10日  
* @version V1.0  
*/ 
package com.xzsyr.core.shiro.reaml;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzsyr.core.entity.SysPermission;
import com.xzsyr.core.entity.SysRole;
import com.xzsyr.core.entity.UserInfo;
import com.xzsyr.core.service.UserInfoService;
import com.xzsyr.core.shiro.token.JWTToken;
import com.xzsyr.core.utils.JWTUtil;

/**  
* @ClassName: MyShiroRealm  
* @Description: 权限校验核心类
* @author jizhuang.wang  
* @date 2018年6月10日  
*    
*/
@SuppressWarnings("all")
public class MyRealm extends AuthorizingRealm{
	
	@Autowired
    private UserInfoService userService;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        UserInfo user = userService.findByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
       // simpleAuthorizationInfo.addRoles(user.getRoleList());
      //  Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
      //  simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        UserInfo userBean = userService.findByUsername(username);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
