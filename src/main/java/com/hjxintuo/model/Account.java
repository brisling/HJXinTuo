package com.hjxintuo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account extends BaseBean {
	private Integer userId;
	private float balance;
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
}
