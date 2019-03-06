package cn.jsit.dao;

import java.sql.SQLException;
import java.util.List;

import cn.jsit.domain.Student;
/**
 * 针对学生表的数据访问
 * */
public interface StudentDao {
	
	int PAGE_SIZE = 5;//换页查询中，规定一页查询5条
	
	List<Student> findStudnetByPage(int currentPage) throws SQLException;
	/**
	 * 查询所有学生
	 * */
	List<Student> findAll()throws SQLException;
	
	/**
	 * 模糊查询
	 * */
	List<Student> search(String sname,String sgender)throws SQLException;
	
	/**
	 * 添加学生信息
	 * */
	void insert(Student student)throws SQLException;

	void delete(int sid)throws SQLException;
	
	Student findStudentById(int sid)throws SQLException;
	
	void update(Student stu)throws SQLException;
	/**
	 * 查询总的学生记录数
	 * */
	int findCount() throws SQLException;
}
