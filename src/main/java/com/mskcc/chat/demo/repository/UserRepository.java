package com.mskcc.chat.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.mskcc.chat.demo.model.User;

/**
 * The UserRepository program extends CrudRepository
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
public interface UserRepository extends CrudRepository<User, Long> {

	User findByusername(String userName);

	@SuppressWarnings("unchecked")
	User save(User user);

}