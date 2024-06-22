package com.bees.interview.ticket_reservation;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/*
 * Simple pojo for User Ticket Receipt Table entity 
 */

@Entity (name="User_Ticket_Receipt")
public class UserTicketDetailsReceipt {
	
	public UserTicketDetailsReceipt() {
		super();
	}
	
	public UserTicketDetailsReceipt(Integer ticket_Receipt_Id, String from_place, String to_place, Integer price_paid) {
		super();
		this.ticket_Receipt_Id = ticket_Receipt_Id;
		this.from_place = from_place;
		this.to_place = to_place;
		this.price_paid = price_paid;
	}
	
	public UserTicketDetailsReceipt(String from_place, String to_place, Integer price_paid) {
		super();
		this.from_place = from_place;
		this.to_place = to_place;
		this.price_paid = price_paid;
	}

	@ManyToOne (fetch = FetchType.LAZY)//many tickets receipts belong to an user
	@JsonIgnore 
	private UserDetailsEntity user_id;


	@Id
	@GeneratedValue
	private Integer ticket_Receipt_Id;
	
	private String from_place;
	
	private String to_place;
	
	private Integer price_paid;

	public Integer getTicket_Receipt_Id() {
		return ticket_Receipt_Id;
	}

	public void setTicket_Receipt_Id(Integer ticket_Receipt_Id) {
		ticket_Receipt_Id = ticket_Receipt_Id;
	}

	public String getFrom_place() {
		return from_place;
	}

	public void setFrom_place(String from_place) {
		this.from_place = from_place;
	}

	public String getTo_place() {
		return to_place;
	}

	public void setTo_place(String to_place) {
		this.to_place = to_place;
	}

	public Integer getPrice_paid() {
		return price_paid;
	}

	public void setPrice_paid(Integer price_paid) {
		this.price_paid = price_paid;
	}
	
	public UserDetailsEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(UserDetailsEntity user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "UserTicketDetailsReceipt [user=" + user_id + ", Ticket_Receipt_Id=" + ticket_Receipt_Id + ", from_place="
				+ from_place + ", to_place=" + to_place + ", price_paid=" + price_paid + "]";
	}	
	

}
