package darian.entity;

import java.util.Date;

public class Reply {
    private Integer id;

    private Integer commentId;

    private Integer userReply;

    private String userReplyName;

    private String userReplyImg;

    private Integer userTo;

    private String userToName;

    private String userToImg;

    private String content;

    private Date createOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserReply() {
        return userReply;
    }

    public void setUserReply(Integer userReply) {
        this.userReply = userReply;
    }

    public String getUserReplyName() {
        return userReplyName;
    }

    public void setUserReplyName(String userReplyName) {
        this.userReplyName = userReplyName == null ? null : userReplyName.trim();
    }

    public String getUserReplyImg() {
        return userReplyImg;
    }

    public void setUserReplyImg(String userReplyImg) {
        this.userReplyImg = userReplyImg == null ? null : userReplyImg.trim();
    }

    public Integer getUserTo() {
        return userTo;
    }

    public void setUserTo(Integer userTo) {
        this.userTo = userTo;
    }

    public String getUserToName() {
        return userToName;
    }

    public void setUserToName(String userToName) {
        this.userToName = userToName == null ? null : userToName.trim();
    }

    public String getUserToImg() {
        return userToImg;
    }

    public void setUserToImg(String userToImg) {
        this.userToImg = userToImg == null ? null : userToImg.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }
}