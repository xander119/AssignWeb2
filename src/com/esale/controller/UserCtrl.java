package com.esale.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.Account;
import model.Customer;
import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;
import strategy.Context;
import strategy.CustomerStrategy;

import com.opensymphony.xwork2.ActionSupport;

public class UserCtrl extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Customer customer = new Customer();
	private List<Account> accounts ;
	private EntityBeanDAOLocal bean = SessionFactory.getSessionBeanInstance();
	private Map<String, Object> session = SessionFactory.getStrutsSessionInstance();

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 
		return SUCCESS;
	}
	public String  customerLogin() throws NoSuchAlgorithmException, InvalidKeySpecException{
		
		
		Context context = new Context(new CustomerStrategy());
		
		String name = this.getCustomer().getUserName();
		String password = this.getCustomer().getPassword();
		boolean result = context.login(name,password);
		
		if (result){
			session.put("customer", name);
			session.put("context", new Date());
			return LOGIN;
		}else{
			return ERROR;
		}
		
	}
	public String logout(){
		session.remove("customer");
		session.remove("context");
		return SUCCESS;
	}
	public String register(){
		Customer c = new Customer();
		c.setUserName(this.getCustomer().getUserName());
		c.setPassword(this.getCustomer().getPassword());
		System.out.println("Registering Customer:"+c.toString());
		
		if (bean.createObject(c)!=null){
			return SUCCESS;
		}
		return NONE;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
