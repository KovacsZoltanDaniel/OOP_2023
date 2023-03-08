package extra;

import java.util.Collections;
import java.util.List;

public class Library {
    private  String address;
    private List<Book> books;
    private String name;

    public Library(String name, String address, List<Book> books){
        this.name = name;
        this.address = address;
        this.books = books;
    }
    public void sortByAuthorAndPages(){

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

    public void checkoutBook(Book book){
        book.setCheckedOut(true);
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
        return "Library{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public void sortBy_Author_Pages(List<Book> books, String sortBy) {
        if (sortBy.compareTo("author") == 0) {
            books.sort(new sortByAuthor());
        } else if (sortBy.compareTo("pages") == 0) {
            books.sort(new sortByNumOfPages());
        }
    }
}
