package com.bees.interview.ticket_reservation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	//private UserDetailsRepository userRepository;
	
	
	  public UserDetailsEntity retreiveUser() { 
	  	return new UserDetailsEntity(1,"Andre","Agassi","andreagassi@gmail.com"); 
	  }
	 
	
	/*public List<UserDetailsEntity> retrieveAllUsers() {
		List<UserDetailsEntity> userDetails = userRepository.findAll();
		return userDetails;	
	}*/	
	
	

}
