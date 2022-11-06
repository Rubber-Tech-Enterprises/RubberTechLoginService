package com.rubbertech.security.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubbertech.security.api.UserApi;
import com.rubbertech.security.exception.BusinesException;
import com.rubbertech.security.model.User;
import com.rubbertech.security.model.UserRegistration;
import com.rubbertech.security.repo.UserRepository;
import com.rubbertech.security.service.UserAuthService;
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
	
	@Autowired
	private UserAuthService userAuthService;

	@GetMapping(path = "/hello")
	public String getMessage() {
		return "hi how are you";
	}

	@Override
	public ResponseEntity<UserDetails> loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("entering loadUserByUsername method ");
		LOGGER.debug("loadUserByUsername for username : {}",username);
		try {
			User user = repository.findByuserName(username);
			LOGGER.debug("user response : {}",user);
			if(Objects.nonNull(user)) {
				return ResponseEntity.ok(new UserService(user));
			}
		} catch (Exception e) {
			throw new BusinesException("user not found",e);
		}
		LOGGER.info("exiting loadUserByUsername method ");
		return null;
	}
	
	@Override
	public ResponseEntity<String> getUsernameFromToken(String token) {
		LOGGER.info("enetrig the getUsernameFromToken");
		LOGGER.debug("jwt token : {}",token);
		try {
			String username= jwtUtil.getUsernameFromToken(token);
			LOGGER.debug("username from token :{}",username);
			if(Objects.nonNull(username)) {
				return ResponseEntity.ok(username);
			}
		} catch (Exception e) {
			LOGGER.error("unable to find username from token : {}",e.getMessage());
			throw new BusinesException("unable to find username from token", e);
		}	
		LOGGER.info("exiting the getUsernameFromToken");
		return null;
	}

	@Override
	public ResponseEntity<Boolean> userRegistration(UserRegistration userRegistration) {
		LOGGER.info("enetrig the userRegistration");
		try {
			Boolean userRegistrationcheck = userAuthService.userRegistration(userRegistration);
			if(userRegistrationcheck) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		}catch(BusinesException e) {
			LOGGER.error("unable to user registration : {}",e.getMessage());
			throw new BusinesException("unable to user registration", e);
		}catch (Exception e) {
			throw new BusinesException("unable to user registration", e);
		}	
	}

}
