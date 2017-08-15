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
//		���غ��������ļ�
		Configuration configuration=new Configuration();
		configuration.configure();
//		����SessionFactory����
		/*����ӳ���ϵ�������ݿⴴ����*/
		SessionFactory sessionFactory=configuration.buildSessionFactory();
//		����session
		/*����������*/
		Session session=sessionFactory.openSession();
//		��������
		Transaction transaction=session.beginTransaction();
//		дcrud�����߼�
		User user=new User();
		user.setUsername("zhu");
		user.setPassword("13");
		user.setAddress("shanghai");
		session.save(user);
//		�ύ����
		transaction.commit();
//		�ͷ���Դ
		session.close();
		sessionFactory.close();
	}

}
