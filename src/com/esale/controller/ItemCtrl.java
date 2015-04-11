package com.esale.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;
import model.Category;
import model.Customer;
import model.Item;
import model.Review;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class ItemCtrl extends ActionSupport implements Preparable,
		ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4048057590528430508L;

	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	private List<Review> reviews = new ArrayList<Review>();
	private Review review;
	private String itemId;
	private String category;
	private String content;
	private String type;
	private Item item = new Item();
	private List<Item> items;
	private Map<String, Object> session ;
	private EntityBeanDAOLocal bean;
	private List<Category> categories = new ArrayList<Category>();
	private List<String> displayCate = new ArrayList<String>();
	private HttpServletRequest servletRequest;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public void prepare() throws Exception {
		session = SessionFactory.getStrutsSessionInstance();
		 bean = SessionFactory.getSessionBeanInstance();
		items = (List<Item>) bean.getAllItems();
		categories = bean.getAllCategories();
		
		for (Category c : categories) {
			displayCate.add(c.getCategoryName());
			System.out.println(c.getCategoryName());
		}

		if (!items.isEmpty()) {
			for (Item i : items) {
				System.out.println("Items in DB:" + i.toString());
			}
		} else {
			System.out.println("No Item in DB:");
		}
	}

	public String saveItem() {
		Item aItem = this.getItem();
		boolean update = false;
		System.out.println("Items ID:" + this.getItemId());
		
		if (!this.getItemId().equals("0")) {
			int id = Integer.valueOf(this.getItemId());
			aItem = bean.getItemById(id);
			update = true;
		}

		try {
			String filePath = servletRequest.getSession().getServletContext()
					.getRealPath("/").concat("userimages");
			filePath = "C:/JBOSS/jboss-as-7.1.1.Final/standalone/deployments/userimages";
			System.out.println("Image Location:" + filePath);
			File fileToCreate = new File(filePath, this.userImageFileName);
			FileUtils.copyFile(this.userImage, fileToCreate);
			System.out.println("Image file name: " + this.userImageFileName);
			aItem.setImage(this.userImageFileName);
			for (Category c : categories) {
				if (c.getCategoryName().equals(this.getCategory())) {
					aItem.setCategory(c);
					System.out
							.println("Setting Item Category: " + c.toString());
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		if (update) {
			bean.update(aItem);
		} else {
			bean.createObject(aItem);
		}

		items = (ArrayList<Item>) bean.getAllItems();
		return SUCCESS;
	}

	public String display() {
		return SUCCESS;
	}

	public String getItemById() {
		int id = Integer.valueOf(this.getItemId());
		item = bean.getItemById(id);
		reviews = bean.getReviewByItem(id);
		if (item != null)
			return SUCCESS;
		else
			return ERROR;
	}

	public String addReview() {
		Review r = this.getReview();
		String name = (String) session.get("customer");
		Customer c = (Customer) bean.findCustomerByName(name);
		item = bean.getItemById(Integer.parseInt(this.getItemId()));
		System.out.println("Customer name" + c.getUserName());
		r.setCustomer(c);
		r.setItem(item);
		bean.createObject(r);
		reviews = bean.getAllReviews();
		return SUCCESS;
	}

	public String displayUpdateItem() {
		int id = Integer.valueOf(this.getItemId());
		item = bean.getItemById(id);
		return SUCCESS;
	}
	
	public String search(){
		System.out.println(this.getType() + " " + this.getContent());
		if(this.getType().equals("01")){
			items = (List<Item>) bean.findItemByManu(this.getContent());
		}else if (this.getType().equals("02")) {
			items = (List<Item>) bean.findItemByCategory(this.getContent());
		}else{
			items = (List<Item>) bean.findItemByTitle(this.getContent());
		}
		return SUCCESS;
	}
	
	

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<String> getDisplayCate() {
		return displayCate;
	}

	public void setDisplayCate(List<String> displayCate) {
		this.displayCate = displayCate;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

	/**
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews
	 *            the reviews to set
	 */
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	/**
	 * @return the review
	 */
	public Review getReview() {
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public void setReview(Review review) {
		this.review = review;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
