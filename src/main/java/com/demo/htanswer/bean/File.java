package com.demo.htanswer.bean;


//文件类
public class File {
    int id;
    int xh;
    String nickname;
    String file_name;
    String file_src;
    String time;
    int upload;

    public void setUpload(int upload) {
        this.upload = upload;
    }

    public int getUpload() {
        return upload;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public File(int id, int xh, String file_name, String file_src, String time, int upload, String nickname) {
        this.id = id;
        this.xh = xh;
        this.file_name = file_name;
        this.file_src = file_src;
        this.time = time;
        this.upload=upload;
        this.nickname=nickname;
    }

    public File() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setFile_src(String file_src) {
        this.file_src = file_src;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getXh() {
        return xh;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getFile_src() {
        return file_src;
    }

    public String getTime() {
        return time;
    }
}
