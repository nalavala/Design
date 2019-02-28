package patterns.decorator;

public class HouseBlend extends Beverage {

	double cost = 2.0;
	private String size;

	public HouseBlend(String size) {
		this.size = size;
	}
	@Override
	public String getDescription() {
		return "House Blend";
	}

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public String getSize() {
		return size;
	}

	

}
