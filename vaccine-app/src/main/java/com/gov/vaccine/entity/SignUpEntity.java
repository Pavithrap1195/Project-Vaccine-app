package com.gov.vaccine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vaccine_signup")
@NamedQuery(name = "getEntityByUsernameAndPassword", query = "from SignUpEntity where userName=:USERNAME")
public class SignUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private Long mobileNumber;
	private String gender;
	private String dateOfBirth;
	private String password;

}
