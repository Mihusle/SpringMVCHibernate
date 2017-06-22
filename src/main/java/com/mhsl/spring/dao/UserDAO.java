package com.mhsl.spring.dao;

import com.mhsl.spring.model.UserEntity;

import java.util.List;

public interface UserDAO {

	void addPerson(UserEntity p);
	void updatePerson(UserEntity p);
	List<UserEntity> listPersons();
	UserEntity getPersonById(int id);
	void removePerson(int id);
	List<UserEntity> getPersonsByName(String name);
}
