package com.rubbertech.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface UserAuthApi {

	@PutMapping(path = "/update/user/accountnonexpired")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull updated"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<Void> updateUserAccountNonExpired(
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "accountNonExpired", required = true) Integer accountNonExpired);

	@PutMapping(path = "/update/user/accountNonLocked")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull updated"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<Void> updateaccountNonLocked(
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "accountNonLocked", required = true) Integer accountNonLocked);

	@PutMapping(path = "/update/user/credentialsNonExpired")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull updated"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<Void> updatecredentialsNonExpired(
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "credentialsNonExpired", required = true) Integer credentialsNonExpired);

	@PutMapping(path = "/update/user/accountEnable")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull updated"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<Void> updateAccountEnable(@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "accountEnable", required = true) Integer acccountEnable);
	
	@PutMapping(path = "/add/user/role")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull updated"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<Void> UpdateUserRole(@RequestParam(name="username",required = true) String username,@RequestParam("oldUserRole") String oldUserRole,@RequestParam("newUserRole") String newUserRole);
	
	@PutMapping(path = "/remove/user/role")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull updated"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<Void>	removeUserRole(@RequestParam(name = "username",required = true) String username,@RequestParam(name ="userRole",required = true ) String userRole);
	
	@PutMapping(path = "/add/user/role")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull updated"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<Void> addUserRole(@RequestParam("username") String username,@RequestParam("userrole") String userRole);
	
}
