package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmpByIdLogic;
import servlet.util.MakeEmpByParam;

@WebServlet(urlPatterns = {"/createInput", "/updateInput"})
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath(); // どこのサーブレットから来ているか
		switch (path) {
		case "/createInput":
			request.setAttribute("nextURL", "createConfirm");
			break;
		case "/updateInput":
			String id = request.getParameter("id");
			GetEmpByIdLogic logic = new GetEmpByIdLogic();
			Employee emp = logic.execute(id);
			request.setAttribute("emp", emp);
			request.setAttribute("nextURL", "updateConfirm");
			break;
		}		
		String url = "WEB-INF/jsp/input.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String path = request.getServletPath();
		switch (path) {
		case "/createInput":
			request.setAttribute("nextURL", "createConfirm");
			break;
		case "/updateInput":
			request.setAttribute("nextURL", "updateConfirm");
			break;
		}		
		MakeEmpByParam makeEmp = new MakeEmpByParam();
		Employee emp = makeEmp.execute(request);				
		request.setAttribute("emp", emp);
		String url = "WEB-INF/jsp/input.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
