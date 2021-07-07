package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRepository;
import com.example.demo.repo.TripCabInfoRepository;


@SpringBootApplication
public class DriverInProgressApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverInProgressApplication.class, args);
	
	}
	@Bean
	public CommandLineRunner runner()
	{
		return new CommandLineRunner() {
			
			@Autowired
			BookingRepository bookingRepo;
			
			@Autowired
			TripCabInfoRepository tripRepo;
			
			

			
			@Override
			public void run(String... args) throws Exception {
			
				//employee details--beg
				BookingRequest employeedetails = new BookingRequest(1,2034,"Nive","Alphacity","Tambaram","Bharath university",LocalDateTime.now(),LocalTime.of(10, 30),0,1050,null,null,null,null,"show",null,null,null,null,0);
				this.bookingRepo.save(employeedetails);
				
				BookingRequest employeedetails1 = new BookingRequest(2,2035,"Aparna","Alphacity","Tambaram","Navalur",LocalDateTime.now(),LocalTime.of(10, 30),0,1050,null,null,null,null,"show",null,null,null,null,0);
				this.bookingRepo.save(employeedetails1);
				
				BookingRequest employeedetails2 = new BookingRequest(3,2036,"Abi","Alphacity","Tambaram","Sathyabama stop",LocalDateTime.now(),LocalTime.of(10, 30),0,1050,null,null,null,null,"show",null,null,null,null,0);
				this.bookingRepo.save(employeedetails2);
				
				BookingRequest employeedetails3 = new BookingRequest(4,2037,"Shalini","Alphacity","Tambaram","Kumaran Nagar",LocalDateTime.now(),LocalTime.of(10, 30),0,1050,null,null,null,null,"show",null,null,null,null,0);
				this.bookingRepo.save(employeedetails3);
				
				BookingRequest employeedetails4 = new BookingRequest(5,2038,"Kiruthika","Alphacity","Tambaram","Navalur",LocalDateTime.now(),LocalTime.of(10, 30),0,1050,null,null,null,null,"show",null,null,null,null,0);
				this.bookingRepo.save(employeedetails4);
				
				BookingRequest employeedetails5 = new BookingRequest(6,2039,"Sneha","Alphacity","Tambaram","Aavin booth",LocalDateTime.now(),LocalTime.of(10, 30),0,1050,null,null,null,null,"show",null,null,null,null,0);
				this.bookingRepo.save(employeedetails5);
				
				BookingRequest employeedetails6 = new BookingRequest(7,2040,"Reshma","Alphacity","Tambaram","Shollingnalur",LocalDateTime.now(),LocalTime.of(10, 30),0,1050,null,null,null,null,"show",null,null,null,null,0);
				this.bookingRepo.save(employeedetails6);
				
				
				BookingRequest employeedetails7 = new BookingRequest(8,2041,"Janani","Alphacity","Tambaram","AGS",LocalDateTime.now(),LocalTime.of(10, 30),0,1050,null,null,null,null,"noshow",null,null,null,null,0);
				this.bookingRepo.save(employeedetails7);
				//employee details--end
				
				
				
				//tripdetails--beg
				TripCabInfo tripdetails = new TripCabInfo(1050,"TN57 NS1000",10,"Bayline","Tambaram","Shollingnalur",LocalDate.now(),LocalDateTime.now(),10,2,8,LocalTime.of(10, 30),null,null,null,null,null,null,0);
                this.tripRepo.save(tripdetails);
                //tripdetails--end
			}
		};
	}

}

		
