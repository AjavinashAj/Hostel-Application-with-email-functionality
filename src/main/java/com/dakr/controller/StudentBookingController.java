package com.dakr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.entity.StudentBooking;
import com.dakr.service.StudentBookingService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
public class StudentBookingController {
	
	@Autowired
	private final StudentBookingService stuser;
	
	@PostMapping("/save")
	public StudentBooking setData(@RequestParam MultipartFile file,@RequestParam String hostelName,@RequestParam String firstName,@RequestParam String lastName,@RequestParam Long stuPhno,@RequestParam String email,@RequestParam Integer age,@RequestParam String identityProof,@RequestParam String identityProofNumber,@RequestParam String checkIn,@RequestParam String checkOut,@RequestParam Integer noOfSheeter,@RequestParam String roomNo,@RequestParam Double totalAmount,@RequestParam String bookingStatus,@RequestParam String parentName,@RequestParam Long parentPhno)
	{
		return stuser.saveData(file,hostelName,firstName,lastName,stuPhno,email,age,identityProof,identityProofNumber,checkIn,checkOut,noOfSheeter,roomNo,totalAmount,bookingStatus,parentName,parentPhno);
	}
	

}
