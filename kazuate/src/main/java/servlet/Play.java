package servlet;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/play")
public class Play extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String retry = request.getParameter("retry");
		if (retry != null && retry.equals("yes")) { // ←input.jsp「別の数字でもう一度する」のリンク先がnullじゃない＆"yes"のとき
			ServletContext application = this.getServletContext();
			Integer answer = (int)(Math.random() * 100);
			application.setAttribute("answer", answer); // ←アプリケーションスコープに"answer"という名前で保存
		}
		String path = "WEB-INF/jsp/input.jsp";
		request.getRequestDispatcher(path).forward(request, response); // ←input.jspへフォワード
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int num = Integer.parseInt(request.getParameter("num"));
		ServletContext application = this.getServletContext(); // ←アプリケーションスコープから取り出し
		int answer = (Integer)application.getAttribute("answer"); // ←アプリケーションスコープから取り出し（オートボクシング）

		String msg = "";
		if (num == answer) {
			msg = "当たりです";
		} else if (num > answer) {
			msg = "大きすぎます";
		} else {
			msg = "小さすぎます";
		}
		
		request.setAttribute("msg", msg); // リクエストスコープにインスタンスを保存
		String path = "WEB-INF/jsp/input.jsp";
		request.getRequestDispatcher(path).forward(request, response); // ←input.jspへフォワード
	}

}
