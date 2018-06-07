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

public class SearchPerson extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		PersonService service = new PersonServiceImpl();
		List<Person> pers = service.searchPerson(name);
		req.setAttribute("persons", pers);
		req.getRequestDispatcher("detail/Search.jsp").forward(req, resp);
	}
}
