package com.dakr.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.entity.*;
import com.dakr.repository.*;

@Service
public class AddHostelServiceImpl implements AddHostelService {

	@Autowired
	private AddHostelRepository addHostelRepo;

	@Override
	public AddHostel saveAddHostel(MultipartFile file1, MultipartFile file2, MultipartFile file3, String hostelName,
			String location, String ownerName, long ownerNumber, String ownerEmail, Integer totalRoom,
			Integer totalRoom2, String street, Long pincode, String description, Integer bed_4sheeter,
			Integer bed_3sheeter, Integer bed_2sheeter, double pricePerBed_4sheeter, double pricePerBed_3sheeter,
			double pricePerBed_2sheeter) {
		AddHostel addHostel = new AddHostel();
		String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
		String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
		String fileName3 = StringUtils.cleanPath(file3.getOriginalFilename());
		if (fileName1.contains("..") || fileName2.contains("..") || fileName3.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			addHostel.setHostelImage1(Base64.getEncoder().encodeToString(file1.getBytes()));
			addHostel.setHostelImage2(Base64.getEncoder().encodeToString(file2.getBytes()));
			addHostel.setHostelImage3(Base64.getEncoder().encodeToString(file3.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		addHostel.setHostelName(hostelName);
		addHostel.setLocation(location);
		addHostel.setOwnerName(ownerName);
		addHostel.setOwnerNumber(ownerNumber);
		addHostel.setOwnerEmail(ownerEmail);

		addHostel.setTotalRoom(totalRoom);
		addHostel.setStreet(street);
		addHostel.setPincode((long) pincode);
		addHostel.setDescription(description);
		addHostel.setBed_4sheeter(bed_4sheeter);
		addHostel.setBed_3sheeter(bed_3sheeter);
		addHostel.setBed_2sheeter(bed_2sheeter);
		addHostel.setPricePerBed_4sheeter(pricePerBed_4sheeter);
		addHostel.setPricePerBed_3sheeter(pricePerBed_3sheeter);
		addHostel.setPricePerBed_2sheeter(pricePerBed_2sheeter);

		addHostelRepo.save(addHostel);
		return addHostel;
	}

	@Override
	public AddHostel update(AddHostel addhostel, Integer hostelId) {

		return null;
	}

	@Override
	public void delete(Integer hostelId) {
		addHostelRepo.deleteById(hostelId);

	}

	@Override
	public List<AddHostel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
