package cn.jsit.service.Impl;

import java.sql.SQLException;
import java.util.List;

import cn.jsit.dao.StudentDao;
import cn.jsit.dao.impl.StudentDaoImpl;
import cn.jsit.domain.PageBean;
import cn.jsit.domain.Student;
import cn.jsit.service.StudentService;

public class StudentServiceImpl implements StudentService {

	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
		
	}

	public void delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(sid);
		
	}

	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	public void update(Student stu) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(stu);
		
	}

	public List<Student> search(String sname, String sgender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.search(sname, sgender);
	}

	public PageBean findStudnetByPage(int currentPage) throws SQLException {
//		private int currentPage;//当前页
//		private int totalPage;//总页数
//		private int pageSize;//每页的记录数
//		private int totalSize;//总的记录数
//		private List<T> list;//当前页的学生集合
		PageBean<Student> pageBean = new PageBean<Student>();
		
		int pageSize = StudentDao.PAGE_SIZE;
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		StudentDao dao = new StudentDaoImpl();
		List<Student> list = dao.findStudnetByPage(currentPage);
		pageBean.setList(list);
		
		int count = dao.findCount();
		pageBean.setTotalSize(count);
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1);//总页数
		
		return pageBean;
	}

	

}
