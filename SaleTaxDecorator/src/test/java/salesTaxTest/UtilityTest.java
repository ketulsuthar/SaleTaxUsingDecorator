package salesTaxTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import saleTax.Utility;


public class UtilityTest {
	
	@Test
	public void testIsExemptTrue() {
		assertTrue(Utility.isExempt("books"));
	}

	@Test
	public void testIsExemptFalse() {
		assertFalse(Utility.isExempt("books-test"));
	}
	
	@Test
	public void testNearestPriceTrue() {
		assertTrue((Utility.nearestPrice(4.04)) == 4.05);
	}
	
	@Test
	public void testNearestPriceFalse() {
		assertFalse((Utility.nearestPrice(4.19)) == 4.05);
	}

	@Test
	public void testRoundProductPriceTrue() {
		
		System.out.print((Utility.roundProductPrice(10.125456)));
		assertTrue(Utility.roundProductPrice(10.125456) == 10.13);
	}
	
	@Test
	public void testRoundProductPriceFalse() {
		
		assertFalse(Utility.roundProductPrice(10.1212) == 10.13);
	}

}
