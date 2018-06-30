/**  
* @Title: ArticleSearchRepository.java  
* @Package com.xzsyr.search.dao  
* @Description: TODO 
* @author jizhuang.wang 
* @date 2018年6月24日  
* @version V1.0  
*/ 
package com.xzsyr.search.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.xzsyr.search.model.Article;

/**  
* @ClassName: ArticleSearchRepository  
* @Description: TODO 
* @author jizhuang.wang  
* @date 2018年6月24日  
*    
*/
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long>{

}
