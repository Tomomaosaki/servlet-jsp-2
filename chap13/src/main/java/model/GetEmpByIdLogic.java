package model;

import dao.EmployeesDAO;

public class GetEmpByIdLogic {
	public Employee execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findEmpById(id);
	}
}