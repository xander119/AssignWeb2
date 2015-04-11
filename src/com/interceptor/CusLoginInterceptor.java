package com.interceptor;

import java.util.Map;

import model.Admin;
import model.Customer;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CusLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();


		String customer = (String) session.get("customer");

        if (customer == null) 
        {
                return Action.LOGIN;
        } 
        else 
        {
                return invocation.invoke();
        }
	}

}
