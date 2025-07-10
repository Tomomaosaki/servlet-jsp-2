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
import model.GetListByNameLogic;
import servlet.util.Validator;

@WebServlet("/listByName")
public class ListByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorList = new ArrayList<>();
		String name = request.getParameter("name"); // ←送られてくるのは文字列
		Validator validator = new Validator();
		validator.checkName(name, errorList);
		
		if (errorList.size() > 0) {  // ←エラーリストがあれば（エラーがあれば）
			request.setAttribute("errorList", errorList);
		} else {
			GetListByNameLogic logic = new GetListByNameLogic();
			List<Employee> empList = logic.execute(name);
			request.setAttribute("empList", empList); // logic.executeメソッドから返ってきたempListを保存
		}

		// ↓list.jspにフォワード
		String path = "WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
