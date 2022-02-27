package com.gov.vaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gov.vaccine.entity.SignUpEntity;
import com.gov.vaccine.entity.UserOTPEntity;

@Repository
public interface UserRepository extends JpaRepository<UserOTPEntity, Integer> {
	
	@Query("select otp from UserOTPEntity where emailID=:EMAILID")
	public int findUserOTPByEmailID(@Param("EMAILID")String emailID);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update UserOTPEntity set otp=:newOtp where emailID=:EMAILID")
	public void updateOtpByEmailID(@Param("EMAILID")  String emailID,@Param("newOtp")int otp);
	
	
	
	
	
}
