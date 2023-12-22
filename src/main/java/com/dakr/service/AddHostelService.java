package com.dakr.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dakr.entity.*;

public interface AddHostelService {

	
	
	
	
	public AddHostel update(AddHostel addhostel,Integer hostelId);
	
	public void delete(Integer hostelId);
	public List<AddHostel> getAll();


	public AddHostel saveAddHostel(MultipartFile file1, MultipartFile file2, MultipartFile file3, String hostelName, String location, String ownerName,
			long ownerNumber, String ownerEmail, Integer totalRoom, Integer totalRoom2, String street, Long pincode,
			String description, Integer bed_4sheeter, Integer bed_3sheeter, Integer bed_2sheeter,
			double pricePerBed_4sheeter, double pricePerBed_3sheeter, double pricePerBed_2sheeter);
}