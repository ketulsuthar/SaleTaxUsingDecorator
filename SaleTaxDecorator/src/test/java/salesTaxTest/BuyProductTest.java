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
		
		productsBuy.displayOrder();
		productsBuy.displayOrdered();
		assertTrue (Math.abs((productsBuy.getTotalTax() - 0.00)) < 0.001);
		assertTrue (Math.abs((productsBuy.getTotalPrice() - 12.49)) < 0.001);
		
	}
	
	@Test
	public void testInput1() {
		
		BuyProducts productsBuy = new BuyProducts();
		productsBuy.add(ProductsParser.parseProduct("1 book at 12.49"), ProductsParser.count("1 book at 12.49"));
		productsBuy.add(ProductsParser.parseProduct("1 music CD at 14.99"), ProductsParser.count("1 music CD at 14.99"));
		productsBuy.add(ProductsParser.parseProduct("1 chocolate bar at 0.85"), ProductsParser.count("1 chocolate bar at 0.85"));
		
		productsBuy.displayOrder();
		productsBuy.displayOrdered();
		
		assertTrue (Math.abs((productsBuy.getTotalTax() - 1.50)) < 0.001);
		assertTrue (Math.abs((productsBuy.getTotalPrice() - 29.83)) < 0.001);
		
	}
	
	@Test
	public void testInput2() {
		
		BuyProducts productsBuy = new BuyProducts();
		productsBuy.add(ProductsParser.parseProduct("1 imported box of chocolates at 10.00"), ProductsParser.count("1 imported box of chocolates at 10.00"));
		productsBuy.add(ProductsParser.parseProduct("1 imported bottle of perfume at 47.50"), ProductsParser.count("1 imported bottle of perfume at 47.50"));
		
		productsBuy.displayOrder();
		productsBuy.displayOrdered();
		
		assertTrue (Math.abs((productsBuy.getTotalTax() - 7.65)) < 0.001);
		assertTrue (Math.abs((productsBuy.getTotalPrice() - 65.15)) < 0.001);
		
	}
	
	
	@Test
	public void testInput3() {
		
		BuyProducts productsBuy = new BuyProducts();
		productsBuy.add(ProductsParser.parseProduct("1 imported bottle of perfume at 27.99"), ProductsParser.count("1 imported bottle of perfume at 27.99"));
		productsBuy.add(ProductsParser.parseProduct("1 bottle of perfume at 18.99"), ProductsParser.count("1 bottle of perfume at 18.99"));
		productsBuy.add(ProductsParser.parseProduct("1 packet of headache pills at 9.75"), ProductsParser.count("1 packet of headache pills at 9.75"));
		productsBuy.add(ProductsParser.parseProduct("1 box of imported chocolates at 11.25"), ProductsParser.count("1 box of imported chocolates at 11.25"));
		
		productsBuy.displayOrder();
		productsBuy.displayOrdered();
		
		assertTrue (Math.abs((productsBuy.getTotalTax() - 6.70)) < 0.001);
		assertTrue (Math.abs((productsBuy.getTotalPrice() - 74.68)) < 0.001);
		
	}
	
}
