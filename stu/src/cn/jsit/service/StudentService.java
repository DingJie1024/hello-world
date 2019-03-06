package cn.jsit.service;

import java.sql.SQLException;
import java.util.List;

import cn.jsit.domain.PageBean;
import cn.jsit.domain.Student;

public interface StudentService {
	/**
	 * 分页查询
	 * */
	PageBean findStudnetByPage(int currentPage) throws SQLException;
	
	List<Student> findAll()throws SQLException;
	/**
	 * 添加学生信息
	 * */
	void insert(Student student)throws SQLException;
	
	void delete(int sid)throws SQLException;
	
	Student findStudentById(int sid)throws SQLException;
	
	void update(Student stu)throws SQLException;
	
	/**
	 * 模糊查询
	 * */
	List<Student> search(String sname,String sgender)throws SQLException;
}
