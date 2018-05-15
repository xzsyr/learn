/**
 * 
 */
package com.xzsyr.jdkdy.proxy;

/**
 * @author jizhuang.wang
 *
 */
public class CountImpl implements ICount{

	/* (non-Javadoc)
	 * @see com.xzsyr.jdkdy.proxy.ICount#queryCount()
	 */
	@Override
	public void queryCount() {
		 
		System.out.println("我是queryCount方法");
	}

}
