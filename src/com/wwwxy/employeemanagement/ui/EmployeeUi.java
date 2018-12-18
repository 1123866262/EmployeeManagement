package com.wwwxy.employeemanagement.ui;

import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.control.EmployeeControl;
import com.wwwxy.employeemanagement.entity.EmployeeEntity;

public class EmployeeUi {
	Scanner sc = new Scanner(System.in);
	EmployeeEntity ee = new EmployeeEntity();
	EmployeeControl ec = new EmployeeControl();
	
	public void EmployeeUiAll() {
		// TODO Auto-generated constructor stub
		String flag = "y";
		do{
			System.out.println("1.�鿴Ա����Ϣ\t\t4.���Ա��");
			System.out.println("2.����������ѯԱ����Ϣ\t5.ɾ��Ա��");
			System.out.println("3.�޸�Ա����Ϣ\t\t6.������һ��");
			System.out.println("��ѡ��ִ�еĲ���:");
			int id=0;
			while (true) {
				try {
					String str = sc.next();
					id = Integer.valueOf(str);
					switch (id) {
						case 1:
							getAllEmployee();
							break;
						case 2:
							getEmployeeByName(id);
							break;
						case 3:
							UpdateEmployee(id);
							break;
						case 4:
							AddEmployee();
							break;
						case 5:
							DeleteEmployee(id);
							break;
						case 6:
							flag = "n";
							break;
						default:
							System.out.println("��������!");
							break;
					}
					if(flag!="n"){
						System.out.println("�Ƿ����(y/n):");
						flag = sc.next();
						if("y".equals(flag)){
							break;
						}
						if("n".equals(flag)){
							System.out.println("�˳�����!");		
						}
						while(!"y".equals(flag)&&!"n".equals(flag)){
							System.out.println("����������(y/n):");
							flag = sc.next();
							if("y".equals(flag)){
								break;
							}
							if("n".equals(flag)){
								System.out.println("�˳�����!");
							}
						}
						break;
					}else {
						System.out.println("�˳�����!");
					}
					
				} catch (Exception e) {
					System.out.println("ERROR!");
					System.out.println("����������:");
				}
			}
				
		}while("y".equals(flag));
	}
	
