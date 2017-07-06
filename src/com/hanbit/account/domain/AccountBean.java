package com.hanbit.account.domain;

public class AccountBean {
	private String name,id,pw,ssn,ddate;
	private int money,accountnumber;
	public final static String BANK="KB국민은행";
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setPw(String pw){
		this.pw=pw;
	}
	public String getPw(){
		return pw;
	}
	public void setSsn(String ssn){
		this.ssn=ssn;
	}
	public String getSsn(){
		return ssn;
	}
	public void setMoney(int money){
		this.money=money;
	}
	public int getMoney(){
		return money;
	}
	public void setAccountnumber(int accountnumber){
		this.accountnumber=accountnumber;
	}
	public int getAccountnumber(){
		return accountnumber;
	}
	public void setDdate(String ddate){
		this.ddate=ddate;
	}
	public String getDdate(){
		return ddate;
	}
	public String toString(){
		return String.format("계좌정보[이름:%s ID:%s PW:%s 계좌번호:%d 잔액%d]\n", name,id,pw,accountnumber,money);
	}
	
}
