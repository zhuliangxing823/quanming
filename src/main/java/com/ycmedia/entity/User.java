package com.ycmedia.entity;

public class User {

  private String username;
  private String password;
  private String role;
  
  private String realname;
  
  private String mobile;
  
  private Integer state;

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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

public String getRealname() {
	return realname;
}

public void setRealname(String realname) {
	this.realname = realname;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public Integer getState() {
	return state;
}

public void setState(Integer state) {
	this.state = state;
}
  
  

}
