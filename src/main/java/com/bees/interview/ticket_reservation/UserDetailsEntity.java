package com.bees.interview.ticket_reservation;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


/*
 * Simple pojo for User_Details Table entity 
 */

@Entity (name="User_Details")
public class UserDetailsEntity {
	
	public UserDetailsEntity() {
		super();
	}
	
	public UserDetailsEntity(Integer user_id, String first_name, String last_name, String email) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	@Id
	@GeneratedValue
	private Integer user_id;
	
	private String first_name;
	
	private String last_name;
	
	private String email;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUserTicketReceipts(List<UserTicketDetailsReceipt> userTicketReceipts) {
		this.userTicketReceipts = userTicketReceipts;
	}

	public List<UserTicketDetailsReceipt> getUserTicketReceipts() {
		return userTicketReceipts;
	}


	@OneToMany(mappedBy = "user_id") 
	@JsonIgnore        //one user can have many ticket receipts
	private List<UserTicketDetailsReceipt> userTicketReceipts;


	@OneToMany(mappedBy = "user_id") 
	@JsonIgnore    //one user can have many ticket receipts
	private List<UserTicketReservations> userTicketReservations;	

	public List<UserTicketReservations> getUserTicketReservations() {
		return userTicketReservations;
	}



	public void setUserTicketReservations(List<UserTicketReservations> userTicketReservations) {
		this.userTicketReservations = userTicketReservations;
	}



	@Override
	public String toString() {
		return "UserDetailsEntity [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + "]";
	}
	
	

}
