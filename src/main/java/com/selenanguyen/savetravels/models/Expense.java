package com.selenanguyen.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="expenses")
public class Expense {
	
	// ========= Primary Key ==========
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	// ========= Member Variables ==========
	@Size(min=2, message="Name must be at least 2 characters.")
	private String name;
	
	@Size(min=2, message="Vendor must be at least 2 characters.")
	private String vendor;
	
	@NotNull(message="Amount must be listed")
	@Min(value=1, message="Ammount must be greater than 1!")
	private double amount;
	
	@Size(min=5, message="Description must be ast least 5 characters.")
	private String description;
	
	// ========= Data Creation Trackers ==========
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	// ========= Constructors ==========
	public Expense() {}
	
	public Expense(String name, String vendor, double amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	// ========= Data Creation Event ==========
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// ========= Getters & Setters ==========
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}

