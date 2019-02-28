package patterns.decorator;

public class HouseBlend extends Beverage {

	double cost = 2.0;
	private String size;

	public HouseBlend(String size) {
		this.size = size;
	}
	
	public HouseBlend() {
		this.size = BeverageConstants.SMALL;
	}
	
	@Override
	public String getDescription() {
		return "House Blend";
	}

	@Override
	public double getCost() {
		String size = getSize();
		double cost ;
		switch(size) {
		case BeverageConstants.MEDIUM :
			cost = 15.0;
			break;
		case BeverageConstants.TALL :
			cost = 20.5;
			break;
		default: 
			cost = 10.5;
			break;
		}
		return cost;
	}

	@Override
	public String getSize() {
		return size;
	}

	

}
