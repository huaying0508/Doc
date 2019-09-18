package com.soft.dao;

import com.soft.entity.UserM;
import com.soft.entity.Users;
import com.soft.tools.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private List<Users> list = null;
    private List<UserM> ulist = null;
    private QueryRunner qr = null;
    private String sql = null;
    private boolean flag = false;
    private Users user = null;


    //------------------------登录------------------------------
    public Users UserLogin(Users user) {

        try {
            qr = DBHelper.getQueryRunner();
            sql = "select * from tbluser where uname=? and upwd=?";
            Object[] param = new Object[]{user.getUname(), user.getUpwd()};

            user = qr.query(sql, new BeanHandler<>(Users.class), param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    //----------------------用户列表查询-----------------------------
//    @Override
    public List<UserM> finaUser(String btime, String endtime, String uname, int page) {


        int pageno = (page - 1) * 5;// 从第几条开始
        int currpage = 5 * page + 1;// 不超过第几条
        try {
            qr = DBHelper.getQueryRunner();

            sql = "select tu.*,ts.StName,t.num,t.DownNum from tbluser tu,tblstate ts,\n" +
                    "(select u.UserNO,(case when d.DownNum is null then 0 else d.DownNum end) as DownNum , count(d.DownNum) as num from tbluser u \n" +
                    "LEFT JOIN tbldoc d on u.UserNO=d.UserNO GROUP BY u.UserNO,d.DownNum) t where tu.StNO=ts.StNo and tu.UserNO=t.UserNO  ";


            if (null != btime) {
                if (0 < btime.length()) {
                    sql += "  and tu.UResDate between '" + btime + "' ";
                }
            }

            if (null != endtime) {
                if (0 < endtime.length()) {
                    sql += " and '" + endtime + "'";
                }
            }

            if (null != uname) {
                if (0 < uname.length()) {
                    sql += " and tu.username like '%" + uname + "%' ";
                }
            }

            sql += " order by tu.UserNO limit " + pageno + "," + currpage + "";//分页，排序

            ulist = qr.query(sql, new BeanListHandler<>(UserM.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ulist;
    }

    //-----------------------------------------检测用户名-----------------------------------
    public Users CheckName(String uname) {

        try {
            qr = DBHelper.getQueryRunner();
            sql = "select * from tbluser where uname like '%" + uname + "%'";

            user = qr.query(sql, new BeanHandler<>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    //-----------------------------------添加用户-----------------------------------
    public boolean AddUser(Users user) {

        try {
            qr = DBHelper.getQueryRunner();

            sql = "insert into tbluser(uname,username,upwd,usex,eduno,posno,utel,uemail,uresdate,stno) " +
                    "values(?,?,?,?,?,?,?,?,?,1) ";

            Object[] param = new Object[]{
                    user.getUname(), user.getUsername(), user.getUpwd(), user.getUsex(),
                    user.getEduno(), user.getPosno(), user.getUtel(), user.getUemail(), user.getUresdate()
            };
            int num = qr.update(sql, param);
            if (num > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }


}
