package com.school.branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordData {
	
private String id;

private	 String Password;

private String comfirmPasswor;

}
