package com.mhsl.spring.service;

import com.mhsl.spring.dao.UserDAO;
import com.mhsl.spring.model.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addPerson(UserEntity p) {
		p.setCreatedDate(new Timestamp(new java.util.Date().getTime()));
		userDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(UserEntity p) {
		p.setCreatedDate(new Timestamp(new java.util.Date().getTime()));
		userDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<UserEntity> listPersons() {
		return userDAO.listPersons();
	}
	
	@Override
	@Transactional
	public List<UserEntity> listPersons(int page) {
		List<UserEntity> list = userDAO.listPersons();
		List<UserEntity> result = new ArrayList<UserEntity>();
		for (int i = page * 10; i < (page + 1) * 10; i++) {
			if (i < list.size())
				result.add(list.get(i));
		}
		return result;
	}

	@Override
	@Transactional
	public UserEntity getPersonById(int id) {
		return userDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		userDAO.removePerson(id);
	}
	
	@Override
	@Transactional
	public List<UserEntity> getPersonsByName(String name) {
		return userDAO.getPersonsByName(name);
	}
	
	@Override
	@Transactional
	public List<UserEntity> listPersonsWithName(String name, int page) {
		List<UserEntity> list = userDAO.getPersonsByName(name);
		List<UserEntity> result = new ArrayList<UserEntity>();
		for (int i = page * 10; i < (page + 1) * 10; i++) {
			if (i < list.size())
				result.add(list.get(i));
		}
		return result;
	}
}
