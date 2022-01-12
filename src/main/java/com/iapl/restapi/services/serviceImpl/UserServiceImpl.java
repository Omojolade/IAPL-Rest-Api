package com.iapl.restapi.services.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iapl.restapi.models.User;
import com.iapl.restapi.repositories.UserRepository;
import com.iapl.restapi.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final RestTemplate restTemplate;
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	public UserServiceImpl(final UserRepository userRepository, final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.userRepository = userRepository;
	}

	@Override
	public List findAllUsers() {
		List users = userRepository.findAll();
		if (users.isEmpty()) {
			List usersArray = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", users.getClass()).getBody();
			usersArray.stream().map(user -> {
				mapper. configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				return mapper.convertValue(user, User.class);
			}).collect(Collectors.toList());
			users = usersArray;
			System.out.println(users);
			return userRepository.saveAll(users);
		}

		return users;
	}
}
