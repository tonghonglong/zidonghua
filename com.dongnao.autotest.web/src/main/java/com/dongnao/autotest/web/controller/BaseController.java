package com.dongnao.autotest.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	/**
	 * 重载+1 返回结果
	 * 
	 * @param code
	 * @param message
	 * @param data
	 * @return
	 */
	protected Map<String, Object> doResult(int code, String message) {
		return this.doResult(code, message, null);
	}

	/**
	 * 重载+2 返回结果
	 * 
	 * @param code
	 * @param message
	 * @param data
	 * @return
	 */
	protected Map<String, Object> doResult(int code, String message, Map<String, Object> data) {
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("success", HttpStatus.OK.value() == code ? true : false);
		resMap.put("code", code);
		resMap.put("data", data);
		resMap.put("message", message);
		return resMap;
	}

	/**
	 * 重载+1 失败结果
	 * 
	 * @param code
	 * @param message
	 * @return
	 */
	protected Map<String, Object> doFailureResult(int code, String message) {
		return this.doFailureResult(code, message, null);
	}

	/**
	 * 重载+2 失败结果
	 * 
	 * @param code
	 * @param message
	 * @param data
	 * @return
	 */
	protected Map<String, Object> doFailureResult(int code, String message, Map<String, Object> data) {
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("success", false);
		resMap.put("code", code);
		resMap.put("data", data);
		resMap.put("message", message);
		return resMap;
	}
}