	//1�鿴Ա����Ϣ
	public void getAllEmployee(){
		List<EmployeeEntity> list = ec.getAllEmployee();
		System.out.println("���\t����\t�Ա�\t����\t����ʱ��\t\t����\t�����ַ\t\t\t�־ӵ�ַ");
		for(EmployeeEntity ee:list){
			System.out.println(ee.getEmpId()+"\t"+ee.getEmpName()+"\t"+ee.getEmpSex()+"\t"+ee.getEmpAge()+"\t"+ee.getEmpBirthday()+"\t"+
			ee.getEmpBasic()+"\t"+ee.getEmpEmail()+"\t"+ee.getEmpAddress());
		}
	}
	//2����������ѯԱ����Ϣ��ģ����ѯ
	public boolean getEmployeeByName(int id){
		if(id==2){
			System.out.println("������Ҫ��ѯ��Ա������:");
		}else if(id==3){
			getAllEmployee();
			System.out.println("������Ҫ�޸ĵ�Ա������:");
		}else{
			getAllEmployee();
			System.out.println("������Ҫɾ����Ա������:");
		}
		boolean flag = true;
		String EmpName = sc.next();
		List<EmployeeEntity> list = ec.getEmployeeByName(EmpName);
		if(list.size()!=0){
			System.out.println("���\t����\t�Ա�\t����\t����ʱ��\t\t����\t�����ַ\t\t\t�־ӵ�ַ");
			for(EmployeeEntity ee:list){
				System.out.println(ee.getEmpId()+"\t"+ee.getEmpName()+"\t"+ee.getEmpSex()
						+"\t"+ee.getEmpAge()+"\t"+ee.getEmpBirthday()+"\t"+ee.getEmpBasic()
						+"\t"+ee.getEmpEmail()+"\t"+ee.getEmpAddress());
			}
		}else{
			System.out.println("Ա�������ڡ�");
			flag = false;
		}
		return flag;
	}
	//3�޸�Ա����Ϣ
	public void UpdateEmployee(int id){
			boolean isflag = getEmployeeByName(id);
			if(isflag){	
				System.out.println("��ѡ�����ϲ�ѯ����Ա��������Ҫ�޸ĵ�Ա�����:");
				int EmpId = sc.nextInt();
				EmployeeEntity ee = ec.getEmployeeById(EmpId);
				
				System.out.println("��ѡ����Ҫ�޸ĵ���Ϣ���ö��Ÿ�����");
				System.out.println("1������\t5������");
				System.out.println("2���Ա�\t6������");
				System.out.println("3������\t7���־ӵ�ַ");
				System.out.println("4������ʱ��\t");
				
				String msg = sc.next();
				String[] strs = msg.split(",");
				for(String str:strs){
					if("1".equals(str)){
						System.out.println("�������޸Ĺ��������:");
						String EmpName = sc.next();
						ee.setEmpName(EmpName);
						ec.UpdateEmployee(ee);
					}
					if("2".equals(str)){
						System.out.println("�������޸Ĺ�����Ա�:");
						String EmpSex = sc.next();
						ee.setEmpSex(EmpSex);
						ec.UpdateEmployee(ee);
					}
					if("3".equals(str)){
						System.out.println("�������޸Ĺ��������:");
						int EmpAge = sc.nextInt();
						ee.setEmpAge(EmpAge);
						ec.UpdateEmployee(ee);
					}
					if("4".equals(str)){
						System.out.println("�������޸Ĺ���ĳ���ʱ��:");
						String EmpBirthday = sc.next();
						ee.setEmpBirthday(EmpBirthday);
						ec.UpdateEmployee(ee);
					}
					if("5".equals(str)){
						System.out.println("�������޸Ĺ���Ĺ���:");
						float EmpBasic = sc.nextFloat();
						ee.setEmpBasic(EmpBasic);
						ec.UpdateEmployee(ee);
					}
					if("6".equals(str)){
						System.out.println("�������޸Ĺ��������:");
						String EmpEmail = sc.next();
						ee.setEmpEmail(EmpEmail);
						ec.UpdateEmployee(ee);
					}
					if("7".equals(str)){
						System.out.println("�������޸Ĺ�����־ӵ�ַ:");
						String EmpAddress = sc.next();
						ee.setEmpAddress(EmpAddress);
						ec.UpdateEmployee(ee);
					}
				}
				boolean flag = ec.UpdateEmployee(ee);
				if(flag){
					System.out.println("�޸ĳɹ�!");
				}else{
					System.out.println("�޸�ʧ��!");
				}
				getAllEmployee();
			}
		}

	//4����Ա����Ϣ
	public void AddEmployee(){
		System.out.println("������Ҫ������Ա������:");
		String EmpName = sc.next();
		System.out.println("�Ա�:");
		String EmpSex = sc.next();
		System.out.println("����:");
		int EmpAge = sc.nextInt();
		System.out.println("��������:");
		String EmpBirthday = sc.next();
		System.out.println("���¹���:");
		float EmpBasic = sc.nextFloat();
		System.out.println("�����ַ:");
		String EmpEmail = sc.next();
		System.out.println("�־ӵ�ַ:");
		String EmpAddress = sc.next();
		EmployeeEntity ee = new EmployeeEntity(null, EmpName,EmpSex, EmpAge, EmpBirthday, EmpBasic, EmpEmail, EmpAddress);
		boolean flag = ec.AddEmployee(ee);
		if(flag){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("���ʧ��");
		}
		getAllEmployee();
	}
	//5ɾ��Ա��
	public void DeleteEmployee(int id){
		getEmployeeByName(id);
		System.out.println("��ѡ����Ҫɾ����Ա�����:");
		int EmpId = sc.nextInt();
		ee.setEmpId(EmpId);
		boolean flag = ec.DeleteEmployee(EmpId);
		if(flag){
			System.out.println("ɾ���ɹ�!");
		}else{
			System.out.println("ɾ��ʧ��!");
		}
		getAllEmployee();
	}
}
