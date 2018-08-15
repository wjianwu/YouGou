package darian.entity;

import java.util.Date;

public class TopicState {
    private Integer id;

    private Integer topicid;

    private Integer statetypeid;

    private Date createOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public Integer getStatetypeid() {
        return statetypeid;
    }

    public void setStatetypeid(Integer statetypeid) {
        this.statetypeid = statetypeid;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }
}