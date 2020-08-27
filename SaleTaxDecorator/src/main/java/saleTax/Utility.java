package saleTax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;


public class Utility {
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	private static Set<String> exemptProducts = null;
	static	{
		exemptProducts = new HashSet<String>();
		exemptProducts.add("book");
		exemptProducts.add("books");
		exemptProducts.add("packet of headache pills");
		exemptProducts.add("box of imported chocolates");
		exemptProducts.add("imported box of chocolates");
		exemptProducts.add("box of chocolates");
		exemptProducts.add("chocolate");
		exemptProducts.add("chocolate bar");
	}
	
	public static boolean isExempt(String name) {
		return exemptProducts.contains(name);
	}
	
	public static double roundProductPrice(double price) {

		//return new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
		df.setRoundingMode(RoundingMode.HALF_UP);
		return new Double(df.format(price));
	}
	
	
	static public double nearestPrice(double price) {

		//return new BigDecimal(Math.ceil(price * 20)/20).setScale(2,RoundingMode.HALF_UP).doubleValue();
		df.setRoundingMode(RoundingMode.HALF_UP);
		return new Double(df.format(Math.ceil(price * 20)/20));

	}
	
	public static void getProductsFromFile(String fileName) {
		
		BuyProducts productsBuy = new BuyProducts();
		try {
			String line;
		    BufferedReader in = new BufferedReader(new FileReader(fileName));
		    while ((line = in.readLine()) != null) {
		    	
		    	if(!line.isEmpty() && ProductsParser.productMatched(line)) {
		    		productsBuy.add(ProductsParser.parseProduct(line), ProductsParser.count(line)); 
		    	}
		    	else {
		    		if(!line.isEmpty())
		    			System.out.println("Ivalid product format: " + line);
		    	}
		    }
		    in.close();
		} catch (IOException e) {
			System.out.println("error:" + e.getMessage());
			return;
		}
		
		productsBuy.displayOrder();
		productsBuy.displayOrdered();
	}


}
