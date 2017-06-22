package com.mhsl.spring.service;

import com.mhsl.spring.model.UserEntity;

import java.util.List;

public interface UserService {

	void addPerson(UserEntity p);
	void updatePerson(UserEntity p);
	List<UserEntity> listPersons();
	List<UserEntity> listPersons(int page);
	UserEntity getPersonById(int id);
	void removePerson(int id);
	List<UserEntity> getPersonsByName(String name);
	List<UserEntity> listPersonsWithName(String name, int page);
}
