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
@Document(collection = "addresses")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"id"}, allowGetters = true)
public class Address {
	@Id
	private UUID id;
	private String street;
	private String city;
	private String zipCode;
}
