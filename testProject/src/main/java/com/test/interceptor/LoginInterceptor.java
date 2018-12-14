package com.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
	private static final Logger Logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object memberVO = modelMap.get("memberVO");
		
		if(memberVO != null) {
			Logger.info("new login success");
			session.setAttribute(LOGIN, memberVO);
			//response.sendRedirect("/");
			
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null ? (String)dest : "/");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		// login info remove
		if(session.getAttribute(LOGIN) != null) {
			Logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		return true;
	}
}
