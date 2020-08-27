package saleTax;

public abstract class MainTaxDecorator implements ProductItem{

	protected ProductItem prodItem;
	protected double rate;
	
	public MainTaxDecorator(ProductItem prod){
		this.prodItem = prod;
	}
	
	abstract double getTaxRate();
	
	public double getProductPriceWithTax() {
		// TODO Auto-generated method stub
		return 0;
	}

}
