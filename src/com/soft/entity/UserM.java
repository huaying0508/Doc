package com.soft.entity;

public class UserM {

    private int userno;//用户编号
    private String uname;//用户账号
    private String username;//用户名
    private String upwd;//密码
    private String usex;//性别
    private int eduno;//学历号
    private String eduname;//学历
    private int posno;//职位号
    private String posname;//职位名
    private long utel;//电话
    private String uemail;//邮箱
    private String uresdate;//注册时间
    private int stno;//状态号
    private String stname;//状态名
    private int intecont;//积分
    private int num;//上传次数
    private int downnum;//下载次数


    public UserM(int userno, String uname, String username, String upwd, String usex, int eduno, String eduname, int posno, String posname, long utel, String uemail, String uresdate, int stno, String stname, int intecont, int num, int downnum) {
        this.userno = userno;
        this.uname = uname;
        this.username = username;
        this.upwd = upwd;
        this.usex = usex;
        this.eduno = eduno;
        this.eduname = eduname;
        this.posno = posno;
        this.posname = posname;
        this.utel = utel;
        this.uemail = uemail;
        this.uresdate = uresdate;
        this.stno = stno;
        this.stname = stname;
        this.intecont = intecont;
        this.num = num;
        this.downnum = downnum;
    }

    public UserM() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEduname() {
        return eduname;
    }

    public void setEduname(String eduname) {
        this.eduname = eduname;
    }

    public int getPosno() {
        return posno;
    }

    public void setPosno(int posno) {
        this.posno = posno;
    }

    public String getPosname() {
        return posname;
    }

    public void setPosname(String posname) {
        this.posname = posname;
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

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public int getIntecont() {
        return intecont;
    }

    public void setIntecont(int intecont) {
        this.intecont = intecont;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDownnum() {
        return downnum;
    }

    public void setDownnum(int downnum) {
        this.downnum = downnum;
    }
}
