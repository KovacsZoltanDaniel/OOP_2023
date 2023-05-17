package lab9_2;

public interface IDictionary {

     String DICTIONARY_FILE = "text_to_find.txt";

     boolean add(String item);

     boolean find(String item);

     int size();

}
