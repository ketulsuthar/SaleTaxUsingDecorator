package SalesTax;

public interface ProductItem {
	
	String getProductName();
	boolean isProductImported();
	boolean isProductExcepmt();
	double getProductPrice();
	double getProductPriceWithTax();

}
