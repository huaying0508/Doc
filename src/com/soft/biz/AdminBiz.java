package com.soft.biz;

import com.soft.entity.Admin;
import com.soft.entity.UserM;
import com.soft.entity.Users;

import java.util.List;

public interface AdminBiz {

    //登录
    public Admin Login(String adname, String adpwd);

    //查询前台用户

    public List<UserM> findByUser(String btime, String endtime, String uname, int page);

    //检测用户名
    public  Users CheckName(String uname);

    //增加用户

    public boolean AddUser(Users user);

}
