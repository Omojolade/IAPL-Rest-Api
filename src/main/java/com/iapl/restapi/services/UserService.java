package com.iapl.restapi.services;

import java.util.List;

import com.iapl.restapi.models.User;

public interface UserService {
	List<User> findAllUsers();
}
