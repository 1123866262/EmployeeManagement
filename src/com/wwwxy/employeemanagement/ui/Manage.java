package com.wwwxy.employeemanagement.ui;

import java.util.Scanner;

public class Manage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		LoginUi lu = new LoginUi();
		System.out.println("��ӭ����������Դ����ϵͳ");
		boolean flag = lu.login();
		if(flag){
			System.out.println("----------��ӭ����������Դ����ϵͳ----------");
			String f = "y";
			do{
				System.out.println("1�������¼");
				System.out.println("2������Ա��");
				System.out.println("3��������");
				System.out.println("4����������");
				System.out.println("5��������");
				System.out.println("6���˳�����ϵͳ");
				System.out.println("��ѡ����Ҫ���еĲ���(���������ż���)��");
				int information = input.nextInt();
				switch(information){
				case 1:
					lu.Awesome();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					
					break;
				case 6:
					f="n";
				default:
					System.out.println("��������");
				}
				if(information!=6){
					System.out.println("�Ƿ������y/n����");
					f = input.next();
				}
				if(!"y".equals(f)){
					System.out.println("ϵͳ���˳���");
				}
			}while("y".equals(f));
		}else{
			System.out.println("�Բ��������˳�ϵͳ");
		}
	}

}
