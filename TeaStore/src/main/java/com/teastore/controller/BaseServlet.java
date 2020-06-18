package com.teastore.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ͨ��Servlet
 *
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		if(null == methodName || "".equals(methodName)) {
			methodName = "execute";
//			System.out.println("����ҳ��");
//			return;
		}
		try {
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			String path = (String)method.invoke(this, request,response);
			if(null != path) {
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return null;
	}
}
