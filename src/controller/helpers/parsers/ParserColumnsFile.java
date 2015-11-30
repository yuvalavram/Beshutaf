package controller.helpers.parsers;

import java.util.ArrayList;
import java.util.List;

import model.Store;
import model.StoreConfiguration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import controller.Constants;

public class ParserColumnsFile {

	public List<Store> iterateFile(Sheet worksheet) {
		List<Store> storesList = new ArrayList<Store>();
		int storeKey = 1;
		for (Row myrow : worksheet) {
	    	if(myrow.getRowNum() > 0){
	    		Store store = createStore(myrow, storeKey);
	    		storesList.add(store);
	    		storeKey++;
	    	}
		}
		return storesList;
	}

	private Store createStore(Row myrow, int storeKey) {
		Store store = new Store();
		store.setStoreKey(storeKey);
		StoreConfiguration storeConfiguration = store.getStoreConfiguration();
		for (Cell mycell : myrow) {
			String str = "";
			int cellType = mycell.getCellType();
			if(cellType == Cell.CELL_TYPE_STRING){
				str = mycell.getStringCellValue();
			} else if (cellType == Cell.CELL_TYPE_NUMERIC) {
				Double dbl = mycell.getNumericCellValue();
				Integer intVal = dbl.intValue();
				str = intVal.toString();
			}
			
			setStoreConfigurationField(storeConfiguration, mycell, str);
		}
		return store;
	}

	private void setStoreConfigurationField(StoreConfiguration storeConfiguration, Cell mycell, String str) {
		if(mycell.getColumnIndex() == Constants.COLUMNS_FILE_COLUMN_INDEX_STORE_NAME){ // store name
			storeConfiguration.setStoreName(str);
		} else if(mycell.getColumnIndex() == Constants.COLUMNS_FILE_COLUMN_INDEX_FILE_NAME){ // file name
			storeConfiguration.setFileName(str);
		} else if(mycell.getColumnIndex() == Constants.COLUMNS_FILE_COLUMN_INDEX_CODE) { // code
			storeConfiguration.setCodeColumn(Integer.parseInt(str));
		} else if(mycell.getColumnIndex() == Constants.COLUMNS_FILE_COLUMN_INDEX_PRICE) { // price
			storeConfiguration.setPriceColumn(Integer.parseInt(str));		
		} else if(mycell.getColumnIndex() == Constants.COLUMNS_FILE_COLUMN_INDEX_CATEGORY) { // category
			storeConfiguration.setCategoryColumn(Integer.parseInt(str));
		} else if(mycell.getColumnIndex() == Constants.COLUMNS_FILE_COLUMN_INDEX_PRODUCT_NAME) { // name
			storeConfiguration.setNameColumn(Integer.parseInt(str));
		}
	}

}
