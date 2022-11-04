package com.rubbertech.security.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubbertech.security.api.UserApi;
import com.rubbertech.security.exception.BussinesException;
import com.rubbertech.security.model.User;
import com.rubbertech.security.repo.UserRepository;
import com.rubbertech.security.service.UserService;
import com.rubbertech.security.util.JwtUtil;

@RestController
@RequestMapping(path = "${Api.Version}")
public class UserController implements UserApi {

	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping(path = "/hello")
	public String getMessage() {
		return "hi how are you";
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("entering loadUserByUsername method ");
		LOGGER.debug("loadUserByUsername for username : {}",username);
		try {
			User user = repository.findByuserName(username);
			LOGGER.debug("user response : {}",user);
			if(Objects.nonNull(user)) {
				return new UserService(user);
			}
		} catch (Exception e) {
			throw new BussinesException("user not found",e);
		}
		LOGGER.info("exiting loadUserByUsername method ");
		return null;
	}
	@Override
	public String getUsernameFromToken(String token) {
		LOGGER.info("enetrig the getUsernameFromToken");
		LOGGER.debug("jwt token : {}",token);
		try {
			String username= jwtUtil.getUsernameFromToken(token);
			LOGGER.debug("username from token :{}",username);
			if(Objects.nonNull(username)) {
				return username;
			}
		} catch (Exception e) {
			LOGGER.error("unable to find username from token : {}",e.getSuppressed());
			throw new BussinesException("unable to find username from token", e);
		}	
		LOGGER.info("exiting the getUsernameFromToken");
		return null;
	}

}
