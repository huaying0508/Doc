package com.soft.biz;

import com.soft.dao.UserDao;
import com.soft.dao.UserDaoImpl;
import com.soft.entity.Users;

public class UserBizImpl implements UserBiz {

    private UserDao userDao=new UserDaoImpl();
    @Override
    public Users Login(String uname, String upwd) {

        return userDao.UserLogin(new Users(uname,upwd));
    }
}
