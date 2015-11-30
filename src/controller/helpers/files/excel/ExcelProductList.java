package controller.helpers.files.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import model.Product;
import model.ProductInStore;
import model.Store;



public class ExcelProductList {
	
	public ArrayList<ArrayList<String>> PrepareExcelProductList(List<Store> storesList, ArrayList<Product> productsList) {
		ArrayList<ArrayList<String>> productsExcelList = new ArrayList<ArrayList<String>>();
		
		// create headers
		ArrayList<String> headers = new ArrayList<String>();
		HashMap<Integer, Integer> storesIndexMap = new HashMap<Integer, Integer>();
//		headers.add("Product global key");
//		headers.add("Product global name");

		int storeIndex = 0;
		for (Store store : storesList) {
			String storeName = store.getStoreConfiguration().getStoreName();
			int storeKey = store.getStoreKey();
			storesIndexMap.put(storeKey, storeIndex);
			// TODO - use constants columns index, name and type
			headers.add(storeName);
			headers.add("Category");
			headers.add("Price");
			headers.add("Price relative");
		}
		productsExcelList.add(headers);

		
		// create rows
		for (Product product : productsList) {
			ArrayList<String> row = new ArrayList<String>();
			HashMap<Integer, ProductInStore> productsInStroteMap = product.getProductsInStroteMap();
			HashMap<Integer, ProductInStore> productInStoreIndex = new HashMap<Integer, ProductInStore>();
			

			for (Entry<Integer, ProductInStore> entry : productsInStroteMap.entrySet()){
			    productInStoreIndex.put(entry.getKey(), entry.getValue());
			}
			
//			row.add(Integer.toString(product.getProductKey()));
//			row.add(product.getProductName());

			for (Entry<Integer, Integer> entry : storesIndexMap.entrySet()){
				ProductInStore productInStore = productInStoreIndex.get(entry.getKey());
				// TODO - use constants columns index, name and type
			    row.add(productInStore.getName());
			    row.add(productInStore.getCategory());
			    row.add(productInStore.getPrice());
			    //TODO - calculate relative price
			    row.add("");
			}

			productsExcelList.add(row);
			
		}
		
		return productsExcelList;
	}
}
