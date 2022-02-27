package com.company;

public class Student {
    double average=0,facsum=0;
    void addGrade(double grade,double factor){
        average = ((average * facsum) + (grade*factor))/(facsum+factor);
        facsum += factor;
    }
    double getAverage(){
        return average;
    }
    boolean isOnProbation(){
        return (average < 12);
    }
}
