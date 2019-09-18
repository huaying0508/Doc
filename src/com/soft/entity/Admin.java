package com.soft.entity;

public class Admin {

    private int adno;
    private String adname;
    private String adpwd;

    public Admin(int adno, String adname, String adpwd) {
        this.adno = adno;
        this.adname = adname;
        this.adpwd = adpwd;
    }

    public Admin(String adname, String adpwd) {
        this.adname = adname;
        this.adpwd = adpwd;
    }

    public Admin() {
    }

    public int getAdno() {
        return adno;
    }

    public void setAdno(int adno) {
        this.adno = adno;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getAdpwd() {
        return adpwd;
    }

    public void setAdpwd(String adpwd) {
        this.adpwd = adpwd;
    }
}
