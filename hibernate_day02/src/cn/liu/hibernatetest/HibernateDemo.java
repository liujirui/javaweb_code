package cn.liu.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import cn.liu.hibernate.User;
import cn.liu.hibernateutils.HibernateUtils;

public class HibernateDemo
{
	/*��������*/
	@Test
	public void addTest()
	{
//		���غ��������ļ�
//		Configuration configuration=new Configuration();
//		configuration.configure();
//		����SessionFactory����
		/*����ӳ���ϵ�������ݿⴴ����*/
//		SessionFactory sessionFactory=configuration.buildSessionFactory();
		/*ʹ�ù������ȡsessionfactory,�Ż�����*/
		SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
//		����session
		/*����������*/
		Session session=sessionFactory.openSession();
//		��������
		Transaction transaction=session.beginTransaction();
//		дcrud�����߼�
		User user=new User();
		user.setUsername("wang");
		user.setPassword("17");
		user.setAddress("nanning");
		session.save(user);
//		�ύ����
		transaction.commit();
//		�ͷ���Դ
		session.close();
		sessionFactory.close();
	}

	
	/*����uid��ѯ����*/
	@Test
	public void getTest()
	{
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		/*Session����������*/
		Session session=sessionFactory.openSession();
		/*��������*/
		Transaction transaction=session.beginTransaction();
		/*��ѯuidΪ1������*/
		User user=session.get(User.class, 1);
		System.out.println(user);
		/*�ύ����*/
		transaction.commit();
		/*�ر��ͷ���Դ*/
		session.close();
		sessionFactory.close();
	}

	/*�޸�����*/
	@Test
	public void updateTest()
	{
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		/*Session����������*/
		Session session=sessionFactory.openSession();
		/*��������*/
		Transaction transaction=session.beginTransaction();
		/*�Ȳ�ѯuidΪ1�����ݣ�Ȼ�����޸�*/
		User user=session.get(User.class, 1);
		user.setPassword("qwerty");
		session.update(user);
		/*�ύ����*/
		transaction.commit();
		/*�ر��ͷ���Դ*/
		session.close();
		sessionFactory.close();
	}
	
	/*�h������*/
	@Test
	public void deleteTest()
	{
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		/*Session����������*/
		Session session=sessionFactory.openSession();
		/*��������*/
		Transaction transaction=session.beginTransaction();
		/*�Ȳ�ѯuidΪ4�����ݣ�Ȼ���لh��*/
		User user=session.get(User.class, 4);
		session.delete(user);
		/*�ύ����*/
		transaction.commit();
		/*�ر��ͷ���Դ*/
		session.close();
		sessionFactory.close();
	}

	
	/*��֤hibernate�е�һ������*/
	@Test
	public void cacheTest()
	{
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		/*Session����������*/
		Session session=sessionFactory.openSession();
		/*��������*/
		Transaction transaction=session.beginTransaction();
		/*�Ȳ�ѯuid�����ݣ���ϵ㣬��һ�β�ѯ��Ҫ����sql���ȥ���ݿ�*/
		User user=session.get(User.class, 2);
		System.out.println(user);
		
		/*�ڶ��β�ѯuid��ͬ�����ݣ�ֱ�Ӵӻ�������ݣ�����Ҫ����sql���*/
		User user2=session.get(User.class, 2);
		System.out.println(user2);
		/*�ύ����*/
		transaction.commit();
		/*�ر��ͷ���Դ*/
		session.close();
		sessionFactory.close();
	}

}
