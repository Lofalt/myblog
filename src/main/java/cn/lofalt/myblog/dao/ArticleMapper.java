package cn.lofalt.myblog.dao;

import cn.lofalt.myblog.pojo.Article;
import cn.lofalt.myblog.pojo.ArticleInfo;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    Article selectByPrimaryKey(Integer articleId);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    List<Article> selectByCategory(int id);

    Article selectNextArticle(ArticleInfo article);

    Article selectPreArticle(ArticleInfo article);
}