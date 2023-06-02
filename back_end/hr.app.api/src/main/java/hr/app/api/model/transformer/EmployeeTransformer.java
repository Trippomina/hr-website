package hr.app.api.model.transformer;

import java.util.List;
import java.util.stream.Collectors;

import hr.app.api.model.in.APIEmployeeIn;
import hr.app.api.model.out.APIEmployeeOut;
import hr.app.business.model.Employee;

public class EmployeeTransformer {

	public static APIEmployeeOut TransformToOutModel(Employee e) {
		return APIEmployeeOut.builder().id(e.getEmployeeId()).fullName(e.getFullName()).department(e.getDepartment())
				.email(e.getEmail()).address(e.getAddress()).build();
	}

	public static Employee TransformFromInModel(APIEmployeeIn e) {
		Employee res = new Employee();
		res.setFullName(e.getFullName());
		res.setDepartment(e.getDepartment());
		res.setAddress(e.getAddress());
		res.setEmail(e.getEmail());
		return res;
	}

	public static List<APIEmployeeOut> TransformToOutModelList(List<Employee> list) {

		return list.stream().map(e -> TransformToOutModel(e)).collect(Collectors.toList());

	}

}