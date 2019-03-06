package cn.jsit.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.jsit.dao.StudentDao;
import cn.jsit.domain.Student;
import cn.jsit.util.JDBCUtil02;
import cn.jsit.util.TestUtils;
/**
 * 这是StudentDao的实现。针对前面定义的规范，做出具体的实现
 * */
public class StudentDaoImpl implements StudentDao {
	
	/**
	 * 查询所有的学生
	 * @throws SQLException 
	 * */
	public List<Student> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu";
		List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	public void insert(Student student) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "insert into stu values(null,?,?,?,?,?,?)";
		qr.update(sql, student.getSname(),
					   student.getSgender(),
					   student.getSphone(),
					   student.getSbirthday(),
					   student.getShobby(),
					   student.getSinfo());
		
	}

	public void delete(int sid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "delete from stu where sid = ?";
		qr.update(sql, sid);
	}

	public Student findStudentById(int sid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu where sid = ?";
		return qr.query(sql, new BeanHandler<Student>(Student.class),sid);
		
	}

	public void update(Student stu) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sname=? , sgender=? , sphone=? , sbirthday=? , shobby=? , sinfo=? where sid = ?", 
				stu.getSname(),
				stu.getSgender(),
				stu.getSphone(),
				stu.getSbirthday(),
				stu.getShobby(),
				stu.getSinfo(),
				stu.getSid());
		
	}

	public List<Student> search(String sname, String sgender) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil02.getDataSource());
		 
		
		/*sql语句分析
		 * 1.如果只有姓名 select * from stu where sname like ?
		 * 2.如果只有性别select * from stu where sgender = ?
		 * 3.如果既有姓名又有性别 select * from stu where sname like ? and sgender = ?
		 * 4.如果两者都没有，查询全部
		 * 
		 * */
		String sql = "select * from stu where 1=1 ";
		List<String> list = new ArrayList<String>();
		if(!TestUtils.idEmpty(sname)) {
			sql = sql + " and sname like ? ";
			list.add("%"+sname+"%");
		}
		if(!TestUtils.idEmpty(sgender)) {
			sql = sql + " and sgender = ? ";
			list.add(sgender);
		}
		
		
		return qr.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
	}

	public List<Student> findStudnetByPage(int currentPage) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil02.getDataSource());
		//第一个问好是指“一页返回多少条记录”，第二个问号指跳过前面多少条记录
		//第一页   5   0
		//第二页   5   5
		//第三页  5   10
		//第四页   5   15
		//第currentPage页   5   (currentPage-1)*5
		String sql = "select * from stu limit ? offset ?";
		return qr.query(sql, new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
	}

	public int findCount() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select count(*) from stu";
		Long result = (Long) qr.query(sql, new ScalarHandler());
		return result.intValue();
	}

	
	
}
