package com.company;

public class LibraryCode {
    public static void main(String[] args){
    LibraryClass library = new LibraryClass();
    library.takeBook(3,"arshia");
    library.checkOwnership(3);
    library.returnBook(3);
    if (library.getAvailability(3)){
            library.checkOwnership(3);
            library.takeBook(3,"yeki dige");
            library.checkOwnership(3);
        }
    }
}
