package com.wwwxy.employeemanagement.ui;

import java.util.Scanner;


public class Manage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		LoginUi lu = new LoginUi();
		System.out.println("��ӭ����������Դ����ϵͳ");
		int id = lu.login();
		if(id !=0){
			System.out.println("----------��ӭ����������Դ����ϵͳ----------");
			String f = "y";
			do{
				System.out.println("1��Ա����Ϣ����");
				System.out.println("2��������Ϣ����");
				System.out.println("3��������Ϣ����");
				System.out.println("4��������Ϣ����");
				System.out.println("5����¼��Ϣ����");
				System.out.println("6���˳�����ϵͳ");
				System.out.println("��ѡ����Ҫ���еĲ���(���������ż���)��");
				int information = input.nextInt();
				switch(information){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					lu.Awesome();
					break;
				case 6:
					f="n";
					break;
				default:
					System.out.println("��������!");
					break;
				}
				if(information!=6){
					System.out.println("�Ƿ������y/n����");
					f = input.next();
				}					
				if(!"y".equals(f)){
					System.out.println("�˳�ϵͳ");
				}
			}while("y".equals(f));
		}else if(id == 0){
			System.out.println("----------��ӭ������˹���ϵͳ----------");
			String f = "y";
			do{
				System.out.println("1�����ڴ�");
				System.out.println("2�����ʲ�ѯ");
				System.out.println("3�������ѯ");
				System.out.println("4���޸�����");
				System.out.println("5���˳�ϵͳ");
				System.out.println("��ѡ����Ҫ���еĲ���(���������ż���)��");
				int information = input.nextInt();
				switch(information){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					f="n";
					break;
				default:
					System.out.println("��������!");
					break;
				}
				if(information!=5){
					System.out.println("�Ƿ������y/n����");
					f = input.next();
				}					
				if(!"y".equals(f)){
					System.out.println("�˳�ϵͳ");
				}
			}while("y".equals(f));
		}else{
			System.out.println("�Բ��������˳�ϵͳ");
		}
	}

}
