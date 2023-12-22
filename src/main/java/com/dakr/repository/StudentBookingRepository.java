package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.StudentBooking;
@Repository
public interface StudentBookingRepository extends JpaRepository<StudentBooking, Integer>{

}
