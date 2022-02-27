package com.company;

public class EquationThing {
    double a,b,c,d,e,f;
    double x,y;
    void setParameters(double i,double j,double m,double k,double l,double n){
        a=i;
        b=j;
        e=m;
        c=k;
        d=l;
        f=n;
    }
    boolean isSolvable(){
        return ((a/b) != (c/d));
    }
    void solve(){
        x=(e*d-b*f)/(a*d-b*c);
        y=(a*f-e*c)/(a*d-b*c);
        System.out.println("x: "+x+"\ny: "+y);
    }

}
