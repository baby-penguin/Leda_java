package com.demo.htanswer.bean;

import java.util.Arrays;
import java.util.Comparator;

public class question implements Comparator<question> {
    private int QID;
    private int Q_xh;
    private String Q_nickname;
    private  String Q_profile_photo;
    private String Q_title;
    private String Q_content;
    private String Q_time;
    private int Q_tag;
    private int Reward_points;
    private int Q_state;
    private String Q_content_html;
    private int[] dynamicTags;
    private String Q_summary;
    private String Q_editTime;
    private int Follow_num;
    private int Comment_num;
    private int follow_state;
    private int hot_level;
    //问题所有带有的标签被浏览次数的总和
    //根据此值做推荐但是在实际调用的时候
    //因为重写接口的是hot_level
    //就只用hot_level
    private int browse_tag_total;

    public question(){

    }

    public question(int QID, int q_xh, String q_nickname, String q_profile_photo, String q_title, String q_content, String q_time, int q_tag, int reward_points, int q_state, String q_content_html, int[] dynamicTags, String q_summary, String q_editTime, int follow_num, int comment_num, int follow_state, int hot_level, int browse_tag_total) {
        this.QID = QID;
        Q_xh = q_xh;
        Q_nickname = q_nickname;
        Q_profile_photo = q_profile_photo;
        Q_title = q_title;
        Q_content = q_content;
        Q_time = q_time;
        Q_tag = q_tag;
        Reward_points = reward_points;
        Q_state = q_state;
        Q_content_html = q_content_html;
        this.dynamicTags = dynamicTags;
        Q_summary = q_summary;
        Q_editTime = q_editTime;
        Follow_num = follow_num;
        Comment_num = comment_num;
        this.follow_state = follow_state;
        this.hot_level = hot_level;
        this.browse_tag_total = browse_tag_total;
    }

    public int getBrowse_tag_total() {
        return browse_tag_total;
    }

    public void setBrowse_tag_total(int browse_tag_total) {
        this.browse_tag_total = browse_tag_total;
    }

    public int getFollow_num() {
        return Follow_num;
    }

    public void setFollow_num(int follow_num) {
        Follow_num = follow_num;
    }

    public int getHot_level() {
        return hot_level;
    }

    public void setHot_level(int hot_level) {
        this.hot_level = hot_level;
    }

    public int getComment_num() {
        return Comment_num;
    }

    public void setComment_num(int comment_num) {
        Comment_num = comment_num;
    }

    public String getQ_summary() {
        return Q_summary;
    }

    public void setQ_summary(String q_summary) {
        Q_summary = q_summary;
    }

    public String getQ_editTime() {
        return Q_editTime;
    }

    public void setQ_editTime(String q_editTime) {
        Q_editTime = q_editTime;
    }

    public String getQ_nickname() {
        return Q_nickname;
    }

    public void setQ_nickname(String q_nickname) {
        Q_nickname = q_nickname;
    }

    public String getQ_profile_photo() {
        return Q_profile_photo;
    }

    public void setQ_profile_photo(String q_profile_photo) {
        Q_profile_photo = q_profile_photo;
    }

    public int[] getDynamicTags() {
        return dynamicTags;
    }

    public void setDynamicTags(int[] dynamicTags) {
        this.dynamicTags = dynamicTags;
    }

    public int getQID() {
        return QID;
    }

    public void setQID(int QID) {
        this.QID = QID;
    }

    public int getQ_xh() {
        return Q_xh;
    }

    public void setQ_xh(int q_xh) {
        Q_xh = q_xh;
    }

    public String getQ_title() {
        return Q_title;
    }

    public void setQ_title(String q_title) {
        Q_title = q_title;
    }

    public String getQ_content() {
        return Q_content;
    }

    public void setQ_content(String q_content) {
        Q_content = q_content;
    }


    public String getQ_time() {
        return Q_time;
    }

    public void setQ_time(String q_time) {
        Q_time = q_time;
    }

    public int getQ_tag() {
        return Q_tag;
    }

    public void setQ_tag(int q_tag) {
        Q_tag = q_tag;
    }

    public int getReward_points() {
        return Reward_points;
    }

    public void setReward_points(int reward_points) {
        Reward_points = reward_points;
    }

    public int getQ_state() {
        return Q_state;
    }

    public void setQ_state(int q_state) {
        Q_state = q_state;
    }

    public String getQ_content_html() {
        return Q_content_html;
    }

    public void setQ_content_html(String q_content_html) {
        Q_content_html = q_content_html;
    }

    public int getFollow_state() {
        return follow_state;
    }

    public void setFollow_state(int follow_state) {
        this.follow_state = follow_state;
    }

    @Override
    public String toString() {
        return "question{" +
                "QID=" + QID +
                ", Q_xh=" + Q_xh +
                ", Q_nickname='" + Q_nickname + '\'' +
                ", Q_profile_photo='" + Q_profile_photo + '\'' +
                ", Q_title='" + Q_title + '\'' +
                ", Q_content='" + Q_content + '\'' +
                ", Q_time='" + Q_time + '\'' +
                ", Q_tag=" + Q_tag +
                ", Reward_points=" + Reward_points +
                ", Q_state=" + Q_state +
                ", Q_content_html='" + Q_content_html + '\'' +
                ", dynamicTags=" + Arrays.toString(dynamicTags) +
                ", Q_summary='" + Q_summary + '\'' +
                ", Q_editTime='" + Q_editTime + '\'' +
                ", Follow_num=" + Follow_num +
                ", Comment_num=" + Comment_num +
                ", follow_state=" + follow_state +
                ", hot_level=" + hot_level +
                ", browse_tag_total=" + browse_tag_total +
                '}';
    }

    @Override
    public int compare(question o1, question o2) {
        //return o1.getAge() - o2.getAge();//升序
        return o2.getHot_level()- o1.getHot_level();//降序
    }

}
