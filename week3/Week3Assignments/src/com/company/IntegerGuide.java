package com.company;

public class IntegerGuide implements MyInteger {
	@Override
	public boolean isOdd(int a) {
		return (a%2!=0);
	}
	@Override
	public boolean isEven(int a) {
		return (a%2==0);
	}
	@Override
	public boolean isNegative(int a) {
		return (a<0);
	}
	@Override
	public boolean isPositive(int a) {
		return (a>0);
	}
	@Override
	public boolean isZero(int a) {
		return (a==0);
	}
}