package lab9_2;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDictionary implements IDictionary{
    private ArrayList<String> words = new ArrayList<>();
    private static  ArrayListDictionary instance;

    private ArrayListDictionary() {
    }
    public IDictionary newInstance(){
        if (instance == null) {
            instance = new ArrayListDictionary();
        }
        return instance;
    }
    @Override
    public boolean add(String word) {
        if(!find(word)){
            words.add(word);
            return true;
        }
       return false;
    }

    @Override
    public boolean find(String word) {
        return Collections.binarySearch(words,word) >= 0;
    }

    @Override
    public int size() {
        return words.size();
    }
}
