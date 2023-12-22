package com.dakr.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
@Entity
@Table(name="STUDENT_BOOKING_TBL")
public class StudentBooking {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bookingId;
	private String hostelName;
	private String firstName;
	private String lastName;
	private Long stuPhno;
	private String email;
	private Integer age;
	private String identityProof;
	private String identityProofNumber;
	private String checkIn;
	private String checkOut;
	private Integer noOfSheeter;
	private String roomNo;
	private Double totalAmount;
	private String bookingStatus;
	private String parentName;
	private Long parentPhno;
	@Lob
	private String studentImage;
}
