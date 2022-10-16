package com.rubbertech.security.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubbertech.security.api.JwtApi;
import com.rubbertech.security.exception.BussinesException;
import com.rubbertech.security.model.JwtRequest;
import com.rubbertech.security.model.JwtResponse;
import com.rubbertech.security.service.CustomUserDetailsService;
import com.rubbertech.security.util.JwtUtil;

@RestController
@RequestMapping(path = "${Api.Version}")
public class JwtController implements JwtApi {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public JwtResponse generateToken(JwtRequest request) {
		UserDetails userDetails = null;
		JwtResponse jwtResponse=null;
		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new BussinesException("Bad Credentials");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new BussinesException("Bad Credentials");
		}
		try {
			userDetails = customUserDetailsService.loadUserByUsername(request.getUsername());
			if (Objects.nonNull(userDetails)) {
				String token = jwtUtil.generateToken(userDetails);
                 if(Objects.nonNull(token)){
                	 jwtResponse=new JwtResponse();
                	jwtResponse.setJwtToken(token);
                 }
			} else {
				throw new BussinesException("user deatials not found");
			}
		} catch (Exception e) {
			throw new BussinesException("unable to get user deatials");
		}
    	return jwtResponse;
	}

}
