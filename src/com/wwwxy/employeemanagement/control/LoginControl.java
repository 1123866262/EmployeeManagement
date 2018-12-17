package com.wwwxy.employeemanagement.control;

import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.dao.LoginDao;
import com.wwwxy.employeemanagement.entity.LoginEntity;

public class LoginControl {
	public boolean login(){
		boolean flag = false;
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
			flag = ld.login(username, password);
			if(flag){
				System.out.println("��ϲ�㣬��¼�ɹ�");
				break;
			}else{
				count++;
				System.out.println("��¼ʧ�ܣ�������"+(3-count)+"�λ��ᡣ");
			}
		}while(count<3);
		return flag;
	}
	LoginDao ld = new LoginDao();
	//��ʾ���е�¼��Ϣ
	public List<LoginEntity> getAllLogin(){
		return ld.getAllLogin();
	}
	//�����˺Ų�ѯԱ����Ϣ,ģ����ѯ
	public List<LoginEntity> getLoginByUsername(String username){
		return ld.getLoginByUsername(username);
	}
	//�޸�Ա����Ϣ
	public int updateLoginByEmpid(LoginEntity le){
		return ld.updateLoginByEmpid(le);
	}
	//���ݱ�Ų���Ա����Ϣ
	public LoginEntity getLoginByEmpid(int empid){
		return ld.getLoginByEmpid(empid);
	}
}
