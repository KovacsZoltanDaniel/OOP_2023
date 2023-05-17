package lab_12_1;

public interface IDictionary {

     String DICTIONARY_FILE = "bible.txt";

     boolean add(String item);

     boolean find(String item);

     int size();

}
