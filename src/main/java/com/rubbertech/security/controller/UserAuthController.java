package com.rubbertech.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	public ResponseEntity<Boolean> updateUserAccountNonExpired(String username, Integer accountNonExpired) {
		LOGGER.info("entering updateUserAccountNonExpired");
		LOGGER.debug("updateUserAccountNonExpired request username: {} ,accountNonExpired :{}", username,
				accountNonExpired);
		try {
			Boolean updateUserAccountNonExpiredCheck = userAuthService.updateUserAccountNonExpired(username,
					accountNonExpired);
			if (updateUserAccountNonExpiredCheck) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (BusinesException e) {
			LOGGER.error("error in updateUserAccountNonExpired UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in updateUserAccountNonExpired UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateUserAccountNonExpired UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Boolean> updateaccountNonLocked(String username, Integer accountNonLocked) {
		LOGGER.info("entering updateaccountNonLocked");
		LOGGER.debug("updateaccountNonLocked request username: {} ,accountNonLocked :{}", username, accountNonLocked);
		try {
			Boolean updateAccountNonLockedcheck = userAuthService.updateAccountNonLocked(username, accountNonLocked);
			if (updateAccountNonLockedcheck) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (BusinesException e) {
			LOGGER.error("error in updateaccountNonLocked UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in updateaccountNonLocked UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateaccountNonLocked UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Boolean> updatecredentialsNonExpired(String username, Integer credentialsNonExpired) {
		LOGGER.info("entering updatecredentialsNonExpired");
		LOGGER.debug("updatecredentialsNonExpired request username: {} ,credentialsNonExpired :{}", username,
				credentialsNonExpired);
		try {
			Boolean updateCredentialsNonExpiredCheck = userAuthService.updateCredentialsNonExpired(username, credentialsNonExpired);
			if (updateCredentialsNonExpiredCheck) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (BusinesException e) {
			LOGGER.error("error in updatecredentialsNonExpired UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in updatecredentialsNonExpired UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in updatecredentialsNonExpired UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Boolean> updateAccountEnable(String username, Integer acccountEnable) {
		LOGGER.info("entering updateAccountEnable");
		LOGGER.debug("updateAccountEnable request username: {} ,acccountEnable :{}", username, acccountEnable);
		try {
			Boolean updateAccountEnableCheck = userAuthService.updateAccountEnable(username, acccountEnable);
			if (updateAccountEnableCheck) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (BusinesException e) {
			LOGGER.error("error in updateAccountEnable UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in updateAccountEnable UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateAccountEnable UserAuthController", e);
		}
	}

	@Override
	public ResponseEntity<Boolean> UpdateUserRole(String username, String oldUserRole, String newUserRole) {
		LOGGER.info("entering UpdateUserRole");
		LOGGER.debug("UpdateUserRole request username: {} ,oldUserRole :{} newUserRole :{} ", username, oldUserRole,
				newUserRole);
		try {
			Boolean updateUserRoleCheck = userAuthService.UpdateUserRole(username, oldUserRole, newUserRole);
			if (updateUserRoleCheck) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (BusinesException e) {
			LOGGER.error("error in UpdateUserRole UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in UpdateUserRole UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in UpdateUserRole UserAuthController", e);
		}

	}

	@Override
	public ResponseEntity<Boolean> removeUserRole(String username, String userRole) {
		LOGGER.info("entering removeUserRole");
		LOGGER.debug("removeUserRole request username: {} ,userRole :{} ", username, userRole);
		try {
			Boolean removeUserRoleCheck = userAuthService.removeUserRole(username, userRole);
			if (removeUserRoleCheck) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (BusinesException e) {
			LOGGER.error("error in removeUserRole UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in removeUserRole UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in removeUserRole UserAuthController", e);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public ResponseEntity<Boolean> addUserRole(String username, String userRole) {
		LOGGER.info("entering addUserRole");
		LOGGER.debug("addUserRole request username: {} ,userRole :{} ", username, userRole);
		try {
			Boolean addUserRoleCheck = userAuthService.addUserRole(username, userRole);
			if (addUserRoleCheck) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (BusinesException e) {
			LOGGER.error("error in addUserRole UserAuthController : {}", e.getMessage());
			throw new BusinesException("error in addUserRole UserAuthController", e);
		} catch (Exception e) {
			throw new BusinesException("error in addUserRole UserAuthController", e);
		}
	}

}
