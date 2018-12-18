package com.wwwxy.employeemanagement.ui;

import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

import com.wwwxy.employeemanagement.control.LoginControl;
import com.wwwxy.employeemanagement.dao.LoginDao;
import com.wwwxy.employeemanagement.entity.LoginEntity;

public class LoginUi {
	public int login() {
		LoginControl lc = new LoginControl();

		LoginDao ld = new LoginDao();
		int admin=ld.getAdminById(lc.login());
		if(admin == 1){
			return 1;
		}else{
			return 0;
		}
		
		
	}
	Scanner input = new Scanner(System.in);
	LoginControl lc = new LoginControl();
	public void Awesome(){
		String f = "y";
		do{
			System.out.println("1����ʾ����Ա����Ϣ");
			System.out.println("2������Ա���˺Ų�ѯԱ����Ϣ");
			System.out.println("3���޸�Ա����Ϣ");
			System.out.println("4������Ա����Ϣ");
			System.out.println("5��ɾ��Ա����Ϣ");
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
				updateLoginByEmpid1(information);
				break;
			case 4:
				addLogin();
				break;
			case 5:
				delLoginByEmpid(information);
				break;
			case 6:
				f ="n";
				break;
			default:
				System.out.println("��������!");
			}
			if(information!=6){
				System.out.println("�Ƿ����y/n");
				f= input.next();
			}
		}while("y".equals(f));
	}
	//��ʾ���е�¼��Ϣ
	public void getAllLogin(){
		List<LoginEntity> list = lc.getAllLogin();
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
			System.out.println("��������Ҫ��ѯ��Ա���˺ţ�");
		}else if(information ==3){
			System.out.println("��������Ҫ�޸ĵ�Ա���˺ţ�");
		}else{
			System.out.println("��������Ҫɾ����Ա���˺ţ�");
		}
		String username = input.next();
		List<LoginEntity> list = lc.getLoginByUsername(username);
		if(list.size()!=0){
			System.out.println("����\t�˺�\t���");
			for(LoginEntity le:list){
				System.out.println(le.getId()+"\t"+le.getUsername()+"\t"+le.getEmpid());
			}
		}else{
			System.out.println("δ��ѯ����Ϣ");
		}
	}
	//���ݱ���޸��˺�
	public void updateLoginByEmpid1(int information){
		getLoginByUsername(information);
		System.out.println("��ѡ�����ϲ�ѯ����Ա��������Ҫ�޸ĵ�Ա����ţ�");
		int empid = input.nextInt();
		LoginEntity le =lc.getLoginByEmpid(empid);	
		System.out.println("��ѡ����Ҫ�޸ĵ���Ϣ��");
		System.out.println("1���˺�");
		System.out.println("�������޸ĺ���˺ţ�");
		String username = input.next();
		int row = lc.updateLoginByEmpid1(empid, username);
		if(row>0){
			System.out.println("�޸ĳɹ���");
			getAllLogin();
		}else{
			System.out.println("�޸�ʧ�ܡ�");
		}
	}
	//������¼��Ϣ
	public void addLogin(){
		System.out.println("������Ҫ��ӵ��˺ţ�");
		String username = input.next();
		System.out.println("������Ҫ��ӵı�ţ�");
		int empid = input.nextInt();
		LoginEntity le = new LoginEntity(0, username, null, 0, empid);
		le.setUsername(username);
		le.setEmpid(empid);
		int row = lc.addLogin(le);
		if(row>0){
			System.out.println("��ӳɹ���");
			getAllLogin();
		}else{
			System.out.println("���ʧ�ܡ�");
		}
	}
	//ɾ����Ϣ
	public void delLoginByEmpid(int information){
		getLoginByUsername(information);
		System.out.println("��ѡ�����ϲ�ѯ����Ա��������Ҫɾ����Ա����ţ�");
		int empid = input.nextInt();
		int row = lc.delLoginByEmpid(empid);
		if(row>0){
			System.out.println("ɾ���ɹ���");
			getAllLogin();
		}else{
			System.out.println("ɾ��ʧ�ܡ�");
		}
	}
}
