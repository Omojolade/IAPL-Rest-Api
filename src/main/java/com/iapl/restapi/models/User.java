package com.iapl.restapi.models;


import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "users")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"id"}, allowGetters = true)
public class User {
	@Id
	private UUID id;
	private String name;
	private String username;
	private String phone;
	private String email;
	private Address address;

}
