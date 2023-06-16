package com.demo.htanswer.bean;

public class Tag {
    private int TID;
    private String tag_name;
    private int T_state;

    private int browse_count;

    public Tag() {
    }

    public Tag(int TID, String tag_name, int t_state, int browse_count) {
        this.TID = TID;
        this.tag_name = tag_name;
        T_state = t_state;
        this.browse_count = browse_count;
    }

    public int getBrowse_count() {
        return browse_count;
    }

    public void setBrowse_count(int browse_count) {
        this.browse_count = browse_count;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getT_state() {
        return T_state;
    }

    public void setT_state(int t_state) {
        T_state = t_state;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "TID=" + TID +
                ", tag_name='" + tag_name + '\'' +
                ", T_state=" + T_state +
                ", browse_count=" + browse_count +
                '}';
    }
}
