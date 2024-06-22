package com.bees.interview.ticket_reservation;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


/*
 * Simple pojo for User_Ticket Reservations Table entity 
 */

@Entity (name="User_Ticket_Reservations")
public class UserTicketReservations {
	
	public UserTicketReservations() {
		super();
	}
	
	
	public UserTicketReservations(Integer pnr_id, String section, String seat_number, 
							Timestamp ticket_timestamp, UserDetailsEntity user_id) {
		super();
		this.pnr_id = pnr_id;
		this.section = section;
		this.seat_number = seat_number;
		this.ticket_timestamp = ticket_timestamp;
		this.user_id = user_id;
	}

	public UserTicketReservations(String section, String seat_number, Timestamp ticket_timestamp) {
		super();
		this.section = section;
		this.seat_number = seat_number;
		this.ticket_timestamp = ticket_timestamp;
	}

	@ManyToOne (fetch = FetchType.LAZY)//many tickets reservations can be done by an user
	@JsonIgnore 
	private UserDetailsEntity user_id;


	@Id
	@GeneratedValue
	private Integer pnr_id;
	
	private String section;
	
	
	private String seat_number;
	
	private Timestamp ticket_timestamp;

	public UserDetailsEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(UserDetailsEntity user_id) {
		this.user_id = user_id;
	}

	public Integer getPnr_id() {
		return pnr_id;
	}

	public void setPnr_id(Integer pnr_id) {
		this.pnr_id = pnr_id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}

	public Timestamp getTicket_timestamp() {
		return ticket_timestamp;
	}

	public void setTicket_timestamp(Timestamp ticket_timestamp) {
		this.ticket_timestamp = ticket_timestamp;
	}


	@Override
	public String toString() {
		return "UserTicketReservations [user_id=" + user_id + ", pnr_id=" + pnr_id + ", section=" + section
				+ ", seat_number=" + seat_number + ", ticket_timestamp=" + ticket_timestamp + "]";
	}
	
	

}
