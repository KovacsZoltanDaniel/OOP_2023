package lab_12_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Storage {
    private Map<Integer, Product> products;

    public Storage(String fileName) {
        this.products = new HashMap<>();
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
                products.put(ID, new Product(ID, name, amount, price));
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

                for (Product product: products.values()) {
                    if (product.getID() == ID) {
                        product.setAmount(newAmount);
                        numOfUpdatedProducts++;
                    }
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
