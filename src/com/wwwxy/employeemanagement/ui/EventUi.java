package com.wwwxy.employeemanagement.ui;

import java.security.spec.ECField;
import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.control.EventControl;
import com.wwwxy.employeemanagement.dao.EventDao;
import com.wwwxy.employeemanagement.entity.EventEntity;

public class EventUi {
	EventControl ec = new EventControl();
	EventDao eve = new EventDao();
	EventEntity t = new EventEntity();
	Scanner input = new Scanner(System.in);
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		public void all(){
			Scanner input = new Scanner(System.in);
		String x="y";
		do{
		boolean flag = true;
		System.out.print("----------�����������----------\n");
		System.out.print("��������Ҫ���еĲ���(�����ż��ɣ�)\n");
		System.out.print("1.��ѯ����Ա������\n");
		System.out.print("2.����һ��Ա������\n");
		System.out.print("3.ɾ��һ��Ա������\n");
		System.out.print("4.�޸�һ��Ա������\n");
		System.out.print("5.����Ա�����Ų�ѯԱ������\n");
		System.out.print("�������ţ�\n");
		//����������
		int a = input.nextInt();
		switch (a){
		case 1:
			getAllEvent();
			break;
		case 2:
			addEvent();
			break;
		case 3:
			getAllEvent();
			DropEvent();
			break;
		case 4:
			UpdateEvent();
			break;
		case 5:
			getEventbyeMpid();
			break;
		default:
			System.out.println("�����뷽������ȷ������������:");
			flag = false;
		}
		if(flag){
		System.out.println("�Ƿ����������(y/n):");
		x = input.next();
		}
		}while(x.equals("y"));
		System.out.println("----------ϵͳ���˳�----------");
	}
	//}
	//�鿴����Ա������
	public void getAllEvent(){

		List<EventEntity> list = eve.getAllEvent();
		System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t�Ӱ����\t\t�󹤴���\t\t�������");
		for(EventEntity e:list){
			System.out.println(e.geteId()+"\t"
					+ "\t"+e.geteMpid()+"\t\t"+e.geteClocking()+"\t"
							+ "\t"+e.geteBigevent()+"\t"
									+ "\t"+e.geteOvertime()+"\t\t"+e.geteAward());
		}
	}
	//����һ��Ա������
	public void addEvent(){
		System.out.println("������Ա����ţ�");
		int a= input.nextInt();
		
		System.out.println("������ٵ������ˣ�");
		int b=input.nextInt();
		
		System.out.println("������Ա���Ӱ������");
		int c=input.nextInt();
		
		System.out.println("������Ա������������");
		String d=input.next();
		
		System.out.print("������Ա�����������");
		int e=input.nextInt();
		
		t.seteMpid(a);
		t.seteClocking(b);
		t.seteOvertime(c);
		t.seteBigevent(d);
		t.seteAward(e);
		int row = eve.addEventEntity(t);
		if(row !=0){
		System.out.print("�����ɹ�");
		}else{
			System.out.print("����ʧ��");
		}
	}
	//ɾ��һ��Ա������
	public void DropEvent(){
		System.out.println("��������Ҫɾ���������ţ�");
		int a = input.nextInt();
		int row = eve.DropEventEntity(a);
		if(row != 0){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
	public void UpdateEvent(){
		//EventEntity t = eve.
		System.out.println("��������Ҫ�޸ĵ�����ID:");
		int id = input.nextInt();
		List<EventEntity> list = eve.getEventById(id);
		for(EventEntity list1:list){
			t.seteMpid(list1.geteMpid());
			t.seteClocking(list1.geteClocking());
			t.seteOvertime(list1.geteOvertime());
			t.seteBigevent(list1.geteBigevent());
			t.seteAward(list1.geteAward());
		}
		System.out.println("��ѡ����Ҫ�޸ĵ���Ϣ���ö��Ÿ�����");
		System.out.println("1�����");
		System.out.println("2���ٵ�����");
		System.out.println("3���Ӱ�");
		System.out.println("4������");
		System.out.println("5���������");
		String msg = input.next();
		String[] strs =msg.split(",");
		for(String str:strs){
			if("1".equals(str)){
				System.out.println("�������޸ĺ��Ա����ţ�");
				int empid = input.nextInt();
				t.seteMpid(empid);
			}
			if("2".equals(str)){
				System.out.println("�������޸ĺ��Ա���ٵ����ˣ�");
				int b = input.nextInt();
				t.seteClocking(b);
			}
			if("3".equals(str)){
				System.out.println("�������޸ĺ��Ա���Ӱ������");
				int c = input.nextInt();
				t.seteOvertime(c);
			}
			if("4".equals(str)){
				System.out.println("�������޸ĺ��Ա������������");
				String d = input.next();
				t.seteBigevent(d);
			}
			if("5".equals(str)){
				System.out.println("�������޸ĺ��Ա�����������");
				int e = input.nextInt();
				t.seteAward(e);
			}
		}
			t.seteId(id);
			int row = eve.updateEventEntityById(t);
			System.out.println(row);
			if(row>0){
				System.out.println("�޸ĳɹ���");
				getAllEvent();
			}else{
				System.out.println("�޸�ʧ�ܡ�");
			}
	}
	public void getEventbyeMpid(){
		System.out.println("������Ҫ��ѯԱ�����ţ�");
		int eMpid = input.nextInt();
		List<EventEntity> list = eve.getAllEventEntity(eMpid);
		System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t�Ӱ����\t\t�󹤴���\t\t�������");
		for(EventEntity e:list){
			System.out.println(e.geteId()+"\t\t"+e.geteMpid()+"\t\t"+e.geteClocking()+"\t\t"+e.geteBigevent()+"\t\t"+e.geteOvertime()+"\t\t"+e.geteAward());
		}
	}
}
