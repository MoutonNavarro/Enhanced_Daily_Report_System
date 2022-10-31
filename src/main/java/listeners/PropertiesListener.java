package listeners;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PropertiesListener implements ServletContextListener {

   public PropertiesListener() {
   }

   /**
    * Run process when shut downing the web application
    */
   public void contextDestroyed(ServletContextEvent arg0) {
   }

   /**
    * Run process when beginning the web application
    */
   public void contextInitialized(ServletContextEvent arg0) {
      ServletContext context = arg0.getServletContext();

      //Read property file and set it at the application scope
      try {
         InputStream is = PropertiesListener.class.getClassLoader().getResourceAsStream("application.properties");

         Properties properties = new Properties();
         properties.load(is);
         is.close();

         Iterator<String> pit = properties.stringPropertyNames().iterator();
         while(pit.hasNext()) {
            String pname = pit.next();
            context.setAttribute(pname,  properties.getProperty(pname));
         }
      }catch (NullPointerException e){
         e.printStackTrace();
      }catch (FileNotFoundException e) {
         e.printStackTrace();
      }catch (IOException e) {
         e.printStackTrace();
      }
   }

}
