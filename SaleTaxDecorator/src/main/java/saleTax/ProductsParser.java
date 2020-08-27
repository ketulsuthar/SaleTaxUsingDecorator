package saleTax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductsParser {
	
	private static final String PRODUCT_REGEX = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";
	
	public static ProductItem parseProduct(String line) {
		
		Matcher matcher = matching(line);
		String productName = matcher.group(2).trim();
	
		Product item = new Product(productName, Double.valueOf(matcher.group(4)));
		if(productName.contains("imported"))
			item.setProductImported(true);
		if(Utility.isExempt(productName))
			item.setProductExempt(true);
	
		return item;
	}
	
	public static int count(String line) {
		return Integer.valueOf(matching(line).group(1));
	}
	
	public static Matcher matching(String line) {
		Pattern pattern = Pattern.compile(PRODUCT_REGEX);
		Matcher matcher = pattern.matcher(line);
		matcher.find();
		return matcher;
	}
	
	public static boolean productMatched(String productsStr) {
		return Pattern.matches(PRODUCT_REGEX, productsStr);
	}
	


}
