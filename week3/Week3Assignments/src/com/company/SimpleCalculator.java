package com.company;
import java.util.Scanner;
interface Operation{
	double Operate(double a,double b);
}
class Multiplier implements Operation {
	public double Operate(double a,double b) {
		return (double)a*b;
	}
}
class Divisor implements Operation {
	public double Operate(double a,double b) {
		return a/b;
	}
}
class Subtractor implements Operation {
	public double Operate(double a,double b) {
		return Math.abs(a-b);
	}
}
class Adder implements Operation {
	public double Operate(double a,double b) {
		return a+b;
	}
}

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("please enter two numbers");
		double input1 = userInput.nextDouble();
		double input2 = userInput.nextDouble();
		Adder adder = new Adder();
		Multiplier multiplier = new Multiplier();
		Subtractor subtractor = new Subtractor();
		Divisor divisor = new Divisor();
		System.out.println("a+b = "+adder.Operate(input1,input2));
		System.out.println("|a-b| = "+subtractor.Operate(input1,input2));
		System.out.println("a*b = "+multiplier.Operate(input1,input2));
		if (input2 !=0) System.out.println("a/b = "+divisor.Operate(input1,input2));

	}

}
