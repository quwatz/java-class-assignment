package quadricequation;

import java.util.Scanner;

public class QuadricEquationCode {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the values of a, b, c in the equation:\nax^2 + bx + c = 0");
		double a=scan.nextInt(),b=scan.nextInt(),c=scan.nextInt();
		try {
			double delta = CalculateDelta(a,b,c);
			double x1 = (-b + Math.sqrt(delta))/(2*a);
			double x2 = (-b - Math.sqrt(delta))/(2*a);
			if (x1==x2) System.out.println(x1);  
			else System.out.println(x1+" & "+x2);
			
			
		}
		catch (Exception e) {
			System.out.println("problem occured: "+ e);
		}
	}
	static double CalculateDelta(double a,double b,double c) throws QuadricException {
		double delta = (b*b)-(4*(a*c));
		if (delta<0) throw new QuadricException("\nthis quadratic equation has no solution");
		else return delta;
	}
	

}
