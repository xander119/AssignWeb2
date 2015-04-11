package com.esale.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;
import model.Account;
import model.Customer;
import model.Item;
import model.ItemSelect;

import com.opensymphony.xwork2.ActionSupport;

public class CartCtrl extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemSelect itemSelect ;
	private int itemSelectId;
	private int quantity;
	private String itemId;
	private double total;
	private List<ItemSelect> cart = new ArrayList<ItemSelect>();
	private EntityBeanDAOLocal bean = SessionFactory.getSessionBeanInstance();
	private Map<String, Object> session = SessionFactory.getStrutsSessionInstance();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	
	public String addItemToCart(){
		Item item = bean.getItemById(Integer.valueOf(this.getItemId()));
		itemSelect = new ItemSelect();
		itemSelect.setQuantity(this.getQuantity());
		itemSelect.setItem(item);
		double totalPrice = this.getQuantity() * item.getPrice();
		itemSelect.setTotalPrice(totalPrice);
		
		if(session.containsKey("cart")){
			cart = (List<ItemSelect>) session.get("cart");
			session.remove("cart");
		}
		cart.add(itemSelect);
		bean.createObject(itemSelect);
		
		session.put("cart", cart);
		
		return SUCCESS;
	}
	public String display(){
		if(session.containsKey("cart")){
			cart = (List<ItemSelect>) session.get("cart");
		}
		calCartTotal();
		return SUCCESS;
	}
	public String delete(){
		if(session.containsKey("cart")){
			cart = (List<ItemSelect>) session.get("cart");
			session.remove("cart");
		}
		cart.remove(this.getItemSelectId());
		session.put("cart", cart);
		return SUCCESS;
	}
	public void calCartTotal(){
		total = 0.0;
		for(ItemSelect s : cart){
			total += s.getTotalPrice();
		}
	}
	
	public String purchase(){
		cart = (List<ItemSelect>) session.get("cart");
		if(!cart.isEmpty()){
			for(ItemSelect is: cart){
				updateStock(is.getItem(),is.getQuantity());
				total += is.getTotalPrice();
			}
			Integer a = (Integer) session.get("account");
			if(a==null){
				return NONE;
			}
			Account account = bean.getAccountById(a);
			if(account.getBalance()>this.getTotal()){
				System.out.println("Balance :" + account.getBalance());
				account.setBalance(account.getBalance()- this.getTotal());
				System.out.println("After Balance :" + account.getBalance());
				bean.update(account);}
			else{
				return ERROR;}
			
		}
		
		System.out.println("Cart size:" + cart.size());
		session.remove("cart");
		return SUCCESS;
	}
	public void updateStock(Item i,int amountPurchased){
		i.setStockQuantity(i.getStockQuantity() - amountPurchased);
		bean.update(i);
	}
	
	public ItemSelect getItemSelect() {
		return itemSelect;
	}


	public void setItemSelect(ItemSelect itemSelect) {
		this.itemSelect = itemSelect;
	}




	public List<ItemSelect> getCart() {
		return cart;
	}


	public void setCart(List<ItemSelect> cart) {
		this.cart = cart;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	/**
	 * @return the itemSelectId
	 */
	public int getItemSelectId() {
		return itemSelectId;
	}


	/**
	 * @param itemSelectId the itemSelectId to set
	 */
	public void setItemSelectId(int itemSelectId) {
		this.itemSelectId = itemSelectId;
	}


	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}


	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}


	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}


	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
}
