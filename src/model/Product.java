package model;

import java.util.HashMap;

public class Product {
	private int productKey;
	private String productName;
	private HashMap<Integer, ProductInStore> productsInStroteMap = new HashMap<Integer, ProductInStore>();
	
	public void addProductsInStroteMap(Integer storeKey, ProductInStore productInStore) {
		productsInStroteMap.put(storeKey, productInStore);
	}
	public int getProductKey() {
		return productKey;
	}
	public void setProductKey(int productKey) {
		this.productKey = productKey;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public HashMap<Integer, ProductInStore> getProductsInStroteMap() {
		return productsInStroteMap;
	}
	public void setProductsInStroteMap(HashMap<Integer, ProductInStore> productsInStroteMap) {
		this.productsInStroteMap = productsInStroteMap;
	}
}
