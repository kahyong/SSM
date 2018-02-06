package com.ssm.util;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;


/**
 * 权限处理
 * @author:ck
 * 
*/
public class Jurisdiction {

	
	
	/**获取当前登录的用户名
	 * @return
	 */
	public static String getUsername(){
		return getSession().getAttribute(Const.SESSION_USERNAME).toString();
	}
	
	
	
	/**shiro管理的session
	 * @return
	 */
	public static Session getSession(){
		//Subject currentUser = SecurityUtils.getSubject();  
		return SecurityUtils.getSubject().getSession();
	}
}
