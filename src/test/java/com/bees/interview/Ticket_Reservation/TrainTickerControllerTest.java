package com.bees.interview.Ticket_Reservation;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bees.interview.ticket_reservation.TrainTicketReservationController;
import com.bees.interview.ticket_reservation.UserDetailsEntity;
import com.bees.interview.ticket_reservation.UserDetailsRepository;
import com.bees.interview.ticket_reservation.UserService;


@WebMvcTest(TrainTicketReservationController.class)
public class TrainTickerControllerTest {

	public TrainTickerControllerTest() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Autowired
	//private UserDetailsRepository userRepository;
/*
	@Test
	public void userTest() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/trainusers")
						.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(
						"{\r\n"
						+ "\"user_id\": 1002,\r\n"
						+ "\"first_name\": \"Andre\",\r\n"
						+ "\"last_name\": \"Agassi\",\r\n"
						+ "\"email\": \"andreagassi@gmail.com\"\r\n"
						+ "}"
						))
				.andReturn();
	}
*/
	
	@Test
/*	public void userFromUserService() throws Exception {
		when(userService.retreiveUser()).thenReturn(
				Arrays.asList(
				new UserDetailsEntity(1,"Andre","Agassi","andreagassi@gmail.com")
				//new UserDetailsEntity(2,"Boris","Becker","boris@gmail.com")
				));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/trainusers")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\r\n"
						+ "\"user_id\": 1,\r\n"
						+ "\"first_name\": \"Andre\",\r\n"
						+ "\"last_name\": \"Agassi\",\r\n"
						+ "\"email\": \"andreagassi@gmail.com\"\r\n"
						+ "}"))
				.andReturn();
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}*/
	
	public void userFromUserService() throws Exception {
		when(userService.retreiveUser()).thenReturn(
				new UserDetailsEntity(1,"Andre","Agassi","andreagassi@gmail.com")
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/trainusers")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\r\n"
						+ "\"user_id\": 1,\r\n"
						+ "\"first_name\": \"Andre\",\r\n"
						+ "\"last_name\": \"Agassi\",\r\n"
						+ "\"email\": \"andreagassi@gmail.com\"\r\n"
						+ "}"))
				.andReturn();
	
	}
}