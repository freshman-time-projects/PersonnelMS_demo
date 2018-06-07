package com.zzupms.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzupms.service.UserService;
import com.zzupms.service.impl.UserServiceImpl;

public class RegisterTest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		String qq = req.getParameter("qq");
		UserService user = new UserServiceImpl();
		user.register(0,username, password, password2,qq);
		req.getRequestDispatcher("index.html").forward(req, resp);
	}
}
