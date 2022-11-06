package com.rubbertech.security.service;

import com.rubbertech.security.model.UserRegistration;

public interface UserAuthService {

	public Boolean updateUserAccountNonExpired(String username, Integer accountNonExpired);

	public Boolean updateAccountNonLocked(String username, Integer accountNonLocked);

	public Boolean updateCredentialsNonExpired(String username, Integer credentialsNonExpired);

	public Boolean updateAccountEnable(String username, Integer accountEnable);
	
	public Boolean UpdateUserRole(String userName,String oldUserRole, String newUserRole);
	
	public Boolean removeUserRole(String username,String userRole);
	
	public Boolean addUserRole(String username,String userRole);
	
	public Boolean userRegistration(UserRegistration userRegistration);

}
