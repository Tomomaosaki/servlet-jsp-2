package model;

import dao.EmployeesDAO;

public class IsNotExistIdLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.isNotExistId(id);
	}
}
