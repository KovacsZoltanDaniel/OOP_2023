package lab_12_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDictionary implements IDictionary {
    private Set<String> words = new TreeSet<>();
    private static  TreeSetDictionary instance;

    public TreeSetDictionary() {
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
            instance = new TreeSetDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String item) {
        words.add(item);
        return true;
    }

    @Override
    public boolean find(String item) {
        return words.contains(item);
    }

    @Override
    public int size() {
        return words.size();
    }
}
