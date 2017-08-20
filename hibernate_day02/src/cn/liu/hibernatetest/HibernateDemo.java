package cn.liu.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import cn.liu.hibernate.User;
import cn.liu.hibernateutils.HibernateUtils;

public class HibernateDemo
{
	/*增加数据*/
	@Test
	public void addTest()
	{
//		加载核心配置文件
//		Configuration configuration=new Configuration();
//		configuration.configure();
//		创建SessionFactory对象
		/*根据映射关系，在数据库创建表*/
//		SessionFactory sessionFactory=configuration.buildSessionFactory();
		/*使用工具类获取sessionfactory,优化性能*/
		SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
//		创建session
		/*类似于连接*/
		Session session=sessionFactory.openSession();
//		开启事务
		Transaction transaction=session.beginTransaction();
//		写crud具体逻辑
		User user=new User();
		user.setUsername("wang");
		user.setPassword("17");
		user.setAddress("nanning");
		session.save(user);
//		提交事务
		transaction.commit();
//		释放资源
		session.close();
		sessionFactory.close();
	}

	
	/*根据uid查询数据*/
	@Test
	public void getTest()
	{
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		/*Session类似于连接*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		Transaction transaction=session.beginTransaction();
		/*查询uid为1的数据*/
		User user=session.get(User.class, 1);
		System.out.println(user);
		/*提交事务*/
		transaction.commit();
		/*关闭释放资源*/
		session.close();
		sessionFactory.close();
	}

	/*修改数据*/
	@Test
	public void updateTest()
	{
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		/*Session类似于连接*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		Transaction transaction=session.beginTransaction();
		/*先查询uid为1的数据，然後再修改*/
		User user=session.get(User.class, 1);
		user.setPassword("qwerty");
		session.update(user);
		/*提交事务*/
		transaction.commit();
		/*关闭释放资源*/
		session.close();
		sessionFactory.close();
	}
	
	/*刪除数据*/
	@Test
	public void deleteTest()
	{
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		/*Session类似于连接*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		Transaction transaction=session.beginTransaction();
		/*先查询uid为4的数据，然後再刪除*/
		User user=session.get(User.class, 4);
		session.delete(user);
		/*提交事务*/
		transaction.commit();
		/*关闭释放资源*/
		session.close();
		sessionFactory.close();
	}

	
	/*验证hibernate中的一级缓存*/
	@Test
	public void cacheTest()
	{
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		/*Session类似于连接*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		Transaction transaction=session.beginTransaction();
		/*先查询uid的数据，打断点，第一次查询需要发送sql语句去数据库*/
		User user=session.get(User.class, 2);
		System.out.println(user);
		
		/*第二次查询uid相同的内容，直接从缓存查数据，不需要发送sql语句*/
		User user2=session.get(User.class, 2);
		System.out.println(user2);
		/*提交事务*/
		transaction.commit();
		/*关闭释放资源*/
		session.close();
		sessionFactory.close();
	}

}
