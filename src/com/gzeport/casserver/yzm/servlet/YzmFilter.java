package com.gzeport.casserver.yzm.servlet;

import com.ivan.zhang.CaptchaServiceSingleton;
import com.octo.captcha.service.image.ImageCaptchaService;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.InitializingBean;

public class YzmFilter implements InitializingBean, Filter {

	public YzmFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("fffffffffffffffffffffffffffff");
		boolean flag = false;
		StringBuffer servletPathBuff = (new StringBuffer())
				.append(((HttpServletRequest) request).getServletPath());
		if (((HttpServletRequest) request).getQueryString() != null)
			servletPathBuff.append("?").append(
					((HttpServletRequest) request).getQueryString());
		String servletPathInfo = servletPathBuff.toString();
		if (servletPathInfo.startsWith("/login")
				&& ((HttpServletRequest) request).getMethod().equals("POST")) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse rep = (HttpServletResponse) response;
			String yzm = request.getParameter("yzm");
			if (yzm == null) {
				rep.sendRedirect((new StringBuilder(String.valueOf(req
						.getContextPath()))).append("/login").toString());
				System.out.println("yzm Îª¿Õ");
			} else {
				System.out.println("yzm ²»Îª¿Õ");
				String captchaId = req.getSession().getId();
				flag = CaptchaServiceSingleton.getInstance()
						.validateResponseForID(captchaId, yzm).booleanValue();
				if (!flag)
					rep.sendRedirect((new StringBuilder(String.valueOf(req
							.getContextPath()))).append("/login").toString());
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("YzmFilter is init................");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("YzmFilter is afterPropertiesSet..................");
	}
}

