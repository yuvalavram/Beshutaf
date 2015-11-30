package controller.helpers.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Product;
import model.ProductInStore;
import model.Store;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ParserCompareFile {
	
	public ArrayList<Product> iterateFile(Sheet worksheet, List<Store> storesList) {
		ArrayList<Product> productList = new ArrayList<Product>();	
		HashMap<String, Store> storesMap = new HashMap<String, Store>();
		for (Store store : storesList) {
			storesMap.put(store.getStoreConfiguration().getStoreName(), store);
		}
		HashMap<Integer, String> storesIndexMap = new HashMap<Integer, String>();
		int productKey = 0;
		for (Row myrow : worksheet) {
	    	if(myrow.getRowNum() == 0){	    		
			    for (Cell mycell : myrow) {
					String storeName = mycell.getStringCellValue();
					Store store = storesMap.get(storeName);
					if(store != null){
						storesIndexMap.put(mycell.getColumnIndex(), storeName);
					}
			    }
	    	}
	    	else{
	    		Product product = new Product();
	    		boolean productExist = false;
	    		product.setProductKey(productKey);
			    for (Cell mycell : myrow) {
					String productCode = null;
					String storeName = null;
			    	int cellType = mycell.getCellType();
			    	if(cellType == Cell.CELL_TYPE_STRING){
			    		productCode = mycell.getStringCellValue();
			    	} else if (cellType == Cell.CELL_TYPE_NUMERIC) {
						Double dbl = mycell.getNumericCellValue();
						Integer intVal = dbl.intValue();
						productCode = intVal.toString();
					}
					storeName = storesIndexMap.get(mycell.getColumnIndex());
					if(productCode != null && storeName!=null){
						Store store = null;
						store = storesMap.get(storeName);
						if(store != null){
							productExist = true;
							ProductInStore productInStore = store.getStoreProductsMap().get(productCode);
							if(productInStore!=null){
								productInStore.setProductKey(productKey);
								product.addProductsInStroteMap(store.getStoreKey(), productInStore);
							}
						}
					}
			    }
			    if(productExist){
					productList.add(product);			    	
			    }
	    	}
		    productKey++;
		}
		return productList;
	}
}
