package patterns.decorator;

public  class DarkBlast extends Beverage{

	static double cost = 1.8;
	private String size;
	
	public DarkBlast(String size) {
		this.size = size;
	}
	
	public DarkBlast() {
		this.size = BeverageConstants.SMALL;
	}
	@Override
	public String getDescription() {
		return "Dark Blast" +" " +  getSize();
	}

	@Override
	public double getCost() {
		String size = getSize();
		double cost ;
		switch(size) {
		case BeverageConstants.MEDIUM :
			cost = 5.0;
			break;
		case BeverageConstants.TALL :
			cost = 2.5;
			break;
		default: 
			cost = 7.5;
			break;
		}
		return cost;
	}

	@Override
	public String getSize() {
		return size;
	}

}
