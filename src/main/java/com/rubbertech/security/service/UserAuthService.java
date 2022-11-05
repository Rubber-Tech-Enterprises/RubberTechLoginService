package com.rubbertech.security.service;

import com.rubbertech.security.model.UserRegistration;

public interface UserAuthService {

	public void updateUserAccountNonExpired(String username, Integer accountNonExpired);

	public void updateAccountNonLocked(String username, Integer accountNonLocked);

	public void updateCredentialsNonExpired(String username, Integer credentialsNonExpired);

	public void updateAccountEnable(String username, Integer accountEnable);
	
	public void UpdateUserRole(String userName,String oldUserRole, String newUserRole);
	
	public void removeUserRole(String username,String userRole);
	
	public void addUserRole(String username,String userRole);
	
	public void userRegistration(UserRegistration userRegistration);

}
