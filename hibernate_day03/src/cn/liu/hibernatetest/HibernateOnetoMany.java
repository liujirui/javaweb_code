package cn.liu.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.liu.hibernate.Customer;
import cn.liu.hibernate.LinkMan;
import cn.liu.hibernateutils.HibernateUtils;

public class HibernateOnetoMany
{
	/*测试级联保存*/
	@Test
	public void testAdd()
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		try
		{
			sessionFactory=HibernateUtils.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Customer customer=new Customer();
			customer.setCustLevel("custLevel2");
			customer.setCustMobile("custMobile2");
			customer.setCustName("custName2");
			customer.setCustPhone("custPhone2");
			customer.setCustSource("custSource2");
			LinkMan linkMan=new LinkMan();
			linkMan.setLink_name("link_name2");
			linkMan.setLink_phone("link_phone2");
			linkMan.setLink_sex("link_sex2");
			/*建立Customer和LinkMan的一对多关系*/
//			把linkMan放入customer的set集合
			customer.getSetLinkMan().add(linkMan);
//			把customer放入linkMan的customer对象
			linkMan.setCustomer(customer);
			session.save(customer);
			session.save(linkMan);
			transaction.commit();
			
		} catch (Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}finally 
		{
			session.close();
			sessionFactory.close();
		}
	}
	
	/*测试级联保存简化写法
	 * 在customer.hbm.xml文件加上
       <set name="setLinkMan" cascade="save-update">
       	可以省略对Linkman的操作
	 * */
	@Test
	public void testAdd2()
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		try
		{
			sessionFactory=HibernateUtils.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Customer customer=new Customer();
			customer.setCustLevel("custLevel2");
			customer.setCustMobile("custMobile2");
			customer.setCustName("custName2");
			customer.setCustPhone("custPhone2");
			customer.setCustSource("custSource2");
			
			LinkMan linkMan=new LinkMan();
			linkMan.setLink_name("link_name2");
			linkMan.setLink_phone("link_phone2");
			linkMan.setLink_sex("link_sex2");
			
			/*建立Customer和LinkMan的一对多关系*/
//			把linkMan放入customer的set集合
			customer.getSetLinkMan().add(linkMan);
		/*	把customer放入linkMan的customer对象
			在配置文件有配置可以省略*/
//			linkMan.setCustomer(customer);
//			session.save(linkMan);
			session.save(customer);
			transaction.commit();
			
		} catch (Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}finally 
		{
			session.close();
			sessionFactory.close();
		}
	}
	
	/*一对多级联删除
	 * 在customer.hbm.xml文件加上
       <set name="setLinkMan" cascade="save-update，delete">
       	可以省略对Linkman的操作
	 * */
	@Test
	public void testDelete()
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		try
		{
			sessionFactory=HibernateUtils.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Customer customer=session.get(Customer.class, 3);
			session.delete(customer);
			transaction.commit();
			
		} catch (Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}finally 
		{
			session.close();
			sessionFactory.close();
		}
	}
	
	/*一对多级联修改
	 * */
	@Test
	public void testUpdate()
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		try
		{
			sessionFactory=HibernateUtils.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Customer customer=session.get(Customer.class, 2);
			LinkMan linkMan=session.get(LinkMan.class, 1);
			
			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);
			
			transaction.commit();
			
		} catch (Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}finally 
		{
			session.close();
			sessionFactory.close();
		}
	}
	
}
