package com.demo.htanswer.bean;

public class comment {
    private int CID;
    private int QID;
    private int xh;
    private String comment_time;
    private String comment_content;
    private  String comment_summary;
    private String comment_content_html;
    private int C_state;
    private String C_nickname;
    private  String C_profile_photo;
    private int like_Comment_state;
    private int like_comment_num;
    private String Q_title;
    private String c_gender;
    private String c_profession;
    private int c_bit;

    public comment() {
    }

    public comment(int CID, int QID, int xh, String comment_time, String comment_content, String comment_summary, String comment_content_html, int c_state, String c_nickname, String c_profile_photo, int like_Comment_state, int like_comment_num, String q_title, String c_gender, String c_profession, int c_bit) {
        this.CID = CID;
        this.QID = QID;
        this.xh = xh;
        this.comment_time = comment_time;
        this.comment_content = comment_content;
        this.comment_summary = comment_summary;
        this.comment_content_html = comment_content_html;
        C_state = c_state;
        C_nickname = c_nickname;
        C_profile_photo = c_profile_photo;
        this.like_Comment_state = like_Comment_state;
        this.like_comment_num = like_comment_num;
        Q_title = q_title;
        this.c_gender = c_gender;
        this.c_profession = c_profession;
        this.c_bit = c_bit;
    }

    public String getC_gender() {
        return c_gender;
    }

    public void setC_gender(String c_gender) {
        this.c_gender = c_gender;
    }

    public String getC_profession() {
        return c_profession;
    }

    public void setC_profession(String c_profession) {
        this.c_profession = c_profession;
    }

    public int getC_bit() {
        return c_bit;
    }

    public void setC_bit(int c_bit) {
        this.c_bit = c_bit;
    }

    public String getQ_title() {
        return Q_title;
    }

    public void setQ_title(String q_title) {
        Q_title = q_title;
    }

    public int getLike_Comment_state() {
        return like_Comment_state;
    }

    public int getLike_comment_num() {
        return like_comment_num;
    }

    public void setLike_comment_num(int like_comment_num) {
        this.like_comment_num = like_comment_num;
    }

    public void setLike_Comment_state(int like_Comment_state) {
        this.like_Comment_state = like_Comment_state;
    }

    public String getC_nickname() {
        return C_nickname;
    }

    public void setC_nickname(String c_nickname) {
        C_nickname = c_nickname;
    }

    public String getC_profile_photo() {
        return C_profile_photo;
    }

    public void setC_profile_photo(String c_profile_photo) {
        C_profile_photo = c_profile_photo;
    }

    public String getComment_summary() {
        return comment_summary;
    }

    public void setComment_summary(String comment_summary) {
        this.comment_summary = comment_summary;
    }

    public String getComment_content_html() {
        return comment_content_html;
    }

    public void setComment_content_html(String comment_content_html) {
        this.comment_content_html = comment_content_html;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
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

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public int getC_state() {
        return C_state;
    }

    public void setC_state(int c_state) {
        C_state = c_state;
    }

    @Override
    public String toString() {
        return "comment{" +
                "CID=" + CID +
                ", QID=" + QID +
                ", xh=" + xh +
                ", comment_time='" + comment_time + '\'' +
                ", comment_content='" + comment_content + '\'' +
                ", comment_summary='" + comment_summary + '\'' +
                ", comment_content_html='" + comment_content_html + '\'' +
                ", C_state=" + C_state +
                ", C_nickname='" + C_nickname + '\'' +
                ", C_profile_photo='" + C_profile_photo + '\'' +
                ", like_Comment_state=" + like_Comment_state +
                ", like_comment_num=" + like_comment_num +
                ", Q_title='" + Q_title + '\'' +
                ", c_gender='" + c_gender + '\'' +
                ", c_profession='" + c_profession + '\'' +
                ", c_bit=" + c_bit +
                '}';
    }
}
