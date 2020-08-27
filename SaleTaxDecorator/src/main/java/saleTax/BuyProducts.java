package saleTax;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Set;


public class BuyProducts {
	
	private final LinkedHashMap<ProductItemInterface,Integer> productMap = new LinkedHashMap<ProductItemInterface,Integer>(); 
	
	DecimalFormat df = new DecimalFormat("###.00");
	
	public void displayOrder() {
		System.out.println("Input: ");
		for ( ProductItemInterface prod : productMap.keySet() ){
			System.out.println(productMap.get(prod) + " " + prod.getProductName() + " at " + df.format(prod.getProductPrice()));
		}	
		System.out.println();
	}
	
	public void add (ProductItemInterface prod, int count){
		
		if(prod.isProductImported()) {
			prod = new ImportedTaxDecorator(prod);
		}
		
		if(!prod.isProductExcepmt()) {
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
		for (ProductItemInterface prod : productMap.keySet()){	
			
			double totalProdPrice = prod.getProductPriceWithTax() * productMap.get(prod);
			double subTotal = prod.getProductPrice() * productMap.get(prod);
			taxtotal += totalProdPrice - subTotal;

		}
		return Utility.roundProductPrice(taxtotal);
	}

	public double getTotalPrice() {
		double total = 0;
		for (ProductItemInterface prod : productMap.keySet()){		
			double subTotal = prod.getProductPriceWithTax()* productMap.get(prod);
			total += subTotal;
		}
		return Utility.roundProductPrice(total);
	}
	
	public void displayOrdered() {	
		double taxtotal = 0;
		double total = 0;
		System.out.println("Output: ");
		Set<ProductItemInterface> taxedItems = productMap.keySet();
		for (ProductItemInterface prod : taxedItems){		
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
		
		//Utility.getProductsFromFile("i.txt");
		
		if(args.length > 0) { 
			for(String filename : args)
				Utility.getProductsFromFile(filename);
		} else
			System.out.println("Invalid Arguments!!");
		
	}
}
