package controller.helpers.parsers;

import model.ProductInStore;
import model.Store;
import model.StoreConfiguration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ParserStoreFile {
	
	public void iterateFile(Sheet worksheet, Store store) {
		
		StoreConfiguration storeConfiguration = store.getStoreConfiguration();
		int codeColumn = storeConfiguration.getCodeColumn();
		int priceColumn = storeConfiguration.getPriceColumn();
		int categoryColumn = storeConfiguration.getCategoryColumn();
		int nameColumn = storeConfiguration.getNameColumn();
		for (Row myrow : worksheet) {
	    	if(myrow.getRowNum() > 0){
	    		String codeValue = null;
	    		String priceValue = null;
	    		String categoryValue = null;
	    		String nameValue = null;
	    		
			    for (Cell mycell : myrow) {
			    	// TODO - extract method
			    	String str = "";
			    	Double dbl = null;
			    	int cellType = mycell.getCellType();
			    	if(cellType == Cell.CELL_TYPE_STRING){
						str = mycell.getStringCellValue();
			    	} else if (cellType == Cell.CELL_TYPE_NUMERIC) {
						dbl = mycell.getNumericCellValue();
						str = dbl.toString();
					}
			    	if(mycell.getColumnIndex() == codeColumn-1 && dbl != null){
						Integer intVal = dbl.intValue();
						str = intVal.toString();
			    		codeValue = str;
			    	} else if(mycell.getColumnIndex() == priceColumn-1){
			    		priceValue = str;
			    	} else if(mycell.getColumnIndex() == categoryColumn-1){
			    		categoryValue = str;
			    	} else if(mycell.getColumnIndex() == nameColumn-1){
			    		nameValue = str;
			    	}			    	
			    }
			    
	    		ProductInStore product = new ProductInStore(codeValue, priceValue, categoryValue, nameValue);
	    		store.addProductToStore(codeValue, product);

	    	}
		}
	}
}
