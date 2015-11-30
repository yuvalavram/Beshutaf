package model.hibernate;

// Generated Nov 7, 2015 12:57:09 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * ProductsInStorePrices generated by hbm2java
 */
public class ProductsInStorePrices implements java.io.Serializable {

	private int id;
	private ProductsInStore productsInStore;
	private Date date;
	private String price;

	public ProductsInStorePrices() {
	}

	public ProductsInStorePrices(int id, ProductsInStore productsInStore,
			Date date) {
		this.id = id;
		this.productsInStore = productsInStore;
		this.date = date;
	}

	public ProductsInStorePrices(int id, ProductsInStore productsInStore,
			Date date, String price) {
		this.id = id;
		this.productsInStore = productsInStore;
		this.date = date;
		this.price = price;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductsInStore getProductsInStore() {
		return this.productsInStore;
	}

	public void setProductsInStore(ProductsInStore productsInStore) {
		this.productsInStore = productsInStore;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}