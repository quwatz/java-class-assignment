package CarBrands;
public class CarFactory {
	public CarClass getCarForBudget(int budget) {
		if (budget > 50000)
		{
			return new Benz();
		}
		else
			return new Pride();
	}
	public CarClass getCarByName(String name) {
		switch (name.toLowerCase()) {
		case "benz":
			return new Benz();
		case "pride":
		case "saypa":
			return new Pride();
		default:
			return null;
		}
		
	}

}
