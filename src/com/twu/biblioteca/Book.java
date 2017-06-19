package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzx on 2017/6/19.
 */
public class Book {
    private static List<Book> books = new ArrayList<Book>();
    public static List<Book> getBooks() { return books; }

    public String title;
    public String author;
    public int yearPublish;
    public boolean isAvailable = false;

    private Book() {}
    public Book(String title, String author, int yearPublish) {
        this.title = title;
        this.author = author;
        this.yearPublish = yearPublish;
        this.isAvailable = true;
    }

    public String toString() {
        return String.format("%-40s %20s %6d %10s",
                title,
                author,
                yearPublish,
                (isAvailable?"true":"false"));
    }

    public static void addBook(Book book) {
        books.add(book);
    }
    public boolean checkout() {
        if (!isAvailable) {
            return false; // "That book is not available."
        }
        isAvailable = false;
        return true; // "Thank you! Enjoy the book".
    }

    public boolean returnBook() {
        if (isAvailable) {
            return false; // "That is not a valid book to return."
        }
        isAvailable = true;
        return true; // "Thank you for returning the book."
    }

    public static void printAllBooks(String header) {
        System.out.println(header);
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isAvailable) {
                System.out.println(String.format("%6d. %s", i, books.get(i)));
            }
        }
    }

    public static void addSomeBooks() {
        addBook(new Book("Managing Projects with GNU Make", "Robert Mecklenburg", 2004));
        addBook(new Book("A Theory of Fun for Game Design", "Raph Koster", 2004));
        addBook(new Book("The Art of UNIX Programming", "Eric S. Raymond", 2003));
        addBook(new Book("The Elements of Style", "William Strunk Jr.", 1999));
        addBook(new Book("The Practice of Programming", "Brian W. Kernighan", 1992));
    }

}
