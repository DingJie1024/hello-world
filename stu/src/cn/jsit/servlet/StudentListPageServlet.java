package cn.jsit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jsit.domain.PageBean;
import cn.jsit.service.StudentService;
import cn.jsit.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentListPageServlet
 */
public class StudentListPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		//获取需要的页码数
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//根据指定的页数，去获取该页的数据回来
		StudentService service = new StudentServiceImpl();
		PageBean pageBean = service.findStudnetByPage(currentPage);
		
		request.setAttribute("pageBean", pageBean);
		//跳转页面
		request.getRequestDispatcher("list_page.jsp").forward(request, response);
		}catch(SQLException e) {
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
