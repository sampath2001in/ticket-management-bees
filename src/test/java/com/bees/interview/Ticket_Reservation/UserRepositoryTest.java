package com.bees.interview.Ticket_Reservation;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bees.interview.ticket_reservation.UserDetailsEntity;
import com.bees.interview.ticket_reservation.UserDetailsRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	
	@Autowired
	private UserDetailsRepository userRepository;
	
	public UserRepositoryTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	  @Test 
	  public void testFindAll() { 
		  List<UserDetailsEntity> items = userRepository.findAll(); 
		  assertEquals(3,items.size()); 
	  }
	 


	  @Test 
	  public void testFindOne() { 
		  UserDetailsEntity userDetailsEntity =
				  			userRepository.findById(1001).get();
		  assertEquals("borisbecker@gmail.com",userDetailsEntity.getEmail()); 
	  }
	 

}
