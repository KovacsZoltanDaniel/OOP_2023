package lab5_extra;

import oop.labor02.MyDate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Person {
    private String firstName;
    private String lastName;
    private MyDate birthDate;
    private ArrayList<Book> books = new ArrayList<>();
    private static AtomicInteger count = new AtomicInteger(1);
    private String id;

    public Person(String firstName, String lastName, MyDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.id = firstName.charAt(0) +""+ lastName.charAt(0) + "_" + count.getAndIncrement();

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public MyDate getBirthDate() {
        return birthDate;
    }

    public String getId() {
        return id;
    }

    public void borrowBook(Book book) {
        books.add(book);
    }

    public void returnBook(String id) {
        for (int i = 0; i < books.size(); i++) {
            if (String.valueOf(books.get(i).getId()).equals(id)) {
                books.remove(books.get(i));
            }
        }
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        if (books.size() != 0) {
            return firstName + " " + lastName + ", born in " + birthDate + " (id: " + id + ")\n - Books to read: \n" + books + "\n";
        } else {
            return firstName + " " + lastName + ", born in " + birthDate + " (id: " + id + ")\n - No books to read\n";
        }
    }

    public int getNumOfBooks() {
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            count++;
        }
        return count;
    }
}
