package com.ranjan.test.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ranjan.test.entity.MenuCard;



public interface MenuRepository extends MongoRepository<MenuCard, String> {
	
	@Query(value ="{'foodCatogories': ?0}" )
	public List<MenuCard> findByfoodCatogories(String placeName);

}
