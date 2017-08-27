package cn.liu.hibernate;

public class LinkMan
{
	//联系人id
	private Integer link_id;
	//联系人姓名
	private String link_name;
	//联系人性别
	private String link_sex;
	//联系人电话
	private String link_phone;
	
	/*在实体类表示一对多关系对应的一的实体类*/
	private Customer customer;
	
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	public Integer getLink_id()
	{
		return link_id;
	}
	public void setLink_id(Integer link_id)
	{
		this.link_id = link_id;
	}
	public String getLink_name()
	{
		return link_name;
	}
	public void setLink_name(String link_name)
	{
		this.link_name = link_name;
	}
	public String getLink_sex()
	{
		return link_sex;
	}
	public void setLink_sex(String link_sex)
	{
		this.link_sex = link_sex;
	}
	public String getLink_phone()
	{
		return link_phone;
	}
	public void setLink_phone(String link_phone)
	{
		this.link_phone = link_phone;
	}
	
}
