package cn.jsit.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jsit.domain.Student;
import cn.jsit.service.StudentService;
import cn.jsit.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		try {
			//1.获取数据
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String sgender = request.getParameter("sgender");
			String sphone = request.getParameter("sphone");
			String sbirthday = request.getParameter("sbirthday");
			String sinfo = request.getParameter("sinfo");
			String[] h = request.getParameterValues("shobby");
			String shobby = Arrays.toString(h);
			shobby = shobby.substring(1, shobby.length()-1);
			
			//2. 添加到数据库
			//string -- date
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sbirthday);
			Student stu = new Student(sid,sname, sgender, sphone, sbirthday, shobby,date);
			
			StudentService service = new StudentServiceImpl();
			service.update(stu);
			//3. 跳转界面
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
