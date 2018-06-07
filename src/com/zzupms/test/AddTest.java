package com.zzupms.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzupms.entity.Person;
import com.zzupms.entity.Salary;
import com.zzupms.service.PersonService;
import com.zzupms.service.SalaryService;
import com.zzupms.service.impl.PersonServiceImpl;
import com.zzupms.service.impl.SalaryServiceImpl;


public class AddTest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			PersonService pservice = new PersonServiceImpl();
			SalaryService sservice = new SalaryServiceImpl();
			String name = req.getParameter("name");
			Integer age = Integer.parseInt(req.getParameter("age"));
			String sex = req.getParameter("sex");
			String married = req.getParameter("married");
			String idcard = req.getParameter("idcard");
			String edu = req.getParameter("edu");
			String school = req.getParameter("school");
			String mobile = req.getParameter("mobile");
			String address = req.getParameter("address");
			String email = req.getParameter("email");
			String org = req.getParameter("org");
			Person person = new Person();
			person.setName(name);
			person.setAge(age);
			person.setSex(sex);
			person.setEdu(edu);
			person.setAddress(address);
			person.setMarried(married);
			person.setMobile(mobile);
			person.setOrg(org);
			person.setSchool(school);
			person.setEmail(email);
			person.setIdcard(idcard);
			Salary s = new Salary();
			s.setName(name);
			s.setFine(0);
			s.setBonus(0);
			s.setSalary(3000);
			int flag = 0;
			flag = pservice.addPerson(person);
			flag += sservice.addSalary(s);
			if(flag > 1){
				PrintWriter out = resp.getWriter();
				out.print("<script>alert('添加成功！');location.href='personmethod?PersonMethod=show'</script>");
			}
		} catch (NumberFormatException e) {
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('请重新填写！');location.href='personmethod?PersonMethod=show'</script>");
		}
	}
}
