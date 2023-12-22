package com.dakr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data

@Entity
@Table(name="ADD_HOSTEL_TBL")
public class AddHostel {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hostelId;
	private String hostelName;
	private String location;
	private String ownerName;
	private Long ownerNumber;
	private String ownerEmail;
	
	private Integer totalRoom;
	private Integer bed_4sheeter;
	private Integer bed_3sheeter;
	private Integer bed_2sheeter;
	private Double pricePerBed_4sheeter;
	private Double pricePerBed_3sheeter;
	private Double pricePerBed_2sheeter;
	private String street;
	private Long pincode;
	@Lob
	private String hostelImage1;
	@Lob
	private String hostelImage2;
	@Lob
	private String hostelImage3;
	private String description;
	
}
 	