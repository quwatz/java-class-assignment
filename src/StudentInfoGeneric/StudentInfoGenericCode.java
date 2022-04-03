package StudentInfoGeneric;

import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInfoGenericCode {

	public static void main(String[] args) {
		
		// create new student 
		StudentClassGeneric<String,Integer,String,ArrayList<Double>> stu1 = new StudentClassGeneric<String,Integer,String,ArrayList<Double>>();
		//set values -->
		stu1.setStudentName("pesare shoja");
		stu1.setStudentFatherName("pedare pesare shoja");
		stu1.setStudentID(1234);
		ArrayList<Double> gradesList = new ArrayList<Double>();
		Scanner scanner = new Scanner(System.in);
		/*for (int i=0;i<5;i++) {
			double d = 0.0d;
		  try{
			 d = scanner.nextDouble();
			}
			catch (InputMismatchException e){
			scanner.nextLine();
			}
			System.out.println("bruh");
			Double D = new Double(d);
			gradesList.add(D);
		}*/ //infinite loop? cheraa...
		gradesList.add(0.0);
		gradesList.add(5.0);
		gradesList.add(10.0);
		gradesList.add(15.0);
		gradesList.add(20.0);
		
		//System.out.println("i ran");
		stu1.setStudentGrades(gradesList);
		//print values -->
		System.out.println("the student's name is: "+ stu1.getStudentName());
		System.out.println("the student's ID is: "+ stu1.getStudentID());
		System.out.println("the name of the student's father is" + stu1.getStudentFatherName());
		System.out.println("and their grades are: ");
		for (Double d: stu1.getStudentGrades()) {
			System.out.println(d);
		}
	}

}
