package com.hjxintuo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_invest_record")
public class InvestRecord extends BaseBean {
	private Integer userId;
	private Integer productId;
	private float investNum;
	private int status;
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public float getInvestNum() {
		return investNum;
	}
	public void setInvestNum(float investNum) {
		this.investNum = investNum;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
