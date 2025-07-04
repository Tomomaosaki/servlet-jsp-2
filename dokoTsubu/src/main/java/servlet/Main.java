package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked") // ←チェックしません（警告を無視します）という意味
		// ↓mutterListを取得しに行っている
		List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
		
		if (mutterList == null) { // ←mutterListがnullならば新規作成↓
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}
		
		HttpSession session = request.getSession();
		// ↓セッションスコープからloginUser（ユーザーインスタンス）を取得
		User loginUser = (User)session.getAttribute("loginUser");
		if (loginUser == null) { // ←loginUserがnullならばindex.jspにリダイレクト↓
			response.sendRedirect("index.jsp");
			return; // ←処理終わり（elseがなくても大丈夫）returnがなければ下に処理が続いてしまう
		}
		
		String path = "WEB-INF/jsp/main.jsp";
		RequestDispatcher d = request.getRequestDispatcher(path);
		d.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		if (text != null && text.length() != 0) {
			ServletContext application = this.getServletContext();
			@SuppressWarnings("unchecked") // 改行されているけど本当は←と↓で一行で書かれている
			List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
			
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter, mutterList);
			// ↓これがなくても大丈夫
			// application.setAttribute("mutterList", mutterList);
		} else {
			request.setAttribute("errorMsg",  "つぶやきが入力されていません");
		}
		
		String path ="WEB-INF/jsp/main.jsp";
		RequestDispatcher d = request.getRequestDispatcher(path);
		d.forward(request, response);
	}
}
