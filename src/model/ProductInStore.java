package model;

public class ProductInStore {

	private String code;
	private String price;
	private String category;
	private String name;

	private int productKey;
	
	public ProductInStore(String code, String price, String category, String name) {
		this.setCode(code);
		this.setPrice(price);
		this.setCategory(category);
		this.setName(name);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductKey() {
		return productKey;
	}

	public void setProductKey(int productKey) {
		this.productKey = productKey;
	}

	

}
