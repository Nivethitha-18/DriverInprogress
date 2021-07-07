package com.example.demo.DL;

import static com.mongodb.client.model.Filters.eq;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRepository;
import com.example.demo.repo.TripCabInfoRepository;

@Service
public class InProgressDL {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private TripCabInfoRepository tripRepo;

	// For getting the Trip details
	public List<TripCabInfo> getTripDetails(long tripCabID) {

		return this.tripRepo.findTripDetailsByTripCabID(tripCabID);
	}

//	// For getting the Booking Request made
//	public List<BookingRequest> getBookingRequests() {
//		return this.bookingRepo.findAll();
//
//	}

	// For fetching rows based on TripCabId and status
	public List<BookingRequest> getFilteredBookingRequests(long tripCabID, String status) {
		
		return this.bookingRepo.findByTripCabIDAndStatus(tripCabID, status);
	}

	
	//For storing status of Employee
	public BookingRequest storeEmployeeStatus(int employeeID,long tripCabID) {
		BookingRequest status= bookingRepo.findByEmployeeId(employeeID, tripCabID);
		if (status!= null) {
			status.setStatus("Reached");
			status.setReachedTime(LocalTime.now());
			bookingRepo.save(status);
		}
		return status;
		

	}

	
	//For updating the end status of cab
	public TripCabInfo updateTrip(long tripCabID) {
		Optional<TripCabInfo> save= tripRepo.findById(tripCabID);
		TripCabInfo status= save.get();
		status.setEndTime(LocalTime.now());
		status.setStatus("Completed");
		return tripRepo.save(status);
	}

}
