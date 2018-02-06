package com.ssm.service;

import java.util.List;

import com.ssm.model.SysMenu;
import com.ssm.model.User;
import com.ssm.util.PageData;


/** 用户接口类
 * @author CK
 */
public interface UserService {
	
	public void test();
	
	/**
	 * 获取该用户权限的菜单
	 * @param userId
	 * @return
	 */
	public List<SysMenu> getMenu(int userId);
	
}
