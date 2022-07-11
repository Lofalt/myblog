package cn.lofalt.myblog.pojotmp;

import java.util.Date;

public class Article {
    private Integer articleId;

    private String articleTitle;

    private Date articleCreateTime;

    private Date articleLastModTime;

    private Integer articleReadTimes;

    private Integer articleLoveTimes;

    private Integer articleShareTimes;

    private Boolean isActive;

    private String articleContent;

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