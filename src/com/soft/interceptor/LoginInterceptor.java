package com.soft.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {


    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        Object obj = actionInvocation.getInvocationContext().getSession().get("usertest");

        System.out.println(obj+"111");
        if (null != obj) {
            actionInvocation.invoke();//放行到对应的action
        }
        System.out.println("shibai");

        return "error";
    }
}
