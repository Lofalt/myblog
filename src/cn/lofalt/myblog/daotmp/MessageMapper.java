package cn.lofalt.myblog.daotmp;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    Message selectByPrimaryKey(Integer messageId);

    List<Message> selectAll();

    int updateByPrimaryKey(Message record);
}