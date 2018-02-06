package com.ssm.interceptor.shiro;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.enums.Role;
import com.ssm.model.User;
import com.ssm.service.IAuthService;
import com.ssm.service.UserService;


/**
 * http://blog.51cto.com/luchunli/1828038
 * @author ck
 * 
 */
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
    private IAuthService iAuthService;
	
	/*
	 * 登录信息和用户验证信息验证(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		System.out.println("========1");
		 String username = (String)token.getPrincipal();  				//得到用户名 
	     //String password = new String((char[])token.getCredentials()); 	//得到密码
	     User user = iAuthService.getByUsername(username);
	        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), getName());
			return authcInfo;       
	}
	
	/*
	 * 权限认证 
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("========2");
		 String loginName=(String) pc.fromRealm(getName()).iterator().next();  
	        //到数据库查是否有此对象  
		 System.out.println(loginName);
	     User user = iAuthService.getByUsername(loginName);
	        if(user!=null){  
//	            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
//	            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
//	            //用户的角色集合  
//	            info.setRoles(Role.getRolesName());  
////               用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
////	            List<Role> roleList=user.getRoleList();  
////	            for (Role role : roleList) {  
//	            List<String> list=new ArrayList<>();
//	            list.add("add");
//	            list.add("update");
//	                info.addStringPermissions(list);  
////	            }  
//	            return info;   //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
	            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
	            //用户的角色集合  
//	            info.setRoles(user.getRolesName());  
//	            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
//	            List<Role> roleList=user.getRoleList();  
//	            for (Role role : roleList) {  
//	                info.addStringPermissions(role.getPermissionsName());  
//	            }  
	            return info;  
	        }  
	        return null;  
	        
//		return null;
	}
	
	

}
