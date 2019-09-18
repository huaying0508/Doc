package com.soft.dao;

import com.soft.entity.Admin;
import com.soft.tools.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private List<Admin> list = null;
    private QueryRunner qr = null;
    private String sql = null;
    private boolean flag = false;
    private Admin admin = null;

    //---------------------------登录----------------------------
    @Override
    public Admin AdminLogin(Admin admin) {
        try {
            qr = DBHelper.getQueryRunner();
            sql = "select * from tbladmin where adname=? and adpwd=?";
            Object[] param = new Object[]{admin.getAdname(), admin.getAdpwd()};

            admin = qr.query(sql, new BeanHandler<>(Admin.class), param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
