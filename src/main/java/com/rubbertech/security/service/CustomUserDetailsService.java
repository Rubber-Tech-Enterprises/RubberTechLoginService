package com.rubbertech.security.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubbertech.security.exception.BussinesException;
import com.rubbertech.security.model.User;
import com.rubbertech.security.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
		
	@Autowired
	private UserRepository repository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByuserName(username);
		if(Objects.nonNull(user)) {
			return new UserService(user);
		}else {
			throw new BussinesException("user not faund");
		}
	}

}
