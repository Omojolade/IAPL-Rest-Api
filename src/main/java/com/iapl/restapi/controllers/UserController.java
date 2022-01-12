package com.iapl.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iapl.restapi.models.User;
import com.iapl.restapi.services.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "fetches a list of users")
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers () {
		return ResponseEntity.ok(userService.findAllUsers());
	}
}
