package com.moke.jpa.usermanager.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="privilege_")
public class Privilege {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
		private String name;
		
		@ManyToMany(mappedBy="privileges")
		private List<Menu> menus;
		
		private Date createdTime;

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

		public List<Menu> getMenus() {
			return menus;
		}

		public void setMenus(List<Menu> menus) {
			this.menus = menus;
		}

		public Date getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}
		
}
