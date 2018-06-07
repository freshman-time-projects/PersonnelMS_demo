package com.zzupms.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzupms.entity.Person;
import com.zzupms.service.PersonService;
import com.zzupms.service.impl.PersonServiceImpl;


public class ShowById extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("org_id"));
		try{
			PersonService service = new PersonServiceImpl();
			List<Person> pers = service.showPersonById(id);
			req.setAttribute("persons", pers);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
}
