package com.ssm.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.SysMenu;
import com.ssm.model.User;
import com.ssm.model.easyui.PageHelper;


/** 用户接口类
 * @author CK
 */
public interface UserManager {
	
	/**通过用户ID获取用户信息和角色信息
	 * @param USER_ID
	 * @return
	 * @throws Exception
	 */
	public User getUser(String username) throws Exception;

	
	 public User getByUsername(String username);

	 public Set<String> getRoles(String username);

	 public Set<String> getPermissions(String username);
	 
	 public User findUserByName(@Param("username") String username);

		public String getUsernameById(@Param("id") int id);

		public List<SysMenu> getMenuByUserId(@Param("userId") int userId);
		
		public List<User> getDatagrid();

		public Long getDatagridTotal(User user);

		public List<User> datagridUser(PageHelper page);

		public void addUser(User user);

		public void editUser(User user);
	    
}
