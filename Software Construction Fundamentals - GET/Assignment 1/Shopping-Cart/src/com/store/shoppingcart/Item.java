package com.store.shoppingcart;

/**
 * Defines the structure of an Item in the Store.
 * 
 * @author Chinmay Jain
 * @version 1.1
 * @since 2021-02-25
 */
public class Item {
	private String code;
	private String name;
	private Double price;
	private Integer availableStock;

	/**
	 * Parameterized Constructor that creates an Item object.
	 * 
	 * @param code           Unique string to represent the Item.
	 * @param name           Name of the Item.
	 * @param price          Price of the Item.
	 * @param availableStock Available Stock of the Item.
	 */
	public Item(String code, String name, Double price, Integer availableStock) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.availableStock = availableStock;
	}

	/**
	 * This method returns the name of the Item.
	 * 
	 * @return String Name of Item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the name of the Item.
	 * 
	 * @param name Name of the Item.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns the stock of the Item.
	 * 
	 * @return Integer Available Stock of Item in Store.
	 */
	public Integer getAvailableStock() {
		return availableStock;
	}

	/**
	 * This method sets the stock of the Item.
	 * 
	 * @param availableStock Available Stock of the Item.
	 */
	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}

	/**
	 * This method return the price of the Item.
	 * 
	 * @return Double Price of the Item.
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * This method sets the price of the Item.
	 * 
	 * @param price Price of the Item.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * This method return the code of the Item.
	 * 
	 * @return String Unique code of the Item.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method sets the code of the Item.
	 * 
	 * @param code Unique code of the Item.
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
