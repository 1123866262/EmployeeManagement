package com.wwwxy.employeemanagement.entity;

public class EventEntity {
	//����id
	private int eId;
	//����Ա��id
	private int eMpid;
	//��������(�ٵ�����)
	private int eClocking;
	//����Ӱ�ʱ��
	private int eOvertime;
	//����󹤴���
	private String eBigevent;
	//��������
	private int eAward;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public int geteMpid() {
		return eMpid;
	}
	public void seteMpid(int eMpid) {
		this.eMpid = eMpid;
	}
	public int geteClocking() {
		return eClocking;
	}
	public void seteClocking(int eClocking) {
		this.eClocking = eClocking;
	}
	public int geteOvertime() {
		return eOvertime;
	}
	public void seteOvertime(int eOvertime) {
		this.eOvertime = eOvertime;
	}
	public String geteBigevent() {
		return eBigevent;
	}
	public void seteBigevent(String eBigevent) {
		this.eBigevent = eBigevent;
	}
	public int geteAward() {
		return eAward;
	}
	public void seteAward(int eAward) {
		this.eAward = eAward;
	}
}
