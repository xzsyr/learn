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
package com.xzsyr.jdkdy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jizhuang.wang
 *
 */
public class JDKMain {
	public static void main(String[] args) {
		CountImpl count = new CountImpl();
		count.queryCount();
		System.out.println("==========================================");
		/** 
         * 以下代码会生成一个$Proxy对象，该对象实现了ICount接口，具体的方法体就是InvocationHandler里面的invoke方法。 
         */ 
 		InvocationHandler  hander = new MyInvocationHandler(count);
 		ICount proxyInstance = (ICount) Proxy.newProxyInstance(count.getClass().getClassLoader(), count.getClass().getInterfaces(), hander);
 		proxyInstance.queryCount();
	}
}
