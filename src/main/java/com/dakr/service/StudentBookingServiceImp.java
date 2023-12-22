package com.dakr.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.entity.StudentBooking;
import com.dakr.repository.StudentBookingRepository;
import com.dakr.utils.BookingIdUtils;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class StudentBookingServiceImp implements StudentBookingService {
    @Autowired
	private final BookingIdUtils bookingId;
    
	@Autowired
	private final StudentBookingRepository repo;
	
	@Override
	public StudentBooking saveData(MultipartFile file, String hostelName, String firstName, String lastName, Long stuPhno,
			String email, Integer age, String identityProof, String identityProofNumber, String checkIn,
			String checkOut, Integer noOfSheeter, String roomNo, Double totalAmount, String bookingStatus,
			String parentName, Long parentPhno) {
		StudentBooking reg = new StudentBooking();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
     	if (fileName.contains("..") ) {
			System.out.println("not a a valid file");
		}
		try {
			reg.setStudentImage(Base64.getEncoder().encodeToString(file.getBytes()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
     	reg.setBookingId(bookingId.BookingId());

		reg.setHostelName(hostelName);
		reg.setFirstName(firstName);
		reg.setLastName(lastName);
		reg.setStuPhno(stuPhno);
		reg.setEmail(email);
		reg.setIdentityProof(identityProof);
		reg.setIdentityProofNumber(identityProofNumber);
		reg.setCheckIn(checkIn);
		reg.setCheckOut(checkOut);
		reg.setAge(age);
		reg.setNoOfSheeter(noOfSheeter);
		reg.setRoomNo(roomNo);
		reg.setParentName(parentName);
		reg.setParentPhno(parentPhno);
		reg.setTotalAmount(totalAmount);
		reg.setBookingStatus(bookingStatus);
		
		return repo.save(reg);
	}

	 
		
	


	

}
