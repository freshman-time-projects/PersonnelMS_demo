package com.zzupms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzupms.entity.User;
import com.zzupms.service.UserService;
import com.zzupms.service.impl.UserServiceImpl;

public class UserAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int flag = 0;
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String Userkey = req.getParameter("UserKey");
		System.out.println(Userkey);
		UserService user = new UserServiceImpl();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(Userkey.equals("login")){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		flag = user.login(username, password);
		if(flag > 0){
			req.getSession().setAttribute("username", username);
			req.getRequestDispatcher("detail/main.jsp").forward(req, resp);
		}else{
			 out.print("<script>alert('登录失败，账号或密码错误!!!');location.href='index.html'</script>");
		}
	}
	if(Userkey.equals("register")){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		String qq = req.getParameter("qq");
		if(user.register(0,username, password, password2,qq)){
		 out.print("<script>alert('注册成功，去登录吧！');location.href='index.html'</script>");
		}
	}if(Userkey.equals("logout")){
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html charset=utf-8");
		req.getSession().removeAttribute("username");
		 out.print("<script>alert('已注销！');location.href='index.html'</script>");
	}
	if(Userkey.equals("show")){
		List<User> users = user.queryAll();
		req.setAttribute("user", users);
		req.getRequestDispatcher("detail/showUsers.jsp").forward(req, resp);
		
	}if(Userkey.equals("modify")){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String newpassword = req.getParameter("newpassword");
		String newpassword2 = req.getParameter("newpassword2"); 
		try {
			System.out.println(username+" "+password);
			flag = user.login(username, password);
			if(flag>0&&newpassword.equals(newpassword2)){
				System.out.println(newpassword+" "+newpassword2);
				flag = user.modifyUser(username, newpassword);
				System.out.println(flag);
				if(flag > 0)
					 out.print("<script>alert('修改成功!');location.href='usermethod?UserKey=show'</script>");
			}else{
				if(flag == 0)
				out.print("<script>alert('修改失败，请完善信息!');location.href='usermethod?UserKey=show'</script>");
				if(!newpassword.equals(newpassword2))
				out.print("<script>alert('两次输入的密码不一致!');location.href='usermethod?UserKey=show'</script>");
			}
			
				} catch (Exception e) {
			e.printStackTrace();
		}
	}if(Userkey.equals("remove")){
		String username = req.getParameter("username");
		flag = user.removeUser(username);
		if(flag > 0)
			 out.print("<script>alert('移除成功!');location.href='usermethod?UserKey=show'</script>");
	}
	}
}
