package com.st.back.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 禁止用户直接访问filter指定的目录下的页面（除了/back/jsps/index.jsp），
 * 但是允许/back/jsps/index.jsp包含页面的操作
 * @author Kor_Zhang
 *
 */
public class BacksJspVisitorFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String sourceJspPath = "/back/jsps/index.jsp";
		String errorJspPath = "/back/jsps/error.jsp";
		//request.getRequestURI()的内容为/st/back/jsps/index.jsp
		//如果请求back包下的主页，那么允许
		if(request.getRequestURI().equals(request.getContextPath()+sourceJspPath)){
			chain.doFilter(request, response);
		}else{
			//request.getHeader("referer")内容为http://localhost:8080/st/back/jsps/index.jsp
			String refer = request.getHeader("referer");
			///如果不是/back/jsps/index.jsp发出的请求，那么拒绝的访问
			if(refer==null||refer.indexOf(request.getContextPath()+sourceJspPath)<=0){
				request.setAttribute("msg", "您无权限访问此页面，请谨慎操作！");
				request.setAttribute("title", "请谨慎操作！");
				request.getRequestDispatcher(errorJspPath).forward(request, response);
			}else{
				chain.doFilter(request, response);
			}
		}
		
		
	}

	@Override
	public void destroy() {
		
	}

}
