package com.rubbertech.security.util;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.rubbertech.security.exception.BussinesException;

@Component
public class UserValidator {

	public boolean validatedUserName(String validatorUserName) {
		boolean check = false;
		String regularpatternforname = "[a-zA-Z][a-zA-Z ]+[a-zA-Z]$";
		if (Pattern.compile(regularpatternforname).matcher(validatorUserName).matches()) {
			check = true;
		} else {
			throw new BussinesException(validatorUserName + " not acceptable");
		}
		return check;
	}

	public boolean validatedEmail(String validatorId) {
		boolean check = false;
		String regularpatternforname = "^((?=[A-Za-z0-9])(?![_\\\\-]).)*$";
		if (Pattern.compile(regularpatternforname).matcher(validatorId).matches()) {
			check = true;
		} else {
			throw new BussinesException(validatorId + " not acceptable");
		}
		return check;
	}

	public boolean validatedPassword(String password) {
		boolean check = false;
		String regularpatternforname = "^((?=[A-Za-z0-9])(?![_\\\\-]).)*$";
		if (Pattern.compile(regularpatternforname).matcher(password).matches()) {
			check = true;
		} else {
			throw new BussinesException(password + " not acceptable");
		}
		return check;
	}

}
