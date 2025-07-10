package model;

import java.util.List;

import dao.EmployeesDAO;

public class GetListByNameLogic {
	public List<Employee> execute(String name) {
		EmployeesDAO dao = new EmployeesDAO();
		List<Employee> empList = dao.findByName(name);
		return empList;
	}
}
