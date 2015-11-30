package controller.helpers.files.excel;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcel {

	public void WriteFile(String outputFilename, String sheetName, ArrayList<String> headers, ArrayList<ArrayList<String>> rows) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(sheetName);

			HSSFRow rowhead = sheet.createRow((short) 0);
			int headerIndex = 0;
			for (String header : headers) {
				rowhead.createCell(headerIndex).setCellValue(header);
				headerIndex++;
			}
			
			int rowIndex = 1;
			for (ArrayList<String> rowStrList : rows) {
				HSSFRow row = sheet.createRow(rowIndex);
				int cellIndex = 0;
				for (String cellValue : rowStrList) {
					row.createCell(cellIndex).setCellValue(cellValue);
					cellIndex++;			
				}	
				rowIndex++;
			}

			FileOutputStream fileOut = new FileOutputStream(outputFilename);
			workbook.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
}
