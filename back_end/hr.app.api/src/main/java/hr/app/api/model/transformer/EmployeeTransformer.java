package hr.app.api.model.transformer;

import java.util.List;
import java.util.stream.Collectors;

import hr.app.api.model.in.APIEmployeeIn;
import hr.app.api.model.out.APIEmployeeOut;
import hr.app.business.model.Employee;

public class EmployeeTransformer {

	public static APIEmployeeOut TransformToOutModel(Employee e) {
		APIEmployeeOut res = new APIEmployeeOut();
		res.setId(e.getEmployeeId());
		res.setFull_name(e.getFullName());
		res.setDepartment(e.getDepartment());
		res.setEmail(e.getEmail());
		res.setAddress(e.getAddress());

		return res;
	}

	public static Employee TransformFromInModel(APIEmployeeIn e) {
		Employee res = new Employee();
		res.setFullName(e.getFull_name());
		res.setDepartment(e.getDepartment());
		res.setAddress(e.getAddress());
		res.setEmail(e.getEmail());
		return res;
	}

	public static List<APIEmployeeOut> TransformToOutModelList(List<Employee> list) {

		return list.stream().map(e -> TransformToOutModel(e)).collect(Collectors.toList());

	}

}