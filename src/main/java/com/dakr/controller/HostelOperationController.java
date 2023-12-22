package com.dakr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.binding.Hostel_FacilityBinding;
import com.dakr.binding.Hostel_Review_Binding;
import com.dakr.entity.AddHostel;
import com.dakr.entity.Hostel_Facility;
import com.dakr.entity.Hostel_Review;
import com.dakr.service.HostelService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
public class HostelOperationController {
	
	@Autowired
	private final HostelService hostel;
	
	@PostMapping("/hfacility")
	public Hostel_Facility setHostelFacility(@RequestBody Hostel_FacilityBinding hfb)
	{
		return hostel.setHFacility(hfb);
	}
	
	// for hostel review
	@PostMapping("/hreview")
	public Hostel_Review setHostelRieview(@RequestBody Hostel_Review_Binding hrb)
	{
		return hostel.setReviewData(hrb);
	}
	
	// for add hostel
	
	@PostMapping("/addhostel")
	public String saveAddHostel(@RequestParam MultipartFile file ,  @RequestParam String hostelName,
			@RequestParam String ownerName,@RequestParam String location,@RequestParam Long ownerNumber, @RequestParam String ownerEmail,
			@RequestParam double bedCharges, @RequestParam Integer totalRoom,@RequestParam String street, @RequestParam Long pincode,
			@RequestParam String description )
	{
		
		
		AddHostel addhostel =hostel.saveAddHostel(file,hostelName,ownerName,location,ownerNumber,ownerEmail,bedCharges,totalRoom,street,pincode,description);
		String message = null;
		if (addhostel == null)
		{
			message = "Image Save Successfully";
		}
		else
		{
			message ="Image Save Successfully";
		}
		return message;
		
	
}}


