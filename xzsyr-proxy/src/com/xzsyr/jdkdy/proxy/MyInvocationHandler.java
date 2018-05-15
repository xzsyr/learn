   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月10日 下午5:00:41    
 * tags     
 * see_to_target     
 */

package com.xzsyr.jdkdy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**        
 * Title: MyInvocationHandler.java    
 * Description: JDK动态代理类
 * 代理对象的拦截器  
 * @author jizhuang.wang       
 * @created 2018年5月10日 下午5:00:41    
 */

public class MyInvocationHandler implements InvocationHandler{
    private CountImpl countImpl;
	
    
	/**
	 * 构造函数
	 * @param countImpl 被代理对象
	 */
	public MyInvocationHandler(CountImpl countImpl) {
	//	super();
		this.countImpl = countImpl;
	}


	/** 
	 * @discription 在此输入一句话描述作用
	 * @author jizhuang.wang       
	 * @created 2018年5月10日 下午5:01:22      
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable     
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])     
	 */  
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("事务处理前。。。。");
		 method.invoke(countImpl, args);
		 System.out.println("事务处理后。。。。");
		return null;
	}

}
