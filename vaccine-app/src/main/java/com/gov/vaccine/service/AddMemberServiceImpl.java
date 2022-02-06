package com.gov.vaccine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gov.vaccine.dao.AddMemberDAO;
import com.gov.vaccine.dto.AddMemberDTO;
import com.gov.vaccine.entity.AddMemberEntity;

@Service
public class AddMemberServiceImpl implements AddMemberService {

	@Autowired
	private AddMemberDAO addMemberDAO;

	@Override
	public boolean validateMemberDetails(AddMemberDTO addMemberDTO) {
		System.out.println("Invoked validateMemberDetails()");
		boolean validated = false;
		if (addMemberDTO.getName() != null && !addMemberDTO.getName().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid Name");
			map.put("NAME", "Invalid Name");
			return validated;
		}
		if (addMemberDTO.getGender() != null && !addMemberDTO.getGender().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid Gender");
			map.put("GENDER", "Invalid Gender");
			return validated;
		}
		if (addMemberDTO.getDob() != null && !addMemberDTO.getDob().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Enter valid dob");
			map.put("DOB", "Enter valid dob");
			return validated;
		}
		if (addMemberDTO.getPhotoIdProof() != null && !addMemberDTO.getPhotoIdProof().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid ID proof");
			map.put("ID", "Invalid ID proof");
			return validated;
		}
		if (addMemberDTO.getPhotoIdNumber() != null && !addMemberDTO.getPhotoIdNumber().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid ID number");
			map.put("IDNUMBER", "Invalid ID number");
			return validated;
		}
		if (addMemberDTO.getVaccineType() != null && !addMemberDTO.getVaccineType().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid vaccine type");
			map.put("TYPE", "Invalid vaccine type");
			return validated;
		}
		if (addMemberDTO.getDose() != null && !addMemberDTO.getDose().isEmpty()) {
			validated = true;
		} else {
			validated = false;
			System.out.println("Invalid Doses");
			map.put("DOSES", "Invalid Doses");
			return validated;
		}
		return validated;
	}

	@Override
	public boolean saveMemberDetails(AddMemberDTO addMemberDTO) {
		System.out.println("Invoked saveMemberDetails()");
		AddMemberEntity addMemberEntity = new AddMemberEntity();
		BeanUtils.copyProperties(addMemberDTO, addMemberEntity);
		return this.addMemberDAO.saveMemberDetails(addMemberEntity);
	}

}
