package com.dongnao.autotest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongnao.autotest.service.mapper.CaseCaseMapper;

/**
 * 用例服务
 * 
 * @author easy
 *
 */
@Service("CaseCaseService")
public class CaseCaseServiceImpl {
	@Autowired
	private CaseCaseMapper caseCaseMapper;

	/**
	 * 新增用例信息
	 * 
	 * @param obj
	 * @return
	 */
	public int add(Map<String, Object> obj) {
		int id2 = caseCaseMapper.insert(obj);
		System.out.println("id2+++:"+id2);
		return id2;
	}

	/**
	 * 修改信息
	 * 
	 * @param obj
	 * @return
	 */
	public int update(Map<String, Object> obj) {
		return caseCaseMapper.update(obj);
	}

	/**
	 * 删除信息
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		return caseCaseMapper.delete(id);
	}

	/**
	 * 批量删除信息
	 * 
	 * @param idList
	 * @return
	 */
	public int deleteBatch(List<Integer> idList) {
		return caseCaseMapper.deleteBatch(idList);
	}

	/**
	 * 根据主键id查找信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> findById(int id) {
		return caseCaseMapper.selectById(id);
	}

	/**
	 * 根据条件查找信息
	 * 
	 * @param whereMap
	 * @return
	 */
	public List<Map<String, Object>> findList(Map<String, Object> whereMap) {
		return caseCaseMapper.selectList(whereMap);
	}

	/**
	 * 分页查找信息
	 * 
	 * @param pagerMap
	 * @return
	 */
	public List<Map<String, Object>> findPaged(Map<String, Object> pagerMap) {
		return caseCaseMapper.selectPaged(pagerMap);
	}

	// ↓↓↓↓↓↓↓↓↓↓ 扩展方法 ↓↓↓↓↓↓↓↓↓↓
	/**
	 * 查找所有用例信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> findAll() {
		return caseCaseMapper.selectAll();
	}
	// ↑↑↑↑↑↑↑↑↑↑ 扩展方法 ↑↑↑↑↑↑↑↑↑↑
}
