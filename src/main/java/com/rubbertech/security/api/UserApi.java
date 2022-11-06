package com.rubbertech.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rubbertech.security.model.UserRegistration;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface UserApi {
	
	
	@GetMapping(path = "/user/username/{userName}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull retrival"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<UserDetails> loadUserByUsername(@PathVariable("userName") String username) throws UsernameNotFoundException;

	@GetMapping(path = "/user/username/token")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull retrival"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<String> getUsernameFromToken(@RequestParam String token);
	
	@PostMapping(path = "/registration")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull retrival"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public ResponseEntity<Boolean> userRegistration(@RequestBody UserRegistration userRegistration );
}
