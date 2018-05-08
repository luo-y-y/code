package com.config.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cat.common.anon.LoginNeed;

 /**
  * 与HandlerInterceptor接口类似，区别是 WebRequestInterceptor 的 preHandle 没有返回值。
  * WebRequestInterceptor 是针对请求的，接口方法参数中没有response。
  * @author luoyang
  *
  */
public class WebDoInterceptor  implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("app拦截的 afterCompletion");

	}

	public void postHandle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("app拦截的 postHandle");

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		boolean bool = false;
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LoginNeed loginNeed = handlerMethod.getMethodAnnotation(LoginNeed.class);
            //标记为不需要登录的不校验
            if (loginNeed != null && loginNeed.value() == false) {
                return true;
            }
        }
    

		if (!bool) {
			bool = isExistLoginUser(request);
		}

		if (!bool) {
			redirectLogin(request, response);
		}
		return bool;
	}

	private boolean isExistLoginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (null == session) {
			return false;
		}
		Object syUser = session.getAttribute("syUser");
		if (null == syUser) {
			return false;
		}
		return true;
	}

	private void redirectLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			request.getRequestDispatcher("/sy/user/logout.do").forward(
					request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
}
