package com.ssm.model;

import java.io.Serializable;

/** 
* 类名称：用户
* @author CK
* @version 1.0
*/


public class User implements Serializable{
	private static final long serialVersionUID = 3453888774933114316L;
	private int id;
	private String username;
	private String password;
	private String email;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
