
  package com.mskcc.chat.demo.dao;
  
  import java.util.ArrayList;

import com.mskcc.chat.demo.model.ChatMessage;
  
/**
* The ChatDao program exposes 
* Chat DAO save and findbyUserName methods
*
* @author  Smitha Chap
* @version 1.0
* @since   2019-09-02
*/

  public interface ChatDao {

	  ChatMessage save(ChatMessage chatMessage);
	  ArrayList<ChatMessage> findByUserName(String userName);
	 
  }
 