package com.bees.interview.ticket_reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
 * Repository to talk to the User Ticket Details table in DB using @Repository Annotation.
 */

@Repository
public interface UserTicketDetailsReceiptRepository extends JpaRepository<UserTicketDetailsReceipt, Integer> {

	//List<UserTicketDetailsReceipt> findByuser_id(UserDetailsEntity UserDetailsEntity); 

}

