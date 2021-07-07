package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.BookingRequest;

public interface BookingRepository extends MongoRepository<BookingRequest, Long> {

	
//List<BookingRequest> findEmployeeDetailsByTripCabID(long tripCabID);

//List<BookingRequest> findByStatus(String status);
	
	// For fetching rows based on TripCabId and status
	List<BookingRequest> findByTripCabIDAndStatus(long tripCabID, String status );

	//For storing status of Employee
    @Query(value="{employeeId:?0 ,status:show}")
	BookingRequest findByEmployeeId(int employeeID,long tripCabID);

	
	
//	@Query(value = "{employeeId:?0 , status:{$nin:[null , show , noshow]}}")
//  List<BookingRequest> findEmployeeDetailsByStatus(String status);
	
//	 public Optional<List<BookingRequest>> findByTripCabID(long tripCabID);
//		BookingRequest findByEmployeeId(int employeeId);
	
	
	
}
