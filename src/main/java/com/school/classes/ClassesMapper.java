package com.school.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.divisions.Divisions;
@Component
public class ClassesMapper {
	
	public Classes converToClassesDto(ClassesDto dto) {
		Classes classObj= new Classes();
		classObj.setId(dto.getId());
		classObj.setClassesName(dto.getClassesName());
		Divisions div = new Divisions(dto.getDivisionId(), dto.getDivisionName());
		classObj.setDivision(div);
		
		return classObj;
			
		
	}
	
	public ClassesDto convertToClasess(Classes classes) {
		ClassesDto dto = new ClassesDto();
		dto.setId(classes.getId());
		dto.setClassesName(classes.getClassesName());
		dto.setDivisionId(classes.getDivision().getId());
		dto.setDivisionName(classes.getDivision().getDivision());
		
		return dto;
			
	}
	
	 public List<ClassesDto> convertToList(List<Classes> clist) {
	        List<ClassesDto> dtolist = new ArrayList<>();
	        for(Classes cl: clist) {
	        	   ClassesDto dto = convertToClasess(cl);
	               dtolist.add(dto);
	        }
	        
		
	        return dtolist;
                  
 }
//	 
//	 public List<ClassesDto> convertToClasseslist(List<Classes> clList){
//		 List<ClassesDto> dolist= new ArrayList<>();
//		 return dolist;
//	 }
//		

	private List<ClassesDto> convertToClasess(List<Classes> clist) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
