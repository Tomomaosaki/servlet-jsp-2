package servlet.create;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;

@WebServlet("/createInput")
public class CreateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/jsp/create/createInput.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ageTxt = request.getParameter("age");
		int age = Integer.parseInt(ageTxt);
		Employee emp = new Employee(id, name, age);
		request.setAttribute("emp", emp);
		String path = "WEB-INF/jsp/create/createInput.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
}
