package com.example.todoservice.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

	// {
	// "token":
	// "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXgiLCJleHAiOjE2MTk4OTEzODgsImlhdCI6MTYxOTI4NjU4OH0.J12RLkvYAVpPSnpRc_WOBL0WjICh_zIAj82tNgU-jzRCnndjWeubzAEWCe8iJ8nxClSSd8CYHLqsuQr_Txf7tg"
	// }

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
