package com.dakr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ADMIN_REGISTRATION_TBL")
public class AdminRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;

	private String firstName;

	private String lastName;

	private Long phno;

	private String email;
	private String gender;
	private Integer age;
	private String street;
	private String city;
	private String pincode;
    private String state;
	private String password;
	private String accStatus;
}
