package com.pluralsight;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkOutTo = checkOutTo;
    }


}
