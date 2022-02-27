package com.company;

import java.util.Scanner;

public class RectangleCode {

    public static void main(String[] args) {
	    RectangularBody shape = new RectangularBody();
        System.out.println("Enter the dimensions of your first rectangular shape: ");
        Scanner scanner = new Scanner(System.in);
        shape.setDimensions(scanner.nextInt(),scanner.nextInt());
        System.out.println("the Area of your shape is: "+shape.getArea()+"\nand the Perimeter of your shape is: "+shape.getPerimeter());
        System.out.println("Enter the dimensions of your second rectangular shape: ");
        shape.setDimensions(scanner.nextInt(),scanner.nextInt());
        System.out.println("the Area of your shape is: "+shape.getArea()+"\nand the Perimeter of your shape is: "+shape.getPerimeter());
    }
}
