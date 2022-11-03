package com.rubbertech.security.comandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.rubbertech.security.config.UserSecurity;
import com.rubbertech.security.model.User;
import com.rubbertech.security.repo.UserRepository;

//@Profile(value = {"dev","test"})
//@Component
public class DummyUserCredential implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserSecurity security;

	@Override
	public void run(String... args) throws Exception {
		User dbUser = userRepository.findById(1L).orElse(null);
		if(Objects.nonNull(dbUser)) {
			userRepository.deleteById(1L);
		}
		User user=new User();
		user.setUserName("admin");
		user.setPassword(security.passwordEncoder().encode("admin"));
		user.setEmail("admin@gmail.com");
		user.setAccountNonExpired(Boolean.TRUE);
		user.setAccountNonLocked(Boolean.TRUE);
		user.setCredentialsNonExpired(Boolean.TRUE);
		user.setEnabled(Boolean.TRUE);
		user.setUserRole(Arrays.asList("USER"));
		userRepository.save(user);

	}

}
