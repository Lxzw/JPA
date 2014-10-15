package com.moke.jpa.entity;

import java.util.Date;

/**
 * 
 * @author L-win8 
 *
 * 2014年10月15日 下午11:15:25
 * 
 * @功能 主要实体之间的比较,以及一些共有的特征值
 * @作用 能够了解实体之间的比较，以及用继承的方式为每个实体生成共有字段，并且实现ER表中，继承关系的表示
 */
public class BaseEntity {
	
	private Date createdTime;
	
	private Date modifiedTime;
	
	private String string1;
	
	private String string2;
	
	private String string3;
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}
	
}
