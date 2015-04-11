package com.esale.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;
import model.Account;
import model.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class AccountCtrl extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3882460419962503692L;

	private List<String> paymentMethods ;
	private Account account  = new Account();
	private List<Account> accounts;
	private String accId;
	private String address;
	private String balance;
	private String paymentMethod;
	private EntityBeanDAOLocal bean = SessionFactory.getSessionBeanInstance();
	private Map<String, Object> session = SessionFactory.getStrutsSessionInstance();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	public String getAccDetail(){
		account = bean.getAccountById(Integer.parseInt(this.getAccId()));
		return SUCCESS;
	}
	

	public String newAcc() {
		String name = (String) session.get("customer");
		Customer c = (Customer) bean.findCustomerByName(name);
		boolean update = false;
		System.out.println("customer ID:" + c.toString());
		Account a = new Account();
		a.setAddress(address);
		a.setPaymentMethod(paymentMethod);
		a.setBalance(Double.parseDouble(this.getBalance()));
		a.setCustomer(c);
		if (!this.getAccId().equals("0")) {
			int id = Integer.valueOf(this.getAccId());
			a = bean.getAccountById(id);
			update = true;
		}
		System.out.println("account :" + a.toString() + "Balance : " + Double.valueOf(this.getBalance()));
		if (update) {
			bean.update(a);
		} else {
			bean.createObject(a);
		}
		
		
		
		return SUCCESS;
	}
	public String deleteAcc(){
		account = bean.getAccountById(Integer.valueOf(this.getAccId()));
		System.out.print("Deleting Account:" + this.getAccId() +"Account Found: "+ account.getId());
		bean.delete(account);
		String name = (String) session.get("customer");
		Customer c = (Customer) bean.findCustomerByName(name);
		accounts = bean.getAccountByCus(c);
		return SUCCESS;
	}
	
	public String displayEditAcc(){
		paymentMethods = new ArrayList<String>();
		paymentMethods.add("Visa");
		paymentMethods.add("MasterCard");
		paymentMethods.add("PayPal");
		account = bean.getAccountById(Integer.valueOf(this.getAccId()));
		
		return SUCCESS;
	}
	public String listAccount(){
		String name = (String) session.get("customer");
		Customer c = (Customer) bean.findCustomerByName(name);
		accounts = bean.getAccountByCus(c);
		if(!accounts.isEmpty()){
			for(Account a : accounts){
				System.out.println("Account : " + a.getAddress());
			}
		}
		return SUCCESS;
	}
	public String display(){
		paymentMethods = new ArrayList<String>();
		paymentMethods.add("Visa");
		paymentMethods.add("MasterCard");
		paymentMethods.add("PayPal");

		return NONE;
	}
	public String getListAccount(){
		String name = (String) session.get("customer");
		Customer c = (Customer) bean.findCustomerByName(name);
		accounts = bean.getAccountByCus(c);
		if(!accounts.isEmpty()){
			for(Account a : accounts){
				System.out.println("Account : " + a.getAddress());
			}
		}
		
		return SUCCESS;
	}
	public String setSessionAcc(){
		String name = (String) session.get("customer");
		Customer c = (Customer) bean.findCustomerByName(name);
		accounts = bean.getAccountByCus(c);
		if(!accounts.isEmpty()){
			for(Account a:accounts){
				if(a.getId()==Integer.valueOf(this.getAccId())){
					System.out.println("Account ID:" + this.getAccId());
					session.put("account", a.getId());
					break;
				}
			}
			
		}
		return SUCCESS;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	



	public List<String> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(List<String> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/**
	 * @return the accId
	 */
	public String getAccId() {
		return accId;
	}
	/**
	 * @param accId the accId to set
	 */
	public void setAccId(String accId) {
		this.accId = accId;
	}
}
