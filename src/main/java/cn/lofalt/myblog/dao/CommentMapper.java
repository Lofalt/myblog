package cn.lofalt.myblog.dao;

import cn.lofalt.myblog.pojo.Comment;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByArticleId(int articleId);

    Comment selectByParentId(int parentId);
}