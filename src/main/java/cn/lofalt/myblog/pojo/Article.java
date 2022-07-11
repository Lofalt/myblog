package cn.lofalt.myblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article {
    private Integer articleId;

    private String articleTitle;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date articleCreateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date articleLastModTime;

    private Integer articleReadTimes;

    private Integer articleLoveTimes;

    private Integer articleShareTimes;

    private Boolean isActive;

    private String articleContent;

    private String articleSummary;

    private List<Category> articleCategories = new ArrayList<>();

    private List<Comment> articleComments = new ArrayList<>();

    private List<Tag> articleTags = new ArrayList<>();


    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleCreateTime=" + articleCreateTime +
                ", articleLastModTime=" + articleLastModTime +
                ", articleReadTimes=" + articleReadTimes +
                ", articleLoveTimes=" + articleLoveTimes +
                ", articleShareTimes=" + articleShareTimes +
                ", isActive=" + isActive +
                ", articleContent='" + articleContent + '\'' +
                ", articleSummary='" + articleSummary + '\'' +
                ", articleCategories=" + articleCategories +
                ", articleComments=" + articleComments +
                ", articleTags=" + articleTags +
                '}';
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Category> getArticleCategories() {
        return articleCategories;
    }

    public void setArticleCategories(List<Category> articleCategories) {
        this.articleCategories = articleCategories;
    }

    public List<Comment> getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(List<Comment> articleComments) {
        this.articleComments = articleComments;
    }

    public List<Tag> getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(List<Tag> articleTags) {
        this.articleTags = articleTags;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public Date getArticleLastModTime() {
        return articleLastModTime;
    }

    public void setArticleLastModTime(Date articleLastModTime) {
        this.articleLastModTime = articleLastModTime;
    }

    public Integer getArticleReadTimes() {
        return articleReadTimes;
    }

    public void setArticleReadTimes(Integer articleReadTimes) {
        this.articleReadTimes = articleReadTimes;
    }

    public Integer getArticleLoveTimes() {
        return articleLoveTimes;
    }

    public void setArticleLoveTimes(Integer articleLoveTimes) {
        this.articleLoveTimes = articleLoveTimes;
    }

    public Integer getArticleShareTimes() {
        return articleShareTimes;
    }

    public void setArticleShareTimes(Integer articleShareTimes) {
        this.articleShareTimes = articleShareTimes;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}