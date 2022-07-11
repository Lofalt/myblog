package cn.lofalt.myblog.controller;


import cn.lofalt.myblog.pojo.Comment;
import cn.lofalt.myblog.service.CommentService;
import cn.lofalt.myblog.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.plugin.com.event.COMEventHandler;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService cs;

    @RequestMapping("/comment/{articleId}")
    @ResponseBody
    public List<Comment> selectByArticleId(@PathVariable("articleId") int articleId){
        return cs.selectByArticleId(articleId);
    }

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addComment(Comment comment){
        ResultInfo ri = new ResultInfo();
        System.out.println(comment);
        try{
            cs.addComment(comment);
            ri.setSuccess(true);
            ri.setMessage("ok");
            return ri;
        }catch(Exception e) {
            ri.setSuccess(false);
            ri.setMessage(e.getMessage());
            e.printStackTrace();
            return ri;
        }
    }

    @RequestMapping(value = "/comment",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultInfo deleteComment(@RequestParam("commentId") Integer commentId){
            return cs.deleteByCommentId(commentId);
    }
}
