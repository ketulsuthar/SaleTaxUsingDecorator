package saleTax;

public class Product implements ProductItemInterface {
	
	private String productName;
	private double  productPrice;
	private boolean isProductImported;
	private boolean isProductExempt;
	
	public Product(String name, double price) {
		this.productName = name;
		this.productPrice = price;
		this.isProductImported = false;
		this.isProductExempt = false;
	}

	public boolean isProductExempt() {
		return isProductExempt;
	}

	public void setProductExempt(boolean isProductExempt) {
		this.isProductExempt = isProductExempt;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductImported(boolean isProductImported) {
		this.isProductImported = isProductImported;
	}

	public String getProductName() {
		return this.productName;
	}

	public boolean isProductImported() {
		return this.isProductImported;
	}

	public boolean isProductExcepmt() {
		return this.isProductExempt;
	}

	public double getProductPrice() {
		return this.productPrice;
	}

	public double getProductPriceWithTax() {
		return this.productPrice;
	}

}
