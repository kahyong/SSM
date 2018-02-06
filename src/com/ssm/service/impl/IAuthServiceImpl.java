package com.ssm.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.redis.RedisDao;
import com.ssm.dao.DaoSupport;
import com.ssm.dao.UserManager;
import com.ssm.dao.redis.impl.RedisDaoImpl;
import com.ssm.model.User;
import com.ssm.service.IAuthService;
import com.ssm.service.UserService;


/** 系统用户
 * @author CK
 * 修改时间：2015.11.2
 */
@Service("iAuthService")
public class IAuthServiceImpl implements IAuthService{

	@Autowired
	private UserManager usersMapper;

	 public User getByUsername(String username) {
	        return usersMapper.getByUsername(username);
	    }

	    public Set<String> getRoles(String username) {
	        return usersMapper.getRoles(username);
	    }

	    public Set<String> getPermissions(String username) {
	        return usersMapper.getPermissions(username);
	    }

	
	
	
	
}
