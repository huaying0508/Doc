package com.soft.biz;

import com.soft.dao.AdminDao;
import com.soft.dao.AdminDaoImpl;
import com.soft.dao.UserDao;
import com.soft.dao.UserDaoImpl;
import com.soft.entity.Admin;
import com.soft.entity.UserM;
import com.soft.entity.Users;
import com.soft.tools.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminBizImpl implements AdminBiz {


    private AdminDao adminDao=new AdminDaoImpl();
    private UserDao userDao=new UserDaoImpl();


    //--------------------------------登录------------------------------
    @Override
    public Admin Login(String adname, String adpwd) {

        return adminDao.AdminLogin(new Admin(adname,adpwd));
    }


    public List<UserM> findByUser(String btime, String endtime, String uname, int page){

        return userDao.finaUser(btime,endtime,uname,page);
    }

    //---------------------------------检测用户名------------------------------
    @Override
    public Users CheckName(String uname) {

        return userDao.CheckName(uname);
    }

    //------------------------------增加用户-------------------------------
    @Override
    public boolean AddUser(Users user) {

        return userDao.AddUser(user);
    }
}
