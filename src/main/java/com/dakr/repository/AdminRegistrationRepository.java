package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.AdminRegistration;
@Repository
public interface AdminRegistrationRepository extends JpaRepository<AdminRegistration, Integer>{

	public AdminRegistration findByEmail(String email);
	public AdminRegistration findByEmailAndPassword(String email,String pwd);

}
