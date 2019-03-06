package cn.jsit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jsit.domain.Student;
import cn.jsit.service.StudentService;
import cn.jsit.service.Impl.StudentServiceImpl;

/**
 * 模糊查询的Servlet
 */
public class SearchStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
		//获取数据
		String sname = request.getParameter("sname");
		String sgender = request.getParameter("sgender");
		
		//找service去查询
		StudentService service = new StudentServiceImpl();
		List<Student> list = service.search(sname, sgender);
		request.setAttribute("list", list);
		//跳转页面
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
