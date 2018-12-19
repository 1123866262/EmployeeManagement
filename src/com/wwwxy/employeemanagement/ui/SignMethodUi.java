package com.wwwxy.employeemanagement.ui;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
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
	    public String Time(){
	    	//�ж�Ա���Ƿ����ˣ��ٵ����������Ӱ࣬����
	    	String state="";
	    	String state1="����";
	    	String state2="����";
	    	String state3="����";
	    	DateFormat df=new SimpleDateFormat("HH:mm:ss");//��ȡʱ����
	    	Date d=new Date();
	    	try {
				Date d1=df.parse("14:00:00");//�涨ǩ��ʱ��
				Date d2=df.parse(df.format(d));//Ա��ǩ����ǩ��ʱ��
				Date d3=df.parse("20:00:00");//�涨ǩ��ʱ��
				int t1=(int) d1.getTime();
				int t2=(int) d2.getTime();
				int t3=(int) d3.getTime();
				if (t2>t1) {
					//�ٵ�
					long between=(t2-t1)/1000;//ת������
					long hour=between%(24*3600)/3600;//ת��ΪСʱ
					long minute=between%3600/60;//ת��Ϊ��
					state1="�ٵ���"+hour+"ʱ"+minute+"��"+between+"��"+"\t";
				}
				if (t2<t3) {
					//����
					long between=(t2-t1)/1000;//ת������
					long hour=between%(24*3600)/3600;//ת��ΪСʱ
					long minute=between%3600/60;//ת��Ϊ��
					state2="���ˣ�"+hour+"ʱ"+minute+"��"+between+"��"+"\t";
				}
				if (t2>t3) {
					//�Ӱ�
					long between=(t2-t1)/1000;//ת������
					long hour=between%(24*3600)/3600;//ת��ΪСʱ
					long minute=between%3600/60;//ת��Ϊ��
					state2="�Ӱࣺ"+hour+"ʱ"+minute+"��"+between+"��"+"\t";
				}
			   
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	return state;
	    }
	    public void Look(){
	    	 System.out.println("������Ҫ��ѯ�����ڣ�yyyy-MM-dd��");
	         Scanner sc = new Scanner(System.in);
	         String SignDate = sc.nextLine();
	         List<CheckTime> listCheck = map.get(SignDate);
	         for(CheckTime ct : listCheck){
	             System.out.println(ct.getEmpid()+" ǩ��ʱ��Ϊ:"+ct.getCcheckin()+
	            		 " ǩ��ʱ��Ϊ:"+ct.getCcheckout());
	                String s = Time();
					System.out.println(s);
	    }
	         
	    }}

