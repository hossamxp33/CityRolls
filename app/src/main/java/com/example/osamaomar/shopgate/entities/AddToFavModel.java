package com.example.osamaomar.shopgate.entities;

public class AddToFavModel {


    /**
     * favid : 30
     * pid : 0
     */

    private int favid;
    private String pid;

    public int getFavid() {
        return favid;
    }

    public void setFavid(int favid) {
        this.favid = favid;
    }

    public int getPid() {
        return Integer.parseInt(pid);
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
