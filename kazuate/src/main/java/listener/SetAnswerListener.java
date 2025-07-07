package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SetAnswerListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  {
    	Integer answer = (int)(Math.random() * 100); 
    	//                new Random().nextInt(100);でも動く
    	ServletContext context = sce.getServletContext(); // ←アプリケーションスコープ呼び出し
    	context.setAttribute("answer", answer); // ←アプリケーションスコープに"answer"という名前で保存
    }	
}
