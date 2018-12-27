package com.dongnao.autotest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongnao.autotest.service.mapper.CaseStepMapper;

/**
 * 步骤服务
 * 
 * @author easy
 *
 */
@Service("CaseStepService")
public class CaseStepServiceImpl {
	@Autowired
	private CaseStepMapper caseStepMapper;

	/**
	 * 新增步骤信息
	 * 
	 * @param obj
	 * @return
	 */
	public int add(Map<String, Object> obj) {
		return caseStepMapper.insert(obj);
	}

	/**
	 * 修改信息
	 * 
	 * @param obj
	 * @return
	 */
	public int update(Map<String, Object> obj) {
		return caseStepMapper.update(obj);
	}

	/**
	 * 删除信息
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		return caseStepMapper.delete(id);
	}

	/**
	 * 批量删除信息
	 * 
	 * @param idList
	 * @return
	 */
	public int deleteBatch(List<Integer> idList) {
		return caseStepMapper.deleteBatch(idList);
	}

	/**
	 * 根据主键id查找信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> findById(int id) {
		return caseStepMapper.selectById(id);
	}

	/**
	 * 根据条件查找信息
	 * 
	 * @param whereMap
	 * @return
	 */
	public List<Map<String, Object>> findList(Map<String, Object> whereMap) {
		return caseStepMapper.selectList(whereMap);
	}

	/**
	 * 分页查找信息
	 * 
	 * @param pagerMap
	 * @return
	 */
	public List<Map<String, Object>> findPaged(Map<String, Object> pagerMap) {
		return caseStepMapper.selectPaged(pagerMap);
	}

	// ↓↓↓↓↓↓↓↓↓↓ 扩展方法 ↓↓↓↓↓↓↓↓↓↓
	/**
	 * 查找所有步骤信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> findAll() {
		return caseStepMapper.selectAll();
	}
	// ↑↑↑↑↑↑↑↑↑↑ 扩展方法 ↑↑↑↑↑↑↑↑↑↑
}
