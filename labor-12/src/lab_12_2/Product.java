package lab_12_2;

public class Product  {
        private int ID;
        private String name;
        private int amount;
        private int price;

        public Product(int ID, String name, int amount, int price) {
            this.ID = ID;
            this.name = name;
            this.amount = amount;
            this.price = price;
        }

        public int getID() {
            return ID;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }

        public int getPrice() {
            return price;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void increaseAmount(int newAmount) {
            this.amount += newAmount;
        }

        @Override
        public String toString() {
            return "\nProduct {" +
                    "ID=" + ID +
                    ", name='" + name + '\'' +
                    ", amount=" + amount +
                    ", price=" + price +
                    "}";
        }
}
