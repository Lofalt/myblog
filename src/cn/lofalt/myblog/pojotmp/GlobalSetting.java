package cn.lofalt.myblog.pojotmp;

public class GlobalSetting {
    private Integer settingId;

    private String backgroundImg;

    private String notice;

    private String topBarBackgroundImg;

    private String topicColor;

    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg == null ? null : backgroundImg.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getTopBarBackgroundImg() {
        return topBarBackgroundImg;
    }

    public void setTopBarBackgroundImg(String topBarBackgroundImg) {
        this.topBarBackgroundImg = topBarBackgroundImg == null ? null : topBarBackgroundImg.trim();
    }

    public String getTopicColor() {
        return topicColor;
    }

    public void setTopicColor(String topicColor) {
        this.topicColor = topicColor == null ? null : topicColor.trim();
    }
}