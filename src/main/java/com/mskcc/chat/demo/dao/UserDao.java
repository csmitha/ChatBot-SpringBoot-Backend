package com.mskcc.chat.demo.dao;
  
import com.mskcc.chat.demo.model.User;
  
  
/**
* The UserDao program exposes 
* User DAO findByusername and saveUser methods
*
* @author  Smitha Chap
* @version 1.0
* @since   2019-09-02
*
**/
public interface UserDao  {
	  
	  User findByusername(String userName);
	  User saveUser(User user);
}
 