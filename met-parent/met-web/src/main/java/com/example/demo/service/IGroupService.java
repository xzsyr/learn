   
 /**     
 * @discription 在此输入一句话描述此文件的作用
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:31:03    
 * tags     
 * see_to_target     
 */

package com.example.demo.service;

import com.example.demo.entity.Group;
import com.github.pagehelper.PageInfo;

/**        
 * Title: IGroupService.java    
 * Description: 描述
 * @author jizhuang.wang       
 * @created 2018年5月30日 下午5:31:03    
 */

public interface IGroupService {
	public PageInfo<Group> getGroups(int pageNum, int pageSize);
}
