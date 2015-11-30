package model;

public class StoreConfiguration {
	private String fileName;
	private String storeName;
	private int codeColumn;
	private int priceColumn;
	private int categoryColumn;
	private int nameColumn;
	
	public int getCodeColumn() {
		return codeColumn;
	}
	public void setCodeColumn(int codeColumn) {
		this.codeColumn = codeColumn;
	}
	public int getPriceColumn() {
		return priceColumn;
	}
	public void setPriceColumn(int priceColumn) {
		this.priceColumn = priceColumn;
	}
	public int getCategoryColumn() {
		return categoryColumn;
	}
	public void setCategoryColumn(int categoryColumn) {
		this.categoryColumn = categoryColumn;
	}
	public int getNameColumn() {
		return nameColumn;
	}
	public void setNameColumn(int nameColumn) {
		this.nameColumn = nameColumn;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
