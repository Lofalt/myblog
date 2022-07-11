package cn.lofalt.myblog.controller;

import cn.lofalt.myblog.pojo.Article;
import cn.lofalt.myblog.pojo.ArticleInfo;
import cn.lofalt.myblog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService as;


    @RequestMapping("/article/{id}")
    @ResponseBody
    public PageInfo<List<Article>> select(@PathVariable("id") String id, @RequestParam("currentPage") int currentPage){
        PageHelper.startPage(currentPage,5);
        if(id.equals("all")){
            return new PageInfo(as.selsectAll());
        }else{
            return new PageInfo(as.selectByCategory(Integer.parseInt(id)));
        }
    }

    @RequestMapping("/archive/{id}")
    @ResponseBody
    public Article selectById(@PathVariable int id){
        return as.selectById(id);
    }

    @RequestMapping("/archive/preAndNext")
    @ResponseBody
    public ArticleInfo selectByTime(ArticleInfo article){
        return as.selectBothByTime(article);
    }


}
