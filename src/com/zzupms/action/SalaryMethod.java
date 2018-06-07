package com.zzupms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.zzupms.service.SalaryService;
import com.zzupms.service.impl.SalaryServiceImpl;

public class SalaryMethod extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html charset=utf-8");
		String m = req.getParameter("method");
		String username = req.getParameter("username");
		PrintWriter out = resp.getWriter();
		if(m.equals("uplevel")){
			if(username.equals("admin")){
			Integer id = Integer.parseInt(req.getParameter("id"));
			Integer level = Integer.parseInt(req.getParameter("level"));
			Integer salary = Integer.parseInt(req.getParameter("salary"));
			SalaryService service = new SalaryServiceImpl();
			if(level<11){
			int flag = service.uplevel(id,level,salary);
			if(flag > 0)
				req.getRequestDispatcher("showsalary?showkey=all").forward(req, resp);
			else{
			 out.print("<script>alert('未知错误');location.href='showsalary?showkey=all'</script>");
			}
		}else
		 out.print("<script>alert('员工已达到最高职位！');location.href='showsalary?showkey=all'</script>");
		}else
			 out.print("<script>alert('抱歉，您没有权限！');location.href='showsalary?showkey=all'</script>");
		}
		if(m.equals("updatebonus")){
			if(username.equals("admin")){
			Integer id = Integer.parseInt(req.getParameter("id"));
			Integer bonus = Integer.parseInt(req.getParameter("bonus"));
			SalaryService service = new SalaryServiceImpl();
			int flag = service.updateBonus(id,bonus);
			if(flag > 0)
				req.getRequestDispatcher("showsalary?showkey=all").forward(req, resp);
			else{
			 out.print("<script>alert('未知错误');location.href='showsalary?showkey=all'</script>");
			}
		}else
			out.print("<script>alert('抱歉，您没有权限！');location.href='showsalary?showkey=all'</script>");
		}
		if(m.equals("updatefine")){
			if(username.equals("admin")){
			Integer id = Integer.parseInt(req.getParameter("id"));
			Integer fine = Integer.parseInt(req.getParameter("fine"));
			SalaryService service = new SalaryServiceImpl();
			int flag = service.updateFine(id,fine);
			if(flag > 0)
				req.getRequestDispatcher("showsalary?showkey=all").forward(req, resp);
			else{
			 out.print("<script>alert('未知错误');location.href='showsalary?showkey=all'</script>");
			}
			}else
				out.print("<script>alert('抱歉，您没有权限！');location.href='showsalary?showkey=all'</script>");
		}
	}
}
