package com.wwwxy.employeemanagement.ui;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.wwwxy.employeemanagement.entity.CheckDetails;
import com.wwwxy.employeemanagement.entity.CheckTime;
public class SignMethodUi {
	 private  Map<Integer,CheckDetails> mapcd = new HashMap<>();
	    //Map�е�KEYΪǩ��������
	    private Map<String,List<CheckTime>> map = new HashMap<>();
	    //����һ�����Ա���ķ���
	    public Map<Integer,CheckDetails> addCheckDetails(int cid,int empid,Timestamp ccheckin,
	    		Timestamp ccheckout,String cstatus,String cdate){
	        mapcd.put(empid,new CheckDetails(cid,empid,ccheckin,ccheckout,cstatus,cdate));
	        return mapcd;
	    }
	  //��ʾ���ڹ�˾Ա������Ϣ
	    public void showcd(){
	        for(Map.Entry<Integer,CheckDetails> m :mapcd.entrySet()){
	        System.out.println("����id:"+m.getValue().getCid()+"Ա��id:"+m.getValue().getEmpid()
	        		+"ǩ��ʱ��"+m.getValue().getCcheckin()+"ǩ��ʱ��"+m.getValue().getCcheckout()
	        		+"����״̬"+m.getValue().getCstatus()+"��������"+m.getValue().getCdate());
	        }
	    }
	    public void Signin(){
	    	//ǩ������
	        Date date = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//��ȡ������
	        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");//��ȡʱ����
	        String SignDate = sdf.format(date);
	        String CheckTime = sdf1.format(date);
	        System.out.println("������Ҫǩ����Ա��Id");
	        Scanner sc = new Scanner(System.in);
	        int inputempid = sc.nextInt();
	        if(!mapcd.containsKey(inputempid)){
	            System.out.println("�����ڸ�Ա��");
	            return;
	        }
	        List<CheckTime> listCheck = null;
	        if(!map.containsKey(SignDate)){
	            //��һ��ǩ����Ա��
	            listCheck = new ArrayList<>();
	            CheckTime ct = new CheckTime();
	           ct.setEmpid(mapcd.get(inputempid).getEmpid());
	           ct.setCcheckin(CheckTime);
	            ct.setCcheckout("");
	            listCheck.add(ct);
	            map.put(SignDate,listCheck);
	            System.out.println("ǩ���ɹ�!");
	        }
	        else {//˵��֮ǰ,�����Ѿ�����ǩ������
	            listCheck = map.get(SignDate);
	            //�ж��Ƿ��Ѿ�ǩ����
	            boolean Find = false;
	            for (CheckTime ct : listCheck) {
	                if (ct.getEmpid() == mapcd.get(inputempid).getEmpid()) {
	                    System.out.println("�Ѿ�ǩ������");
	                    Find = true;
	                    break;
	                }
	            }
	            if (!Find) {
	                CheckTime ct = new CheckTime();
	                ct.setEmpid(mapcd.get(inputempid).getEmpid());
	                ct.setCcheckin(CheckTime);
	                ct.setCcheckout("");
	                listCheck.add(ct);
	                System.out.println("ǩ���ɹ�!");
	            }
	        }
	    }
	    public void Signout(){
	    	//ǩ�˷���
	    	 System.out.println("������ǩ��Ա��ID");
	         Scanner sc = new Scanner(System.in);
	         int inputId = sc.nextInt();
	         String s = sc.nextLine();
	         if(!mapcd.containsKey(inputId)){
	             System.out.println("Ա��������");
	             return;
	         }
	         Date date = new Date();
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//��ȡ������
	         SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");//��ȡʱ����
	         String SignDate = sdf.format(date);
	         String CheckTime = sdf1.format(date);
	         if(!map.containsKey(SignDate)){
	             System.out.println("��ûǩ��,����ǩ��!");
	    }
	         else{
	             List<CheckTime> listCheck = map.get(SignDate);
	             boolean Find = false;
	             for(CheckTime ct : listCheck){
	                 if(ct.getEmpid()==mapcd.get(inputId).getEmpid()){
	                     ct.setCcheckout(CheckTime);
	                     Find = true;
	                     break;
	                 }
	             }
	             if(!Find){
	                 System.out.println("��ûǩ��,����ǩ��");
	             }else{
	                 System.out.println("ǩ�˳ɹ�!");
	             }
	      }
	    }
	    public void Look(){
	    	 System.out.println("������Ҫ��ѯ�����ڣ�yyyy-MM-dd��");
	         Scanner sc = new Scanner(System.in);
	         String SignDate = sc.nextLine();
	         List<CheckTime> listCheck = map.get(SignDate);
	         for(CheckTime ct : listCheck){
	             System.out.println(ct.getEmpid()+" ǩ��ʱ��Ϊ:"+ct.getCcheckin()+
	            		 " ǩ��ʱ��Ϊ:"+ct.getCcheckout());
	 
	    }
	    }}

