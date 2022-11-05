package com.rubbertech.security.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.rubbertech.security.exception.BusinesException;
import com.rubbertech.security.model.UserRole;

@Component
public class UserValidatorUtil {

	public boolean validatedUserName(String validatorUserName) {
		boolean check = false;
		String regularpatternforname = "[a-zA-Z][a-zA-Z ]+[a-zA-Z]$";
		if (Pattern.compile(regularpatternforname).matcher(validatorUserName).matches()) {
			check = true;
		} else {
			throw new BusinesException(validatorUserName + " not acceptable");
		}
		return check;
	}

	public boolean validatedEmail(String validatorId) {
		boolean check = false;
		String regularpatternforname = "^((?=[A-Za-z0-9])(?![_\\\\-]).)*$";
		if (Pattern.compile(regularpatternforname).matcher(validatorId).matches()) {
			check = true;
		} else {
			throw new BusinesException(validatorId + " not acceptable");
		}
		return check;
	}

	public boolean validatedPassword(String password) {
		boolean check = false;
		String regularpatternforname = "^((?=[A-Za-z0-9])(?![_\\\\-]).)*$";
		if (Pattern.compile(regularpatternforname).matcher(password).matches()) {
			check = true;
		} else {
			throw new BusinesException(password + " not acceptable");
		}
		return check;
	}
	
	public String userRoleCheck(String checkUserRole) {
		List<String> roles=Arrays.asList(UserRole.ROLE_ADMIN.getUserRole(),UserRole.ROLE_USER.getUserRole(),UserRole.ROLE_SELLER.getUserRole());
		for(String userRole:roles) {
			if(checkUserRole.equalsIgnoreCase(userRole)) {
				checkUserRole=userRole;
				return checkUserRole;
			}
		}
		return null;
	}

}
