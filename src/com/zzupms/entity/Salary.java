package com.zzupms.entity;

public class Salary {
	private Integer id;
	private String name;
	private Integer salary;
	private Integer bonus;
	private Integer fine;
	private Integer level;
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	public Integer getFine() {
		return fine;
	}
	public void setFine(Integer fine) {
		this.fine = fine;
	}
	public Salary() {
		super();
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", bonus=" + bonus + ", fine=" + fine + ", level=" + level
				+ "]";
	}

	
}
