package com.gov.vaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.vaccine.entity.AddMemberEntity;

@Repository
public interface AddMemberRepository extends JpaRepository<AddMemberEntity, Integer> {

	
	
	
}
