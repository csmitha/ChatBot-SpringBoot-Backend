package com.mskcc.chat.demo.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mskcc.chat.demo.dao.ChatDao;
import com.mskcc.chat.demo.model.ChatMessage;
import com.mskcc.chat.demo.repository.ChatRepository;

/**
* The ChatDaoImpl program exposes 
* Chat save and findbyUserName methods
*
* @author  Smitha Chap
* @version 1.0
* @since   2019-09-02
**/

@Service
public class ChatDaoImpl implements ChatDao {

	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public ChatMessage save(ChatMessage chatMessage) {
		ChatMessage chatmessage = chatRepository.save(chatMessage);
		return chatmessage;
	}

	@Override
	public ArrayList<ChatMessage> findByUserName(String userName) {
		// TODO Auto-generated method stub
		ArrayList<ChatMessage> res = chatRepository.findByUserName(userName);
		return res;
	}

}
