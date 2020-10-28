package com.eduDashboardProject.regist.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduDashboardProject.common.vo.UserVO;
import com.eduDashboardProject.regist.service.RegistService;

@Controller
@RequestMapping(value = "/regist")
public class RegistController {
	
	@Resource(name = "registService")
	private RegistService registService;
	
	@RequestMapping(value = "/registForm.do")
	public String MoveRegistForm() throws Exception {
		return "/regist/regist";
	}
	
	@RequestMapping(value = "/duplicateCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> duplicateCheck(HttpServletRequest request, @RequestParam String id) throws Exception {
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", registService.duplicateCheck(id) > 0 ? true : false );
		
		return map;
	}
	
	@RequestMapping(value = "/regist.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> insertUser(HttpServletRequest request, @ModelAttribute(name="userVO") UserVO userVO) throws Exception {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", registService.insertUser(userVO));
		
		return map;
	}
}
