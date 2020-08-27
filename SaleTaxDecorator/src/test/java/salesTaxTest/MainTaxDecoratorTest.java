package salesTaxTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import saleTax.ImportedTaxDecorator;
import saleTax.Product;
import saleTax.ProductItemInterface;
import saleTax.SaleTaxDecorator;

public class MainTaxDecoratorTest {
	
	@Test
	public void testGetPrice() {
		
		ProductItemInterface item = new Product("Book",150.00);
		
		assertEquals(item.getProductName(), "Book");
		assertTrue(Math.abs((item.getProductPriceWithTax() - 150.00)) < 0.001);
		
		item = new ImportedTaxDecorator(item);
		assertTrue(Math.abs((item.getProductPriceWithTax() - 157.5)) < 0.001);


		item = new SaleTaxDecorator(item);
		assertTrue(Math.abs((item.getProductPriceWithTax() - 172.5)) < 0.001);

	
		assertTrue(Math.abs((item.getProductPrice() - 150.00)) < 0.001);
	}
	
	
	
}
