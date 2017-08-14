package cn.liu.action;
/*
 * create on 2017/8/13 by liu
 * */
public class HelloAction {
	/*
	 * (1)servlet每次调用都会执行service方法
	 *   访问servlet前需要在xml文件里配置访问路径
	 *   
	 *  (2)action每次调用都会执行execute()方法
	 *  访问action前需要在struts.xml(文件路径固定在src下)
	 *  文件配置访问路径
	 *  
	 */
	
	public String execute()
	{
		return "ok";
	}

}
