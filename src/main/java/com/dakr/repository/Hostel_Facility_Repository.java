package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.Hostel_Facility;

@Repository
public interface Hostel_Facility_Repository extends JpaRepository<Hostel_Facility, Integer>{

	
}
