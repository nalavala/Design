package patterns.decorator;

public class DarkBlast extends Beverage{

	static double cost = 1.8;
	private String size;
	
	public DarkBlast(String size) {
		this.size = size;
	}
	@Override
	public String getDescription() {
		return "Dark Blast";
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
