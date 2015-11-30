package model;
import java.util.HashMap;


public class Store {
	private int storeKey;
	private HashMap<String, ProductInStore> storeProductsMap = new HashMap<String, ProductInStore>();
	private HashMap<String, ProductInStore> globalProductsMap = new HashMap<String, ProductInStore>();
	private StoreConfiguration storeConfiguration = new StoreConfiguration();
	
	
	public void addProductToStore(String productCode, ProductInStore product){
		storeProductsMap.put(productCode, product);
	}

	public StoreConfiguration getStoreConfiguration() {
		return storeConfiguration;
	}

	public void setStoreConfiguration(StoreConfiguration storeConfiguration) {
		this.storeConfiguration = storeConfiguration;
	}

	public HashMap<String, ProductInStore> getStoreProductsMap() {
		return storeProductsMap;
	}

	public void setStoreProductsMap(HashMap<String, ProductInStore> storeProductsMap) {
		this.storeProductsMap = storeProductsMap;
	}

	public HashMap<String, ProductInStore> getGlobalProductsMap() {
		return globalProductsMap;
	}

	public void setGlobalProductsMap(HashMap<String, ProductInStore> globalProductsMap) {
		this.globalProductsMap = globalProductsMap;
	}

	public int getStoreKey() {
		return storeKey;
	}

	public void setStoreKey(int storeKey) {
		this.storeKey = storeKey;
	}

}
