package com.sample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonRootName;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

@Table(name = "USER_DETAILS")
public class User implements Serializable {

	private static final long serialVersionUID = 6198797987700262955L;

	@Id
	@GeneratedValue
	@JsonProperty
	private Integer id;

	@JsonProperty
	@Column(name = "username", nullable = false,unique=true)
	private String username;

	@JsonProperty
	@Column(name = "password", nullable = false)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}

}
