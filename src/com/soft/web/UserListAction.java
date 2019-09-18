package com.soft.web;

import com.opensymphony.xwork2.ActionSupport;
import com.soft.biz.AdminBiz;
import com.soft.biz.AdminBizImpl;
import com.soft.entity.FindData;
import com.soft.entity.UserM;
import com.soft.entity.Users;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class UserListAction extends ActionSupport implements SessionAware {

    private AdminBiz adminBiz = new AdminBizImpl();
    private FindData find;
    private List<UserM> userlist;
    private int page = 1;
    private int userno;
    private Users user;
    private Map<String, Object> session = null;
    private Map<String, String> addmap = new HashMap<String, String>();

    private File uploadImage;

    private String uploadImageContentType;

    private String uploadImageFileName;


    //查找用户
    public String findByUser() {
        String msg = "fail";

        userlist = adminBiz.findByUser(null, null, null, page);

        if (null != userlist) {
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("ulist", userlist);

//            session.put("ulist",userlist);
            msg = "findok";
        }

        return msg;

    }

    //添加用户
    public String AddUser() {


        //获取时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = sdf.format(new Date());

//        Users adduse = new Users(user.getUname(), user.getUsername(), user.getUpwd(), user.getUsex(), user.getEduno(),
//                user.getPosno(), user.getUtel(), user.getUemail(), message);

//        boolean f = adminBiz.AddUser(adduse);
//
//        if (f) {
//            addmap.put("addmsg", "success");
//        } else {
//            addmap.put("addmsg", "fail");
//        }


        //文件上传

        System.out.println("filename:" + this.getUploadImageFileName());
        System.out.println("contentType:" + this.getUploadImageContentType());
        System.out.println("file:" + this.getUploadImage());


        System.out.println("yhm:" + user.getUname());

        String realPath = ServletActionContext.getServletContext().getRealPath("../upload");

        File file = new File(realPath);
        System.out.println("1");
        if (file.exists()) {
            file.mkdirs();
        }

        try {
            System.out.println("2");
            FileUtils.copyFile(uploadImage, new File(file, uploadImageFileName));

        } catch (IOException e) {
            System.out.println("3");
//            addmap.put("addmsg", "fail");
            e.printStackTrace();
        }

        addmap.put("addmsg", "success");

        System.out.println(addmap.get("addmsg")+"111");
        return "addu";
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


    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public FindData getFind() {
        return find;
    }

    public void setFind(FindData find) {
        this.find = find;
    }

    public List<UserM> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserM> userlist) {
        this.userlist = userlist;
    }

    public Map<String, String> getAddmap() {
        return addmap;
    }

    public void setAddmap(Map<String, String> addmap) {
        this.addmap = addmap;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public File getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(File uploadImage) {
        this.uploadImage = uploadImage;
    }

    public String getUploadImageContentType() {
        return uploadImageContentType;
    }

    public void setUploadImageContentType(String uploadImageContentType) {
        this.uploadImageContentType = uploadImageContentType;
    }

    public String getUploadImageFileName() {
        return uploadImageFileName;
    }

    public void setUploadImageFileName(String uploadImageFileName) {
        this.uploadImageFileName = uploadImageFileName;
    }
}
