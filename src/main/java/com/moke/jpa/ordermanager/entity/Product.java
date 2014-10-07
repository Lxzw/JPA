package com.moke.jpa.ordermanager.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1792197062256064174L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id;
	private String name;
	private Long cost;
	private Date productDate;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return cost;
	}
	public void setPrice(Long price) {
		this.cost = price;
	}
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
