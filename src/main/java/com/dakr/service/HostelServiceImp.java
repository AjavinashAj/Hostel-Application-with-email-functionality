package com.dakr.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.binding.Hostel_FacilityBinding;
import com.dakr.binding.Hostel_Review_Binding;
import com.dakr.entity.AddHostel;
import com.dakr.entity.Hostel_Facility;
import com.dakr.entity.Hostel_Review;
import com.dakr.repository.AddHostelRepository;
import com.dakr.repository.Hostel_Facility_Repository;
import com.dakr.repository.Hostel_Review_Repository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HostelServiceImp implements HostelService {

	@Autowired
	private final AddHostelRepository adRepo;
	@Autowired
	private final Hostel_Facility_Repository repo;
	@Autowired
	private final Hostel_Review_Repository reRepo;

	@Override
	public Hostel_Facility setHFacility(Hostel_FacilityBinding hfb) {
		Hostel_Facility hf = new Hostel_Facility();
		BeanUtils.copyProperties(hfb, hf);
		return repo.save(hf);
	}

	@Override
	public Hostel_Review setReviewData(Hostel_Review_Binding hrb) {
		Hostel_Review hr = new Hostel_Review();
		BeanUtils.copyProperties(hrb, hr);
		return reRepo.save(hr);
	}

	@Override
	public AddHostel saveAddHostel(MultipartFile file,  String hostelName, String ownerName,
			String location, long ownerNumber, String ownerEmail, double bedCharges, Integer totalRoom, String street,
			Long pincode, String description) {
		AddHostel addHostel = new AddHostel();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			addHostel.setHostelImage1(Base64.getEncoder().encodeToString(file.getBytes()));
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
		addHostel.setPincode(pincode);
		addHostel.setDescription(description);
		
		adRepo.save(addHostel);
		return addHostel;
	
		
	}

	
}
