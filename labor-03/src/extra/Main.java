package extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Library library = new Library("library", "215/B", books);
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "978", 307));
        library.addBook(new Book("Lord of the Rings", " J.R.R. Tolkien", "888", 450));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "500", 150));
        library.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "908", 350));

        System.out.println(library);
        System.out.println();

        for (int i = 0; i < library.countBooks(); i++) {
            System.out.println(library.getBooks().get(i));
        }
        // Using Scanner for Getting Input from User
        System.out.print("\nEnter the title: ");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();

        System.out.println(library.findBook(title));
        System.out.println();
        if (library.findBook(title) != null) {
            library.checkoutBook(library.findBook(title));
            System.out.println(library.findBook(title).getTitle() + "'s checked out value is: " + library.findBook(title).isCheckedOut() + "\n");


            library.returnBook(library.findBook(title));
            System.out.println(library.findBook(title).getTitle() + "'s checked out value is: " + library.findBook(title).isCheckedOut() + "\n");

            library.removeBook(library.findBook(title));

            for (int i = 0; i < books.size(); i++) {
                System.out.println(library.getBooks().get(i));
            }
            if (library.countBooks() == 1) {
                System.out.println("\nThere is " + library.countBooks() + " book in the library.");
            } else if (library.countBooks() > 1) {
                System.out.println("\nThere are " + library.countBooks() + " books in the library.");
            } else {
                System.out.println("\nThere are no books in the library!");
            }
        }
        else {
            System.out.println("There are no books with the given name!");
        }
        library.sortBooks();
        System.out.println();

        System.out.println("sort by isbn:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(library.getBooks().get(i));
        }
        System.out.print("\n(author, pages)\nEnter the sort mode: ");
        String sortBy =in.nextLine();
        library.sortBy_Author_Pages(books, sortBy);

        System.out.println();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(library.getBooks().get(i));
        }

        }
    }
