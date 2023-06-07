package com.school.branch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
	
public class BranchDto {
	
		private Long id;
		private String name;
		private String adress;
		private String contactNo;
		private String email;
		private String personname;
		private String personcontactNo;
		private String personEmail;
		private String personadress;

	}

