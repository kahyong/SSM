package com.ssm.service;

import java.util.Set;

import com.ssm.model.User;

public interface IAuthService {

	 public User getByUsername(String username);

	 public Set<String> getRoles(String username);

	 public Set<String> getPermissions(String username);
    
}
