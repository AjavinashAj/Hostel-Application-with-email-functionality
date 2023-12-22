package com.dakr.service;

import org.springframework.web.multipart.MultipartFile;

import com.dakr.entity.StudentBooking;

public interface StudentBookingService {

	public StudentBooking saveData(MultipartFile file, String hostelName, String firstName, String lastName, Long stuPhno, String email, Integer age, String identityProof, String identityProofNumber, String checkIn, String checkOut, Integer noOfSheeter, String roomNo, Double totalAmount, String bookingStatus, String parentName, Long parentPhno);

}
