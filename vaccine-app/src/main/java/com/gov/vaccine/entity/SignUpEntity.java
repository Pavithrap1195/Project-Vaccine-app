package com.gov.vaccine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vaccine_signup")
@NamedQueries({
		@NamedQuery(name = "getEntityByUsernameAndPassword", query = "from SignUpEntity where userName=:USERNAME"),
		@NamedQuery(name = "getLoginAttemptsByUsername", query = "select loginAttempts from SignUpEntity where userName=:USERNAME"),
		@NamedQuery(name = "updateLoginAttemptsByUsername", query = "update SignUpEntity set loginAttempts=:ATTEMPTS where userName=:USERNAME"),
		@NamedQuery(name = "updatePasswordByUsername", query = "update SignUpEntity set password=:PASSWORD,loginAttempts=:ATTEMPTS where userName=:USERNAME") })
public class SignUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private Long mobileNumber;
	private String gender;
	private String dateOfBirth;
	private String password;
	private int loginAttempts;

}
