package com.zzupms.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzupms.service.UserService;
import com.zzupms.service.impl.UserServiceImpl;

public class LoginTest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String Userkey = req.getParameter("UserKey");
		if(Userkey.equals("login")){
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html charset=utf-8");
		int flag = 0;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService user = new UserServiceImpl();
		flag = user.login(username, password);
		if(flag > 0){
			req.getSession().setAttribute("username", username);
			req.getRequestDispatcher("detail/main.jsp").forward(req, resp);
		}else{
			PrintWriter out = resp.getWriter();
			 out.print("<script>alert('用户名或密码错误，请重试!');location.href='index.html'</script>");
		}
	}
	if(Userkey.equals("register")){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		String qq = req.getParameter("qq");
		UserService user = new UserServiceImpl();
		user.register(0,username, password, password2,qq);
		req.getRequestDispatcher("index.html").forward(req, resp);
	}if(Userkey.equals("logout")){
		req.getSession().removeAttribute("username");
		req.getRequestDispatcher("../index.html").forward(req, resp);
	}
}
	}
