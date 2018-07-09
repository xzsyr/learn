/**  
* @Title: ArticleSearchController.java  
* @Package com.xzsyr.search.controller  
* @Description: TODO 
* @author jizhuang.wang 
* @date 2018年6月24日  
* @version V1.0  
*/ 
package com.xzsyr.search.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xzsyr.common.ResponseBean;
import com.xzsyr.search.dao.ArticleSearchRepository;
import com.xzsyr.search.model.Article;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**  
* @ClassName: ArticleSearchController  
* @Description: TODO 
* @author jizhuang.wang  
* @date 2018年6月24日  
*    
*/
@RestController
@RequestMapping("/article")
@EnableSwagger2
public class ArticleSearchController {
	 @Autowired
	 private ArticleSearchRepository articleSearchRepository;
	 
	 /**  
	* @Title: saveArticleIndex  
	* @Description: TODO  新增文章
	* @param @return    参数  
	* @return ResponseBean    返回类型  
	* @throws  
	*/  
	@PostMapping("/add")
	 public ResponseBean saveArticleIndex() {
		return null;
	 }
	 
	  
	    /**  
	    * @Title: getArticleById  
	    * @Description: TODO  根据文章编号检索文章
	    * @param @param articleId
	    * @param @return    参数  
	    * @return ResponseBean    返回类型  
	    * @throws  
	    */  
	    @GetMapping("/get/{id}")
	    public ResponseBean getArticleById(@PathVariable Long articleId) {
	    	// return articleSearchRepository.findOne(articleId);
			return null;
	    }

	    /**  
	    * @Title: searchAll  
	    * @Description: TODO  全文检索（根据整个实体的所有属性，可能结果为0个）
	    * @param @param q
	    * @param @return    参数  
	    * @return ResponseBean    返回类型  
	    * @throws  
	    */  
	    @GetMapping("/select/{q}")
	    public ResponseBean searchAll(@PathVariable String q) {
	        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
	        Iterable<Article> searchResult = articleSearchRepository.search(builder);
	        Iterator<Article> iterator = searchResult.iterator();
	        List<Article> list = new ArrayList<Article>();
	        while (iterator.hasNext()) {
	            list.add(iterator.next());
	        }
	       // return list;
			return null;
	    }

	    /**  
	    * @Title: searchForPage  
	    * @Description: TODO  分页、分数、分域（结果一个也不少）
	    * @param @param page
	    * @param @param size
	    * @param @param q
	    * @param @return    参数  
	    * @return ResponseBean    返回类型  
	    * @throws  
	    */  
	    @GetMapping("/{page}/{size}/{q}")
	    public ResponseBean searchForPage(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String q) {

	        // 分页参数
	        Pageable pageable = new PageRequest(page, size);

	        // 分数，并自动按分排序
	        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
	                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", q)),
	                        ScoreFunctionBuilders.weightFactorFunction(1000)) // 权重：name 1000分
	                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("message", q)),
	                        ScoreFunctionBuilders.weightFactorFunction(100)); // 权重：message 100分

	        // 分数、分页
	        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable)
	                .withQuery(functionScoreQueryBuilder).build();

	        Page<Article> searchPageResults = articleSearchRepository.search(searchQuery);
	        searchPageResults.getContent();
			return null;

	    }
	    
	     
	    /**  
	    * @Title: remove  
	    * @Description: TODO  根据文章编号删除文章
	    * @param @param id
	    * @param @return    参数  
	    * @return ResponseBean    返回类型  
	    * @throws  
	    */  
	    @DeleteMapping("/remove/{id}")
	    public ResponseBean remove(@PathVariable Long id) {
	    	Article book = articleSearchRepository.findOne(id);
	    	articleSearchRepository.delete(id);
			return null;
	    }

	     
	    /**  
	    * @Title: edit  
	    * @Description: TODO  编辑修改文章内容
	    * @param @param article
	    * @param @return    参数  
	    * @return ResponseBean    返回类型  
	    * @throws  
	    */  
	    @PutMapping("/edit")
	    public ResponseBean edit(Article article) {
	    	articleSearchRepository.save(article);
			return null;
	    }
}
