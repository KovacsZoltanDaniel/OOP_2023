package lab_11_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Storage {
    private ArrayList<Product> products;

    public Storage(String fileName) {
        this.products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                int ID = Integer.parseInt(items[0]);
                String name = items[1];
                int amount = Integer.parseInt(items[2]);
                int price = Integer.parseInt(items[3]);
                products.add(new Product(ID, name, amount, price));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int numOfUpdatedProducts = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                int ID = Integer.parseInt(items[0]);
                int newAmount = Integer.parseInt(items[1]);

                Collections.sort(this.products);
                int position = Collections.binarySearch(products, new Product(ID));
                if (position >= 0) {
                    products.get(position).increaseAmount(newAmount);
                    numOfUpdatedProducts++;
                }
            }
            System.out.println(numOfUpdatedProducts + " items were successfully updated.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Storage {" +
                "products= " + products +
                '}';
    }
}
