package com.rubbertech.security.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubbertech.security.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByuserName(String username);

	@Modifying
	@Query(value = "update users.user set account_non_expired=:accountNonExpired where user_name=:userName",nativeQuery = true)
	void updateUserAccountNonExpired(@Param("userName") String userName,@Param("accountNonExpired") Integer accountNonExpired);
	
	@Modifying
	@Query(value = "update users.user set account_non_locked=:accountNonLocked where user_name=:username" ,nativeQuery = true )
	void updateUserAccountNonLocked(@Param("username") String username,@Param("accountNonLocked") Integer accountNonLocked );
	
	@Modifying
	@Query(value  = "update users.user set credentials_non_expired=:credentialsNonExpired where user_name=:username",nativeQuery = true)
	void updateUserCredentialsNonExpired(@Param("username") String username,@Param("credentialsNonExpired") Integer credentialsNonExpired);
	
	@Modifying
	@Query(value  = "update users.user set enabled=:AccountEnable where user_name=:username" ,nativeQuery = true)
	void updateUserAccountEnable(@Param("username") String username,@Param("AccountEnable") Integer AccountEnable);
	
	@Modifying
	@Query(value = "update  users.user_user_role set user_role=:newUserRole where user_id= (SELECT id FROM users.user where user_name=:username) and user_role=:olduserRole",nativeQuery = true)
	void updateUserRole(@Param("username") String username,@Param("olduserRole") String olduserRole ,@Param("newUserRole") String newUserRole);
	
	@Modifying
	@Query(value = "delete FROM users.user_user_role where user_id= (SELECT id FROM users.user where user_name=:username) and user_role=:userRole",nativeQuery = true)
	void removeUserRole(@Param("username") String username,@Param("userRole") String userRole);
	
	@Modifying
	@Query(value = "insert into users.user_user_role(user_id,user_role) value((SELECT id FROM users.user where  user_name=:username) ,:userRole)",nativeQuery = true)
	void addUserRoles(@Param("username") String username,@Param("userRole") String userRole);
	
	@Modifying
	@Query(value = "select user_role from users.user_user_role where user_id=(select id from users.user where user_name=:username);",nativeQuery = true)
	List<String> getAllUserRole(@Param("username") String username);
}
