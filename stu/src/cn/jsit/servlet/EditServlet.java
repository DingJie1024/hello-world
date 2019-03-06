package cn.jsit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jsit.domain.Student;
import cn.jsit.service.StudentService;
import cn.jsit.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			StudentService service = new StudentServiceImpl();
			Student stu = service.findStudentById(sid);
			
			request.setAttribute("stu", stu);
			
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
