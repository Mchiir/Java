package Library;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("123456789", "Java Programming", "John Doe", 2020);
        Book book2 = new Book("987654321", "Python Basics", "Jane Smith", 2019);

        LibraryMember member1 = new LibraryMember(1, "Alice");
        LibraryMember member2 = new LibraryMember(2, "Bob");

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);
        library.borrowBook(member1, book1); // Test borrowing more than the limit
        library.borrowBook(member2, book2);
        library.borrowBook(member2, book1); // Test borrowing when not available
        library.returnBook(member1, book1);
        library.displayAvailableBooks();
        member1.displayBorrowedBooks();
        member2.displayBorrowedBooks();
    }
}
