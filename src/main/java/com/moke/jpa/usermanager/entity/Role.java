package com.moke.jpa.usermanager.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role_")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy="role")
	private List<User> users;
	
	@ManyToMany
	@JoinTable(
			name="role_menu_",
			joinColumns=@JoinColumn(name="role_id"),
			inverseJoinColumns=@JoinColumn(name="menu_id")
	)
	private List<Menu> menus;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
