package com.dakr.service;

import org.springframework.web.multipart.MultipartFile;

import com.dakr.binding.Hostel_FacilityBinding;
import com.dakr.binding.Hostel_Review_Binding;
import com.dakr.entity.AddHostel;
import com.dakr.entity.Hostel_Facility;
import com.dakr.entity.Hostel_Review;

public interface HostelService {

	Hostel_Facility setHFacility(Hostel_FacilityBinding hfb);

	Hostel_Review setReviewData(Hostel_Review_Binding hrb);

	

	AddHostel saveAddHostel(MultipartFile file, String hostelName, String ownerName, String location,
			long ownerNumber, String ownerEmail, double bedCharges, Integer totalRoom, String street, Long pincode,
			String description);

}
