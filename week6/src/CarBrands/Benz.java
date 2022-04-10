package CarBrands;

public class Benz extends CarClass{

	@Override
	public void propietaryFunction() {
		System.out.println("we're totally overpriced!");
	}
	public Benz() {
		setBrandName("Benz");
		setSpeed(200);
		setSound("WROOOOOM");
	}

}
