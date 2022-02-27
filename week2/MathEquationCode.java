package com.company;

import java.util.Scanner;

public class MathEquationCode {
    public static void main(String[] args){
        EquationThing equation = new EquationThing();
        System.out.println("enter the parameters for: \nax+by=e\ncx+dy=f\n(in order: a,b,e,c,d,f)");
        Scanner scanner = new Scanner(System.in);
        equation.setParameters(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble());
        if (equation.isSolvable()) equation.solve();
        else System.out.println("ERROR");

    }
}
