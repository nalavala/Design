package patterns.decorator;

public class StarBucks {

	public static void main(String args[]) {
		
		/*
		 * Here the type of beverages varies based on requirements
		 * When requirements change we need to reopen this code for deletion or addition of beverages
		 */
		//Beverage beverage = new HouseBlend();
		
		/**
		 * we are using factory pattern which takes the type of beverage and creates beverage and pass to star bucks
		 * 1. factory is place where creation takes place, in future addition and deleting should take care by factory
		 * 		and we are moved all requirement that vary in one so if need to change we should change in one place
		 */
		BeverageFactory factory = new BeverageFactory();
		Beverage beverage = factory.getBeverage(BeverageConstants.DARKBLAST_TYPE, BeverageConstants.MEDIUM);
		beverage = new Mocha(beverage);
		beverage = new Chacos(beverage);
		System.out.println(beverage.getDescription() + " $" +beverage.getCost());
		
	}
}
