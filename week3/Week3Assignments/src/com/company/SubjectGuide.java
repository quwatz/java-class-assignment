package com.company;

import java.util.Scanner;

abstract class Subject{
	int creditHours;
	String[] preRequisites = {};
	String[] coRequisites= {};
	/*abstract void showPreRequisites();
	abstract void showCoRequisites();*/
	public Subject(String[] pre, String[] co){
		this.preRequisites=pre;
		this.coRequisites=co;
	}
	
	void showPreRequisites() {
		System.out.println("the pre-requisites for this subject are: ");
		for (int i=0; i< preRequisites.length;i++) {
			System.out.println(preRequisites[i]);;
		}
	}
	void showCoRequisites() {
		System.out.println("the co-requisites for this subject are: ");
		for (int i=0; i< coRequisites.length;i++) {
			System.out.println(coRequisites[i]);;
		}
	}
	
}

class Math2 extends Subject{
	
	
	int creditHours = 3;
	static String[] preRequisites = {"Math 1","Math 0"};
	static String[] coRequisites = {"definite integral equations"};	
	public Math2() {
		super(preRequisites, coRequisites);	
	}
	
}
class Physics2 extends Subject{
	int creditHours = 2;
	static String[] preRequisites = {"Physics 1","Math 0"};
	static String[] coRequisites= {};
	public Physics2() {
		super(preRequisites, coRequisites);	
	}
	
}
public class SubjectGuide {

	public static void main(String[] args) {
		System.out.println("select a subject to show its respective informations: Math2 or Physics2");
		String answer = new Scanner(System.in).nextLine();
	
		switch (answer) {
		case "Math2":
		case "Math 2":
		case "math2":
		case "math 2":
			
			Math2 mSub = new Math2();
			mSub.showCoRequisites();
			mSub.showPreRequisites();
			System.out.println("this subject has "+mSub.creditHours+" credit hours");
			break;
		case "Physics 2":
		case "Physics2":
		case "physics2":
		case "physics 2":
			Physics2 fSub = new Physics2();
			fSub.showCoRequisites();
			fSub.showPreRequisites();
			System.out.println("this subject has "+fSub.creditHours+" credit hours");
			break;
		default:
			System.out.println("ERROR");
		}
		

	}

}
