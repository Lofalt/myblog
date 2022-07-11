package cn.lofalt.myblog.pojo;

import java.util.Date;

public class SinglePage {
    private Integer singlePageId;

    private String singlePageName;

    private Date singlePageCreateTime;

    private Date singlePageLastModTime;

    private String singlePageContent;

    public Integer getSinglePageId() {
        return singlePageId;
    }

    public void setSinglePageId(Integer singlePageId) {
        this.singlePageId = singlePageId;
    }

    public String getSinglePageName() {
        return singlePageName;
    }

    public void setSinglePageName(String singlePageName) {
        this.singlePageName = singlePageName == null ? null : singlePageName.trim();
    }

    public Date getSinglePageCreateTime() {
        return singlePageCreateTime;
    }

    public void setSinglePageCreateTime(Date singlePageCreateTime) {
        this.singlePageCreateTime = singlePageCreateTime;
    }

    public Date getSinglePageLastModTime() {
        return singlePageLastModTime;
    }

    public void setSinglePageLastModTime(Date singlePageLastModTime) {
        this.singlePageLastModTime = singlePageLastModTime;
    }

    public String getSinglePageContent() {
        return singlePageContent;
    }

    public void setSinglePageContent(String singlePageContent) {
        this.singlePageContent = singlePageContent == null ? null : singlePageContent.trim();
    }
}