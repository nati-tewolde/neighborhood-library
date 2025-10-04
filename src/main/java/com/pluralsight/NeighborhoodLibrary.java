package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static Scanner input = new Scanner(System.in);
    public static int numBooks = 20;

    public static void main(String[] args) {

        Book[] library = new Book[30];

        library[0] = new Book(1, "978-1-4829-7351-0", "Effective Java");
        library[1] = new Book(2, "978-1-9273-4860-1", "Head First Java");
        library[2] = new Book(3, "978-1-3847-5921-2", "Clean Code");
        library[3] = new Book(4, "978-1-7583-9402-3", "Design Patterns");
        library[4] = new Book(5, "978-1-6293-5718-4", "Java Concurrency in Practice");
        library[5] = new Book(6, "978-1-8437-2609-5", "Core Java Volume I");
        library[6] = new Book(7, "978-1-5927-3486-6", "Head First Design Patterns");
        library[7] = new Book(8, "978-1-7364-9021-7", "The C Programming Language");
        library[8] = new Book(9, "978-1-4952-8673-8", "Introduction to Algorithms");
        library[9] = new Book(10, "978-1-2847-3951-9", "Java Cookbook");
        library[10] = new Book(11, "978-1-7365-8204-0", "Head First SQL");
        library[11] = new Book(12, "978-1-5829-4716-1", "Refactoring");
        library[12] = new Book(13, "978-1-3948-5271-2", "The Pragmatic Programmer");
        library[13] = new Book(14, "978-1-8752-3460-3", "Agile Software Development");
        library[14] = new Book(15, "978-1-4938-5276-4", "Effective C++");
        library[15] = new Book(16, "978-1-6274-8391-5", "Learning SQL");
        library[16] = new Book(17, "978-1-3849-7261-6", "Test Driven Development");
        library[17] = new Book(18, "978-1-5928-3746-7", "The Mythical Man-Month");
        library[18] = new Book(19, "978-1-7392-5816-8", "Fluent Python");
        library[19] = new Book(20, "978-1-4829-7365-9", "Learning Java");

        while (true) {
            System.out.print("Library Home Screen\n===================\n1 - Show Available Books\n2 - Show Checked Out Books\n3 - Exit\nEnter your choice (1 - 3): ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    displayAvailableBooks(library);
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("\nExiting the library.");
                    return;

                default:


            }
        }

    }

    public static void displayAvailableBooks(Book[] library) {
        System.out.println("Available Books\n===============\n");
        for (int i = 0; i < numBooks; i++) {
            Book currentBook = library[i];
            if (!currentBook.isCheckedOut()) {
                System.out.println(library[i]);
            }
        }

        System.out.print("\nEnter book ID to check out a book (0 to return): ");
        int option = input.nextInt();
        input.nextLine();


/*
        String nameOption = "";
        if (option <= numBooks) {
            System.out.print("\nEnter your name: ");
            nameOption = input.nextLine();
        }
*/

        boolean found = false;
        for (int i = 0; i < numBooks; i++) {
            Book currentBook = library[i];
            if (currentBook != null && currentBook.getId() == option) {
                if (!currentBook.isCheckedOut()) {
                    System.out.print("\nEnter your name: ");
                    String nameOption = input.nextLine();
                    currentBook.checkOut(nameOption);
                    System.out.println("\nBook \"" + currentBook.getTitle() +
                            "\" is checked out to " + nameOption + ".\n");
                } else {
                    System.out.println("\nSorry, that book is already checked out to " + currentBook.getCheckOutTo() + ".\n");
                }
                found = true;
                break;
            }

        }
        if (!found && option != 0) {
            System.out.println("\nNot a valid book ID.\n");
        }
    }

/*    public static void displayCheckOut(Book[] library) {
        System.out.println("Enter the ID of the book to check out (0 to cancel): ");
        int option = input.nextInt();
        input.nextLine();

        String nameOption = "";
        if (option != 0) {
            System.out.println("Enter your name: ");
            nameOption = input.nextLine();
        }

        for (int i = 0; i < 20; i++) {
            Book currentBook = library[i];
            if (currentBook.getId() == option) {
                currentBook.checkOut(nameOption);
            }
        }
    }*/

}


// could split into 3 methods - displayBooks(), showAvailableBooks(), checkOutBook()
// keep committing to GITHUB
// close scanner (input)
