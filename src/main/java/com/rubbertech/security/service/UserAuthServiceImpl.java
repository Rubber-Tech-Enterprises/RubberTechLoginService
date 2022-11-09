package com.rubbertech.security.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubbertech.security.config.UserSecurity;
import com.rubbertech.security.exception.BusinesException;
import com.rubbertech.security.model.User;
import com.rubbertech.security.model.UserRegistration;
import com.rubbertech.security.model.UserRole;
import com.rubbertech.security.repo.UserRegistrationRepository;
import com.rubbertech.security.repo.UserRepository;
import com.rubbertech.security.util.UserValidatorUtil;

@Service
public class UserAuthServiceImpl implements UserAuthService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@Autowired
	private UserSecurity security;

	@Autowired
	private UserValidatorUtil userValidatorUtil;

	@Override
	public Boolean updateUserAccountNonExpired(String username, Integer accountNonExpired) {
		Boolean check=false;
		LOGGER.info("entering updateUserAccountNonExpired");
		LOGGER.debug("updateUserAccountNonExpired for username:{} ,accountNonExpired : {}", username,
				accountNonExpired);
		try {
			if (Objects.nonNull(username) && Objects.nonNull(accountNonExpired) && accountNonExpired.equals(0)
					|| accountNonExpired.equals(1)) {
				userRepository.updateUserAccountNonExpired(username, accountNonExpired);
				check=true;
			}
		} catch (BusinesException e) {
			LOGGER.error("error in updateUserAccountNonExpired :{}", e.getMessage());
			throw new BusinesException("error in updateUserAccountNonExpired", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateUserAccountNonExpired", e);
		}
		LOGGER.info("existing updateUserAccountNonExpired");
		return check;
	}

	@Override
	public Boolean updateAccountNonLocked(String username, Integer accountNonLocked) {
		Boolean check=false;
		LOGGER.info("enter updateAccountNonLocked");
		LOGGER.debug("updateaccountNonLocked request username: {} accountNonLocked : {}", username, accountNonLocked);
		try {
			if (Objects.nonNull(username) && Objects.nonNull(accountNonLocked) && accountNonLocked.equals(0)
					|| accountNonLocked.equals(1)) {
				userRepository.updateUserAccountNonLocked(username, accountNonLocked);
				check=true;
			}
		} catch (BusinesException e) {
			LOGGER.error("error in updateAccountNonLocked :{}", e.getMessage());
			throw new BusinesException("error in updateAccountNonLocked", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateAccountNonLocked", e);
		}
		LOGGER.info("existing updateAccountNonLocked");
		return check;
	}

	@Override
	public Boolean updateCredentialsNonExpired(String username, Integer credentialsNonExpired) {
		Boolean check=false;
		LOGGER.info("enter updateCredentialsNonExpired");
		LOGGER.debug("updateCredentialsNonExpired request username: {} credentialsNonExpired : {}", username,
				credentialsNonExpired);
		try {
			if (Objects.nonNull(username) && Objects.nonNull(credentialsNonExpired) && credentialsNonExpired.equals(0)
					|| credentialsNonExpired.equals(1)) {
				userRepository.updateUserCredentialsNonExpired(username, credentialsNonExpired);
				check=true;
			}
		} catch (BusinesException e) {
			LOGGER.error("error in updateCredentialsNonExpired :{}", e.getMessage());
			throw new BusinesException("error in updateCredentialsNonExpired", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateCredentialsNonExpired", e);
		}
		LOGGER.info("existing updateCredentialsNonExpired");
return check;
	}

	@Override
	public Boolean updateAccountEnable(String username, Integer accountEnable) {
		Boolean check=false;
		LOGGER.info("enter updateAccountEnable");
		LOGGER.debug("updateCredentialsNonExpired request username: {} accountEnable : {}", username, accountEnable);
		try {
			if (Objects.nonNull(username) && Objects.nonNull(accountEnable) && accountEnable.equals(0)
					|| accountEnable.equals(1)) {
				userRepository.updateUserAccountEnable(username, accountEnable);
				check=true;
			}
		} catch (BusinesException e) {
			LOGGER.error("error in updateAccountEnable :{}", e.getMessage());
			throw new BusinesException("error in updateAccountEnable", e);
		} catch (Exception e) {
			throw new BusinesException("error in updateAccountEnable", e);
		}
		LOGGER.info("existing updateAccountEnable");
return check;
	}

	@Override
	public Boolean UpdateUserRole(String userName, String oldUserRole, String newUserRole) {
		Boolean check=false;
		LOGGER.info("enter UpdateUserRole");
		LOGGER.debug("UpdateUserRole request  username: {} oldUserRole : {} newUserRole:{} ", userName, oldUserRole,
				newUserRole);
		try {

			oldUserRole = userValidatorUtil.userRoleCheck(oldUserRole);
			newUserRole = userValidatorUtil.userRoleCheck(newUserRole);

			if (Objects.nonNull(userName) && Objects.nonNull(oldUserRole) && Objects.nonNull(newUserRole)) {
				userRepository.updateUserRole(userName, oldUserRole, newUserRole);
				check=true;
			}
		} catch (BusinesException e) {
			LOGGER.error("error in UpdateUserRole :{}", e.getMessage());
			throw new BusinesException("error in UpdateUserRole", e);
		} catch (Exception e) {
			throw new BusinesException("error in UpdateUserRole", e);
		}
		LOGGER.info("existing UpdateUserRole");
		return check;
	}

	@Override
	public Boolean removeUserRole(String username, String userRole) {
		Boolean check=false;
		LOGGER.info("enter removeUserRole");
		LOGGER.debug("removeUserRole request  username: {} userRole : {} ", username, userRole);
		try {
			userRole = userValidatorUtil.userRoleCheck(userRole);
			if (Objects.nonNull(username) && Objects.nonNull(userRole)) {
				userRepository.removeUserRole(username, userRole);
				check=true;
			}
		} catch (BusinesException e) {
			LOGGER.error("error in removeUserRole :{}", e.getMessage());
			throw new BusinesException("error in removeUserRole", e);
		} catch (Exception e) {
			throw new BusinesException("error in removeUserRole", e);
		}
		LOGGER.info("existing removeUserRole");
		return check;
	}

	@Override
	public Boolean addUserRole(String username, String userRole) {
		Boolean check =false;
		LOGGER.info("enter addUserRole");
		LOGGER.debug("addUserRole request  username: {} userRole : {} ", username, userRole);
		try {
			userRole = userValidatorUtil.userRoleCheck(userRole);
			if (Objects.nonNull(username) && Objects.nonNull(userRole)) {
				String checkUserRole = userRole;
				List<String> allUserRole = userRepository.getAllUserRole(username);
				LOGGER.debug("addUserRole response :{}", allUserRole);
				String checkedRole=null;
				if(Objects.nonNull(allUserRole)) {
				 checkedRole = allUserRole.stream().filter(role -> role.equalsIgnoreCase(checkUserRole))
						.findFirst().orElse(null);
				}
				if (Objects.isNull(checkedRole)) {
					userRepository.addUserRoles(username, userRole);
					check=true;
				} else {
					LOGGER.error("Role already exist username: {}", username);
				}
			}
		} catch (BusinesException e) {
			LOGGER.error("error in addUserRole :{}", e.getMessage());
			throw new BusinesException("error in addUserRole", e);
		} catch (Exception e) {
			throw new BusinesException("error in addUserRole", e);
		}
		LOGGER.info("existing addUserRole");
		return check;
	}

	@Override
	public Boolean userRegistration(UserRegistration userRegistration) {
		Boolean check = false;
		LOGGER.info("enter userRegistration");
		LOGGER.debug("userRegistration request:{}", userRegistration);
		try {
			if (Objects.nonNull(userRegistration)
					&& userRegistration.getPassword().equals(userRegistration.getConfirmPassword())) {
				userRegistration.setPassword(security.passwordEncoder().encode(userRegistration.getPassword()));
				userRegistration
						.setConfirmPassword(security.passwordEncoder().encode(userRegistration.getConfirmPassword()));
				UserRegistration savedRegistration = userRegistrationRepository.save(userRegistration);
				if (Objects.nonNull(savedRegistration)) {
					LOGGER.debug("user registration for username:{}", savedRegistration.getUserid());
					User dbUser = userRepository.findByuserName(savedRegistration.getUserid());
					if (Objects.isNull(dbUser)) {

						User user = new User();
						user.setUserName(userRegistration.getUserid() != null ? userRegistration.getUserid() : null);
						user.setAccountNonExpired(Boolean.TRUE);
						user.setAccountNonLocked(Boolean.TRUE);
						user.setCredentialsNonExpired(Boolean.TRUE);
						user.setEmail(userRegistration.getEmail() != null ? userRegistration.getEmail() : null);
						user.setEnabled(Boolean.TRUE);
						user.setPassword(
								userRegistration.getPassword() != null ? userRegistration.getPassword() : null);
						user.setUserRole(Arrays.asList(UserRole.ROLE_USER.getUserRole()));

						LOGGER.debug("user Request : {}", user);
						User savedUser = userRepository.save(user);
						if (Objects.nonNull(savedUser)) {
							check = true;
						}

					}
				}
			}
		} catch (BusinesException e) {
			LOGGER.error("error in userRegistration :{}", e.getMessage());
			throw new BusinesException("error in userRegistration", e);
		} catch (Exception e) {
			throw new BusinesException("error in userRegistration", e);
		}
		LOGGER.info("existing userRegistration");
		return check;
	}

}
