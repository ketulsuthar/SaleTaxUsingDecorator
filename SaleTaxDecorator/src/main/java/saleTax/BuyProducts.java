package saleTax;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Set;


public class BuyProducts {
private final LinkedHashMap<ProductItem,Integer> productMap=new LinkedHashMap<ProductItem,Integer>(); 
	
	DecimalFormat df = new DecimalFormat("###.00");
	
	public void displayOrder() {
		System.out.println("Input: ");
		for ( ProductItem prod : productMap.keySet() ){
			System.out.println(productMap.get(prod) + " " + prod.getProductName() + " at " + df.format(prod.getProductPrice()));
		}	
		System.out.println();
	}
	
	public void add (ProductItem prod, int count){
		
		if(prod.isProductImported()) {
			prod = new ImportedTaxDecorator(prod);
		}
		
		if(prod.isProductExcepmt()) {
			prod = new SaleTaxDecorator(prod);
		}
		
		Integer c = this.productMap.get(prod);
		if(c != null)
			count++;
		
		this.productMap.put(prod, count);
	}
	
	public int getQuantity(Product prod){
		return productMap.get(prod);	
	}
	
	public double getTotalTax() {
		double taxtotal = 0;
		for (ProductItem prod : productMap.keySet()){			
			double totalProdPrice = prod.getProductPrice() * productMap.get(prod);
			taxtotal += prod.getProductPriceWithTax() - totalProdPrice;
		}
		return taxtotal;
	}

	public double getTotalPrice() {
		double total = 0;
		for (ProductItem prod : productMap.keySet()){		
			double subTotal = prod.getProductPrice() * productMap.get(prod);
			total += subTotal;
		}
		return Utility.roundProductPrice(total);
	}
	
	public void displayOrdered() {	
		double taxtotal = 0;
		double total = 0;
		System.out.println("Output: ");
		Set<ProductItem> taxedItems = productMap.keySet();
		for (ProductItem prod : taxedItems){		
			double taxPerProduct = prod.getProductPriceWithTax() * productMap.get(prod);
			double totalProdPrice = prod.getProductPrice() * productMap.get(prod);
			taxtotal += taxPerProduct - totalProdPrice;
			total +=  taxPerProduct;
			System.out.println(productMap.get(prod) + " " + prod.getProductName() + ": " +df.format(taxPerProduct));
		}
		total = Utility.roundProductPrice(total);
		System.out.print("Sales Taxes: "+df.format(taxtotal));
		System.out.print("  Total: "+df.format(total));
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		if(args.length > 0) { 
			for(String filename : args)
				Utility.getProductsFromFile(filename);
		} else
			System.out.println("Invalid Arguments!!");
		
	}
}
