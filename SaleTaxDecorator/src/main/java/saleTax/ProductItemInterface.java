package saleTax;

public interface ProductItemInterface {
	
	String getProductName();
	boolean isProductImported();
	boolean isProductExcepmt();
	double getProductPrice();
	double getProductPriceWithTax();
}
