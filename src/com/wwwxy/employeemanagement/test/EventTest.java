package com.wwwxy.employeemanagement.test;
import java.util.List;
import com.wwwxy.employeemanagement.dao.EventDao;
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
		/*EventEntity t = new EventEntity();
		int a=103;
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
		int row1 = eve.DropEventEntity(16);
		System.out.print(row1);
	}
}
