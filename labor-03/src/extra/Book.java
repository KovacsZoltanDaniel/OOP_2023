package extra;

import java.util.Comparator;

public class Book implements Comparable<Book> {
    private final String title;
    private final String author;
    private final String isbn;
    private int numPages;
    private  boolean checkedOut;

    public Book(String title, String author, String isbn, int numPages){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numPages = numPages;
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