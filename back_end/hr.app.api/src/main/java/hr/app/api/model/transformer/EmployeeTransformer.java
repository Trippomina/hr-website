package hr.app.api.model.transformer;

import java.util.List;
import java.util.stream.Collectors;

import hr.app.api.model.out.APIEmployeeOut;
import hr.app.business.model.Employee;

public class EmployeeTransformer {

	public static APIEmployeeOut TransformToOutModel(Employee e) {
		return APIEmployeeOut.builder().id(e.getEmployeeId()).fullName(e.getFullName())
				.department(e.getDepartment().getDepartmentName()).email(e.getEmail()).address(e.getAddress()).build();
	}

	public static List<APIEmployeeOut> TransformListToOutModels(List<Employee> list) {

		return list.stream().map(e -> TransformToOutModel(e)).collect(Collectors.toList());

	}
}