package com.bees.interview.ticket_reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
 * Repository to talk to the User Details table in DB using @Repository Annotation.
 */

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Integer> {



}

