package model;

import java.util.List;

import dao.EmployeesDAO;

public class GetListByAgeLogic {
	public List<Employee> execute(int age) {
		EmployeesDAO dao = new EmployeesDAO();
		List<Employee> empList = dao.findAll(); // findByAge()に変える
		return empList;
	}
}
