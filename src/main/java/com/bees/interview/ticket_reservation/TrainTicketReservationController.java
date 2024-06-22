package com.bees.interview.ticket_reservation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainTicketReservationController {

	public TrainTicketReservationController(UserDetailsRepository userDetailsRepository,UserTicketDetailsReceiptRepository 
			userTicketDetailsReceiptRepository,UserTicketReservationsRepository userTicketReservationsRepository) {
		this.userDetailsRepository = userDetailsRepository;
		this.userTicketDetailsReceiptRepository = userTicketDetailsReceiptRepository;
		this.userTicketReservationsRepository = userTicketReservationsRepository;
	}
	
	
	private static ConcurrentHashMap<String, String> tickets = new ConcurrentHashMap<String, String>();
	private static int INITIAL_TRAIN_CAPACITY;
	private static String RESERVED = "Reserved";
	private static String UNRESERVED = "Unreserved";
	
	static {
		INITIAL_TRAIN_CAPACITY = 10;
		for(int i = 1; i <=INITIAL_TRAIN_CAPACITY; i++) {
			tickets.put("A1" + "-S" + i, UNRESERVED);
			tickets.put("B1" + "-S" + i, UNRESERVED);
		}
	}
	
	 
	private UserDetailsRepository userDetailsRepository;
	
	private UserTicketDetailsReceiptRepository userTicketDetailsReceiptRepository;
	
	private UserTicketReservationsRepository userTicketReservationsRepository;


	/*
	 * Retrieve all train users
	 */
	@GetMapping(path="/trainusers")
	public List<UserDetailsEntity> retrieveAllTrainUsers() {
		return userDetailsRepository.findAll();
	}

	/*
	 * Retrieve a single train user
	 */
	@GetMapping(path="/trainusers/{id}")
	public Optional<UserDetailsEntity> retrieveOneUser(@PathVariable int id) {
		return userDetailsRepository.findById(id);
	}
	
	/*
	 * Retrieve all the receipts 
	 */
	
	@GetMapping(path="/trainusers/receipts")
	public List<UserTicketDetailsReceipt> retrieveAllReceipts() {
		return userTicketDetailsReceiptRepository.findAll();
	}
	
	/*
	 * Retrieve a single receipt
	 */
	@GetMapping(path="/trainusers/receipts/{id}")
	public UserTicketDetailsReceipt retrieveAReceipt(@PathVariable int id) {
		return userTicketDetailsReceiptRepository.findById(id).get();
	}

	/*
	 * Retrieve reservations via a section
	 */

	@GetMapping(path="/trainusers/sectionreservations/{section}")
	public List<UserTicketReservations> retrieveSectionReservations(@PathVariable String  section) {
		return userTicketReservationsRepository.findBySection(section);
	}

	/*
	 * Retrieve reservations for an user by pnr
	 */

	@GetMapping(path="/trainusers/reservations/{pnrId}")
	public Optional<UserTicketReservations> retrieveUserReservations(@PathVariable int  pnrId)  { //@RequestBody  UserDetailsEntity userDetails) {
		return userTicketReservationsRepository.findById(pnrId);
	}
	
	/*
	 * Retrieve all reservations
	 */

	@GetMapping(path="/trainusers/reservations")
	public List<UserTicketReservations> retrieveAllUserReservations()  { //@RequestBody  UserDetailsEntity userDetails) {
		return userTicketReservationsRepository.findAll();
	}
	

	/*
	 * Creating an user
	 */
	@PostMapping(path="/trainusers/{id}")
	public void createUser(@PathVariable int id, @RequestBody  UserDetailsEntity userDetails) {
		 userDetailsRepository.save(userDetails);
	}
	
	
	/*
	 * To create a receipt and reserve a ticket for an user request   
	 */
	@PostMapping(path="/trainusers/{id}/reserve")
	public void createTicketForAnUser(@PathVariable int id) { //@RequestBody  UserDetailsEntity userDetails) { 
		Optional<UserDetailsEntity> user = userDetailsRepository.findById(id);
		UserDetailsEntity userDetails=user.get();
		
		// Receipt creation
		List<UserTicketDetailsReceipt> userTicketDetailsReceiptList =  new ArrayList<UserTicketDetailsReceipt>();
		// these data can be improvised to get from the user, currently setting default values
		UserTicketDetailsReceipt userTicketDetailsReceipt = new UserTicketDetailsReceipt("France", "London", 5); 
		userTicketDetailsReceiptList.add(userTicketDetailsReceipt);
		userDetails.setUserTicketReceipts(userTicketDetailsReceiptList);
		userTicketDetailsReceipt.setUser_id(userDetails);
		userTicketDetailsReceiptRepository.save(userTicketDetailsReceipt);
		
		//Reservation Creation
		List<UserTicketReservations> userTicketReservationsList =  new ArrayList<UserTicketReservations>();
		UserTicketReservations userTicketReservations = new UserTicketReservations();// "A1", 4, null); 
		//Ticket Reservation logic:
		reserveTickets(userTicketReservations);
		userTicketReservationsList.add(userTicketReservations);
		userDetails.setUserTicketReservations(userTicketReservationsList);
		userTicketReservations.setUser_id(userDetails);
		userTicketReservationsRepository.save(userTicketReservations);
	}
	
	/*
	 * Simple ticket reservation using ConcurrentHashMap 
	 */
	public void reserveTickets(UserTicketReservations userTicketReservations) {
		 for(int i = 1; i <=INITIAL_TRAIN_CAPACITY; i++) { 
			 if(tickets.get("A1" + "-S" +i).equals(UNRESERVED))  {
				 tickets.put("A1" + "-S" +i, RESERVED);
				 userTicketReservations.setSeat_number("A1" + "-S" +i);
				 userTicketReservations.setSection("A1");
				 userTicketReservations.setTicket_timestamp(new Timestamp(System.currentTimeMillis()));
				 break;
			 }
			 if(tickets.get("B1" + "-S" +i).equals(UNRESERVED))  {
				 tickets.put("B1" + "-S" +i, RESERVED);
				 userTicketReservations.setSeat_number("B1" + "-S" +i);
				 userTicketReservations.setSection("B1");
				 userTicketReservations.setTicket_timestamp(new Timestamp(System.currentTimeMillis()));
				 break;
			 }
		 } 
	}
	
	/*
	 * Delete any user
	 */
	@DeleteMapping(path="/trainusers/{id}")
	public void deleteUser(@PathVariable int id) {
		 userDetailsRepository.deleteById(id);
	}
	
	/*
	 * Delete any ticker using pnr
	 */
	@DeleteMapping(path="/trainusers/reservations/{pnrId}")
	public void deletePnrTicket(@PathVariable int id) {
		userTicketReservationsRepository.deleteById(id);
	}	
	

	
	/*
	 * Update User Ticket Information
	 */
	@PostMapping(path="/trainusers/{id}/updatereserve")
	public void updateTicketForAReservedTicketUser(@PathVariable int id, @RequestBody  UserTicketReservations userTicketReserved) { 
		Optional<UserDetailsEntity> user = userDetailsRepository.findById(id);
		UserDetailsEntity userDetails = user.get();
		userTicketReserved.setUser_id(userDetails);
		userTicketReserved.setTicket_timestamp(new Timestamp(System.currentTimeMillis()));
		userTicketReservationsRepository.save(userTicketReserved);
		
	}	
	
	
}
