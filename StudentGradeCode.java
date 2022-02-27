package com.company;

import java.util.Scanner;

public class StudentGradeCode {
    static Student stu = new Student();
    public static void main(String[] args){
        System.out.println("do you wish to add in more grades? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        switch (response){
            case "y":
                System.out.println("enter your grade followed by its factor: ");
                stu.addGrade(scanner.nextDouble(), scanner.nextDouble());
                main(args);
                break;
            case "n":
                exit();
                break;
            default:
                System.out.println("Invalid input");
                main(args);
        }
    }
    static void exit(){
        System.out.println("great! your GPA is: "+ stu.getAverage());
        String auxiliary = (stu.isOnProbation())? "ARE":"ARE NOT";
        System.out.println("and you "+ auxiliary+ " on academic probation!");
    }
}
