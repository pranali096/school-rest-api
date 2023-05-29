package com.school.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.divisions.Divisions;

@Component
public class ClassesMapper {
	public static ClassesMapper aClassesDataBuilder() {
		return new ClassesMapper();
	}

	public Classes convertToClassesData(ClassesData cdata) {
		Divisions ds = Divisions.builder().did(cdata.getId()).Division(cdata.getDivisionName()).build();
		Classes cla = Classes.builder().id(cdata.getId()).classesName(cdata.getClassesName())

				.division(ds).build();
		return cla;

	}

	public ClassesData convertToClasses(Classes classes) {
		ClassesData data = ClassesData.builder().id(classes.getId()).classesName(classes.getClassesName())
				.divisionId(classes.getDivision().getDid()).divisionName(classes.getDivision().getDivision()).build();
		return data;

	}

	public List<ClassesData> convertToList(List<Classes> clist) {
		List<ClassesData> datalist = new ArrayList<>();
		for (Classes cl : clist) {
			ClassesData dt = ClassesData.builder().id(cl.getId()).classesName(cl.getClassesName())

					.divisionId(cl.getDivision().getDid()).divisionName(cl.getDivision().getDivision()).build();

			datalist.add(dt);
		}

		return datalist;
	}

}
