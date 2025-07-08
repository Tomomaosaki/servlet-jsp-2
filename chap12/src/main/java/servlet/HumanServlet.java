package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Human;

@WebServlet("/HumanServlet")
public class HumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Human> humanList = new ArrayList<>();
		Human human = new Human("湊 雄輔", 23);
		humanList.add(human);
		humanList.add(new Human("綾部 みゆき", 22));
		
		request.setAttribute("humanList", humanList);
		String path ="human.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
