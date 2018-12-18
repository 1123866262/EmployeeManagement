package com.wwwxy.employeemanagement.ui;

import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.control.LoginControl;
import com.wwwxy.employeemanagement.entity.LoginEntity;

public class LoginUi {
	public boolean login() {
		LoginControl lc = new LoginControl();
		return lc.login();
	}
	Scanner input = new Scanner(System.in);
	LoginControl lC = new LoginControl();
	public void Awesome(){
		String f = "y";
		do{
			System.out.println("1����ʾ���е�¼��Ϣ");
			System.out.println("2������Ա���˺Ų�ѯ��Ϣ");
			System.out.println("3���޸�Ա����¼��Ϣ");
			System.out.println("4������Ա����¼��Ϣ");
			System.out.println("5��ɾ��Ա����¼��Ϣ");
			System.out.println("6��������һ��");
			System.out.println("��������Ҫ��Ա�����еĹ��������");
			int information = input.nextInt();
			switch(information){
			case 1:
				getAllLogin();
				break;
			case 2:
				getLoginByUsername(information);
				break;
			case 3:
				updateLoginByEmpid(information);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				f ="n";
				break;
			default:
				System.out.println("��������");
			}
			if(information!=6){
				System.out.println("�Ƿ����y/n");
				f= input.next();
			}
		}while("y".equals(f));
	}
	//��ʾ���е�¼��Ϣ
	public void getAllLogin(){
		List<LoginEntity> list = lC.getAllLogin();
		System.out.println("����\t�˺�\t����\t��ݱ��\t���");
		for(LoginEntity le:list){
			if(le.getAdmin()==1){
			System.out.println(le.getId()+"\t"+le.getUsername()+"\t"+
					le.getPassword()+"\t"+le.getAdmin()+"\t"+le.getEmpid());
			}else{
				System.out.println(le.getId()+"\t"+le.getUsername()+"\t"+
						"\t"+le.getAdmin()+"\t"+le.getEmpid());
			}
		}
	}
	//�����˺Ų�ѯԱ����Ϣ
	public void getLoginByUsername(int information){
		if(information ==2){
			System.out.println("��������Ҫ��ѯ��Ա���˺�:");
		}else if(information ==3){
			System.out.println("��������Ҫ�޸ĵ�Ա���˺�:");
		}else{
			System.out.println("��������Ҫɾ����Ա���˺�:");
		}
		String username = input.next();
		List<LoginEntity> list = lC.getLoginByUsername(username);
		if(list.size()!=0){
			System.out.println("����\t�˺�\t���");
			for(LoginEntity le:list){
				System.out.println(le.getId()+"\t"+le.getUsername()+"\t"+le.getEmpid());
			}
		}else{
			System.out.println("δ��ѯ����Ϣ");
		}
	}
	//�޸�Ա����Ϣ
	public void updateLoginByEmpid(int information){
		getLoginByUsername(information);
		System.out.println("��ѡ�����ϲ�ѯ����Ա��������Ҫ�޸ĵ�Ա�����:");
		int empid = input.nextInt();
		LoginEntity le = lC.getLoginByEmpid(empid);
		System.out.println("1������");
//		System.out.println("����");

	}

}
