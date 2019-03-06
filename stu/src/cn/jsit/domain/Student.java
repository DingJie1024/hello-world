package cn.jsit.domain;

import java.util.Date;
/**
 * 封装的学生类的JavaBean
 * */
public class Student {
	private int sid;
	private String sname;
	private String sgender;
	private String sphone;
	private Date sbirthday;
	private String shobby;
	private String sinfo;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public Date getSbirthday() {
		return sbirthday;
	}
	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}
	public String getShobby() {
		return shobby;
	}
	public void setShobby(String shobby) {
		this.shobby = shobby;
	}
	public String getSinfo() {
		return sinfo;
	}
	public void setSinfo(String sinfo) {
		this.sinfo = sinfo;
	}
	public Student(String sname, String sgender, String sphone, String sinfo, String shobby, Date sbirthday) {
		super();
		this.sname = sname;
		this.sgender = sgender;
		this.sphone = sphone;
		this.sbirthday = sbirthday;
		this.shobby = shobby;
		this.sinfo = sinfo;
	}
	public Student(int sid,String sname, String sgender, String sphone, String sinfo, String shobby, Date sbirthday) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sgender = sgender;
		this.sphone = sphone;
		this.sbirthday = sbirthday;
		this.shobby = shobby;
		this.sinfo = sinfo;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sgender=" + sgender + ", sphone=" + sphone
				+ ", sbirthday=" + sbirthday + ", shobby=" + shobby + ", sinfo=" + sinfo + "]";
	}
	
}
