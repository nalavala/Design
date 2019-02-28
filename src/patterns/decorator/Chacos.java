package patterns.decorator;

public class Chacos extends CondimentDecorator {

	private Beverage beverage;
	static double cost = 0.10;

	public Chacos(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " Chaco, ";
	}

	@Override
	public double getCost() {

		double cost = beverage.getCost();
		String size = getSize();
		switch(size) {
			case BeverageConstants.MEDIUM :
				cost += 2.0;
				break;
			case BeverageConstants.SMALL :
				cost += 1.5;
				break;
			case BeverageConstants.TALL :
				cost += 2.25;
				break;
		}
		return cost;
	}

	@Override
	public String getSize() {
		return beverage.getSize();
	}

}
