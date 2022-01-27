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
@Table(name="vaccine_user_otp")
@NamedQuery(name="UserOTPEntity.getUserOTPByEmailID",query="select otp from UserOTPEntity where emailID=:EMAILID")
public class UserOTPEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailID;
	private int otp;

}
