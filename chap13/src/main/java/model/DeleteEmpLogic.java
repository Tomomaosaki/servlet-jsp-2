package model;

import dao.EmployeesDAO;

public class DeleteEmpLogic {
	public boolean execute(Employee emp) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.remove(emp.getId());
	}
}
