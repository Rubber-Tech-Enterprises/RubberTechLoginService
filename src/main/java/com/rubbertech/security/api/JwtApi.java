package com.rubbertech.security.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rubbertech.security.model.JwtRequest;
import com.rubbertech.security.model.JwtResponse;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface JwtApi {

	@PostMapping(path = "/token")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "succesfull retrival"),
			@ApiResponse(responseCode = "500", description = "Not Found"),
			@ApiResponse(responseCode = "404", description = "service not found") })
	public JwtResponse generateToken(@RequestBody JwtRequest request);

}
