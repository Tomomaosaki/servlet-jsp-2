package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Com;
import model.GameManager;
import model.User;

@WebServlet("/play")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/jsp/janken.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userHand = Integer.parseInt(request.getParameter("hand"));
		User user = new User();
		user.setHand(userHand);
		Com com = new Com();
		com.setRamdomHand();
		
		GameManager manager = new GameManager();
		manager.judge(user, com);
		
		request.setAttribute("manager", manager);
		
		String path = "WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
