package cn.liu.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.liu.hibernate.Role;
import cn.liu.hibernate.User;
import cn.liu.hibernateutils.HibernateUtils;

public class HibernateManytoMany
{
	/*���Զ�Զ��ϵ��������*/
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
			
			User user1=new User();
			user1.setUserName("liu");
			user1.setUserPassword("132");
			
			User user2=new User();
			user2.setUserName("mo");
			user2.setUserPassword("330");
			
			Role role1=new Role();
			role1.setRole_name("mo");
			role1.setRole_demo("manger");
			
			Role role2=new Role();
			role2.setRole_name("liu");
			role2.setRole_demo("worker");
			
			Role role3=new Role();
			role3.setRole_name("zhu");
			role3.setRole_demo("boss");
			
			/*������ϵ��user1---role1��role2
			        user2---role2,role3*/
			user1.getSetRole().add(role1);
			user1.getSetRole().add(role2);
			
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			
			session.save(user1);
			session.save(user2);
			
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
	
	/*���Զ�Զ��ϵ����ɾ��*/
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
			
			User user1=session.get(User.class, 9);
			User user2=session.get(User.class, 10);
			session.delete(user1);
			session.delete(user2);
			
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
	
	/*���Զ�Զ��ϵ����ɾ��*/
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
			
			User user=session.get(User.class, 11);
			Role role=session.get(Role.class, 18);
//			��user 11û����ؽ�ɫ 18
			user.getSetRole().remove(role);
			
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
