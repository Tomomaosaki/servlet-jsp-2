package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.JankenLogic;

@WebServlet("/play")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/jsp/janken.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		// ↑下の2行を1行にまとめたもの
		// RequestDispatcher d = request.getRequestDispatcher(path);
		// d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userHand = Integer.parseInt(request.getParameter("hand"));
		int comHand = (int)(Math.random() * 3);
		JankenLogic jankenLogic = new JankenLogic();
		String msg = jankenLogic.execute(userHand, comHand);
		request.setAttribute("msg", msg);
		String path = "WEB-INF/jsp/result.jsp";
		RequestDispatcher d = request.getRequestDispatcher(path);
		d.forward(request, response);
	}

}
