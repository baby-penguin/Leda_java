package com.demo.htanswer.bean;

public class follow {
    private int QID;
    private int xh;
    private String follow_time;
    private int f_state;
    private int[] followQIDList;//该学号关注的所有问题qid

    public follow() {
    }

    public follow(int QID, int xh, String follow_time, int f_state) {
        this.QID = QID;
        this.xh = xh;
        this.follow_time = follow_time;
        this.f_state = f_state;
    }

    public int[] getFollowQIDList() {
        return followQIDList;
    }

    public void setFollowQIDList(int[] followQIDList) {
        this.followQIDList = followQIDList;
    }

    public int getQID() {
        return QID;
    }

    public void setQID(int QID) {
        this.QID = QID;
    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getFollow_time() {
        return follow_time;
    }

    public void setFollow_time(String follow_time) {
        this.follow_time = follow_time;
    }

    public int getF_state() {
        return f_state;
    }

    public void setF_state(int f_state) {
        this.f_state = f_state;
    }

    @Override
    public String toString() {
        return "follow{" +
                "QID=" + QID +
                ", xh=" + xh +
                ", follow_time='" + follow_time + '\'' +
                ", f_state=" + f_state +
                '}';
    }
}
