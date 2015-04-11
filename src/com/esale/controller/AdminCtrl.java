package com.esale.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.Map;







import org.apache.struts2.interceptor.SessionAware;

import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;
import strategy.AdminStrategy;
import strategy.Context;
import model.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class AdminCtrl extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 170454108307940158L;
	private Admin admin = new Admin();
	private EntityBeanDAOLocal bean = SessionFactory.getSessionBeanInstance();
	private Map<String, Object> session = SessionFactory.getStrutsSessionInstance();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	public String cancel(){
		return SUCCESS;
	}
	public String adminLogin() {
		String password = this.getAdmin().getPassword();
		String name = this.getAdmin().getName();
		Context context = new Context(new AdminStrategy());
		boolean result = context.login(name, password);
		
		if(result){
			session.put("admin", name);
			session.put("context", new Date());
			System.out.println("Logged in session:" + session.get("admin").toString() );
			return LOGIN;
		}else{
			return ERROR;
		}
			
		
	}
	public String logout(){
		session.remove("admin");
		session.remove("context");
		return SUCCESS;
	}
	public String newCate() {

		return SUCCESS;

	}

	// used once
	public String createAdmin() {
		bean.createObject(this.getAdmin());
		return SUCCESS;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
