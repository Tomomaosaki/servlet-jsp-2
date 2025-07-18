package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DeleteEmpLogic;
import model.Employee;
import model.RegisterEmpLogic;
import model.UpdateEmpLogic;
import servlet.util.MakeEmpByParam;

@WebServlet(urlPatterns = {"/createDone", "/updateDone", "/deleteDone"})
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ↓この2行でid,name,ageを受け取ってempにまとめる
		MakeEmpByParam makeEmp = new MakeEmpByParam();		
 		Employee emp = makeEmp.execute(request);
 				
 		String path = request.getServletPath();
 		boolean result = false;
 		String job = null;
 		String h2_text = null;
 		switch (path) {
 		case "/createDone":
 	 		RegisterEmpLogic registerlogic = new RegisterEmpLogic();
 	 		result = registerlogic.execute(emp);
 	 		job = "登録";
 	 		h2_text = "新規社員登録・結果";
 			break;
 		case "/updateDone":
 	 		UpdateEmpLogic updatelogic = new UpdateEmpLogic();
 	 		result = updatelogic.execute(emp);
 	 		job = "更新";
 	 		h2_text = "社員情報更新・結果";
 			break;
 		case "/deleteDone":
 			DeleteEmpLogic deleteLogic = new DeleteEmpLogic();
 			result = deleteLogic.execute(emp);
 			job = "削除";
 			h2_text = "社員情報削除・結果";
 			break;
 		}

 		String msg =(result) ? (job + "しました") : (job + "に失敗しました");
 		request.setAttribute("msg", msg);
 		request.setAttribute("h2_text", h2_text);
 		String url = "WEB-INF/jsp/done.jsp";
 		request.getRequestDispatcher(url).forward(request, response);
	}

}
