package com.dongnao.autotest.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author mrluo735
 *
 */
@Controller
public class CommonViewController {
	/**
	 * 首页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/index");
	}
	
	/**
	 * 登录页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/login" })
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/login");
	}
	
	/**
	 * 注册页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/regist" })
	public ModelAndView regist(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/regist");
	}
	
	/**
	 * 用例页表列
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping(value = { "/case/case_list" })
	public ModelAndView caseList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/case/case_list");
	}
	/**
	 * 用例上传页
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping(value = { "/case/case_upload" })
	public ModelAndView caseUpload(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/case/case_upload");
	}
}
