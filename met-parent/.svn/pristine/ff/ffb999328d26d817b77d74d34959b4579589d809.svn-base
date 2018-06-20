/**
 * 
 */
package com.example.demo.base;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author Stronger
 *
 */
@Service
public interface IBaseService<T> {
	 /**
     * @Description 根据主键查询一条实体
     * @param key 主键
     * @return
     */
    T selectByKey(Object key);
    /**
     * @Description 添加实体
     * @param entity 实体
     * @return
     */
    int save(T entity);
    /**
     * @Description 根据主键删除一条实体
     * @param key 主键
     * @return
     */
    int delete(Object key);
    /**
     * @Description 更新全字段实体
     * @param entity 实体
     * @return
     */
    int updateAll(T entity);
    /**
     * @Description 更新飞空字段实体
     * @param entity 实体
     * @return
     */
    int updateNotNull(T entity);
    /**
     * @Description 更具查询条件查询实体列表
     * @param entity 查询条件
     * @return
     */
    List<T> selectByExample(Object example);
}
