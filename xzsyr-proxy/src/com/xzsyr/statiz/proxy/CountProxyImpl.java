   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月10日 下午4:39:37    
 * tags     
 * see_to_target     
 */

package com.xzsyr.statiz.proxy;

  
/**        
 * Title: CountProxyImpl.java    
 * Description: 账号信息代理实现类
 * @author jizhuang.wang       
 * @created 2018年5月10日 下午4:39:37    
 */

public class CountProxyImpl implements ICount{

	 private CountImpl count; 
	/** 
	 * @discription 账号信息查询
	 * @author jizhuang.wang       
	 * @created 2018年5月10日 下午4:40:31           
	 * @see com.xzsyr.statiz.proxy.ICount#queryCount()     
	 */  
	
	@Override
	public void queryCount() {
		 
		System.out.println("事务处理前.....");
		count.queryCount();
		System.out.println("事务处理后.....");
	}
	
	public CountProxyImpl(CountImpl count) {
		super();
		this.count = count;
	}

}
