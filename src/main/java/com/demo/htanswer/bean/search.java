package com.demo.htanswer.bean;

public class search {
    int id;
    String search;
    String search_time;

    public void setId(int id) {
        this.id = id;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setSearch_time(String search_time) {
        this.search_time = search_time;
    }

    public int getId() {
        return id;
    }

    public String getSearch() {
        return search;
    }

    public String getSearch_time() {
        return search_time;
    }

    public search(int id, String search, String search_time) {
        this.id = id;
        this.search = search;
        this.search_time = search_time;
    }

    public search() {
    }
}
