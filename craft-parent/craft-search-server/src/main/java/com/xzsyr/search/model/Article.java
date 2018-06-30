/**  
* @Title: Article.java  
* @Package com.xzsyr.search.model  
* @Description: TODO 
* @author jizhuang.wang 
* @date 2018年6月24日  
* @version V1.0  
*/ 
package com.xzsyr.search.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**  
* @ClassName: Article  
* @Description: TODO 
* @author jizhuang.wang  
* @date 2018年6月24日  
*    
*/
@Document(indexName="Article",type="article",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Article implements Serializable{
	/**  
	* @Fields field:field:{todo}
	*/
	private static final long serialVersionUID = -4977597504446395599L;
	@Id
    private Long articleId;
    /**标题*/
    private String title;
    /**摘要*/
    private String abstracts;
    /**内容*/
    private String content;
    /**发表时间*/
    private String postTime;
    /**点击率*/
    private Long clickCount;
    /**作者*/
    private Integer authorId;
    /**文章类型*/
    private String articleTypeId;
    /**文章专栏分类*/
    private String categoryId;
    /**文章标签*/
    private String lableId;
    /**是否私密*/
    private boolean isPrivate;
    /**是否发布*/
    private boolean isPublish;
	/**
	 * @return the articleId
	 */
	public Long getArticleId() {
		return articleId;
	}
	/**
	 * @param articleId the articleId to set
	 */
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the abstracts
	 */
	public String getAbstracts() {
		return abstracts;
	}
	/**
	 * @param abstracts the abstracts to set
	 */
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the postTime
	 */
	public String getPostTime() {
		return postTime;
	}
	/**
	 * @param postTime the postTime to set
	 */
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	/**
	 * @return the clickCount
	 */
	public Long getClickCount() {
		return clickCount;
	}
	/**
	 * @param clickCount the clickCount to set
	 */
	public void setClickCount(Long clickCount) {
		this.clickCount = clickCount;
	}
	/**
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the articleTypeId
	 */
	public String getArticleTypeId() {
		return articleTypeId;
	}
	/**
	 * @param articleTypeId the articleTypeId to set
	 */
	public void setArticleTypeId(String articleTypeId) {
		this.articleTypeId = articleTypeId;
	}
	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the lableId
	 */
	public String getLableId() {
		return lableId;
	}
	/**
	 * @param lableId the lableId to set
	 */
	public void setLableId(String lableId) {
		this.lableId = lableId;
	}
	/**
	 * @return the isPrivate
	 */
	public boolean isPrivate() {
		return isPrivate;
	}
	/**
	 * @param isPrivate the isPrivate to set
	 */
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	/**
	 * @return the isPublish
	 */
	public boolean isPublish() {
		return isPublish;
	}
	/**
	 * @param isPublish the isPublish to set
	 */
	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}
    
}
