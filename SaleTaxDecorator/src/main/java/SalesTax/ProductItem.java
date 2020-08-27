package SalesTax;

public interface ProductItem {
	
	String getName();
	boolean isProductImported();
	boolean isProductExcepmt();
	double getProductPrice();
	double getProductPriceWithTax();

}
