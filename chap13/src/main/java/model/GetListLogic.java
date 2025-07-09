package model;

import java.util.List;

import dao.EmployeesDAO;

public class GetListLogic {
	public List<Employee> execute() {
		EmployeesDAO dao = new EmployeesDAO();
		List<Employee> empList = dao.findAll();
		return empList;
	}
}
