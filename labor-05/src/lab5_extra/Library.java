package lab5_extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private  String address;
    private ArrayList<Book> books;
    private String name;

    public Library(String name, String address, ArrayList<Book> books){
        this.name = name;
        this.address = address;
        this.books = books;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        int db = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).equals(book)){
                books.remove(book);
                db = 1;
            }
        }
        if(db == 0){
            System.out.println("this book is not found");
        }
    }

    public boolean checkoutBook(String book){
            if(findBook(String.valueOf(book)) == null){
                System.out.println("book is not found!");
            }
            if(findBook(book).isCheckedOut()){
                return false;
            }
            else {
                findBook(book).setCheckedOut(true);
                System.out.println(findBook(book).getTitle() + "The checkout was successfull!");
                return true;
            }


    }
    public void returnBook(Book book){
        book.setCheckedOut(false);
    }
    public Book findBook(String title){
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    public int countBooks(){
        return books.size();
    }
    public void sortBooks(){
        Collections.sort(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "The " + name + " library has " + books.size() + " books: \n" + books;
    }
    public void sortBy_Author_Pages(List<Book> books, String sortBy) {
        if (sortBy.compareTo("author") == 0) {
            books.sort(new sortByAuthor());
        } else if (sortBy.compareTo("pages") == 0) {
            books.sort(new sortByNumOfPages());
        }
    }

    public int searchByTitle(String title) {
        int db = 0;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                db++;
            }
        }
        return db;
    }
}
