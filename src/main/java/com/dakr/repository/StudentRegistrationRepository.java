package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.StudentRegistration;
@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Integer>{

	public StudentRegistration findByEmail(String email);
	public StudentRegistration findByEmailAndPassword(String email,String pwd);

}
