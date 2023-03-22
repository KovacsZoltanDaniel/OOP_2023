package lab5_extra;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class Book implements Comparable<Book> {
    private final String title;
    private final String author;
    private final String isbn;
    private int numPages;
    private  boolean checkedOut;
    private final int id;
    private static final AtomicInteger count = new AtomicInteger(1);

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        //this.numPages = numPages;
        // mivel az elso konyv 1 es id-t kell kapjon

        this.id = count.getAndIncrement(); // igy lehet novelni az id-t
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }

    public String getTitle() {
        return title;
    }

    public int compareTo(Book book){
        return this.isbn.compareTo(book.isbn);
    }

    public boolean isCheckedOut(){
        return checkedOut;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book: " +
                "title= '" + title + '\'' +
                ", author= '" + author + '\'';
    }


    /*public boolean getCheckedOut() {
        return checkedOut;
    }*/
    }
class sortByAuthor implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return a.getAuthor().compareTo(b.getAuthor());
    }
}
class sortByNumOfPages implements Comparator<Book> {
    /*@Override
    public int compare(Book o1, Book o2) {
        return 0;
    }

    */
    @Override
    public int compare(Book a, Book b) {
        return a.getNumPages() - b.getNumPages();
    }
}