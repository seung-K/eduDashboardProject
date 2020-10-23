package com.eduDashboardProject.sample.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduDashboardProject.common.vo.UserVO;
import com.eduDashboardProject.sample.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {
	
//	@Resource(name="SampleService")
//	private SampleService sampleService;
//	
//	@RequestMapping(value="/main.do", method=RequestMethod.GET)
//	public String main() throws Exception {
//		return "login/login";
//	}
//	
//	/*
//	 * @RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
//	 * 
//	 * @ResponseBody public Map<String, Object> loginCheck(HttpServletRequest
//	 * request, UserVO userVO) throws Exception {
//	 * 
//	 * Map<String, Object> map = new HashMap<>(); HttpSession session =
//	 * request.getSession(); // �쑀�� �젙蹂닿� �씪移섑븯�뒗吏� �솗�씤 if (sampleService.login(userVO) > 0)
//	 * { map.put("result", true); session.setAttribute("user", userVO); } else {
//	 * map.put("result", false); session.setAttribute("user", null); } return map; }
//	 */
//	
//	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
//	@ResponseBody
//	public boolean loginCheck(HttpServletRequest request, UserVO userVO) throws Exception {
//		
//		boolean result;
//		HttpSession session = request.getSession();
//		// �쑀�� �젙蹂닿� �씪移섑븯�뒗吏� �솗�씤
//		result = sampleService.login(userVO) > 0 ? true : false;
//		session.setAttribute("user", result ? userVO : null);
//		
//		return result;
//	}
}
