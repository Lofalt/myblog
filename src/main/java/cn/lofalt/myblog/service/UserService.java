package cn.lofalt.myblog.service;

import cn.lofalt.myblog.pojo.Token;
import cn.lofalt.myblog.pojo.User;
import cn.lofalt.myblog.utils.ResultInfo;

public interface UserService {

    void addUser(User user);

    void checkUserName(User user);

    Token validToken(String token);

    ResultInfo login(User user);
}
