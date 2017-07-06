package com.hanbit.account.service;

import java.util.Vector;

import com.hanbit.account.domain.AccountBean;

public interface AccountService {
	public void createaccount(AccountBean account);
	public Vector<AccountBean> findByname(String name);
	public AccountBean findByaccount(int accountnumber);
	public Vector<AccountBean> list();
	public int listnumber();
	public void updatepw(AccountBean account);
	public void deposit(AccountBean account);
	public void withdraw(AccountBean account);
	public void deleteaccount(int accountnumber);

}
