package com.wwwxy.employeemanagement.ui;

import java.util.Scanner;

import com.wwwxy.employeemanagement.control.LoginControl;


public class Manage {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		LoginUi lu = new LoginUi();
		System.out.println("��ӭ����������Դ����ϵͳ");
		int arr[] = lu.login();
		int admin = arr[0];
		int id = arr[1];
		if(admin !=0){
			System.out.println("----------��ӭ�������Աϵͳ----------");
			String f = "y";
			do{
				System.out.println("1��Ա����Ϣ����");
				System.out.println("2��������Ϣ����");
				System.out.println("3��������Ϣ����");
				System.out.println("4��������Ϣ����");
				System.out.println("5����¼��Ϣ����");
				System.out.println("6��������Ϣ����");
				System.out.println("7���˳�����ϵͳ");
				System.out.println("��ѡ����Ҫ���еĲ���(���������ż���)��");
				int information = 0;
				try {
					information=input.nextInt();
				} catch (Exception e) {
					System.out.println("��������,����������");
					input = new Scanner(System.in);
					continue;
				}
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
					lu.Reset(id);
					break;
				case 7:
					f="n";
					break;
				default:
					System.out.println("��������!");
					break;
				}
				if(information !=7){
					System.out.println("�Ƿ����?������������y/�˳�����n����");
					f = input.next();	
				}	
				while(!"n".equals(f)&&!"y".equals(f)){
					System.out.println("��������������y����n");
					f = input.next();
				}
			}while("y".equals(f));{	
				System.out.println("�Բ������˳�����Աϵͳ");
			}
		}else if(admin == 0){
			System.out.println("----------��ӭ������˹���ϵͳ----------");
			String f = "y";
			do{
				System.out.println("1�����ڴ�");
				System.out.println("2�����ʲ�ѯ");
				System.out.println("3�������ѯ");
				System.out.println("4���޸�����");
				System.out.println("5���˳�ϵͳ");
				System.out.println("��ѡ����Ҫ���еĲ���(���������ż���)��");
				int information = 0;
				try {
					information = input.nextInt();
				} catch (Exception e) {
					System.out.println("��������,����������");
					input = new Scanner(System.in);
					continue;
				}
				switch(information){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					lu.UpdateLoginPassword(id);
					break;
				case 5:
					f="n";
					break;
				default:
					System.out.println("��������!");
					break;
				}
				if(information!=5){
					System.out.println("�Ƿ����? ������������y/�˳�����n����");
					f = input.next();
				}					
				while(!"n".equals(f)&&!"y".equals(f)){
					System.out.println("��������������y����n");
					f = input.next();
				}
			}while("y".equals(f));{
				System.out.println("�Բ������˳����˹���ϵͳ");
			}
		}else{
			System.out.println("�Բ��������˳�������Դϵͳ");
		}
	}

}
