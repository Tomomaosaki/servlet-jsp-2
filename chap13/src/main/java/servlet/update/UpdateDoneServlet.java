package servlet.update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.UpdateEmpLogic;
import servlet.util.MakeEmpByParam;

@WebServlet("/updateDone")
public class UpdateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		MakeEmpByParam makeEmp = new MakeEmpByParam();
 		Employee emp = makeEmp.execute(request);		
 		
 		UpdateEmpLogic logic = new UpdateEmpLogic();
 		boolean result = logic.execute(emp);
 		String msg ="";
 		if (result) {
 			msg ="更新しました";
 		} else {
 			msg ="更新に失敗しました";
 		}
 		request.setAttribute("msg", msg);
 		request.setAttribute("h2_text", "社員情報更新・結果");
 		String path = "WEB-INF/jsp/done.jsp";
 		request.getRequestDispatcher(path).forward(request, response);
	}

}
