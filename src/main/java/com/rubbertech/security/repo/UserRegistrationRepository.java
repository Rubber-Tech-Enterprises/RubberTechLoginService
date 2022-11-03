package com.rubbertech.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubbertech.security.model.UserRegistration;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {

}
