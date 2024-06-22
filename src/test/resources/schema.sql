--create table User_Details (
--	user_id bigint not null,
--	first_name varchar(255) not null,
--	last_name  varchar(255) not null,
--	email varchar(255),
--	primary key (user_id)
--);

--create table UserTicketDetailsReceipt (
--	Ticket_Receipt_Id bigint not null,
--	from_place varchar(255) not null,
--	to_place varchar(255) not null,
--	price_paid bigint,
--	user_id bigint not null,
--	primary key (Ticket_Receipt_Id),
--	foreign key (user_id) references User_Details(user_id)
--);

--create table UserTicketReservations (
--	pnr_id bigint not null,
--	section varchar(255),
--	seat_number bigint,
--	ticket_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--	user_id bigint,
--	primary key (pnr_id),
--	foreign key (user_id) references User_Details(user_id)
--);

create table sectiont (
	section_Id bigint not null,
	section_name varchar(255) not null
);

--insert into User_details(user_id, first_name, last_name, email)
--values
--(1001, 'Boris', 'Becker', 'borisbecker@gmail.com');


--insert into User_details(user_id, first_name, last_name, email)
--values
--(1002, 'Andre', 'Agassi', 'andreagassi@gmail.com');

--ALTER TABLE User_Ticket_Reservations ALTER COLUMN seat_number
--    SET DATA TYPE varchar(255);