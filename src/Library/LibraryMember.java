package Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private int memberId;
    private String name;
    private List<Book> borrowedBooks;
    public LibraryMember(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 5) {
            borrowedBooks.add(book);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println(name + " has reached the maximum limit of borrowed books.");
        }
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(name + " returned " + book.getTitle());
    }
    public void displayBorrowedBooks() {
        System.out.println(name + "'s borrowed books:");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void setMemberId(int memberId) { this.memberId = memberId; }
    public void setName(String name) { this.name = name; }
    public void setBorrowedBooks(List<Book> borrowedBooks) { this.borrowedBooks = borrowedBooks; }
}