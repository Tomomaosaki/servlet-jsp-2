package servlet.create;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.RegisterEmpLogic;

@WebServlet("/createDone")
public class CreateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
 		String name = request.getParameter("name");
 		String ageTxt = request.getParameter("age");
 		int age = Integer.parseInt(ageTxt);		
 		Employee emp = new Employee(id, name, age);
 		
 		RegisterEmpLogic logic = new RegisterEmpLogic();
 		boolean result = logic.execute(emp);
 		String msg ="";
 		if (result) {
 			msg ="登録しました";
 		} else {
 			msg ="登録に失敗しました";
 		}
 		request.setAttribute("msg", msg);
 		String path = "WEB-INF/jsp/create/createDone.jsp";
 		request.getRequestDispatcher(path).forward(request, response);
	}

}
