package salesTaxTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import saleTax.BuyProducts;
import saleTax.ProductsParser;


public class BuyProductTest {

	@Test
	public void testSingleProduct() {
		
		BuyProducts productsBuy = new BuyProducts();
		productsBuy.add(ProductsParser.parseProduct("1 book at 12.49"), ProductsParser.count("1 book at 12.49"));
		
		assertTrue (Math.abs((productsBuy.getTotalTax() - 1.50)) < 0.001);
		assertTrue (Math.abs((productsBuy.getTotalPrice() - 12.49)) < 0.001);
	}
	
	@Test
	public void testMultipleProducts() {
		
		BuyProducts productsBuy = new BuyProducts();
		productsBuy.add(ProductsParser.parseProduct("1 book at 12.49"), ProductsParser.count("1 book at 12.49"));
		productsBuy.add(ProductsParser.parseProduct("1 music CD at 14.99"), ProductsParser.count("1 music CD at 14.99"));
		productsBuy.add(ProductsParser.parseProduct("1 chocolate bar at 0.85"), ProductsParser.count("1 chocolate bar at 0.85"));
		
		System.out.println("testMultipleProducts******************");
		System.out.println(productsBuy.getTotalTax());
		assertTrue (Math.abs((productsBuy.getTotalTax() - 1.50)) < 0.001);
		assertTrue (Math.abs((productsBuy.getTotalPrice() - 28.33)) < 0.001);
	}
	
}
