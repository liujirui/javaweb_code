package cn.liu.hibernate;

import java.util.HashSet;
import java.util.Set;

public class Role
{
	private Integer role_id;
	private String role_name;
	private String role_demo;
	
	private Set<User> setUser=new HashSet<User>();
	
	public Set<User> getSetUser()
	{
		return setUser;
	}
	public void setSetUser(Set<User> setUser)
	{
		this.setUser = setUser;
	}
	public Integer getRole_id()
	{
		return role_id;
	}
	public void setRole_id(Integer role_id)
	{
		this.role_id = role_id;
	}
	public String getRole_name()
	{
		return role_name;
	}
	public void setRole_name(String role_name)
	{
		this.role_name = role_name;
	}
	public String getRole_demo()
	{
		return role_demo;
	}
	public void setRole_demo(String role_demo)
	{
		this.role_demo = role_demo;
	}
	
}
