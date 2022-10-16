 package com.rubbertech.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${Api.Version}")
public class UserController {
	@GetMapping(path = "/hello")
	public String getMessage() {
		return "hi how are you";
	}

}
