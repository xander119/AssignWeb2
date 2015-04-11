package com.esale.controller;

import java.util.Map;

import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;
import model.ItemSelect;

import com.opensymphony.xwork2.ActionSupport;

public class ItemSelectCtrl extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1916857939643298660L;
	private ItemSelect itemSelect = new ItemSelect();
	private EntityBeanDAOLocal bean = SessionFactory.getSessionBeanInstance();
	private Map<String, Object> session = SessionFactory.getStrutsSessionInstance();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
