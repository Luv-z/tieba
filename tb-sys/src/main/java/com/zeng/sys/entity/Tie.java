package com.zeng.sys.entity;

import java.sql.Timestamp;

public class Tie {

    private long tieId;
    private String tieTopic;
    private String tieContent;
    private String creatorId;
    private Timestamp createTime;
    private long likeNum;

    public long getTieId() {
        return tieId;
    }

    public void setTieId(long tieId) {
        this.tieId = tieId;
    }

    public String getTieTopic() {
        return tieTopic;
    }

    public void setTieTopic(String tieTopic) {
        this.tieTopic = tieTopic;
    }

    public String getTieContent() {
        return tieContent;
    }

    public void setTieContent(String tieContent) {
        this.tieContent = tieContent;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(long likeNum) {
        this.likeNum = likeNum;
    }
}
