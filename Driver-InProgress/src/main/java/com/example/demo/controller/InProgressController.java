package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BL.InProgressBL;
import com.example.demo.DL.InProgressDL;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/driver/inprogress")
public class InProgressController {

	@Autowired
	private InProgressBL inprogressBl;
	
	@Autowired
	private InProgressDL inProgressDL;
	
	//For getting the Trip details of cab
	@GetMapping(path = "/tripdetails/{id}")
	public ResponseEntity<List<TripCabInfo>> getTripDetails(@PathVariable("id")long tripCabID)
	{
		List<TripCabInfo> tripdetails = this.inprogressBl.getTripDetails(tripCabID);
		
		return ResponseEntity.status(HttpStatus.OK).body(tripdetails);
	}
	
	
//	For getting the booking requests made
//	@GetMapping(path = "/bookings")
//	public ResponseEntity<List<BookingRequest>> getBookings()
//	{
//		List<BookingRequest> requests = this.inprogressBl.getBookingRequests();
//		
//		return ResponseEntity.status(HttpStatus.OK).body(requests);
//	}
	
	
	
	
	// For fetching rows based on TripCabId and status
	@GetMapping(path = "/bookings/status/{status}/{tripCabID}")
	public ResponseEntity<List<BookingRequest>> getFilteredBookings(@PathVariable("tripCabID") long tripCabID,
			@PathVariable("status") String status)
	{
		List<BookingRequest> requests = this.inprogressBl.getFilteredBookingRequests(tripCabID, status);
		
		return ResponseEntity.status(HttpStatus.OK).body(requests);
	}
	
	
	
	
	
	//For storing status of Employee
		@PutMapping(path = "/employee/status/{employeeID}")
		public ResponseEntity<BookingRequest> storeEmployeeStatus(@PathVariable("employeeID")int employeeID, @Param("tripCabID")long tripCabID)
		{
			BookingRequest savedStatus = this.inprogressBl.storeEmployeeStatus(employeeID, tripCabID);
			
			return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
		}
		
	
      //For updating the end status of cab
		 @PutMapping("/update/{tripCabID}")
		   public ResponseEntity<TripCabInfo> updatebytripCabID(@PathVariable("tripCabID")long tripCabID){
		    	
		    		 
		    		TripCabInfo savedStatus = this.inprogressBl.updateTrip(tripCabID); 
		    	 
		    	 
		    	 
			return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
		     }
		 
	//For getting server time-startTime
		 @GetMapping("getServerTime/{tripCabID}")
		 public TripCabInfo getBookingTime(@PathVariable("tripCabID") long tripCabID)
			{
				return this.inprogressBl.getBookingTime(tripCabID);
				
			}

	      
}
	
		


