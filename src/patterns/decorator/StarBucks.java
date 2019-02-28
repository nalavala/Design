package patterns.decorator;

public class StarBucks {

	public static void main(String args[]) {
		Beverage beverage = new HouseBlend(BeverageConstants.MEDIUM);
		beverage = new Mocha(beverage);
		beverage = new Chacos(beverage);
		System.out.println(beverage.getDescription() + " $" +beverage.getCost());
	}
}
