package Library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBooks;
    private List<Book> borrowedBooks;

    public Library() {
        this.availableBooks = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (availableBooks.contains(book)) {
            member.borrowBook(book);
            availableBooks.remove(book);
            borrowedBooks.add(book);
        } else {
            System.out.println("Book " + book.getTitle() + " is not available.");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (borrowedBooks.contains(book)) {
            member.returnBook(book);
            borrowedBooks.remove(book);
            availableBooks.add(book);
        } else {
            System.out.println("Book " + book.getTitle() + " is not borrowed by " + member.getName());
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }
}