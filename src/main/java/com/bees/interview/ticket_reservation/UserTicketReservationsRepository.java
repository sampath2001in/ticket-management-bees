package com.bees.interview.ticket_reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
 * Repository to talk to the User Ticket Reservation Details table in DB using @Repository Annotation.
 */

@Repository
public interface UserTicketReservationsRepository extends JpaRepository<UserTicketReservations, Integer> {

	List<UserTicketReservations> findBySection(String section);
	
	//List<UserTicketReservations> findByUser_Id(UserDetailsEntity UserDetailsEntity);


}

