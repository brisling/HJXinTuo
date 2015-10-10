package com.hjxintuo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_invest_record")
public class InvestRecord extends BaseBean {
	private float investNum;
	private int status;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.PERSIST)
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.PERSIST)
	@JoinColumn(name="productId")
	private Product product;
	
	public InvestRecord() {}
	
	public InvestRecord(String productTitle, 
						Date productStartDate, 
						Date productEndDate,
						float productRateOfReturn,
						float investNum) {
		this.investNum = investNum;
		this.product = new Product();
		this.product.setTitle(productTitle);
		this.product.setStartDate(productStartDate);
		this.product.setEndDate(productEndDate);
		this.product.setRateOfReturn(productRateOfReturn);
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
}
