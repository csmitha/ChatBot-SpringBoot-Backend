package com.mskcc.chat.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mskcc.chat.demo.dao.ChatDao;
import com.mskcc.chat.demo.dao.UserDao;
import com.mskcc.chat.demo.model.ChatMessage;
import com.mskcc.chat.demo.model.User;

import io.swagger.annotations.Api;

@RestController
@Api(value = "CHAT Management System")
public class ChatDemoController {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(ChatDemoController.class);
	@Autowired
	private UserDao userDao;

	@Autowired
	private ChatDao chatDao;

	@RequestMapping(value = "/join")
	@MessageMapping("/join")
	@SendTo("/topic/chatting")
	public ChatMessage join(ChatMessage message) throws Exception {
		Thread.sleep(1000); 
		return message;
	}

	@RequestMapping(value = "/chat", method = RequestMethod.POST)
	@MessageMapping("/chat")
	@SendTo("/topic/chatting")
	public ChatMessage chat(ChatMessage message) throws Exception {
		Thread.sleep(1000); 
		try {
			message.setTime(getDateTimeNow());
			chatDao.save(message);

		} catch (Exception ex) {
			logger.error("Error saving chat data " + ex.getMessage());
			ex.printStackTrace();
		}
		return message;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/loginUser/{userid}/{password}", method = RequestMethod.GET)
	public User loginUser(@PathVariable String userid, @PathVariable String password) throws Exception {

		User user = null;
		try {
			logger.info("(password) User ::" + userid + "Password" + password);
			User userDaoRes = userDao.findByusername(userid);
			if (userDaoRes != null && userDaoRes.getUsername() != null && userDaoRes.getPassword() != null) {

				if (userid.equalsIgnoreCase(userDaoRes.getUsername())) {
					logger.info("User already exists");
					return userDaoRes;
				}
			} else {
				throw new Exception("Invalid User");
			}
		} catch (Exception ex) {
			throw new Exception("backend serverError");
		}
		return user;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody User user) {

		logger.info("saveUser entered...");
		userDao.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}


	private java.sql.Timestamp getDateTimeNow() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(utilDate.getTime());
		return sqlTimeStamp;
	}

}
