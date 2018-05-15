/*
 * Copyright 2018-2037 www.ikongge.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.xzsyr.statiz.proxy;

  
/**        
 * Title: CountImpl.java    
 * Description: 账号信息实现类
 * @author jizhuang.wang       
 * @created 2018年5月10日 下午4:37:40    
 */

public class CountImpl implements ICount{

	  
	/** 
	 * @discription 在此输入一句话描述作用
	 * @author jizhuang.wang       
	 * @created 2018年5月10日 下午4:37:54           
	 * @see com.xzsyr.statiz.proxy.ICount#queryCount()     
	 */  
	
	@Override
	public void queryCount() {
         System.out.println("我是queryCount方法.");		
	}

}
