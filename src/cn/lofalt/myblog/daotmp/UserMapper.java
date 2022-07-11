package cn.lofalt.myblog.daotmp;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}