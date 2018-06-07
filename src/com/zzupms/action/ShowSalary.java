package com.zzupms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zzupms.entity.Salary;
import com.zzupms.service.SalaryService;
import com.zzupms.service.impl.SalaryServiceImpl;

public class ShowSalary extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String k = req.getParameter("showkey");
		System.out.println(k);
		try{
			if(k.equals("salarydesc")){
				SalaryService service = new SalaryServiceImpl();
				List<Salary> salarys = service.showAllSalary("salarydesc");
				req.setAttribute("Salarys", salarys);
				req.getRequestDispatcher("detail/Salary.jsp").forward(req, resp);
			}
			if(k.equals("bonusdesc")){
				SalaryService service = new SalaryServiceImpl();
				List<Salary> salarys = service.showAllSalary("bonusdesc");
				req.setAttribute("Salarys", salarys);
				req.getRequestDispatcher("detail/Salary.jsp").forward(req, resp);
			}
			if(k.equals("finedesc")){
				SalaryService service = new SalaryServiceImpl();
				List<Salary> salarys = service.showAllSalary("finedesc");
				req.setAttribute("Salarys", salarys);
				req.getRequestDispatcher("detail/Salary.jsp").forward(req, resp);
			}
			if(k.equals("finaldesc")){
				SalaryService service = new SalaryServiceImpl();
				List<Salary> salarys = service.showAllSalary("finaldesc");
				req.setAttribute("Salarys", salarys);
				req.getRequestDispatcher("detail/Salary.jsp").forward(req, resp);
			}
			SalaryService service = new SalaryServiceImpl();
			List<Salary> salarys = service.showAllSalary("all");
//			Gson gson = new Gson();
//			String json = gson.toJson(salarys);
//			resp.setContentType("text/html;charset=utf-8");
//			//允许跨域
//			resp.setHeader("Access-Control-Allow-Origin", "*"); 
//			PrintWriter out = resp.getWriter();
//			//Gson 传输数据、
//			out.print(json);
		
			req.setAttribute("Salarys", salarys);
			req.getRequestDispatcher("detail/Salary.jsp").forward(req, resp);
		}catch(Exception e ){
			e.printStackTrace();
		}
		
	}
}
