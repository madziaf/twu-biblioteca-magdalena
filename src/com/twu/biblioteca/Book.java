package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String published;

    public Book(String bookTitle, String bookAuthor, String publishedAt) {
        title = bookTitle;
        author = bookAuthor;
        published = publishedAt;
    }

    public String details() {
        String details = title + "\t" + author + "\t" + published;
        return details;
    }


}
