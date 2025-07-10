package servlet.create;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import servlet.util.Validator;

@WebServlet("/createConfirm")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String id = request.getParameter("id");
 		String name = request.getParameter("name");
 		String ageTxt = request.getParameter("age");
 		
 		List<String> errorList = new ArrayList<>();
 		Validator validator = new Validator();
 		int age = validator.checkAge(ageTxt, errorList);
 		Employee emp = new Employee(id, name, age);
 		validator.check(emp, errorList);
 	}

}
