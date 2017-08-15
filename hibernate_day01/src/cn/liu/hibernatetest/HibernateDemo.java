package cn.liu.hibernatetest;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.liu.hibernate.User;


public class HibernateDemo 
{
	
	@Test
	public void addtest()
	{
//		加载核心配置文件
		Configuration configuration=new Configuration();
		configuration.configure();
//		创建SessionFactory对象
		/*根据映射关系，在数据库创建表*/
		SessionFactory sessionFactory=configuration.buildSessionFactory();
//		创建session
		/*类似于连接*/
		Session session=sessionFactory.openSession();
//		开启事务
		Transaction transaction=session.beginTransaction();
//		写crud具体逻辑
		User user=new User();
		user.setUsername("zhu");
		user.setPassword("13");
		user.setAddress("shanghai");
		session.save(user);
//		提交事务
		transaction.commit();
//		释放资源
		session.close();
		sessionFactory.close();
	}

}
