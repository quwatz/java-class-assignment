package ClassActivity;

import java.util.Scanner;

public class UserCode {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);	
		CalculatorFactory calcFac = new CalculatorFactory();
		System.out.println("enter a two expression math operation:");
		String math = scanner.nextLine();
		int exp1 = (int)math.charAt(0)-48;
		int exp2 = (int)math.charAt(2)-48;
		Calculate calc = calcFac.Operation(math.charAt(1));
		System.out.println(math+" = "+ calc.calc(exp1, exp2));
		System.out.println(exp1+" "+exp2);
	}
}
