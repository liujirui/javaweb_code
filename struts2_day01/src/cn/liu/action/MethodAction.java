package cn.liu.action;

import com.opensymphony.xwork2.ActionSupport;
/*
 * create on 2017/8/13 by liu
 * */
public class MethodAction extends ActionSupport
{
	public void add() 
	{
		System.out.println("add.....");
	}
	
	public String update()
	{
		System.out.println("update.....");
		return NONE;
	}
	
	public String query() 
	{
		System.out.println("query....");
		return "query";
	}
	
	public String delete() 
	{
		System.out.println("delete....");
		return "delete";
	}
	
	public String testDynamic() 
	{
		System.out.println("dynamic....");
		return "success";
	}

}
