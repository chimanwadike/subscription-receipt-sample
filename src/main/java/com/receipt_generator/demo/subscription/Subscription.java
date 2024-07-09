package com.receipt_generator.demo.subscription;

import java.io.Serializable;
import java.time.LocalDate;

public class Subscription implements Serializable {
	
	private Integer id;
	
	private String subscriptionPlan;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String description;
	
	private Double price;
	
	public Subscription(Integer id, String subscriptionPlan, LocalDate startDate, LocalDate endDate, String description,
			Double price) {
		this.id = id;
		this.subscriptionPlan = subscriptionPlan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getSubscriptionPlan() {
		return subscriptionPlan;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Double getPrice() {
		return price;
	}
}
