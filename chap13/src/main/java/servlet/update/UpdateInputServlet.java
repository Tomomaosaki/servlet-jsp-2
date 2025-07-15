package servlet.update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmpByIdLogic;
import servlet.util.MakeEmpByParam;

@WebServlet("/updateInput")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		GetEmpByIdLogic logic = new GetEmpByIdLogic();
		Employee emp = logic.execute(id);
		request.setAttribute("emp", emp);
		String url = "WEB-INF/jsp/update/updateInput.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeEmpByParam makeEmp = new MakeEmpByParam();
		Employee emp = makeEmp.execute(request);
		request.setAttribute("emp", emp);
		String url = "WEB-INF/jsp/update/updateInput.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
