package com.demo.htanswer.bean;
/*
 * 用户实体
 * */
public class User {
    private int xh;//学号
    private String password;//密码
    private String nickname;//昵称
    private String profile_photo;//头像
    private String gender;//性别
    private String profession;//专业
    private int bit;
    private String lastTime;
    private int U_state;

    public User(){
    }

    public User(int xh, String nickname,String password, String gender, String profile_photo,  String profession, int bit, String lastTime, int u_state) {
        this.xh = xh;
        this.password=password;
        this.nickname = nickname;
        this.profile_photo = profile_photo;
        this.gender = gender;
        this.profession = profession;
        this.bit = bit;
        this.lastTime = lastTime;
        U_state = u_state;
    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public String getlastTime() {
        return lastTime;
    }

    public void setlastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public int getU_state() {
        return U_state;
    }

    public void setU_state(int u_state) {
        U_state = u_state;
    }

    @Override
    public String toString() {
        return "User{" +
                "xh=" + xh +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profile_photo='" + profile_photo + '\'' +
                ", gender='" + gender + '\'' +
                ", profession='" + profession + '\'' +
                ", bit=" + bit +
                ", lastTime='" + lastTime + '\'' +
                ", U_state=" + U_state +
                '}';
    }
}
