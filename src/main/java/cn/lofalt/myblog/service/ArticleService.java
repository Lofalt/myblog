package cn.lofalt.myblog.service;

import cn.lofalt.myblog.pojo.Article;
import cn.lofalt.myblog.pojo.ArticleInfo;

import java.util.List;

public interface ArticleService {

    List<Article> selsectAll();

    List<Article> selectByCategory(int id);

    Article selectById(int id);

    ArticleInfo selectBothByTime(ArticleInfo article);
}
