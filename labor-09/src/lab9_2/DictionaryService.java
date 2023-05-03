package lab9_2;

import java.util.ArrayList;

public class DictionaryService {
    private IDictionary dictionary;
    DictionaryService(DictionaryType dtype){
        dictionary = dtype;
    }
    public  boolean findWord(String word){
        return dictionary.find(word);
    }
    public ArrayList<String> findWordsFile(String word){
        ArrayList<String> result = new ArrayList<>();
        for (String w : dictionary.getWordsFromFile()) {
            if (w.contains(word)) {
                result.add(w);
            }
        }
        return result;
    }
}
