package com.zzupms.entity;

public class Recruit {
	private Integer id;
	private String name;
	private String sex;
	private String school;
	private String edu;
	private String cv;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public Recruit() {
		super();
	}
	@Override
	public String toString() {
		return "Recruit [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", school=" + school + ", edu=" + edu + ", cv=" + cv + "]";
	}
	
}	
