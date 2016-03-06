package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static final ArrayList<Book> allBooks = new ArrayList<Book>();

    public static void main(String[] args) {
        populateBooksList();
        System.out.println(welcomeMessage());
        System.out.println("Book List\nTitle\tAuthor\tYear Published");
        System.out.println(booksDetails(allBooks));
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
        for (Book book: books) {
            allBookDetails += book.details();
            allBookDetails += "\n";
        }
        return allBookDetails;
    }
}

