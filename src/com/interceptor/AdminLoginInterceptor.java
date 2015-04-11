package com.interceptor;

import java.util.Map;

import model.Admin;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();


        String admin = (String) session.get("admin");

        if (admin == null) 
        {
                return Action.LOGIN;
        } 
        else 
        {
                return invocation.invoke();
        }
		
	}
}
