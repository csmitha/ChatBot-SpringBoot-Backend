package com.mskcc.chat.demo.daoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mskcc.chat.demo.dao.UserDao;
import com.mskcc.chat.demo.model.User;
import com.mskcc.chat.demo.repository.UserRepository;


@Service
public  class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByusername(String userName) {
		User user = userRepository.findByusername(userName);
		return user;
	}

	
	@Override 
	public User saveUser(User user) { 
		User newUser = userRepository.save(user);
		return newUser;
	}


	
}