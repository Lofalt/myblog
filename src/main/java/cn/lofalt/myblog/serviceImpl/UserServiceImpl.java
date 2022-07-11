package cn.lofalt.myblog.serviceImpl;

import cn.lofalt.myblog.dao.UserMapper;
import cn.lofalt.myblog.pojo.Token;
import cn.lofalt.myblog.pojo.User;
import cn.lofalt.myblog.service.UserService;
import cn.lofalt.myblog.utils.CustomException;
import cn.lofalt.myblog.utils.HttpRequestHelper;
import cn.lofalt.myblog.utils.ResultInfo;
import cn.lofalt.myblog.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;

    @Override
    public void addUser(User user) {
        user.setAdmin(false);
        user.setUserIntegral(0);
        user.setUserRegistTime(new Date());
        try{
            um.insert(user);
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public void checkUserName(User user) {
        User user1 = um.selectByUser(user);
        if(user1!=null){
            throw new CustomException("用户名已被注册");
        }
    }

    @Override
    public Token validToken(String token) {
        HttpServletRequest req = HttpRequestHelper.getReq();
        ServletContext servletContext = req.getServletContext();
        Map<String,Integer> tokenMap = (Map<String, Integer>) servletContext.getAttribute(Utils.TOKEN_MAP);
        Map<Integer,Token> tokens = (Map<Integer, Token>) servletContext.getAttribute(Utils.TOKENS);
        Integer userId = tokenMap.get(token);

        if(userId==null){
            throw new CustomException("该token无效");
        }
        Token userToken = tokens.get(userId);
        if((new Date().getTime() - userToken.getTokenTime().getTime())> 2592000000L){
            tokenMap.remove(token);
            throw new CustomException("该token已过期");
        }
        return userToken;
    }

    @Override
    public ResultInfo login(User user) {
        ResultInfo resultInfo = new ResultInfo();
        try {
        User user1 = um.selectByUser(user);
            if(user1==null){
                resultInfo.setSuccess(false);
                resultInfo.setMessage("找不到用户名");
                return resultInfo;
            }else{
                if(!user.getUserPassword().equals(user1.getUserPassword())){
                    resultInfo.setMessage("密码错误");
                    resultInfo.setSuccess(false);
                    return resultInfo;
                }
            }
            String token = UUID.randomUUID().toString();
            ServletContext servletContext = HttpRequestHelper.getReq().getServletContext();
            Token tokenS = new Token();
            tokenS.setTokenTime(new Date());
            tokenS.setUserPassword(user1.getUserPassword());
            tokenS.setUserName(user1.getUserName());
            tokenS.setUserId(user1.getUserId());
            tokenS.setUser(user1);
            Map<Integer,Token> tokens = (Map<Integer, Token>) servletContext.getAttribute(Utils.TOKENS);
            Map<String,Integer> tokenMap = (Map<String, Integer>) servletContext.getAttribute(Utils.TOKEN_MAP);
            tokens.put(user1.getUserId(),tokenS);
            tokenMap.put(token,user1.getUserId());
            resultInfo.setSuccess(true);
            resultInfo.setMessage("登陆成功,马上为你跳转");
            resultInfo.setToken(token);
            return resultInfo;
        } catch (Exception e){
            resultInfo.setMessage("登陆失败,请联系管理员");
            return resultInfo;
        }
    }
}
