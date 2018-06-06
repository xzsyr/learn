   
 /**     
 * @discription 雇主信息管理
 * @author jizhuang.wang       
 * @created 2018年4月28日 上午11:31:06    
 * tags     
 * see_to_target     
 */

package com.xzsyr.employ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xzsyr.employ.provider.WorkServiceProvider;


/**        
 * Title: EmployController.java    
 * Description: 雇主控制层
 * @author jizhuang.wang       
 * @created 2018年4月28日 上午11:31:06    
 */
@RestController
public class EmployController {
	
	@Value("${server.port}")
    String port;
   
	@Autowired
	private WorkServiceProvider workServiceProvider;
	  
	/**     
	 * @discription 获取雇主名称
	 * @author jizhuang.wang       
	 * @created 2018年4月28日 下午1:51:37     
	 * @param name
	 * @return     
	 */
	@RequestMapping(value="/getName/{name}",method=RequestMethod.GET)
    public String getName(@PathVariable("name") String name) {
        return "hi "+name+",i am employ:" +port;
    }
	
	/**     
	 * @discription 获取工匠名称
	 * @author jizhuang.wang       
	 * @created 2018年4月28日 下午1:51:37     
	 * @param name
	 * @return     
	 */
	@RequestMapping(value="/getWorkName/{name}",method=RequestMethod.GET)
    public String getWorkName(@PathVariable("name") String name) {
        return workServiceProvider.getWorkerNameById(name);
    }
}
