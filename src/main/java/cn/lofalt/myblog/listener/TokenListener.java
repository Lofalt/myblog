package cn.lofalt.myblog.listener;

import cn.lofalt.myblog.pojo.Token;
import cn.lofalt.myblog.utils.Utils;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@WebListener()
public class TokenListener extends ContextLoaderListener implements ServletContextListener{



    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        try {
//            InputStream tokens = new FileInputStream("E:\\myblog\\maps");
            InputStream tokens = new FileInputStream("/blog/maps");
//            InputStream tokenS = new FileInputStream("E:\\myblog\\tokens");
            InputStream tokenS = new FileInputStream("/blog/tokens");
            ObjectInputStream ois = new ObjectInputStream(tokens);
            ObjectInputStream ois2 = new ObjectInputStream(tokenS);
            Map<String,Integer> tokenMap = (Map<String, Integer>) ois.readObject();
            Map<Integer, Token> tokenX = (Map<Integer, Token>) ois2.readObject();
            sce.getServletContext().setAttribute(Utils.TOKEN_MAP,tokenMap);
            sce.getServletContext().setAttribute(Utils.TOKENS,tokenX);
            ois.close();
            ois2.close();
            tokens.close();
            tokenS.close();
        } catch (Exception e) {
            Map<Integer,String> tokenMap = new HashMap<>();
            Map<String,Token> tokens = new HashMap<>();
            sce.getServletContext().setAttribute(Utils.TOKEN_MAP,tokenMap);
            sce.getServletContext().setAttribute(Utils.TOKENS,tokens);
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        super.contextDestroyed(sce);
        ServletContext servletContext = sce.getServletContext();
        Object tokenMap = servletContext.getAttribute(Utils.TOKEN_MAP);
        Object tokens = servletContext.getAttribute(Utils.TOKENS);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/blog/maps"));
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\myblog\\maps"));
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("/blog/tokens"));
//            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("E:\\myblog\\tokens"));
            oos2.writeObject(tokens);
            oos.writeUnshared(tokenMap);
            oos.close();
            oos2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
