package saleTax;

public class SaleTaxDecorator extends MainTaxDecorator {

	private ProductItemInterface prod;
	
	final double rate = 0.1;

	
	public SaleTaxDecorator(ProductItemInterface prod) {
		
		super(prod);
		this.prod = prod;
		
	}
	public String getProductName() {
		return this.prod.getProductName();
	}

	public boolean isProductImported() {
		return this.prod.isProductImported();
	}

	public boolean isProductExcepmt() {
		return this.prod.isProductExcepmt();
	}

	public double getProductPrice() {
		return this.prod.getProductPrice();
	}

	@Override
	double getTaxRate() {
		return rate;
	}

}
