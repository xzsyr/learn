/**
 * 
 */
package com.example.demo.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Stronger
 *
 */
public class BaseServiceImpl<T> implements IBaseService<T>  {
	    @Autowired
	    protected IBaseMapper<T> baseMapper;

	    public IBaseMapper<T> getbaseMapper() {
	        return baseMapper;
	    }

	    public T selectByKey(Object key) {
	        return baseMapper.selectByPrimaryKey(key);
	    }

	    public int updateNotNull(T entity) {
	        return baseMapper.updateByPrimaryKeySelective(entity);
	    }

	    public int save(T entity) {
	        return baseMapper.insert(entity);
	    }

	    public int delete(Object key) {
	        return baseMapper.deleteByPrimaryKey(key);
	    }

	    public int updateAll(T entity) {
	        return baseMapper.updateByPrimaryKey(entity);
	    }

	    public List<T> selectByExample(Object example) {
	        return baseMapper.selectByExample(example);
	    }

}
