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
import servlet.util.MakeEmpByParam;
import servlet.util.Validator;

@WebServlet(urlPatterns = {"/createConfirm", "/updateConfirm"})
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String path = request.getServletPath(); // どこのサーブレットから来ているか
 		
 		MakeEmpByParam makeEmp = new MakeEmpByParam();
 		Employee emp = makeEmp.execute(request); 		
 		Validator validator = new Validator();
 		List<String> errorList = new ArrayList<>();
 		
 		switch (path) {
 		case "/createConfirm":
 			validator.checkCreate(emp, errorList);
 			if (errorList.size() == 0) // エラーがなければ
 				request.setAttribute("nextURL", "createDone");
 			break;
 		case "/updateConfirm":
 			validator.checkUpdate(emp, errorList);
 			if (errorList.size() == 0) // エラーがなければ
 				request.setAttribute("nextURL", "updateDone");
 			break;
 		}
 			
 		String url = "";
 		if (errorList.size() > 0) { 
 			// エラーがあれば（errorListにエラーが入っていたら）入力画面に戻る
 			request.setAttribute("errorList", errorList);
 			url = "WEB-INF/jsp/input.jsp";
 		} else { // エラーがなければ			
 			url = "WEB-INF/jsp/confirm.jsp";
 		}
		request.setAttribute("emp", emp);
 		request.getRequestDispatcher(url).forward(request, response);
 	}
}
