package com.zzupms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzupms.entity.Face;
import com.zzupms.service.FaceService;
import com.zzupms.service.impl.FaceServiceImpl;

public class FaceAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html charset=utf-8");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		int flag = 0;
		String FaceMethod = req.getParameter("facemethod");
		FaceService service = new FaceServiceImpl();
		if(FaceMethod.equals("add")){
			//该方法由管理员通过数据库使用
		}if(FaceMethod.equals("show")){
			List<Face> face = service.queryAllFace();
		     req.setAttribute("list",face);
		     req.getRequestDispatcher("detail/face.jsp").forward(req, resp);
		}if(FaceMethod.equals("remove")){
			if(username.equals("admin")){
			Integer id = Integer.parseInt(req.getParameter("id"));
			flag = service.removeFace(id);
			if(flag>0)
			{
			out.print("<script>alert('操作成功!');location.href='facemethod?facemethod=show'</script>");
			}
			}else{
			out.print("<script>alert('抱歉，您没有权限！');location.href='facemethod?facemethod=show'</script>");
			}
		}
	}

}
