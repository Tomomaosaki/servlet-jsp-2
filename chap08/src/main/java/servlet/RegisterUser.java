package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = null;
		if (action == null) {
			path = "WEB-INF/jsp/registerForm.jsp";
		} else if (action.equals("done")) {
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			
			// ↓不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerUser");
			// ↓確認のためコンソールに表示
			System.out.println("セッションスコープから削除しました");
			
			path = "WEB-INF/jsp/registerDone.jsp";
		}
		
		RequestDispatcher d = request.getRequestDispatcher(path);
		d.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		User registerUser = new User(id, pass, name);
		
		// ↓セッションスコープに登録ユーザーを保存
		// ↓doPost内で消える
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		// ↓フォワード
		String path = "WEB-INF/jsp/registerConfirm.jsp";
		RequestDispatcher d = request.getRequestDispatcher(path);
		d.forward(request, response);
		}

}
