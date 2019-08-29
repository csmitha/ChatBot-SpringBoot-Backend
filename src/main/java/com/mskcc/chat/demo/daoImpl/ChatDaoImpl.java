package com.mskcc.chat.demo.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mskcc.chat.demo.dao.ChatDao;
import com.mskcc.chat.demo.model.ChatMessage;
import com.mskcc.chat.demo.repository.ChatRepository;

@Service
public class ChatDaoImpl implements ChatDao {

	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public ChatMessage save(ChatMessage chatMessage) {
		ChatMessage chatmessage = chatRepository.save(chatMessage);
		return chatmessage;
	}

}
