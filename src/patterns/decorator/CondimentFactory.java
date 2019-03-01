package patterns.decorator;

public class CondimentFactory {
	
	Beverage addCodiment(Beverage beverage , String condimentType) {
		
		switch(condimentType) {
		case BeverageConstants.CHACOS_CODIMENT_TYPE :
			return new Chacos(beverage);
		case BeverageConstants.MOCHA_CODIMENT_TYPE : 
			return new Mocha(beverage);
		default :
				return beverage;
		}
	}
	
}
