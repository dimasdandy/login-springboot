package com.springboot.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.springboot.login.base.BaseEntity;


@Entity
@Table(name = "tbl_roles", uniqueConstraints = 
@UniqueConstraint(columnNames = { "code" }))
public class Roles extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private String code;

	@Column
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
