package servlet.update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import servlet.util.MakeEmpByParam;
import servlet.util.Validator;

@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		MakeEmpByParam makeEmp = new MakeEmpByParam();
 		Employee emp = makeEmp.execute(request); 		
 		
 		Validator validator = new Validator();		
		List<String> errorList = new ArrayList<>(); 		
 		validator.checkUpdate(emp, errorList);
 		
 		String path = "";
 		if (errorList.size() > 0) { 
 			// エラーがあれば（errorListにエラーが入っていたら）入力画面に戻る
 			request.setAttribute("errorList", errorList);
 			path = "WEB-INF/jsp/update/updateInput.jsp";
 		} else { // エラーがなければ
 			path = "WEB-INF/jsp/update/updateConfirm.jsp";
 		}
		request.setAttribute("emp", emp);
 		request.getRequestDispatcher(path).forward(request, response);
	}

}
