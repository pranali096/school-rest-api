package com.school.branch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.classes.Classes;
import com.school.classes.ClassesData;

@Component
public class BranchBuilder {
	public static BranchBuilder bBuilder() {
		return new BranchBuilder();
	}

	public Branch convertToBranchrequestdto(BranchRequestDto dto) {
		Branch bdto = Branch.builder()
				.adress(dto.getAdress()).confirmPassword(dto.getConfirmpassword())
				.contactNo(dto.getContactNo()).email(dto.getEmail()).id(dto.getId()).name(dto.getName()).password(dto.getAdress())
				.personAdress(dto.getPersonadress()).personContactNo(dto.getPersoncontactNo()).personEmail(dto.getPersonEmail())
				.personName(dto.getPersonname())
				.build();
		return bdto;
	}
	
	public BranchResposnceDto counvrtToBranch(Branch bch) {
		BranchResposnceDto brdto = BranchResposnceDto.builder().adress(bch.getAdress()).contactNo(bch.getContactNo())
				.email(bch.getEmail()).id(bch.getId()).name(bch.getName())
				.build();
		return brdto;
		
	}
	public List<BranchResposnceDto> convertToList(List<Branch> blist) {
		List<BranchResposnceDto> datalist = new ArrayList<>();
		for (Branch bh: blist) {
			BranchResposnceDto dt = BranchResposnceDto.builder()
					.adress(bh.getAdress()).contactNo(bh.getContactNo())
					.email(bh.getEmail()).id(bh.getId()).name(bh.getName())
					.build();
			datalist.add(dt);
		}

		return datalist;
	}
	public BranchDto counvrtToBranchs(Branch ch) {
		BranchDto brdto = BranchDto.builder().adress(ch.getAdress()).contactNo(ch.getContactNo())
				.email(ch.getEmail()).id(ch.getId()).name(ch.getName())
				.build();
		return brdto;
		
	}
	
	public Branch convertToBranchDto(BranchDto bdto2) {
		Branch bdto = Branch.builder()
				.adress(bdto2.getAdress())
				.contactNo(bdto2.getContactNo()).email(bdto2.getEmail()).id(bdto2.getId()).name(bdto2.getName())
				.personAdress(bdto2.getPersonadress()).personContactNo(bdto2.getPersoncontactNo()).personEmail(bdto2.getPersonEmail())
				.personName(bdto2.getPersonname())
				.build();
		return bdto;
	}
}
	
