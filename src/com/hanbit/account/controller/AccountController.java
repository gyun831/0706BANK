package com.hanbit.account.controller;

import java.util.Vector;

import javax.swing.*;

import com.hanbit.account.domain.AccountBean;
import com.hanbit.account.serviceImpl.AccountServiceImpl;

public class AccountController {
	public static void main(String[]args){
		AccountBean bean= new AccountBean();
		AccountServiceImpl service = new AccountServiceImpl();
		
		while(true){
			switch(JOptionPane.showInputDialog("0.종료 1.계좌생성 2.계좌리스트 3.전체계좌수 4.계좌찾기(이름) 5.계좌찾기(계좌) 6.PW변경 7.입금 8.출금 9.계좌삭제")){
			case "0":
				JOptionPane.showMessageDialog(null, "종료" );
				return;
			case "1":
				bean = new AccountBean();
				String[] info = JOptionPane.showInputDialog("이름/ID/PW/SSN/입금액").split("/");
				bean.setName(info[0]);
				bean.setId(info[1]);
				bean.setPw(info[2]);
				bean.setSsn(info[3]);
				bean.setMoney(Integer.parseInt(info[4]));
				service.createaccount(bean);
				JOptionPane.showMessageDialog(null,"가입완료");
				break;
			case "2":
				JOptionPane.showMessageDialog(null,service.list());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, service.listnumber());
				break;
			case "4":
				Vector<AccountBean>vec2=service.findByname(JOptionPane.showInputDialog("이름"));
				JOptionPane.showMessageDialog(null, service.findByname(JOptionPane.showInputDialog("이름")));
				break;
			case "5":
				JOptionPane.showMessageDialog(null, service.findByaccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호"))));
				break;
			case "6":
				bean = new AccountBean();
				String arr[] = JOptionPane.showInputDialog("ID/변경할PW").split("/");
				bean.setId(arr[0]);
				bean.setPw(arr[1]);
				service.updatepw(bean);
				JOptionPane.showMessageDialog(null, "변경완료");
				break;
			case "7":
				bean = new AccountBean();
				bean.setAccountnumber(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
				bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("입금액")));
				service.deposit(bean);
				JOptionPane.showMessageDialog(null, "입금완료");
				break;
			case "8":
				bean = new AccountBean();
				bean.setAccountnumber(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
				bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("출금액")));
				service.withdraw(bean);
				JOptionPane.showMessageDialog(null, "출금완료");
				break;
			case "9":
				service.deleteaccount(Integer.parseInt(JOptionPane.showInputDialog("삭제할계좌번호")));
				JOptionPane.showMessageDialog(null, "삭제완료");
				break;
				default:
					JOptionPane.showMessageDialog(null, "잘못된입력입니다.");
					break;
			}
		}
		
	}
}
