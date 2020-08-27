package saleTax;


public abstract class MainTaxDecorator implements ProductItemInterface{

	protected ProductItemInterface prodItem;
	protected double rate;
	
	public MainTaxDecorator(ProductItemInterface prod){
		this.prodItem = prod;
	}
	
	abstract double getTaxRate();
	
	public double getProductPriceWithTax() {
		double tax = Utility.nearestPrice(this.prodItem.getProductPrice() * this.getTaxRate());
		return Utility.roundProductPrice(this.prodItem.getProductPriceWithTax() + tax); 
	}

}
