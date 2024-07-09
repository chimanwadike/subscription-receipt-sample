package com.receipt_generator.demo.subscription;

import java.io.Serializable;
import java.time.LocalDate;

public class Subscription implements Serializable {
	
	private String id;
	
	private String subscriptionPlan;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String description;
	
	private Double price;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSubscriptionPlan() {
		return subscriptionPlan;
	}
	
	public void setSubscriptionPlan(String subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
}
