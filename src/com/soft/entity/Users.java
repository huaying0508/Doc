package com.soft.entity;

public class Users {

    private int userno;
    private String uname;
    private String username;
    private String upwd;
    private String usex;
    private int eduno;
    private int posno;
    private long utel;
    private String uemail;
    private String uresdate;
    private int stno;
    private int intecount;


    public Users(int userno, String uname, String upwd, String usex, int eduno, int posno, long utel, String uemail, String uresdate, int stno) {
        this.userno = userno;
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.eduno = eduno;
        this.posno = posno;
        this.utel = utel;
        this.uemail = uemail;
        this.uresdate = uresdate;
        this.stno = stno;
    }

    public Users(int userno, String uname, String username, String upwd, String usex, int eduno, int posno, long utel, String uemail, String uresdate, int stno, int intecount) {
        this.userno = userno;
        this.uname = uname;
        this.username = username;
        this.upwd = upwd;
        this.usex = usex;
        this.eduno = eduno;
        this.posno = posno;
        this.utel = utel;
        this.uemail = uemail;
        this.uresdate = uresdate;
        this.stno = stno;
        this.intecount = intecount;
    }

    public Users(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public Users(String uname, String username, String upwd, String usex, int eduno, int posno, long utel, String uemail, String uresdate) {
        this.uname = uname;
        this.username = username;
        this.upwd = upwd;
        this.usex = usex;
        this.eduno = eduno;
        this.posno = posno;
        this.utel = utel;
        this.uemail = uemail;
        this.uresdate = uresdate;
    }

    public Users() {

    }


    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public int getEduno() {
        return eduno;
    }

    public void setEduno(int eduno) {
        this.eduno = eduno;
    }

    public int getPosno() {
        return posno;
    }

    public void setPosno(int posno) {
        this.posno = posno;
    }

    public long getUtel() {
        return utel;
    }

    public void setUtel(long utel) {
        this.utel = utel;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUresdate() {
        return uresdate;
    }

    public void setUresdate(String uresdate) {
        this.uresdate = uresdate;
    }

    public int getStno() {
        return stno;
    }

    public void setStno(int stno) {
        this.stno = stno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIntecount() {
        return intecount;
    }

    public void setIntecount(int intecount) {
        this.intecount = intecount;
    }
}




