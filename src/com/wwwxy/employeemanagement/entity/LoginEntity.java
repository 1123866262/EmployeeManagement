package com.wwwxy.employeemanagement.entity;

public class LoginEntity {
	//����Ա��Ա������
	private int id;
	//����Ա��Ա���˺�
	private String username;
	//����Ա��Ա������
	private String password;
	//����Ա��Ա��
	private int admin;
	//���Եķ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	//����Ա��Ա�����
	private int empid;
	public LoginEntity(int id, String username, String password, int admin, int empid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.empid = empid;
	}
	public LoginEntity() {
		
	}
}
