package com.example.demo.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DL.InProgressDL;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;



@Component
public class InProgressBL {

	@Autowired
	private InProgressDL inprogressDl;
	
	//For getting the Trip details
	public List<TripCabInfo> getTripDetails(long tripCabID)
	{
		return this.inprogressDl.getTripDetails(tripCabID);
	}
	
//	//For getting the booking requests made
//		public List<BookingRequest> getBookingRequests()
//		{
//			return this.inprogressDl.getBookingRequests();
//		}
	
	
	
	// For fetching rows based on TripCabId and status
	public List<BookingRequest> getFilteredBookingRequests(long tripCabID, String status)
	{
		return this.inprogressDl.getFilteredBookingRequests(tripCabID,status);
	}
	
	
	
	
  //For storing status of Employee
	public BookingRequest storeEmployeeStatus(int employeeID, long tripCabID){
		
		return this.inprogressDl.storeEmployeeStatus(employeeID, tripCabID);
	}

	//For updating the end status of cab
	public TripCabInfo updateTrip(long tripCabID) {
		// TODO Auto-generated method stub
		return this.inprogressDl.updateTrip(tripCabID);
	}

	//For getting server time-startTime
	public TripCabInfo getBookingTime(long tripCabID) {
		// TODO Auto-generated method stub
		return this.inprogressDl.getBookingTime(tripCabID);
	}
	
}

