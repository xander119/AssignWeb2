package com.interceptor;

import java.util.Map;

import model.Account;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AccountInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String, Object> session = arg0.getInvocationContext()
				.getSession();


        Integer account = (Integer) session.get("account");

        if (account == null) 
        {
                return Action.NONE;
        } 
        else 
        {
                return arg0.invoke();
        }
		
	}

}
