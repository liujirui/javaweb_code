package cn.liu.hibernatetest;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.liu.hibernate.User;
import cn.liu.hibernateutils.HibernateUtils;


public class HibernateDemo 
{
	
	@Test
	public void addtest()
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

}
