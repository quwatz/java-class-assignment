package CarBrands;
import java.util.Scanner;
public class BuyerCode {
	public static void main(String args[]) {
		CarFactory carFactory = new CarFactory();
		CarClass car=null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("are you on a budget? (y/n)");
		String answer = scanner.next();
		
		switch (answer) {
		case "y":
			System.out.println("enter your budget!");
			car= carFactory.getCarForBudget(scanner.nextInt());
			break;
		case "n":
			scanner.nextLine();
			System.out.println("what brand do you want?(pride/benz)");
			car= carFactory.getCarByName(scanner.nextLine());
			break;
		default:
			System.out.println("something went wrong:/");
			break;
		}
		car.honk();
		car.flex();
		car.propietaryFunction();
		
	}
	
}
