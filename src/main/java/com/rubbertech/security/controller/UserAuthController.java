package com.rubbertech.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubbertech.security.api.UserAuthApi;
import com.rubbertech.security.exception.BusinesException;
import com.rubbertech.security.service.UserAuthService;

@RestController
@RequestMapping(path = "${Api.Version}")
public class UserAuthController implements UserAuthApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthController.class);

	@Autowired
	private UserAuthService userAuthService;

	@Override
	public ResponseEntity<Void> updateUserAccountNonExpired(String username, Integer accountNonExpired) {
		LOGGER.info("entering updateUserAccountNonExpired");
		LOGGER.debug("updateUserAccountNonExpired request username: {} ,accountNonExpired :{}", username,
				accountNonExpired);
		try {
			userAuthService.updateUserAccountNonExpired(username, accountNonExpired);
			return ResponseEntity.accepted().build();
		} catch (BusinesException e) {
			LOGGER.error("error in updateUserAccountNonExpired UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in updateUserAccountNonExpired UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateUserAccountNonExpired UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Void> updateaccountNonLocked(String username, Integer accountNonLocked) {
		LOGGER.info("entering updateaccountNonLocked");
		LOGGER.debug("updateaccountNonLocked request username: {} ,accountNonLocked :{}", username, accountNonLocked);
		try {
			userAuthService.updateAccountNonLocked(username, accountNonLocked);
			return ResponseEntity.accepted().build();
		} catch (BusinesException e) {
			LOGGER.error("error in updateaccountNonLocked UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in updateaccountNonLocked UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateaccountNonLocked UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Void> updatecredentialsNonExpired(String username, Integer credentialsNonExpired) {
		LOGGER.info("entering updatecredentialsNonExpired");
		LOGGER.debug("updatecredentialsNonExpired request username: {} ,credentialsNonExpired :{}", username,
				credentialsNonExpired);
		try {
			userAuthService.updateCredentialsNonExpired(username, credentialsNonExpired);
			return ResponseEntity.accepted().build();
		} catch (BusinesException e) {
			LOGGER.error("error in updatecredentialsNonExpired UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in updatecredentialsNonExpired UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in updatecredentialsNonExpired UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Void> updateAccountEnable(String username, Integer acccountEnable) {
		LOGGER.info("entering updateAccountEnable");
		LOGGER.debug("updateAccountEnable request username: {} ,acccountEnable :{}", username, acccountEnable);
		try {
			userAuthService.updateAccountEnable(username, acccountEnable);
			return ResponseEntity.accepted().build();
		} catch (BusinesException e) {
			LOGGER.error("error in updateAccountEnable UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in updateAccountEnable UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateAccountEnable UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Void> UpdateUserRole(String username, String oldUserRole, String newUserRole) {
		LOGGER.info("entering UpdateUserRole");
		LOGGER.debug("UpdateUserRole request username: {} ,oldUserRole :{} newUserRole :{} ",username,oldUserRole,newUserRole);
		try {
			userAuthService.UpdateUserRole(username, oldUserRole, newUserRole);
			return ResponseEntity.accepted().build();
		}catch (BusinesException e) {
			LOGGER.error("error in UpdateUserRole UserAuthController : {}",e.getMessage());
			throw new BusinesException("error in UpdateUserRole UserAuthController", e);
		}catch (Exception e) {
			throw new BusinesException("error in UpdateUserRole UserAuthController", e);
		}
		
	}

	@Override
	public ResponseEntity<Void> removeUserRole(String username, String userRole) {
		LOGGER.info("entering removeUserRole");
		LOGGER.debug("removeUserRole request username: {} ,userRole :{} ",username,userRole);
		try {
			userAuthService.removeUserRole(username, userRole);
			return ResponseEntity.accepted().build();
		}catch (BusinesException e) {
			LOGGER.error("error in removeUserRole UserAuthController : {}",e.getMessage());
			throw new BusinesException("error in removeUserRole UserAuthController", e);
		}catch (Exception e) {
			throw new BusinesException("error in removeUserRole UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Void> addUserRole(String username, String userRole) {
		LOGGER.info("entering addUserRole");
		LOGGER.debug("addUserRole request username: {} ,userRole :{} ",username,userRole);
		try {
			userAuthService.addUserRole(username, userRole);
			return ResponseEntity.accepted().build();
		}catch (BusinesException e) {
			LOGGER.error("error in addUserRole UserAuthController : {}",e.getMessage());
			throw new BusinesException("error in addUserRole UserAuthController", e);
		}catch (Exception e) {
			throw new BusinesException("error in addUserRole UserAuthController", e);
		}	}

}
