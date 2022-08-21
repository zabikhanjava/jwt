package com.example.jwt.controller;

public class JwtTokenResponse {

	String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtTokenResponse(String token) {
		super();
		this.token = token;
	}
	 
}
