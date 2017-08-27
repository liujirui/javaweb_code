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
	/*���Լ�������*/
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
			/*����Customer��LinkMan��һ�Զ��ϵ*/
//			��linkMan����customer��set����
			customer.getSetLinkMan().add(linkMan);
//			��customer����linkMan��customer����
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
	
	/*���Լ��������д��
	 * ��customer.hbm.xml�ļ�����
       <set name="setLinkMan" cascade="save-update">
       	����ʡ�Զ�Linkman�Ĳ���
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
			
			/*����Customer��LinkMan��һ�Զ��ϵ*/
//			��linkMan����customer��set����
			customer.getSetLinkMan().add(linkMan);
		/*	��customer����linkMan��customer����
			�������ļ������ÿ���ʡ��*/
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
	
	/*һ�Զ༶��ɾ��
	 * ��customer.hbm.xml�ļ�����
       <set name="setLinkMan" cascade="save-update��delete">
       	����ʡ�Զ�Linkman�Ĳ���
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
	
	/*һ�Զ༶���޸�
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
