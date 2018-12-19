package com.wwwxy.employeemanagement.ui;

//import java.security.spec.ECField;
import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.control.EventControl;
import com.wwwxy.employeemanagement.dao.EventDao;
import com.wwwxy.employeemanagement.entity.CheckDetails;
import com.wwwxy.employeemanagement.entity.EventEntity;

public class EventUi {
	EventControl ec = new EventControl();
	static EventDao eve = new EventDao();
	static EventEntity ee = new EventEntity();
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//public void all(){
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
		int a1 = input.nextInt();
		switch (a1){
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
	public static void getAllEvent(){
		int Clocking = 0;
		int Overtime = 0;
		int Bigevent = 0;
		int Award;
		System.out.println("���������Ժ�.....");
		String a = null;//����һ���жϱ�׼
		int c ;
		//��ȡ���ڱ����������жϷ�����Ա�����Ա��id
		List<CheckDetails> list2 = eve.updateEventCheckdetails();
		for(CheckDetails b:list2){
			
			//�������¼����ݸ�ֵ��a
			 a=b.getCstatus();
			 //System.out.println(a);
			 //�������¼�Ա����Ÿ�ֵ��c
			 c=b.getEmpid();
			// System.out.println(c);
			 //��ȡ�������������
			 
			 for(CheckDetails f:list2){
					if(a !=null){
						//����id��ѯ��������
						List<EventEntity> list1 = eve.getEventById(c);
						for(EventEntity list11:list1){
							ee.seteMpid(0);
							ee.seteClocking(0);
							ee.seteOvertime(0);
							ee.seteBigevent(0);
							ee.seteAward(list11.geteAward());
						}
						//����Ա��id��ȡ��Ա���ٵ����ˣ��Ӱ��������������
						List<EventEntity> list = eve.getAllEventEntity(c);
						for(EventEntity e:list){
						Clocking = e.geteClocking();//�ٵ�����
						Bigevent = e.geteBigevent();//����
						Overtime = e.geteOvertime();//�Ӱ�
						if(("����".equals(a))||("�ٵ�".equals(a)))
						{	 
							Clocking++;
							//System.out.println(Clocking);
							ee.seteClocking(Clocking);
							break;
						}
						if("����".equals(a)){
							Bigevent++;
							//System.out.println(Bigevent);
							ee.seteBigevent(Bigevent);
							break;
						}
						if("�Ӱ�".equals(a)){
							Overtime++;
							//System.out.println(Overtime);
							ee.seteOvertime(Overtime);
							break;
						}
						}
							}
					}
			 //System.out.println("����"+Clocking+"\t�Ӱ�"+Overtime+"\t����"+Bigevent);
			// Award = (Clocking*-50+Overtime*50+Bigevent*-100);
			// ee.seteAward(Award);
			 int row = eve.updateEventEntityById(ee);
		}
		
		List<EventEntity> list = eve.getAllEvent();
			System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t����\t\t�Ӱ����\t\t�������");
			for(EventEntity e:list){
				System.out.println(e.geteId()+"\t\t"+e.geteMpid()+"\t\t"+e.geteClocking()+"\t\t"+e.geteBigevent()+"\t\t"+e.geteOvertime()+"\t\t"+e.geteAward());
			}
			
	}
	//����һ��Ա������
	public static void addEvent(){
		System.out.println("������Ա����ţ�");
		int a= input.nextInt();
		
		System.out.println("������ٵ������ˣ�");
		int b=input.nextInt();
		
		System.out.println("������Ա���Ӱ������");
		int c=input.nextInt();
		
		System.out.println("������Ա������������");
		int d=input.nextInt();
		
		System.out.print("������Ա�����������");
		int e=input.nextInt();
		
		ee.seteMpid(a);
		ee.seteClocking(b);
		ee.seteOvertime(c);
		ee.seteBigevent(d);
		ee.seteAward(e);
		int row = eve.addEventEntity(ee);
		if(row !=0){
		System.out.print("�����ɹ�");
		}else{
			System.out.print("����ʧ��");
		}
	}
	//ɾ��һ��Ա������
	public static void DropEvent(){
		System.out.println("��������Ҫɾ���������ţ�");
		int a = input.nextInt();
		int row = eve.DropEventEntity(a);
		if(row != 0){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
	//�޸�����
	public static void UpdateEvent(){
		//EventEntity t = eve.
		System.out.println("��������Ҫ�޸ĵ�Ա��ID:");
		int empid = input.nextInt();
		List<EventEntity> list = eve.getEventById(empid);
		for(EventEntity list1:list){
			ee.seteMpid(list1.geteMpid());
			ee.seteClocking(list1.geteClocking());
			ee.seteOvertime(list1.geteOvertime());
			ee.seteBigevent(list1.geteBigevent());
			ee.seteAward(list1.geteAward());
		}
		System.out.println("��ѡ����Ҫ�޸ĵ���Ϣ���ö��Ÿ�����");
		System.out.println("1���ٵ�����");
		System.out.println("2������");
		System.out.println("3���Ӱ�");
		System.out.println("4���������");
		String msg = input.next();
		String[] strs =msg.split(",");
		for(String str:strs){
			if("1".equals(str)){
				System.out.println("�������޸ĺ��Ա���ٵ����ˣ�");
				int b = input.nextInt();
				ee.seteClocking(b);
			}
			if("2".equals(str)){
				System.out.println("�������޸ĺ��Ա���Ӱ������");
				int c = input.nextInt();
				ee.seteOvertime(c);
			}
			if("3".equals(str)){
				System.out.println("�������޸ĺ��Ա������������");
				int d = input.nextInt();
				ee.seteBigevent(d);
			}
			if("4".equals(str)){
				System.out.println("�������޸ĺ��Ա�����������");
				int e = input.nextInt();
				ee.seteAward(e);
			}
		}
			ee.seteId(empid);
			int row = eve.updateEventEntityById(ee);
			System.out.println(row);
			if(row>0){
				System.out.println("�޸ĳɹ���");
				getAllEvent();
			}else{
				System.out.println("�޸�ʧ�ܡ�");
			}
	}
	public static void getEventbyeMpid(){
		System.out.println("������Ҫ��ѯԱ�����ţ�");
		int eMpid = input.nextInt();
		List<EventEntity> list = eve.getAllEventEntity(eMpid);
		System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t�Ӱ����\t\t�󹤴���\t\t�������");
		for(EventEntity e:list){
			System.out.println(e.geteId()+"\t\t"+e.geteMpid()+"\t\t"+e.geteClocking()+"\t\t"+e.geteBigevent()+"\t\t"+e.geteOvertime()+"\t\t"+e.geteAward());
		}
	}
}
