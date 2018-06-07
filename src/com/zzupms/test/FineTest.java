package com.zzupms.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzupms.service.SalaryService;
import com.zzupms.service.impl.SalaryServiceImpl;

public class FineTest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Integer fine = Integer.parseInt(req.getParameter("fine"));
		SalaryService service = new SalaryServiceImpl();
		int flag = service.updateFine(id,fine);
		if(flag > 0)
			req.getRequestDispatcher("showsalary").forward(req, resp);
	}
}
