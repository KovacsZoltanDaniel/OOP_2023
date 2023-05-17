package lab_11_2;



public class Main {
    public static void main(String[] args) {
        Company company = new Company("Sapi");
        company.hireAll("employees.csv");
        System.out.println("All employees: ");
        company.printAll(System.out);
        System.out.println();

        System.out.println("Alphabetically: ");
        company.sortByComparator((e1, e2) -> {
            if (e1.getFirstName().equals(e2.getFirstName())) {
                return e1.getLastName().compareTo(e2.getLastName());
            }
            return e1.getFirstName().compareTo(e2.getFirstName());
        });

        company.printAll(System.out);

    }
}
