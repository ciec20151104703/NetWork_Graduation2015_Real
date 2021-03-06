package com.model;

import java.util.Date;

/**
 * TUser generated by MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable
{
	private Integer userId;
	private String userName;
	private String userPw;
	private String userRealname;
	
	private String userSex;
	private Integer laoshiId;
	private String userTel;
	private String userEmail;
	
	private String userDel;
	
	private TLaoshi laoshi;
	

	public TLaoshi getLaoshi() {
		return laoshi;
	}
	public void setLaoshi(TLaoshi laoshi) {
		this.laoshi = laoshi;
	}
	public Integer getLaoshiId() {
		return laoshiId;
	}
	public void setLaoshiId(Integer laoshiId) {
		this.laoshiId = laoshiId;
	}
	public String getUserDel()
	{
		return userDel;
	}
	public void setUserDel(String userDel)
	{
		this.userDel = userDel;
	}
	public String getUserEmail()
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPw()
	{
		return userPw;
	}
	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	public String getUserRealname()
	{
		return userRealname;
	}
	
	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}
	public String getUserSex()
	{
		return userSex;
	}
	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}
	public String getUserTel()
	{
		return userTel;
	}
	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}

}