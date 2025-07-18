package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.GetListLogic;
import model.Member;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetListLogic logic = new GetListLogic();
		List<Member> memberList = logic.execute();
		request.setAttribute("memberList", memberList);
		String url = "WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
