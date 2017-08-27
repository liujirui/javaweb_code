package cn.liu.hibernatetest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import cn.liu.hibernate.User;
import cn.liu.hibernateutils.HibernateUtils;

public class HibernateQueryData
{
   /* query�����ѯ����*/
	@Test
	public void testQuery()
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		try
		{
			sessionFactory=HibernateUtils.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			/*
			 * ʹ��query�����ѯ����
			 * session.createQuery()��������Ĳ���ΪҪ��ѯ��ʵ������
			 * */
			Query query=session.createQuery("from User");
			List<User> userList=query.list();
			for(User user:userList)
			{
				System.out.println(user);
			}
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
	
	/* criteria�����ѯ����*/
	@Test
	public void testCriteria()
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		try
		{
			sessionFactory=HibernateUtils.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			/*
			 * ʹ��criteria�����ѯ����
			 * session.createCriteria��������Ĳ���ΪҪ��ѯ��ʵ������
			 * */
			Criteria criteria=session.createCriteria(User.class);
			List<User> userList=criteria.list();
			for(User user:userList)
			{
				System.out.println(user);
			}
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
	
	/* SQLQuery�����ѯ����*/
	@Test
	public void testSQLQuery()
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		try
		{
			sessionFactory=HibernateUtils.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			/*
			 * ʹ��SQLQuery�����ѯ����
			 * session.createSQLQuery��������Ĳ���Ϊsql���
			 * */
			SQLQuery sqlQuery=session.createSQLQuery("select * from t_user");
			//sqlQuery.list()����Ĭ�Ϸ�������
			List<Object[]> list=sqlQuery.list();
			for(Object[] object:list)
			{
				System.out.println(Arrays.toString(object));
			}
			
			SQLQuery sqlQuery2=session.createSQLQuery("select * from t_user");
			//����sqlQuery2.list()���صĶ���ΪUser
			sqlQuery2.addEntity(User.class);
			List<User> userList=sqlQuery2.list();
			for(User user:userList)
			{
				System.out.println(user);
			}
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
