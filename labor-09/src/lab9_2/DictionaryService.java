package lab9_2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryService {
    private IDictionary dictionary;

    public DictionaryService(DictionaryType dtype) {
        dictionary = DictionaryProvider.createDictionary(dtype);//statikus metodusokat a tipusneven keresztul erjuk el
    }
    public boolean findWord(String word){
        return dictionary.find(word);
    }
    public ArrayList<String> findWordsFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))){
                while (scanner.hasNext()){
                    String word = scanner.next();
                    if(!(dictionary.find(word) && !(words.contains(word)))){
                        words.add(word);
                    }
                }

        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }
}
