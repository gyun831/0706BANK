package com.hanbit.account.serviceImpl;

import java.util.Calendar;
import java.util.Vector;

import com.hanbit.account.domain.AccountBean;
import com.hanbit.account.service.AccountService;

public class AccountServiceImpl implements AccountService {
	Vector<AccountBean> vec;
	AccountBean bean;
	
	public AccountServiceImpl(){
		vec = new Vector<AccountBean>(10,10);
		bean = new AccountBean();
	}
	@Override
	public void createaccount(AccountBean bean) {
		Calendar now = Calendar.getInstance();
		bean.setDdate(now.get(now.YEAR)+"년"+now.get(now.MONTH)+"월"+now.get(now.DAY_OF_MONTH)+"일");
		bean.setAccountnumber((int)(Math.random()*99999999+10000000));
		vec.add(bean);
	}

	@Override
	public Vector<AccountBean> findByname(String name) {
		// 이름검색(동명이인 허용)
		Vector<AccountBean>temp= new Vector<AccountBean>();
		for(int i=0; i<vec.size();i++){
			if(name.equals(vec.get(i).getName())){
				temp.add(vec.get(i));
			}
		}
		return temp;
	}

	@Override
	public AccountBean findByaccount(int accountnumber) {
		bean = new AccountBean();
		for(int i=0; i<vec.size();i++){
			if(accountnumber==vec.get(i).getAccountnumber()){
				bean = vec.get(i);
			}
		}
		return bean;
	}

	@Override
	public Vector<AccountBean> list() {
		//계좌목록
		return vec;
	}

	@Override
	public int listnumber() {
		// 계좌수
		return vec.size();
	}
	@Override
	public void updatepw(AccountBean account) {
		for(int i=0;i<vec.size();i++){
			if(account.getId().equals(vec.get(i).getId())){
				vec.get(i).setPw(account.getPw());
			}
		}
	}

	@Override
	public void deposit(AccountBean bean) {
		// 입금
		for(int i=0; i<vec.size(); i++){
			if(bean.getAccountnumber()==vec.get(i).getAccountnumber()){
				vec.get(i).setMoney(bean.getMoney()+vec.get(i).getMoney());
				break;
			}
		}
	}

	@Override
	public void withdraw(AccountBean account) {
		for(int i=0; i<vec.size(); i++){
			if(bean.getAccountnumber()==vec.get(i).getAccountnumber()){
				if(vec.get(i).getMoney()>=bean.getMoney()){
					vec.get(i).setMoney(vec.get(i).getMoney()-bean.getMoney());
					break;
					}
				}
			}
		}

	@Override
	public void deleteaccount(int accountnumber) {
		// 계좌해지
		for(int i=0;i<vec.size();i++){
			if(accountnumber==vec.get(i).getAccountnumber()){
					vec.remove(vec.get(i));
					break;
			}
		}
	}
		
}

