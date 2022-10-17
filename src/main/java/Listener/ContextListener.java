package Listener;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
    String realPath =  context.getRealPath("");
    int index = realPath.lastIndexOf("target");
    String root = null;
     if (index > 0){
     root = realPath.substring(0, index - 1);
     }
        context.setAttribute("root",root);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
