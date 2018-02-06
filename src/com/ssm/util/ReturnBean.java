package com.ssm.util;

import java.io.Serializable;

public class ReturnBean<T> implements Serializable {
	  private static final long serialVersionUID = 1L;
	  public static final int SUCCESS = 0;
	  public static final int FAIL = 1;
	  public static final int NO_PERMISSION = 2;
	  private String msg = "success";
	  private int code = SUCCESS;
	  private T data;
	  
	  public ReturnBean() {
	    super();
	  }
	  public ReturnBean(T data) {
	    super();
	    this.data = data;
	  }
	  public ReturnBean(Throwable e) {
	    super();
	    this.msg = e.toString();
	    this.code = FAIL ;
	  }
	}