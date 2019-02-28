package patterns.decorator;

public class BeverageFactory {
	
	public Beverage getBeverage(String type,String size) {
		switch(type) {
		case BeverageConstants.DARKBLAST_TYPE :
			return new DarkBlast(size);
		case BeverageConstants.HOUSEBLEND_TYPE :
			return new HouseBlend(size);
		default :
			return null;
		}
	}

}
