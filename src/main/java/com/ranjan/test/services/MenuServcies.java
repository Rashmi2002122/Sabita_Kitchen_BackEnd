package com.ranjan.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranjan.test.entity.MenuCard;
import com.ranjan.test.repository.MenuRepository;

@Service
public class MenuServcies {

	@Autowired
	private MenuRepository menuRepository;

	public MenuCard addFood(MenuCard card) {
		MenuCard save = menuRepository.save(card);
		return save;
	}

	public List<MenuCard> getAllFood() {
		List<MenuCard> list = menuRepository.findAll();
		return list;
	}

	public Optional<MenuCard> getFoodById(String Id) {
		Optional<MenuCard> optional = menuRepository.findById(Id);
		return optional;
	}

	public List<MenuCard> findBycato(String Cato) {

		List<MenuCard> catogories = menuRepository.findByfoodCatogories(Cato);

		return catogories;

	}

	public List<MenuCard> addAllFood(List<MenuCard> list) {
		List<MenuCard> saveAll = menuRepository.saveAll(list);
		return saveAll;
	}

}
