package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PathFilter extends HttpFilter {

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String path = request.getServletPath();
		if (path.equals("/")) { // リンク先（http://localhost:8080/chap11の後）が/だけなら↓へリンク
			String url = "WEB-INF/jsp/form.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			return; // ←ここで処理は終わり
		}
		chain.doFilter(request, response);
	}
}
