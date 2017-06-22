package com.mhsl.spring.dao;

import com.mhsl.spring.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(UserEntity person) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(person);
		logger.info("UserEntity saved successfully, UserEntity Details = " + person);
	}

	@Override
	public void updatePerson(UserEntity person) {
		Session session = sessionFactory.getCurrentSession();
		session.update(person);
		logger.info("UserEntity updated successfully, UserEntity Details = " + person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> listPersons() {
		Session session = sessionFactory.getCurrentSession();
		List<UserEntity> personsList = session.createQuery("from UserEntity").list();
		for(UserEntity person : personsList){
			logger.info("UserEntity List::" + person);
		}
		return personsList;
	}

	@Override
	public UserEntity getPersonById(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserEntity p = session.load(UserEntity.class, id);
		logger.info("UserEntity loaded successfully, UserEntity details = "+p);
		return p;
	}

	
	@Override
	public void removePerson(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserEntity person = session.load(UserEntity.class, id);
		if(null != person){
			session.delete(person);
		}
		logger.info("UserEntity deleted successfully, person details = " + person);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getPersonsByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<UserEntity> personsList = session.createQuery("from UserEntity user where user.name = '" + name + "'").list();
		for(UserEntity person : personsList){
			logger.info("UserEntity List::" + person);
		}
		return personsList;
	}
	
}
