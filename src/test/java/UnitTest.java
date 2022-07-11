import cn.lofalt.myblog.pojo.Article;
import cn.lofalt.myblog.pojo.Comment;
import cn.lofalt.myblog.service.ArticleService;
import cn.lofalt.myblog.service.CommentService;
import cn.lofalt.myblog.utils.ResultInfo;
import cn.lofalt.myblog.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class UnitTest {

    @Autowired
    ArticleService as;
    @Autowired
    CommentService cs;
    @Test
    public void test3(){
        List<Article> articles = as.selsectAll();
        System.out.println(articles);
    }

    @Test
    public void test4(){
        ResultInfo resultInfo = cs.deleteByCommentId(9);
        System.out.println(resultInfo);
    }

    @Test
    public void tes5(){
        PageHelper.startPage(1,5);
        List<Article> articles = as.selsectAll();
        PageInfo<Article> listPageInfo = new PageInfo<Article>(articles);
        System.out.println(listPageInfo);

    }
}
