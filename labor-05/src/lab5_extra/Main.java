package lab5_extra;

import oop.labor02.DateUtil;
import oop.labor02.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Library> libraries = readLibrariesFromCSV("lab5extra_libraries.csv");
        for (int i = 0; i < libraries.size(); i++) {
            printLibrariesToFile(libraries.get(i));
        }
        ArrayList<Person> persons = readPersonsFromCSVFile("lab5extra_persons.csv");
        printPersons(persons);
        System.out.println("\nPersons after checkout:\n");
        readFromCheckoutCSVFile("lab5extra_checkout.csv", libraries, persons);

        System.out.print("\nEnter the title of the searched book: ");
        Scanner keyboard = new Scanner(System.in);
        String title = keyboard.nextLine();
        int numberOfBooksWithTheGivenTitle = 0;
        for (Library library : libraries) {
            numberOfBooksWithTheGivenTitle += library.searchByTitle(title);
        }
        System.out.println("There are " + numberOfBooksWithTheGivenTitle + " books with the given title.\n\n");

        System.out.println("Persons and the number of books they need to return:\n");
        printPeople(persons);
    }
    public static ArrayList<Library> readLibrariesFromCSV(String fileName) {
            ArrayList<Library> libraries = new ArrayList<>();

            try (Scanner scanner = new Scanner(new File(fileName))) {
                int i = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.isEmpty()) {
                        continue;
                    }
                    String[] items = line.split(",");

                    while (scanner.hasNextLine()){
                        if(items[0].trim().equals("LIBRARY")){
                        ArrayList<Book> books = new ArrayList<>();
                        String name = items[1].trim();
                        String address = items[2].trim();
                        libraries.add(new Library(name, address, books));
                         i++;
                            if (scanner.hasNextLine()) {
                                line = scanner.nextLine();
                                items = line.split(",");
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            while (items[0].trim().equals("BOOK")){
                                String name = items[1].trim();
                                String author = items[2].trim();
                                String isbn = items[3].trim();
                                libraries.get(i-1).addBook(new Book(name, author,isbn));
                                if (scanner.hasNextLine()) {
                                    line = scanner.nextLine();
                                    items = line.split(",");
                                }
                                else {
                                    break;
                                }
                            }
                        }
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return libraries;
        }
    public static void printLibrariesToFile(Library library) {
        try {
            String nameWithoutSpaces = library.getName().replace(" ", "_");
            String filename = String.format("%s_%s.txt", nameWithoutSpaces, library.countBooks());
            System.out.println(filename);
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(library.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static ArrayList<Person> readPersonsFromCSVFile(String fileName) {
            ArrayList<Person> persons = new ArrayList<>();
            int incorrectDetails = 0;
            try (Scanner scanner = new Scanner(new File(fileName))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.isEmpty()) {
                        continue;
                    }
                    String[] items = line.split(",");
                    if(items.length == 5){
                        String firstName = items[0].trim();
                        String lastName = items[1].trim();
                        if(DateUtil.isValidDate(Integer.parseInt(items[2].trim()), Integer.parseInt(items[3].trim()), Integer.parseInt(items[4].trim()))){
                            MyDate date = new MyDate(Integer.parseInt(items[2].trim()), Integer.parseInt(items[3].trim()), Integer.parseInt(items[4].trim()));
                            persons.add(new Person(firstName,lastName,date));
                        }
                        else {
                            incorrectDetails++;
                        }
                    }
                    else {
                        incorrectDetails++;
                    }
                }
                System.out.println("the number of persons with incorrect details: " + incorrectDetails);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return persons;
        }
    public static void printPersons(ArrayList<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
    public static void readFromCheckoutCSVFile(String fileName, ArrayList<Library> libraries, ArrayList<Person> persons) {
            try (Scanner scanner = new Scanner(new File(fileName))) {
                int notPresentPerson = 0;
                int notPresentBook = 0;
                int checkedoutBook = 0;

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.isEmpty()) {
                        continue;
                    }
                    String[] items = line.split(",");
                    String personID = items[0].trim();

                    Person person = null;
                    Book book = null;

                    int bookID = Integer.parseInt(items[1].trim());
                    for (int i = 0; i < persons.size(); i++) {
                        if(persons.get(i).getId().equals(personID)){
                            person = persons.get(i);
                        }
                    }
                    if(person == null){
                        notPresentPerson++;
                        continue;
                    }
                    for (Library library : libraries) {
                        for (int j = 0; j < library.countBooks(); j++) {
                            if (library.getBooks().get(j).getId() == bookID && !library.getBooks().get(j).isCheckedOut()) {
                                book = library.getBooks().get(j);
                                library.checkoutBook(book.getTitle());
                            }
                        }
                    }

                    if(book ==  null){
                        notPresentBook++;
                    }

                    if(book != null && book.isCheckedOut()){
                        checkedoutBook++;
                    }

                    if(person != null && book != null && !book.isCheckedOut()){
                        person.borrowBook(book);
                        book.setCheckedOut(true);
                        System.out.println(person);
                    }
                }
                System.out.println("No such person: " + notPresentPerson);
                System.out.println("Book not found: " + notPresentBook);
                System.out.println("Cannot borrow book: " + checkedoutBook);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    public static void printPeople(ArrayList<Person> persons) {
        for (Person person : persons) {
            System.out.print(person.getFirstName() + " " + person.getLastName() + " - books to return: " + person.getNumOfBooks() + "\n");
        }
    }
}

