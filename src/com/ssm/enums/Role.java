package com.ssm.enums;

import java.util.HashSet;
import java.util.Set;

public enum Role {
	ADMIN("ADMIN","admin"),
	MANAGER("MANAGER","manager");
	
	
	public static Set<String> getRolesName(){  
        Set<String> set=new HashSet<String>();  
        for(Role name :Role.values()){
        	set.add(name.en);
   	 }
        return set;  
    }  
	
	
	
	private String cn;
	private String en;
	

	Role(String cn, String en ) {
		this.cn=cn;
		this.en=en;
	}
	
	
	
	
	public String getCn() {
		return cn;
	}
	
	public String getEn() {
		return en;
	}


	
	
	
	  
}
