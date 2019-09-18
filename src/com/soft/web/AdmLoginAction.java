package com.soft.web;

import com.opensymphony.xwork2.ActionSupport;
import com.soft.biz.AdminBiz;
import com.soft.biz.AdminBizImpl;

import com.soft.entity.Admin;
import com.soft.entity.Users;

import org.apache.struts2.interceptor.SessionAware;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdmLoginAction extends ActionSupport implements SessionAware {

    private AdminBiz adminBiz = new AdminBizImpl();
    private Admin admin;
    private Users user;
    private String uname;
    private List<Admin> list;
    private String securityCode;
    private Map<String, Object> session = null;

    private Map<String, String> remap = new HashMap<String, String>();
    private Map<String, String> recheck = new HashMap<String, String>();

    //----------------------------------登录------------------------------------------
    public String execute() {

        Admin ulogin = adminBiz.Login(admin.getAdname(), admin.getAdpwd());

        String serverCode = (String) session.get("SESSION_SECURITY_CODE");

        session.put("usertest",ulogin);

        if (null != ulogin) {

            if (serverCode.equals(securityCode)) {

                remap.put("info", "success");
            }else{
                remap.put("info","codefail");
            }

        } else {
            remap.put("info", "fail");

        }
        return "rejson";
    }

    //-------------------------检查用户名---------------------------
    public String CheckName() {

        Users checkU=adminBiz.CheckName(uname);

        if (null!=checkU){
            recheck.put("checkmsg","success");
        }else {
            recheck.put("checkmsg","fail");
        }

        return "checkN";
    }


    @Override
    public void setSession(Map<String, Object> map) {

        //map 来源， 谁调用setSession
        // //加载struts.xml path -> LoginAction 实例化 后，调用setSession
        //  Map<String,Object> a = ActionContext.getContext().getSession();
        // setSession(a);

        //session 对象来源: map
        session = map;
    }

    //------------------------------get、set-----------------------------------
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Map<String, String> getRemap() {
        return remap;
    }

    public void setRemap(Map<String, String> remap) {
        this.remap = remap;
    }

    public Map<String, String> getRecheck() {
        return recheck;
    }

    public void setRecheck(Map<String, String> recheck) {
        this.recheck = recheck;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
