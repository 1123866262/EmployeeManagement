package com.wwwxy.employeemanagement.ui;
import java.sql.Timestamp;
import java.util.*;

import com.wwwxy.employeemanagement.control.CheckDetailsControl;
import com.wwwxy.employeemanagement.dao.*;
import com.wwwxy.employeemanagement.entity.CheckDetails;
public class CheckDateilsUi {
	SignMethodUi smu=new SignMethodUi();
	Scanner input=new Scanner(System.in);
		public void All(){
			smu.addCheckDetails(1, 101, Timestamp.valueOf("2018-12-13 14:15:41"), 
					Timestamp.valueOf("2018-12-13 14:15:58"),"����", "2018-12-13");
			smu.addCheckDetails(2, 102, Timestamp.valueOf("2018-12-13 12:17:25"), 
					Timestamp.valueOf("2018-12-13 14:17:44"),"����", "2018-12-13");
			smu.addCheckDetails(3, 102, Timestamp.valueOf("2018-12-18 11:09:17"), 
					Timestamp.valueOf("2018-12-18 11:09:17"),"����", "2018-12-17");
			smu.addCheckDetails(5, 103, Timestamp.valueOf("2018-12-17 12:10:10"), 
					Timestamp.valueOf("2018-12-17 17:10:10"),"����", "2018-12-17");
//			smu.showcd();
		String f="y";
		do {
			 System.out.println("Ա������ϵͳ");
	         System.out.println("1-------------ǩ��");
	         System.out.println("2-------------ǩ��");
	         System.out.println("3-------------��ʾ������Ϣ");
	         System.out.println("0-------------exit");
	         int loop=input.nextInt();
	         switch (loop) {
	         	case 1:
	         		smu.Signin();
	         		
	         		break;
	         	case 2:
	         		smu.Signout();
	         		
         	    case 3:
	         		smu.Look();
	         		case 0:
	         		f="n";
    				break;
               default:
                	System.out.println("��������");
                    break;
		}
	         if(loop!=0){
					System.out.println("�Ƿ������y/n����");
					f = input.next();
				}
		} while ("y".equals(f));		
	}
//	public void all(){
//		String f = "y";
//		do{
//			System.out.println("1����ʾ���п�����Ϣ");
//			System.out.println("2������Ա��ID��ѯ������Ϣ");
//			System.out.println("3���޸Ŀ�����Ϣ");
//			System.out.println("4��ɾ��������Ϣ");
//			System.out.println("5��������һ��");
//			System.out.println("��������Ҫ���еĹ��������");
//			int action = input.nextInt();
//			switch(action){
//			case 1:
//				getAllCheckDateils();
//				break;
//			case 2:
//				getCheckDateilsByempid(action);
//				break;
//			case 3:
//				updateCheckDetailsBYCid();
//				break;
//			case 4:
//				delCheckDetailsBycid(action);
//				break;
//			case 5:
//				f="n";
//				break;
//			default:
//				System.out.println("��������");
//			}
//			if(action!=5){
//				System.out.println("�Ƿ������y/n����");
//				f = input.next();
//			}
//		}while("y".equals(f));
//	}
//	//��ʾ���п�����Ϣ
//		public void getAllCheckDateils(){
//			List<CheckDetails> list = cdc.getAllCheckDetails();
//			System.out.println("����id\tԱ��id\t\t\tǩ��ʱ��\t\tǩ��ʱ��\t\t����״̬\t��������\t");
//			for(CheckDetails cd:list){
//				System.out.println(cd.getCid()+"\t"+cd.getEmpid()+"\t"+cd.getCcheckin()+"\t"
//					+cd.getCcheckout()+"\t"+cd.getCstatus()+"\t"+cd.getCdate()+"\t");
//			}
//		}
//		//����Ա��id��ѯ������Ϣ
//		public void getCheckDateilsByempid(int action){
//			if(action==2){
//				System.out.println("��������Ҫ��ѯ�Ŀ���Ա��ID��");
//			}else if(action==3){
//				System.out.println("��������Ҫ�޸ĵĿ���Ա��ID��");
//			}else{
//				System.out.println("��������Ҫɾ���Ŀ���Ա��ID��");
//			}
//			int empid = input.nextInt();
//			List<CheckDetails> list = cdc.getCheckDetailsByempid(empid);
//			if(list.size()!=0){
//				System.out.println("����id\tԱ��id\t\t\tǩ��ʱ��\t\t\t\tǩ��ʱ��\t\t����״̬\t��������\t\t");
//				for(CheckDetails cd:list){
//					System.out.println(cd.getCid()+"\t"+cd.getEmpid()+"\t"+cd.getCcheckin()+"\t"
//							+cd.getCcheckout()+"\t"+"\t"+cd.getCstatus()+"\t"+cd.getCdate()+"\t");
//				}
//			}else{
//				System.out.println("δ��ѯ����Ӧ��Ϣ��");
//			}		
//		}		
////ɾ��������Ϣ
//	public void delCheckDetailsBycid(int action){
//		getAllCheckDateils();
//		System.out.println("��ѡ����Ҫɾ���Ŀ���id��");
//		int cid = input.nextInt();
//		int row = cdc.delCheckDetailsBYCid(cid);
//		if(row>0){
//			System.out.println("ɾ���ɹ���");
//			getAllCheckDateils();
//		}else{
//			System.out.println("ɾ��ʧ�ܡ�");
//		}
//	}
//	//�޸Ŀ�����Ϣ
//	public void updateCheckDetailsBYCid(){
//		CheckDetails cd=new CheckDetails();
//		System.out.println("��������Ҫ�޸ĵ�Ա��id:");
//		int cid = input.nextInt();
//		cd.setCid(cid);
//		List<CheckDetails> list = cdc.getCheckDetailsByempid(cid);
//		for(CheckDetails list1:list){
//			cd.setEmpid(list1.getEmpid());
//			cd.setCcheckin(list1.getCcheckin());
//			cd.setCcheckout(list1.getCcheckout());
//			cd.setCstatus(list1.getCstatus());
//			cd.setCdate(list1.getCdate());
//		}
//		System.out.println("��ѡ����Ҫ�޸ĵ�ѡ��ö��Ÿ�����");
//		String msg = input.next();
//		String[] x = msg.split(",");
//		for(String str:x){
//			if("1".equals(str)){
//				System.out.println("�������޸ĺ��Ա��ID��");
//				int empid = input.nextInt();
//				cd.setEmpid(empid);
//			}
//			if("2".equals(str)){
//				System.out.println("�������޸ĺ��ǩ��״̬��");
//				String cstatus = input.next();
//				cd.setCstatus(cstatus);
//			}
//		}
//		int row = cdd.updateCheckDetailsBYCid(cd);
//		if(row>0){
//			System.out.println("�޸ĳɹ�");
//		}else{
//			System.out.println("�޸�ʧ��");
//		}
//	}
	public static void main(String[] args) {
		new CheckDateilsUi().All();
	}
	}
	
	
	
		
	


