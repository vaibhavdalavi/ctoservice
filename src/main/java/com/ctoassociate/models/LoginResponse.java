package com.ctoassociate.models;

import java.io.Serializable;

/**
 * 
 * @author VDALAVA
 *
 */
public class LoginResponse extends ServiceResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private User user;

	public LoginResponse() {
	}

	public LoginResponse(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
