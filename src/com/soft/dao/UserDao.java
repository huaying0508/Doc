package com.soft.dao;

import com.soft.entity.Users;

import java.util.List;

public interface UserDao {

    //登录
    public Users UserLogin(Users user);

    //用户查询
    public <T>List<T> finaUser(String btime,String endtime,String uname,int page);

    //检测用户名
    public Users CheckName(String uname);

    //添加用户
    public boolean AddUser(Users user);
}
