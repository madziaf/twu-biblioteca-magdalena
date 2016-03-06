package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void shouldReturnWelcomeMessage () {
        assertEquals("Welcome to Biblioteca!", BibliotecaApp.welcomeMessage() );
    }

    @Test
    public void shouldReturnBookDetails () {
        Book b = new Book("The Call of the Wild", "Jack London", "1903");
        assertEquals("The Call of the Wild\tJack London\t1903", b.details());
    }

    @Test
    public void shouldReturnAllBooksDetails () {
        ArrayList<Book> allBooks = new ArrayList<Book>();
        Book b1 = new Book("The Call of the Wild", "Jack London", "1903");
        Book b2 = new Book("Siddhartha", "Hermann Hesse", "1922");
        allBooks.add(b1);
        allBooks.add(b2);

        assertEquals("The Call of the Wild\tJack London\t1903\nSiddhartha\tHermann Hesse\t1922\n",
                BibliotecaApp.booksDetails(allBooks));
    }

}
