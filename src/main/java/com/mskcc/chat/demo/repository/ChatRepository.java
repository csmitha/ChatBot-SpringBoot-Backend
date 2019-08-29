package com.mskcc.chat.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.mskcc.chat.demo.model.ChatMessage;

@Repository 
@Transactional
@RepositoryRestResource
public interface ChatRepository extends CrudRepository<ChatMessage, Long>{

	@SuppressWarnings("unchecked")
	ChatMessage save(ChatMessage chatMessage);
}
