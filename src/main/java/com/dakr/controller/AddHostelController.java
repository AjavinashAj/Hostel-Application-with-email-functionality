package com.dakr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.entity.*;
import com.dakr.service.*;

@RestController
@CrossOrigin("*")
public class AddHostelController {
	
	@Autowired
	private AddHostelService service;

	
	@PostMapping("/saveImage")
	public String saveAddHostel(@RequestParam MultipartFile file1 ,@RequestParam MultipartFile file2,@RequestParam MultipartFile file3,   @RequestParam String hostelName,
			@RequestParam String ownerName,@RequestParam String location,@RequestParam long ownerNumber, @RequestParam String ownerEmail,
			 @RequestParam Integer totalRoom,@RequestParam String street, @RequestParam Long pincode,
			@RequestParam String description ,@RequestParam Integer bed_4sheeter,@RequestParam Integer bed_3sheeter,@RequestParam Integer bed_2sheeter,@RequestParam double pricePerBed_4sheeter,@RequestParam double pricePerBed_3sheeter,@RequestParam double pricePerBed_2sheeter)
	{
		
		
		AddHostel addhostel =service.saveAddHostel(file1,file2,file3,hostelName,location,ownerName,ownerNumber,ownerEmail,totalRoom,totalRoom, street,pincode,description,bed_4sheeter,bed_3sheeter,bed_2sheeter,pricePerBed_4sheeter,pricePerBed_3sheeter,pricePerBed_2sheeter);
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
