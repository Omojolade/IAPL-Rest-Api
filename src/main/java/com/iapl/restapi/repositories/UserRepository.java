package com.iapl.restapi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iapl.restapi.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
