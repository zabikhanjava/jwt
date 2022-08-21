package com.example.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.*;
import com.example.jwt.MyUserDetailsService;
import com.example.jwt.util.JwtUtil;


@RestController
public class JwtController {
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	
	@GetMapping(value="/hello")
	public  String main() {
		return "hello";
	}
		
	@PostMapping(value="/token")

	public  ResponseEntity<JwtTokenResponse> maini(@RequestBody JwtRequestObject jwtRequestObject ) throws Exception {
		
		try
		{
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestObject.getUsername(), jwtRequestObject.getPassword()));
		}
		catch(UsernameNotFoundException e)
		{
			throw new Exception("bad cred");
		}
		UserDetails userDetails=this.myUserDetailsService.loadUserByUsername(jwtRequestObject.getUsername());
		String token=this.jwtUtil.generateToken(userDetails);
		System.out.println("token="+token);
		return new ResponseEntity(new JwtTokenResponse(token),HttpStatus.OK);
	}

	
}
