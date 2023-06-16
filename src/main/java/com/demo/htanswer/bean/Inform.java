package com.demo.htanswer.bean;

public class Inform {
    private int xh;
    private String meg;
    private String time;
    private boolean read;

    public int getXh() {
        return xh;
    }

    public String getMeg() {
        return meg;
    }

    public String getTime() {
        return time;
    }

    public boolean isRead() {
        return read;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public void setMeg(String meg) {
        this.meg = meg;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Inform() {
    }

    public Inform(int xh, String meg, String time, boolean read) {
        this.xh = xh;
        this.meg = meg;
        this.time = time;
        this.read = read;
    }
}
