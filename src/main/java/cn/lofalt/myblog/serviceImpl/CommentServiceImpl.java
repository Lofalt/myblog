package cn.lofalt.myblog.serviceImpl;


import cn.lofalt.myblog.dao.CommentMapper;
import cn.lofalt.myblog.pojo.Comment;
import cn.lofalt.myblog.service.CommentService;
import cn.lofalt.myblog.utils.CustomException;
import cn.lofalt.myblog.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper cm;

    @Override
    public void addComment(Comment comment) {
        comment.setCommentCreateTime(new Date());
        try {
            cm.insert(comment);
        }catch(Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public ResultInfo deleteByCommentId(Integer commentId) {
        ResultInfo  ri =new ResultInfo();
        try{
            cm.deleteByPrimaryKey(commentId);
            ri.setSuccess(true);
            return ri;
        }catch(Exception e){
            ri.setMessage(e.getMessage());
            return ri;
        }
    }

    @Override
    public List<Comment> selectByArticleId(int articleId) {
        return cm.selectByArticleId(articleId);
    }
}
