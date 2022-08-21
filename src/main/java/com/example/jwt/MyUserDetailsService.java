package com.example.jwt;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import javax.websocket.server.ServerEndpoint;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(username.equals("Zabi"))
		{
			return new User("Zabi","myPassword",new ArrayList<>() );
		}
		else
		{
			throw new UsernameNotFoundException("User Not found");
		}
	}

}
