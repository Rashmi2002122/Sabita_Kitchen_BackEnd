package com.ranjan.test.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ranjan.test.entity.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {
	Optional<UserModel> findByEmail(String email);
}
