package com.wwwxy.employeemanagement.test;
import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.dao.EventDao;
import com.wwwxy.employeemanagement.entity.CheckDetails;
import com.wwwxy.employeemanagement.entity.EventEntity;


//import com.wwwxy.employeemanagement.entity.EventEntity;

public class EventTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventDao eve = new EventDao();
		/*List<EventEntity> list = eve.getAllEvent();
		System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t�Ӱ����\t\t�������");
		for(EventEntity e:list){
			System.out.println(e.geteId()+"\t\t"+e.geteMpid()+"\t\t"+e.geteClocking()+"\t\t"+e.geteBigevent()+"\t\t"+e.geteAward());
		}*/
		
		
		
		EventEntity ee = new EventEntity();
		/*int a=103;
		int b=4;
		int c=4;
		String d="�Ľ�";
		int e=4;
		t.seteMpid(a);
		t.seteClocking(b);
		t.seteOvertime(c);
		t.seteBigevent(d);
		t.seteAward(e);
		int row = eve.addEventEntity(t);
		System.out.print(row);*/
		
		
		/*t.seteMpid(102);
		t.seteClocking(1);
		t.seteOvertime(1);
		t.seteBigevent("����");
		t.seteAward(2);
		t.seteId(1);
		int row = eve.updateEventEntityById(t);
		System.out.print(row);*/
		/*EventEntity t1 = new EventEntity();
		t1.seteId(16);*/
		
		
		/*int row1 = eve.DropEventEntity(16);
		System.out.print(row1);*/
		
		/*List<EventEntity> list1 = eve.getAllEventEntity(103);
		System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t�Ӱ����\t\t�������");
		for(EventEntity t1:list1){
			System.out.println(t1.geteId()+"\t\t"+t1.geteMpid()+"\t\t"+t1.geteClocking()+"\t\t"+t1.geteBigevent()+"\t\t"+t1.geteAward());
		}*/
		List<CheckDetails> list2 = eve.updateEventCheckdetails();
		//System.out.println("Ա�����\t\t����");
		String a = null;
		boolean flag = false;
		int c = -1;
		for(CheckDetails b:list2){
			//System.out.println(b.getEmpid()+"\t\t"+b.getCstatus());
			 a=b.getCstatus();
			 c=b.getEmpid();
			 for(CheckDetails f:list2){
					if(a !=null){
						//System.out.println("��������Ҫ�޸ĵ�Ա��ID:");
						int empid = c;
						List<EventEntity> list = eve.getEventById(empid);
						for(EventEntity list1:list){
							ee.seteMpid(list1.geteMpid());
							ee.seteClocking(list1.geteClocking());
							ee.seteOvertime(list1.geteOvertime());
							ee.seteBigevent(list1.geteBigevent());
							ee.seteAward(list1.geteAward());
						}
						ee.seteBigevent(a);
							}
							
					}
			 int row = eve.updateEventEntityById(ee);
				/*System.out.println(row);
				if(row>0){
					System.out.println("�޸ĳɹ���");
					//getAllEvent();
				}else{
					System.out.println("�޸�ʧ�ܡ�");
				}*/
							
					//}
					}
		 List<EventEntity> list = eve.getAllEvent();
			System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t�Ӱ����\t\t�������");
			for(EventEntity e:list){
				System.out.println(e.geteId()+"\t\t"+e.geteMpid()+"\t\t"+e.geteClocking()+"\t\t"+e.geteBigevent()+"\t\t"+e.geteAward());
			}
		}	
	}
