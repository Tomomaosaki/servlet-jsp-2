package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		User user = new User(name, pass);
		
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);
		
		if (isLogin) { // isLoginがtrueの時
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}
		
		String path ="WEB-INF/jsp/loginResult.jsp";
		RequestDispatcher d = request.getRequestDispatcher(path);
		d.forward(request, response);
	}

}
