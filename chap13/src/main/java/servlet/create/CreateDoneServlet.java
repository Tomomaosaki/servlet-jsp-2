package servlet.create;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.RegisterEmpLogic;
import servlet.util.MakeEmpByParam;

@WebServlet("/createDone")
public class CreateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeEmpByParam makeEmp = new MakeEmpByParam();		
 		Employee emp = makeEmp.execute(request);
 		
 		RegisterEmpLogic logic = new RegisterEmpLogic();
 		boolean result = logic.execute(emp);
 		String job = "登録";
 		String msg ="";
 		if (result) {
 			msg = job + "しました";
 		} else {
 			msg = job + "に失敗しました";
 		}
 		request.setAttribute("msg", msg);
 		request.setAttribute("h2_text", "新規社員登録・結果");
 		String path = "WEB-INF/jsp/done.jsp";
 		request.getRequestDispatcher(path).forward(request, response);
	}

}
