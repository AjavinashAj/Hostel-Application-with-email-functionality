package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.Hostel_Review;

@Repository
public interface Hostel_Review_Repository extends JpaRepository<Hostel_Review, Integer> {

}
