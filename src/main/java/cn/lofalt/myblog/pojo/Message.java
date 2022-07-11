package cn.lofalt.myblog.pojo;

import java.util.Date;

public class Message {
    private Integer messageId;

    private String messageContent;

    private Date messageCreateTime;

    private Integer messageParentId;

    private String messageUserName;

    private Integer messageUserId;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public Date getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Date messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public Integer getMessageParentId() {
        return messageParentId;
    }

    public void setMessageParentId(Integer messageParentId) {
        this.messageParentId = messageParentId;
    }

    public String getMessageUserName() {
        return messageUserName;
    }

    public void setMessageUserName(String messageUserName) {
        this.messageUserName = messageUserName == null ? null : messageUserName.trim();
    }

    public Integer getMessageUserId() {
        return messageUserId;
    }

    public void setMessageUserId(Integer messageUserId) {
        this.messageUserId = messageUserId;
    }
}