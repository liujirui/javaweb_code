package cn.liu.hibernate;

import java.util.HashSet;
import java.util.Set;

public class Customer
{
	//客户id
	private Integer cid;
	//客户名字
	private String custName;
	//客户级别
	private String custLevel;
	//客户来源
	private String custSource;
	//联系电话
	private String custPhone;
	//手机
	private String custMobile;
	
	/*
	 * 在实体类表示一对多对应的多的实体类
	 * 使用set集合表示，与list集合比，set集合具有无序性和可重复性
	 * */
	private Set<LinkMan> setLinkMan=new HashSet<LinkMan>();
	
	public Set<LinkMan> getSetLinkMan()
	{
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan)
	{
		this.setLinkMan = setLinkMan;
	}
	
	public Integer getCid()
	{
		return cid;
	}
	public void setCid(Integer cid)
	{
		this.cid = cid;
	}
	public String getCustName()
	{
		return custName;
	}
	public void setCustName(String custName)
	{
		this.custName = custName;
	}
	public String getCustLevel()
	{
		return custLevel;
	}
	public void setCustLevel(String custLevel)
	{
		this.custLevel = custLevel;
	}
	public String getCustSource()
	{
		return custSource;
	}
	public void setCustSource(String custSource)
	{
		this.custSource = custSource;
	}
	public String getCustPhone()
	{
		return custPhone;
	}
	public void setCustPhone(String custPhone)
	{
		this.custPhone = custPhone;
	}
	public String getCustMobile()
	{
		return custMobile;
	}
	public void setCustMobile(String custMobile)
	{
		this.custMobile = custMobile;
	}
	
}
