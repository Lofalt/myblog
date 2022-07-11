package cn.lofalt.myblog.serviceImpl;


import cn.lofalt.myblog.dao.ArticleMapper;
import cn.lofalt.myblog.pojo.Article;
import cn.lofalt.myblog.pojo.ArticleInfo;
import cn.lofalt.myblog.service.ArticleService;
import cn.lofalt.myblog.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper am;

    @Override
    public ArticleInfo selectBothByTime(ArticleInfo article) {
        ArticleInfo ai = new ArticleInfo();
        Article pre = am.selectPreArticle(article);
        Article next = am.selectNextArticle(article);
        ai.setNext(next);
        ai.setPre(pre);
        return ai;
    }
    @Override
    public Article selectById(int id) {
        return am.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> selectByCategory(int id) {
        List<Article> list = am.selectByCategory(id);
        for (Article article : list) {
            String content = Utils.deleteHtml(article.getArticleContent()).trim();
            int index = content.length();
            if(index>100){
                index = 100;
            }
            article.setArticleContent(content.substring(0,index));
        }
        return list;
    }

    @Override
    public List<Article> selsectAll() {
        List<Article> list = am.selectAll();
        for (Article article : list) {
            String content = Utils.deleteHtml(article.getArticleContent()).trim();
            int index = content.length();
            if(index>100){
                index = 100;
            }
            article.setArticleContent(content.substring(0,index));
        }
        return list;
    }
}
