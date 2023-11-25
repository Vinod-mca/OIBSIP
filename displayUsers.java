import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String category;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Category: " + category;
    }
}

class Member {
    String name;
    String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }
}

class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addBook(String title, String author, String category) {
        Book book = new Book(title, author, category);
        books.put(title, book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(String title) {
        if (books.containsKey(title)) {
            books.remove(title);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books available:");
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
    }

    public void issueBook(String title, String memberName) {
        if (books.containsKey(title) && members.containsKey(memberName)) {
            System.out.println("Book issued to " + memberName + " successfully!");
        } else {
            System.out.println("Book or member not found!");
        }
    }

    public void returnBook(String title) {
        if (books.containsKey(title)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void addUser(String name, String email) {
        Member member = new Member(name, email);
        members.put(name, member);
        System.out.println("User added successfully!");
    }

    public void displayUsers() {
        if (members.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("Users registered:");
            for (Member member : members.values()) {
                System.out.println(member);
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("The Catcher in the Rye", "VIJAY thalapathy", "Fiction");
        library.addBook("To Kill a Mockingbird", "Isha", "Classics");

        library.addUser("vinod", "vinoddharavath@example.com");
        library.addUser("vinod", "vinoddharavath@example.com");

        // Sample usage
        library.displayBooks();
        library.displayUsers();

        // Admin operations
        library.removeBook("To Kill a Mockingbird");
        library.displayBooks();

        // User operations
        library.issueBook("The Catcher in the Rye", "VIJAY thalapathy");
        library.returnBook("The Catcher in the Rye");
    }
}
