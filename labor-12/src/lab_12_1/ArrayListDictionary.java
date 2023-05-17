package lab_12_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListDictionary implements IDictionary {
    private ArrayList<String> words = new ArrayList<>();
    private static ArrayListDictionary instance;

    private ArrayListDictionary() {
        try (Scanner scanner = new Scanner(new File(IDictionary.DICTIONARY_FILE))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                if (word.isEmpty()) {
                    continue;
                }
                add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static IDictionary newInstance() {
        if (instance == null) {
            instance = new ArrayListDictionary();
        }
        return instance;
    }

    public int size() {
        return words.size();
    }

    public boolean add(String item) {
        words.add(item);
        return true;
    }

    public boolean find(String item) {
        return Collections.binarySearch(words, item) >= 0;
    }
}
