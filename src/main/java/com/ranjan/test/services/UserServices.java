package com.ranjan.test.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranjan.test.entity.UserModel;
import com.ranjan.test.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository repository;
	
	
	public void saveOrUpdateUser(String id, String name, String email, String picture) {
        Optional<UserModel> existingUser = repository.findByEmail(email);

        if (existingUser.isPresent()) {
        	UserModel user = existingUser.get();
        	
            user.setName(name);
            user.setPicture(picture);
            
            repository.save(user);
        } else {
        	UserModel newUser = new UserModel( name, email, picture);
            repository.save(newUser);
        }
    }
	

}
