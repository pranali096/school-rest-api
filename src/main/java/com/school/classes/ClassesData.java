package com.school.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassesData {
	private Long id;
	private String classesName;
	private String divisionName;
	private Long divisionId;
	


	

}
