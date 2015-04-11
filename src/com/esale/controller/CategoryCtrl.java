package com.esale.controller;

import java.util.ArrayList;
import java.util.List;

import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;
import model.Category;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryCtrl extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Category category = new Category();
	private EntityBeanDAOLocal bean = SessionFactory.getSessionBeanInstance();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return SUCCESS;
	}

	public String saveCategory() {
		bean.createObject(this.getCategory());
		return SUCCESS;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


}
