package patterns.decorator;

public class Mocha extends CondimentDecorator {

	private Beverage beverage;
	static double cost = 0.15;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " Mocha, " ;
	}

	@Override
	public double getCost() {

		double cost = beverage.getCost();
		String size = getSize();
		switch(size) {
			case BeverageConstants.MEDIUM :
				cost += 1.5;
				break;
			case BeverageConstants.SMALL :
				cost += 1.0;
				break;
			case BeverageConstants.TALL :
				cost += 2.0;
				break;
		}
		return cost;
	}

	@Override
	public String getSize() {
		return beverage.getSize();
	}

}
