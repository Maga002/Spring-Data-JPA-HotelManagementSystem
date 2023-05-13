package com.practice.hotel;

import com.practice.hotel.customer.Customer;
import com.practice.hotel.customer.CustomerRepository;
import com.practice.hotel.customer.CustomerStatus;
import com.practice.hotel.paymentTransaction.Payment;
import com.practice.hotel.reservation.Reservation;
import com.practice.hotel.room.RoomClass;
import com.practice.hotel.room.RoomInformation;
import com.practice.hotel.room.RoomType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			Customer customer1 = new Customer("Mahammad","Gulalov","Vamhaz krt 11 1093", CustomerStatus.GUEST);
			RoomClass roomClass = new RoomClass(RoomType.TWIN);
			RoomInformation roomInfo = new RoomInformation("25 sq2, 2 bed with perfect",49.99,roomClass);
			Reservation reservation1 = new Reservation(LocalDate.now().minusDays(20),LocalDate.of(2023,5,12),LocalDate.of(2023,5,22),customer1,roomInfo);
			customer1.addReservations(reservation1);
			customer1.addPayments(new Payment(LocalDate.now(),customer1));
			customerRepository.save(customer1);
		};
	}



}
