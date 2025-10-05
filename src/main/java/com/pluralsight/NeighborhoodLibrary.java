package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static Scanner input = new Scanner(System.in);
    public static int numBooks = 20;

    public static void main(String[] args) {

        Book[] library = new Book[30];

        library[0] = new Book(1, "978-1-4829-7351-0", "Effective Java");
        library[1] = new Book(2, "978-1-9273-4860-1", "Head First Into Java");
        library[2] = new Book(3, "978-1-3847-5921-2", "Clean Code Practices");
        library[3] = new Book(4, "978-1-7583-9402-3", "Design Patterns & Method Structures");
        library[4] = new Book(5, "978-1-6293-5718-4", "Java Concurrency in Practice");
        library[5] = new Book(6, "978-1-8437-2609-5", "Core Java Volume I");
        library[6] = new Book(7, "978-1-5927-3486-6", "Head First Into Logic Sequences");
        library[7] = new Book(8, "978-1-7364-9021-7", "The C Programming Language");
        library[8] = new Book(9, "978-1-4952-8673-8", "Introduction to Algorithms");
        library[9] = new Book(10, "978-1-2847-3951-9", "Java Cookbook - A Look Into Mash Potatoes");
        library[10] = new Book(11, "978-1-7365-8204-0", "Head First Into SQL");
        library[11] = new Book(12, "978-1-5829-4716-1", "Refactoring Code (DRY)");
        library[12] = new Book(13, "978-1-3948-5271-2", "The Pragmatic Programmer");
        library[13] = new Book(14, "978-1-8752-3460-3", "Agile Software Development");
        library[14] = new Book(15, "978-1-4938-5276-4", "Effective C++ Practices");
        library[15] = new Book(16, "978-1-6274-8391-5", "Learning SQL - Databases Evolved");
        library[16] = new Book(17, "978-1-3849-7261-6", "Test Driven Development");
        library[17] = new Book(18, "978-1-5928-3746-7", "The Mythical Man-Month");
        library[18] = new Book(19, "978-1-7392-5816-8", "Fluent Python Practices");
        library[19] = new Book(20, "978-1-4829-7365-9", "Learning Java - Understanding the Basics");

        while (true) {
            System.out.print("\nLibrary Home Screen\n===================\n1 - Show Available Books\n2 - Show Checked Out Books\n3 - Exit\nEnter your choice (1 - 3): ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    displayAvailableBooks(library);
                    break;

                case 2:
                    displayCheckedOutBooks(library);
                    break;

                case 3:
                    System.out.println("\nExiting the library.");
                    input.close();
                    return;

                default:
                    System.out.println("\nInvalid home screen option.");
                    break;
            }
        }
    }

    public static void displayAvailableBooks(Book[] library) {
        System.out.println("Available Books\n===============");
        for (int i = 0; i < numBooks; i++) {
            Book currentBook = library[i];
            if (!currentBook.isCheckedOut()) {
                System.out.println(library[i]);
            }
        }

        System.out.println("===============");
        System.out.print("\nEnter book ID to check out a book (0 to return): ");
        int option = input.nextInt();
        input.nextLine();

        if (option == 0) {
            System.out.println("\n==Returning to Home Screen==");
            return;
        }

        boolean found = false;
        for (int i = 0; i < numBooks; i++) {
            Book currentBook = library[i];
            if (currentBook != null && currentBook.getId() == option) {
                if (!currentBook.isCheckedOut()) {
                    System.out.print("\nEnter your name: ");
                    String nameOption = input.nextLine();
                    currentBook.checkOut(nameOption);
                    System.out.println("\nBook \"" + currentBook.getTitle() +
                            "\" is checked out to " + nameOption + ".\n\n==Returning to Home Screen==");
                    found = true;
                } else {
                    System.out.println("\nSorry, that book is already checked out to " + currentBook.getCheckOutTo() + ".\n\n==Returning to Home Screen==");
                    found = true;
                    break;
                }
                break;
            }
        }
        if (!found) {
            System.out.println("\nNot a valid book ID.\n\n==Returning to Home Screen==");
        }
    }

    public static void displayCheckedOutBooks(Book[] library) {
        System.out.println("\nChecked Out Books\n=================");
        for (int i = 0; i < numBooks; i++) {
            Book currentBook = library[i];
            if (currentBook.isCheckedOut()) {
                System.out.println(library[i]);
            }
        }

        System.out.println("=================");
        System.out.print("\nEnter C to check in a book, or X to return: ");
        String option = input.nextLine();

        if (option.equalsIgnoreCase("X")) {
            System.out.println("\n==Returning to Home Screen==");
            return;
        } else if (option.equalsIgnoreCase("C")) {
            System.out.print("\nEnter book ID to check in book: ");
            int idOption = input.nextInt();
            input.nextLine();

            boolean found = false;
            for (int i = 0; i < numBooks; i++) {
                Book currentBook = library[i];
                if (currentBook != null && currentBook.getId() == idOption) {
                    found = true;
                    if (currentBook.isCheckedOut()) {
                        currentBook.checkIn();
                        System.out.println("\nThank you for returning \"" + currentBook.getTitle() + "\".\n\n==Returning to Home Screen==");
                    } else {
                        System.out.println("\nSorry, the book \"" + currentBook.getTitle() + "\" is currently not checked out.\n\n==Returning to Home Screen==");
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("\nNot a valid book ID.\n\n==Returning to Home Screen==");
            }

        } else {
            System.out.println("\nInvalid selection, please enter C or X.\n\n==Returning to Home Screen=="); // Will handle invalid user input (not C or X)
        }
    }

}


// Notes: default switch condition not printing out when user inputs a non-int value (it throws an exception) - input validation condition in method,
// (already structured additional exception conditions) adding another if condition to display if no books are currently checked out/in, AND where to place the input.close() statement for scope,
// could split displayAvailableBooks method into 3 methods - displayBooks(), showAvailableBooks(), checkOutBook().

