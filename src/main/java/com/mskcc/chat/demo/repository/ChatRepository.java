package com.mskcc.chat.demo.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.mskcc.chat.demo.model.ChatMessage;

/**
 * The ChatRepository program extends CrudRepository
 * 
 *
 * @author Smitha Chap
 * @version 1.0
 * @since 2019-09-02
 *
 **/

@Repository
@Transactional
@RepositoryRestResource
public interface ChatRepository extends CrudRepository<ChatMessage, Long> {

	@SuppressWarnings("unchecked")
	ChatMessage save(ChatMessage chatMessage);

	ArrayList<ChatMessage> findByUserName(String userName);
}
