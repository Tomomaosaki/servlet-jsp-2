package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetListByAgeLogic;

@WebServlet("/listByAge")
public class ListByAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorList = new ArrayList<>();
		String ageTxt = request.getParameter("age");
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt);
		} catch (NumberFormatException e) {
			errorList.add("数字ではない");
			request.setAttribute("errorList", errorList);
		}
		if (errorList.size() == 0) { // エラーメッセージが０ならば（エラーがなければ）
			GetListByAgeLogic logic = new GetListByAgeLogic();
			List<Employee> empList = logic.execute(age);
			request.setAttribute("empList", empList);
		}
		// ↓list.jspにフォワード
		String path = "WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
