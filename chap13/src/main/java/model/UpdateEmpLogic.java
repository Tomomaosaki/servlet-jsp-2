package model;

import dao.EmployeesDAO;

public class UpdateEmpLogic {
	public boolean execute(Employee emp) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.update(emp);
	}
}
