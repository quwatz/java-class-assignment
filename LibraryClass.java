package com.company;

import java.util.Arrays;

public class LibraryClass {
    boolean[] books;
    {
        books = new boolean[25];
        Arrays.fill(books,true);
    }
    String[] owners = new String[25];

    boolean getAvailability(int index){
        return books[index];
    }
    void takeBook(int index,String owner){
        books[index] = false;
        owners[index]=owner;
    }
    void returnBook(int index){
        books[index]=true;
        owners[index]="";
    }
    void checkOwnership(int index){
        if (books[index]) System.out.println("currently,the book is not owned by anyone");
        else{
            System.out.println("book number "+(index+1)+" is currently in possession of "+owners[index]);
        }
    }
}
