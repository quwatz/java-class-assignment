package com.company;

public class IntegerCode {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = -2;
		int zero = 0;
		IntegerGuide intGuide = new IntegerGuide();
		System.out.println(intGuide.isEven(num1));
		System.out.println(intGuide.isOdd(num2));
		System.out.println(intGuide.isNegative(num2));
		System.out.println(intGuide.isPositive(num2));
		System.out.println(intGuide.isZero(zero));
	}
}

