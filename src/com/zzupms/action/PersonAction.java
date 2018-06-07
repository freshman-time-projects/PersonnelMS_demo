package com.zzupms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.zzupms.dao.PersonDao;
import com.zzupms.entity.Page;
import com.zzupms.entity.Person;
import com.zzupms.entity.Salary;
import com.zzupms.service.PersonService;
import com.zzupms.service.SalaryService;
import com.zzupms.service.impl.PersonServiceImpl;
import com.zzupms.service.impl.SalaryServiceImpl;
import com.zzupms.util.MyBatisUtil;

public class PersonAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    @Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	int flag = 0;
    	req.setCharacterEncoding("utf-8");
    	resp.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();

    	String method = req.getParameter("PersonMethod");
    	PersonService service = new PersonServiceImpl();
    	if(method.equals("show")){
    	SqlSession session = null;
    	session = MyBatisUtil.openSession();
		PersonDao DAO = session.getMapper(PersonDao.class);
        List<Person> list=  DAO.queryAllPersons();
        session.commit();
        //页面当前页
        int page=0;
        //得到传过来的当前页
        String str_page= req.getParameter("page");
        /**
         * 创建分页的关于一些内容的工具bean
         * 
         * */
        Page Page=new Page();
        Page.setList(list);//从数据库得到数据存入的list集合
        Page.setCount();//数据总数
        Page.setPagesize(20);//一个页面的数据多少条
        Page.setPagenumber();//总的页面数
        Page.setEndpage();//最后一页
        Page.setIndexpage(1);//第一页
        if (str_page!=null) {
            //将页转换整型判断其大小
            int pag=Integer.parseInt(str_page);
            //当大于零，将传过来的pag值赋给当前页page
            if (pag>=0) {
                page=pag;
                //如果小于最大值时则，将其传过来的值减1在赋值给当前页，让其一直在最后一页
                if (pag>(Page.getPagenumber()-1)) {
                    page=pag-1;
                }
            }
        }
        Page.setPage(page);//最终确认当前页
        List<Person> list_page =new ArrayList<Person>();
        //将当前页的值传给新的list_page集合中，list集合是全部数据综合，用i调用其中的几条数据给list_page
        for (int i = Page.getPage()*Page.getPagesize(); i <(Page.getPage()+1)*Page.getPagesize()&&i<list.size(); i++) {
            list_page.add(list.get(i));
        }
        //将Page对象其设置在作用域中，以便后面页面调用
        req.setAttribute("page", Page);
        req.setAttribute("list", list_page);
        req.getRequestDispatcher("detail/PersonList.jsp").forward(req, resp);
    	}if(method.equals("search")){
    		req.setCharacterEncoding("utf-8");
    		resp.setCharacterEncoding("utf-8");
    		String name = URLEncoder.encode(req.getParameter("name"),"UTF-8");
    		List<Person> pers = service.searchPerson(name);
    		req.setAttribute("persons", pers);
    		req.getRequestDispatcher("detail/Search.jsp").forward(req, resp);
    	}if(method.equals("add")){
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
    			flag = pservice.addPerson(person);
    			flag += sservice.addSalary(s);
    			if(flag > 1){
    				req.getRequestDispatcher("personmethod?PersonMethod=show").forward(req, resp);
    			}
    		} catch (NumberFormatException e) {
    			
    			out.print("<script>alert('请重新填写！');location.href='list'</script>");
    		}
    	}
    	if(method.equals("update_jsp")){
        	String username = req.getParameter("username");
    		if(username.equals("admin")){
    			Integer id = Integer.parseInt(req.getParameter("id"));
    			List<Person> persons = service.showPersonById(id);
    			req.setAttribute("persons", persons);
        		req.getRequestDispatcher("detail/updatePerson.jsp").forward(req, resp);
    		}else{
    			out.print("<script>alert('抱歉，您没有权限！');location.href='personmethod?PersonMethod=show'</script>");
    		}
    	}
    	if(method.equals("update")){
    		req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			Integer id = Integer.parseInt(req.getParameter("id").trim());
			String name = req.getParameter("name");
			Integer age = Integer.parseInt(req.getParameter("age").trim());
			String sex = req.getParameter("sex");
			String married = req.getParameter("married");
			String idcard = req.getParameter("idcard");
			String edu = req.getParameter("edu");
			String school = req.getParameter("school");
			String mobile = req.getParameter("mobile");
			String address = req.getParameter("address");
			String email = req.getParameter("email");
			Person person = new Person();
			person.setName(name);
			person.setAge(age);
			person.setSex(sex);
			person.setEdu(edu);
			person.setAddress(address);
			person.setMarried(married);
			person.setMobile(mobile);
			person.setSchool(school);
			person.setEmail(email);
			person.setIdcard(idcard);
			person.setId(id);
			flag = service.updatePerson(person);
    			if(flag > 0)
    				out.print("<script>alert('修改成功！');location.href='personmethod?PersonMethod=show'</script>");
    			else
    				out.print("<script>alert('修改失败！！！');location.href='personmethod?PersonMethod=show'</script>");
    	}if(method.equals("remove")){
    		int key=0;
        	String username = req.getParameter("username");
    		if(username.equals("admin")){
    			Integer id = Integer.parseInt(req.getParameter("id"));
    			flag = service.removePerson(id);
    			SalaryService sservice = new SalaryServiceImpl();
    			key = sservice.removeSalary(id);
    			if(flag > 0&& key>0)
    				out.print("<script>alert('删除成功！');location.href='personmethod?PersonMethod=show'</script>");
    			else
    				out.print("<script>alert('删除失败！！！');location.href='personmethod?PersonMethod=show'</script>");
    		}else{
    			out.print("<script>alert('抱歉，您没有权限！');location.href='personmethod?PersonMethod=show'</script>");
        	}
    	}
    }

}