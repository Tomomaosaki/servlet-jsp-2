package servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import model.Employee;

public class MakeEmpByParam {
	public Employee execute(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ageTxt = request.getParameter("age");
		
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt);
		} catch (NumberFormatException e) {
			age = 0;
		}
 		Employee emp = new Employee(id, name, age); 		
 		return emp;
	}
}
