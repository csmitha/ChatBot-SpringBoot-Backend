package com.mskcc.chat.demo.dao;
  
import com.mskcc.chat.demo.model.User;
  
  
  
public interface UserDao  {
	  
	  User findByusername(String userName);
	  User saveUser(User user);
}
 