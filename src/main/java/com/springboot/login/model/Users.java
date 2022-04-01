package com.springboot.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.springboot.login.base.BaseEntity;

@Entity
@Table(name = "tbl_users", uniqueConstraints = 
@UniqueConstraint(columnNames = { "username" }))
public class Users extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "id_role", referencedColumnName = "id")
	@ManyToOne
	private Roles role;

	@Column
	private String username;

	@Column
	private String password;

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
