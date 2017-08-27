package cn.liu.hibernateutils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils 
{
	private static final Configuration configuration;
	private static final SessionFactory sessionFactory;
	
	/*¾²Ì¬´úÂë¿é*/
	static
	{
		configuration=new Configuration();
		configuration.configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	
	public static void main(String[] args)
	{
		
	}

}
