package cn.liu.hibernate;

public class LinkMan
{
	//��ϵ��id
	private Integer link_id;
	//��ϵ������
	private String link_name;
	//��ϵ���Ա�
	private String link_sex;
	//��ϵ�˵绰
	private String link_phone;
	
	/*��ʵ�����ʾһ�Զ��ϵ��Ӧ��һ��ʵ����*/
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
