package salesTaxTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import saleTax.ImportedTaxDecorator;
import saleTax.Product;
import saleTax.ProductItem;
import saleTax.SaleTaxDecorator;

public class MainTaxDecoratorTest {
	
	@Test
	public void testGetPrice() {
		
		ProductItem item = new Product("Book",150.00);
		
		assertEquals(item.getProductName(), "Book");
		System.out.println(item.getProductPriceWithTax());
		assertTrue(Math.abs((item.getProductPriceWithTax() - 150.00)) < 0.001);
		
		item = new ImportedTaxDecorator(item);
		System.out.println(item.getProductPriceWithTax());
		assertTrue(Math.abs((item.getProductPriceWithTax() - 157.5)) < 0.001);


		item = new SaleTaxDecorator(item);
		System.out.println(item.getProductPriceWithTax());
		assertTrue(Math.abs((item.getProductPriceWithTax() - 172.5)) < 0.001);

		
		System.out.println(item.getProductPrice());
		assertTrue(Math.abs((item.getProductPrice() - 150.00)) < 0.001);
	}
	
	
	
}
