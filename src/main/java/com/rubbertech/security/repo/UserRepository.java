package com.rubbertech.security.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubbertech.security.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByuserName(String username);

}
