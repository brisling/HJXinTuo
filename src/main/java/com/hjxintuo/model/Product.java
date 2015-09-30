package com.hjxintuo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_product")
public class Product extends BaseBean{
	private String title;
	private float rateOfReturn;
	
	@Temporal(value = TemporalType.DATE)
	private Date startDate;
	
	@Temporal(value = TemporalType.DATE)
	private Date endDate;
	
	@Transient
	private int days;   // 临时值，根据开始日期和结束日期计算得来
	
	private float minBuy;
	private int status;
	private int category;
	private int buyPeopleNum;
	private float alreadyBuyNum;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public float getRateOfReturn() {
		return rateOfReturn;
	}
	
	public void setRateOfReturn(float rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}
	
	public float getMinBuy() {
		return minBuy;
	}

	public void setMinBuy(float minBuy) {
		this.minBuy = minBuy;
	}

	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getDays() {
		int days = (int)( (endDate.getTime() - startDate.getTime()) / 86400000 );
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}

	public int getBuyPeopleNum() {
		return buyPeopleNum;
	}

	public void setBuyPeopleNum(int buyPeopleNum) {
		this.buyPeopleNum = buyPeopleNum;
	}

	public float getAlreadyBuyNum() {
		return alreadyBuyNum;
	}

	public void setAlreadyBuyNum(float alreadyBuyNum) {
		this.alreadyBuyNum = alreadyBuyNum;
	}
	
}
