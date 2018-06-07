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



public class ShowAllTest extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			PersonService service = new PersonServiceImpl();
			List<Person> pers = service.showAllPerson();
			req.setAttribute("persons", pers);
			req.getRequestDispatcher("detail/PersonList.jsp").forward(req, resp);
		}catch(Exception e ){
			e.printStackTrace();
		}
		
	}
}
