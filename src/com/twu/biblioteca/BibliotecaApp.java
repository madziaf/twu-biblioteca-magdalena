package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    public static final ArrayList<Book> allBooks = new ArrayList<Book>();
    public static ArrayList<Book> availableBooks = new ArrayList<Book>();
    public static ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public static void main(String[] args) {
        populateBooksList();
        availableBooks = allBooks;
        System.out.println(welcomeMessage());

        while(true) {
            System.out.println(printMenu());
            String choice = getUserInput();
            executeMenuChoice(choice);
        }
    }

    private static void booksDetailsHeader() {
        System.out.println("Book List\nTitle\tAuthor\tYear Published");
    }

    private static void populateBooksList() {
        Book b1 = new Book("The Call of the Wild", "Jack London", "1903");
        Book b2 = new Book("Siddhartha", "Hermann Hesse", "1922");
        allBooks.add(b1);
        allBooks.add(b2);
    }

    public static String welcomeMessage() {
        String message = "Welcome to Biblioteca!";
        return message;
    }

    public static String booksDetails(ArrayList<Book> books) {
        String allBookDetails = "";
        for (Book book : books) {
            allBookDetails += book.details();
            allBookDetails += "\n";
        }
        return allBookDetails;
    }

    public static String printMenu() {
        String menu = "Main Menu - choose an option:\nL for List Books\tC for Checkout\tR for Return\tQ for Quit\n: ";
        return menu;
    }

    public static void executeMenuChoice(String choice) {
        if(choice.equals("L")) {
            booksDetailsHeader();
            System.out.println(booksDetails(availableBooks));
        } else if(choice.equals("C")) {
            BibliotecaApp.checkoutMsg();
            BibliotecaApp.checkoutBook();
        /*} else if(choice == "R") {
            BibliotecaApp.returnMsg();
            BibliotecaApp.returnBook(String title); */
         } else if(choice.equals("Q")) {
            BibliotecaApp.quitMsg();
            System.exit(0);
        } else {
            System.out.println("wrong menu choice");
        }
    }

    private static void checkoutBook() {
        String title = getUserInput();
        for (Book book : availableBooks) {
            if (book.getTitle().equals(title)) {
                availableBooks.remove(book);
                borrowedBooks.add(book);
                System.out.println("You checked out " + book.getTitle() + ". Enjoy it!");
            }
        }
        System.out.println("No book available. Repeat the title.");
        checkoutBook();
    }

    private static void checkoutMsg() {
        System.out.println("Which book would you like to checkout?\nTitle: ");
    }

    private static void quitMsg() {
        System.out.println("Thank you for visit in Biblioteca");
    }

    public static String getUserInput() {
        String input = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}

