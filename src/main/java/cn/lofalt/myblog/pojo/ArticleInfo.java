package cn.lofalt.myblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ArticleInfo {
    private int categoryId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date articleCreateTime;
    private Article next;
    private Article pre;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "next=" + next +
                ", pre=" + pre +
                '}';
    }

    public Article getNext() {
        return next;
    }

    public void setNext(Article next) {
        this.next = next;
    }

    public Article getPre() {
        return pre;
    }

    public void setPre(Article pre) {
        this.pre = pre;
    }
}
