package com.zzupms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzupms.entity.Face;
import com.zzupms.entity.Page;
import com.zzupms.entity.Recruit;
import com.zzupms.service.FaceService;
import com.zzupms.service.RecruitService;
import com.zzupms.service.impl.FaceServiceImpl;
import com.zzupms.service.impl.RecruitServiceImpl;

public class RecruitAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String RecruitMethod = req.getParameter("RecruitMethod");
    	RecruitService service = new RecruitServiceImpl();
    	System.out.println(RecruitMethod);
    	String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String school  = req.getParameter("school");
		String edu = req.getParameter("edu");
		String cv = req.getParameter("cv");
    	if(RecruitMethod.equals("add")){
    		Recruit recruit = new Recruit();
    		recruit.setName(name);
    		recruit.setSchool(school);
    		recruit.setSex(sex);
    		recruit.setCv(cv);
    		recruit.setEdu(edu);
    		service.insertRecruit(recruit);
    		PrintWriter out = resp.getWriter();
    		out.print("<script>alert('添加成功!');location.href='recruitmethod?RecruitMethod=show'</script>");
    	}    		
    	if(RecruitMethod.equals("show")){
        List<Recruit> list=  service.queryAllRecruit();
        //页面当前页
        int page=0;
        //得到传过来的当前页
        String str_page= req.getParameter("page");
        /**
         * 创建分页的关于一些内容的工具bean
         * 
         * */
        Page Page=new Page();
        Page.setList_recruit(list);//从数据库得到数据存入的list集合
        Page.setCount_recruit();//数据总数
        Page.setPagesize_recruit(10);//一个页面的数据多少条
        Page.setPagenumber_recruit();//总的页面数
        Page.setEndpage_recruit();//最后一页
        Page.setIndexpage_recruit(1);//第一页
        if (str_page!=null) {
            //将页转换整型判断其大小
            int pag=Integer.parseInt(str_page);
            //当大于零，将传过来的pag值赋给当前页page
            if (pag>=0) {
                page=pag;
                //如果小于最大值时则，将其传过来的值减1在赋值给当前页，让其一直在最后一页
                if (pag>(Page.getPagenumber_recruit()-1)) {
                    page=pag-1;
                }
            }
        }
        Page.setPage_recruit(page);//最终确认当前页
        List<Recruit> list_page =new ArrayList<Recruit>();
        //将当前页的值传给新的list_page集合中，list集合是全部数据综合，用i调用其中的几条数据给list_page
        for (int i = Page.getPage_recruit()*Page.getPagesize_recruit(); i <(Page.getPage_recruit()+1)*Page.getPagesize_recruit()&&i<list.size(); i++) {
            list_page.add(list.get(i));
        }
        //将Page对象其设置在作用域中，以便后面页面调用
        req.setAttribute("page", Page);
        req.setAttribute("list", list_page);
        req.getRequestDispatcher("detail/RecruitList.jsp").forward(req, resp);
    }if(RecruitMethod.equals("gotoFace")){	
    	Integer recruit_id = Integer.parseInt(req.getParameter("id"));
    	String username = req.getParameter("username");
    	if(username.equals("admin")){
    	int flag = 0;
    	int key = 0;
    	flag = service.gotoFace(recruit_id);
    	FaceService fs = new FaceServiceImpl();
    	Recruit recruit = service.queryRecruitById(recruit_id);
    	Face face = new Face();
    	face.setRecruit_id(recruit_id);
    	face.setEdu(recruit.getEdu());
    	face.setCv(recruit.getCv());
    	face.setName(recruit.getName());
    	face.setSchool(recruit.getSchool());
    	face.setSex(recruit.getSex());
    	flag = fs.addFace(face);
    	key = service.delete(recruit_id);
    	if(flag > 0&& key>0){
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('操作成功!');location.href='recruitmethod?RecruitMethod=show'</script>");
			 }
    	}else{
    	PrintWriter out = resp.getWriter();
		out.print("<script>alert('抱歉，您没有权限!');location.href='recruitmethod?RecruitMethod=show'</script>");
    }
}
	}
	}
