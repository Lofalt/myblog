package cn.lofalt.myblog.service;


import cn.lofalt.myblog.pojo.Comment;
import cn.lofalt.myblog.utils.ResultInfo;

import java.util.List;

public interface CommentService {

    List<Comment> selectByArticleId(int articleId);

    void addComment(Comment comment);

    ResultInfo deleteByCommentId(Integer commentId);
}
