package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.*;


@Repository
public interface AddHostelRepository extends JpaRepository<AddHostel, Integer> {

}
