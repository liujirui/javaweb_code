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
   /* query对象查询数据*/
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
			 * 使用query对象查询数据
			 * session.createQuery()方法里面的参数为要查询的实体类名
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
	
	/* criteria对象查询数据*/
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
			 * 使用criteria对象查询数据
			 * session.createCriteria方法里面的参数为要查询的实体类名
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
	
	/* SQLQuery对象查询数据*/
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
			 * 使用SQLQuery对象查询数据
			 * session.createSQLQuery方法里面的参数为sql语句
			 * */
			SQLQuery sqlQuery=session.createSQLQuery("select * from t_user");
			//sqlQuery.list()方法默认返回数组
			List<Object[]> list=sqlQuery.list();
			for(Object[] object:list)
			{
				System.out.println(Arrays.toString(object));
			}
			
			SQLQuery sqlQuery2=session.createSQLQuery("select * from t_user");
			//设置sqlQuery2.list()返回的对象为User
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
