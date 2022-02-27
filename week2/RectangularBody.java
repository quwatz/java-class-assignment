package com.company;

public class RectangularBody {
    int x,y;
    void setDimensions(int a,int b){
        x = a;
        y = b;
    }
    double getPerimeter(){
        return 2 * (x+y);
    }
    double getArea(){
        return x*y;
    }

}
