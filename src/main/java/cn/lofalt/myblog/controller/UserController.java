package cn.lofalt.myblog.controller;

import cn.lofalt.myblog.pojo.Token;
import cn.lofalt.myblog.pojo.User;
import cn.lofalt.myblog.service.UserService;
import cn.lofalt.myblog.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addUser(User user, HttpSession hs){
        ResultInfo ri = new ResultInfo();
        ServletContext sc = hs.getServletContext();
        Map<String,Integer> tokenMap = (Map<String, Integer>) sc.getAttribute("tokenMap");
        Map<Integer, Token> tokens = (Map<Integer,Token>)sc.getAttribute("tokens");
        String token = UUID.randomUUID().toString();

        try {
            us.addUser(user);
            ri.setMessage("success!");
            ri.setSuccess(true);
            ri.setToken(token);
            Token t = new Token();
            t.setUserId(user.getUserId());
            t.setUserName(user.getUserName());
            t.setUserPassword(user.getUserPassword());
            t.setTokenTime(new Date());
            t.setUser(user);
            tokenMap.put(token,user.getUserId());
            tokens.put(user.getUserId(),t);
            return ri;
        }catch(Exception e){
            e.printStackTrace();
            ri.setMessage("failed!");
            ri.setSuccess(false);
            return ri;
        }
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo checkUserName(User user){
        ResultInfo ri = new ResultInfo();
        try{
            us.checkUserName(user);
            ri.setSuccess(true);
            return ri;
        }
        catch(Exception e){
            ri.setSuccess(false);
            ri.setMessage("用户名已被注册!");
            return ri;
        }
    }

    @RequestMapping(value="/tokenValid",method = RequestMethod.GET)
    @ResponseBody
    public Token tokenValid(@RequestParam("token")String token){
        try {
            return us.validToken(token);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new Token();
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo login(User user){

        return us.login(user);
    }

}
