package com.wwwxy.employeemanagement.control;

import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.dao.LoginDao;
import com.wwwxy.employeemanagement.entity.LoginEntity;

public class LoginControl {
	public int login(){
		int id = 0;
		Scanner input =new Scanner(System.in);
		int count =0;
		String username;
		String password;
		do{
			System.out.println("�������˺ţ�");
			username = input.next();
			System.out.println("���������룺");
			password = input.next();
			LoginDao ld = new LoginDao();
			id = ld.login(username, password);
			if(id !=0){
				String username1 = ld.getLoginById(id);
				System.out.println("��ϲ�㣬��¼�ɹ�"+"\t"+username1);
				break;
			}else{
				count++;
				System.out.println("��¼ʧ�ܣ�������"+(3-count)+"�λ��ᡣ");
			}
		}while(count<3);
		return id;
	}
	LoginDao ld = new LoginDao();
	//��ʾ���е�¼��Ϣ
	public List<LoginEntity> getAllLogin(){
		return ld.getAllLogin();
	}
	//�����˺Ų�ѯ��Ϣ,ģ����ѯ
	public List<LoginEntity> getLoginByUsername(String username){
		return ld.getLoginByUsername(username);
	}
	//��������
	public int updateLoginByEmpid(int empid){
		return ld.updateLoginByEmpid(empid);
	}
	//���ݱ���޸��˺�
	public int updateLoginByEmpid1(int empid,String username){
		return ld.updateLoginByEmpid1(empid, username);
	}
	//���ݱ�Ų�����Ϣ
	public LoginEntity getLoginByEmpid(int empid){
		return ld.getLoginByEmpid(empid);
	}
	//������Ϣ
	public int addLogin(LoginEntity le){
		return ld.addLogin(le);
	}
	//ɾ����Ϣ
	public int delLoginByEmpid(int empid){
		return ld.delLoginByempId(empid);
	}
}
