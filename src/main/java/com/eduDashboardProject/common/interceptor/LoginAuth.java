package com.eduDashboardProject.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginAuth extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  throws Exception {
		
		if (request.getRequestURI().contains("/board")) {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("userInfo");
			
			// 로그인 체크
			if (ObjectUtils.isEmpty(obj)) {
				response.sendRedirect("/login/main.do");
				return false; // 컨트롤러 요청으로 가지 않도록 false 반환
			} 
			
		}
		return true;
	}

}
