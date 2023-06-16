package com.demo.htanswer.bean;

public class Accuse {
    //    @Id
    private int accusexh;
    private int accusedxh;
    //    @Id
    private String time;
    private String meg;
    private String img;
    private String state;

    public void setAccusexh(int accusexh) {
        this.accusexh = accusexh;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setAccusedxh(int accusedxh) {
        this.accusedxh = accusedxh;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMeg(String meg) {
        this.meg = meg;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAccusexh() {
        return accusexh;
    }

    public int getAccusedxh() {
        return accusedxh;
    }

    public String getTime() {
        return time;
    }

    public String getMeg() {
        return meg;
    }

    public String getState() {
        return state;
    }

    public Accuse() {
    }

    public Accuse(int accusexh, int accusedxh, String time, String meg, String state,String img) {
        this.accusexh = accusexh;
        this.accusedxh = accusedxh;
        this.time = time;
        this.meg = meg;
        this.state = state;
        this.img=img;
    }
}
