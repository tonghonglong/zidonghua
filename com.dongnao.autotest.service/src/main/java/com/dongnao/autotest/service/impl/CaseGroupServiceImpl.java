package com.dongnao.autotest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongnao.autotest.service.mapper.CaseGroupMapper;

/**
 * 分组服务
 * 
 * @author easy
 *
 */
@Service("CaseGroupService")
public class CaseGroupServiceImpl {
	@Autowired
	private CaseGroupMapper caseGroupMapper;

	/**
	 * 新增分组信息
	 * 
	 * @param obj
	 * @return
	 */
	public int add(Map<String, Object> obj) {
		int id = caseGroupMapper.insert(obj);
		System.out.println("id========："+id);
		return id;
	}

	/**
	 * 修改信息
	 * 
	 * @param obj
	 * @return
	 */
	public int update(Map<String, Object> obj) {
		return caseGroupMapper.update(obj);
	}

	/**
	 * 删除信息
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		return caseGroupMapper.delete(id);
	}

	/**
	 * 批量删除信息
	 * 
	 * @param idList
	 * @return
	 */
	public int deleteBatch(List<Integer> idList) {
		return caseGroupMapper.deleteBatch(idList);
	}

	/**
	 * 根据主键id查找信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> findById(int id) {
		return caseGroupMapper.selectById(id);
	}

	/**
	 * 根据条件查找信息
	 * 
	 * @param whereMap
	 * @return
	 */
	public List<Map<String, Object>> findList(Map<String, Object> whereMap) {
		return caseGroupMapper.selectList(whereMap);
	}

	/**
	 * 分页查找信息
	 * 
	 * @param pagerMap
	 * @return
	 */
	public List<Map<String, Object>> findPaged(Map<String, Object> pagerMap) {
		return caseGroupMapper.selectPaged(pagerMap);
	}

	// ↓↓↓↓↓↓↓↓↓↓ 扩展方法 ↓↓↓↓↓↓↓↓↓↓
	/**
	 * 查找所有分组信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> findAll() {
		return caseGroupMapper.selectAll();
	}
	// ↑↑↑↑↑↑↑↑↑↑ 扩展方法 ↑↑↑↑↑↑↑↑↑↑
}
