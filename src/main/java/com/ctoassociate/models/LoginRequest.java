package com.ctoassociate.models;

import java.io.Serializable;

/**
 * 
 * @author VDALAVA
 *
 */
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LoginRequest() {
	}

	public LoginRequest(String username, String password) {
		super();
		this.name = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
