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
 * Servlet implementation class AddStudent
 */
public class AddStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//1.获取数据
			String sname = request.getParameter("sname");
			String sgender = request.getParameter("sgender");
			String sphone = request.getParameter("sphone");
			String sbirthday = request.getParameter("sbirthday");
			//String shobby = request.getParameter("shobby");
			String sinfo = request.getParameter("sinfo");
			String[] h = request.getParameterValues("shobby");
			String shobby = Arrays.toString(h);
			shobby = shobby.substring(1, shobby.length()-1);
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse(sbirthday);
			//2.添加到数据库
			
			Student student = new Student(sname, sgender, sphone, shobby, sinfo, date);
			StudentService service = new StudentServiceImpl();
			service.insert(student);
			
			//3.更新list。jsp页面
			//方法一，再查一次数据库，然后装到作用域中，然后再跳转
			//方法二，servlet跳转到StudentListServlet中
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
