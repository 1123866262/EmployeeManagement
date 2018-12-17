package com.wwwxy.employeemanagement.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.dao.SalaryDao;
import com.wwwxy.employeemanagement.entity.SalaryEntity;

public class SalaryControl {
	SalaryDao sd =new SalaryDao();
	Scanner sc = new Scanner(System.in);
	public void GetAllSalary() {
		List<SalaryEntity> list = sd.GetAllSalary();
		System.out.println("���ʱ��\tԱ��ID\t����ID\t�����ܺ�\t������ʱ��\t");
		for(SalaryEntity list1:list){
			System.out.println(list1.getsId()+"\t"+list1.getEmpId()+"\t"
		+list1.geteId()+"\t"+list1.getsSum()+"\t"+list1.getsTime());
		}
	}
	
	public void GetSalaryById(int id) {
		List<SalaryEntity> list = sd.GetSalaryById(id);
		System.out.println("���ʱ��\tԱ��ID\t����ID\t�����ܺ�\t������ʱ��\t");
		for(SalaryEntity list1:list){
			System.out.println(list1.getsId()+"\t"+list1.getEmpId()+"\t"
		+list1.geteId()+"\t"+list1.getsSum()+"\t"+list1.getsTime());
		}
	}
	
	
	public void AddSalary() {
		System.out.println("���������ӵ�Ա�����:");
		int empid = sc.nextInt();
		System.out.println("���������ӵ�����ID:");
		int eid = sc.nextInt();
		System.out.println("���������ӵĹ����ܺ�:");
		float ssum = sc.nextFloat();
		System.out.println("���������ӵķ�����ʱ��:");
		String stime = sc.next();
		SalaryEntity se = new SalaryEntity(0, empid, eid, ssum, stime);
		int row = sd.add(se);
		if(row>0){
			System.out.println("�����ɹ�");
		}else{
			System.out.println("����ʧ��");
		}
	}
	public void DeleteSalary() {
		System.out.println("��������Ҫɾ���Ĺ���ID:");
		int id = sc.nextInt();
		int row = sd.delete(id);
		if(row>0){
			System.out.println("�����ɹ�");
		}else{
			System.out.println("����ʧ��");
		}
	}
	public void UpdateSalary() {
		SalaryEntity se = new SalaryEntity();
		System.out.println("��������Ҫ�޸ĵĹ��ʱ��:");
		int id = sc.nextInt();
		se.setsId(id);
		List<SalaryEntity> list = sd.GetSalaryById(id);
		for(SalaryEntity list1:list){
			se.setEmpId(list1.getEmpId());
			se.seteId(list1.geteId());
			se.setsSum(list1.getsSum());
			se.setsTime(list1.getsTime());
		}
		
		System.out.println("��ѡ����Ҫ�޸ĵ�ѡ��ö��Ÿ�����");
		String msg = sc.next();
		String[] strs = msg.split(",");
		for(String str:strs){
			if("1".equals(str)){
				System.out.println("�������޸ĺ��Ա��ID��");
				int empId = sc.nextInt();
				se.setEmpId(empId);
			}
			if("2".equals(str)){
				System.out.println("�������޸ĺ������ID��");
				int eid = sc.nextInt();
				se.seteId(eid);
			}
			if("3".equals(str)){
				System.out.println("�������޸ĺ�Ĺ����ܺͣ�");
				float ssum = sc.nextFloat();
				se.setsSum(ssum);
			}
			if("4".equals(str)){
				System.out.println("�������޸ĺ�ķ�����ʱ�䣺");
				String stime = sc.next();
				se.setsTime(stime);
			}
		}
		int row = sd.update(se);
		if(row>0){
			System.out.println("�����ɹ�");
		}else{
			System.out.println("����ʧ��");
		}
	}
	public static void main(String[] args) {
		new SalaryControl().UpdateSalary();
	}
}
