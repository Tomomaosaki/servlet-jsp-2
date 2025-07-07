package listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class NoAppScopeListener implements ServletContextAttributeListener {

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println("変更禁止");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 

    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("追加禁止");
    }
	
}
