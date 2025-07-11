package model;

import dao.EmployeesDAO;

public class RegisterEmpLogic {
	public boolean execute(Employee emp) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.create(emp);
	}
}
