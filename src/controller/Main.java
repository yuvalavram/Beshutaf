package controller;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Store;

import org.apache.poi.ss.usermodel.Sheet;

import controller.helpers.files.excel.ExcelProductList;
import controller.helpers.files.excel.ReadExcel;
import controller.helpers.files.excel.WriteExcel;
import controller.helpers.parsers.ParserColumnsFile;
import controller.helpers.parsers.ParserCompareFile;
import controller.helpers.parsers.ParserStoreFile;

public class Main {	

	public static void main(String[] args) {
		ReadExcel re = new ReadExcel();
		WriteExcel we = new WriteExcel();

		ParserColumnsFile parserColumnsFile = new ParserColumnsFile();
		ParserStoreFile parserStoreFile = new ParserStoreFile();
		ParserCompareFile parserCompareFile = new ParserCompareFile();
		ExcelProductList excelProductList = new ExcelProductList();

		Sheet columnsFile = re.ReadFile(Constants.INPUT_FOLDER_PATH + Constants.COLUMNS_FILE_NAME);
		List<Store> storesList = parserColumnsFile.iterateFile(columnsFile);
		
		for (Store store : storesList) {
			Sheet storeFile = re.ReadFile(Constants.INPUT_FOLDER_PATH + store.getStoreConfiguration().getFileName());
			parserStoreFile.iterateFile(storeFile, store);
		}

		Sheet compareFile = re.ReadFile(Constants.INPUT_FOLDER_PATH + Constants.COMPARE_FILE_NAME);
		ArrayList<Product> productsList = parserCompareFile.iterateFile(compareFile, storesList);

		ArrayList<ArrayList<String>> prepareExcelProductList = excelProductList.PrepareExcelProductList(storesList, productsList);
		ArrayList<String> headers = prepareExcelProductList.get(0);
		prepareExcelProductList.remove(0);
		
		we.WriteFile(Constants.OUTPUT_FOLDER_PATH + Constants.OUTPUT_FILE_NAME, Constants.OUTPUT_FILE_SHEET_NAME ,headers, prepareExcelProductList);
	}
	

}
