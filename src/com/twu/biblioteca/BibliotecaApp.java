package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void printHelloMessage() {
        System.out.println(
                "====================================================================\n" +
                "== Welcome to Biblioteca, the The Online Bangalore Public Library ==\n" +
                "====================================================================\n");
    }

    public static int showMainMenu() {
        String menu = "\nMenu:\n" +
                "\t1. List Books\n" +
                "\t2. Borrow Book\n" +
                "\t3. Return Book\n" +
                "Choose ('0' to quit): ";
        System.out.print(menu);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static boolean isValidOption(int select) {
        return 1 <= select && select <= 3;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // for test
        Book.addSomeBooks();

        printHelloMessage();

        int select = 0;
        while ((select = showMainMenu()) != 0) {
            if (!isValidOption(select)) {
                System.out.println("Select a valid option!");
            } else {
                if (select == 1) {
                    Book.printAllBooks("\nAll Books in Biblioteca:\n"+
                            " Index              Title                                 Author        Year     Available?");
                    System.out.println("(Press RETURN to get back to menu.)");
                    in.nextLine();
                } else if (select == 2) {
                    System.out.print("Which book to borrow? Enter index: ");
                    int choose = in.nextInt();
                    if (choose < 0 || choose >= Book.getBooks().size() || !Book.getBooks().get(choose).checkout()) {
                        System.out.println("That book is not available.");
                    } else {
                        System.out.println("Thank you! Enjoy the book.");
                    }
                } else if (select == 3) {
                    System.out.print("Which book to return? Enter index: ");
                    int choose = in.nextInt();
                    if (choose < 0 || choose >= Book.getBooks().size() || !Book.getBooks().get(choose).returnBook()) {
                        System.out.println("That is not a valid book to return.");
                    } else {
                        System.out.println("Thank you for returning the book.");
                    }
                }
            }
        }

        System.out.println("\n\nThanks for using Biblioteca.");
    }
}
