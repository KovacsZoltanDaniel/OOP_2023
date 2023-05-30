package lab_12_3;

public class Main {
    public static void main(String[] args) {
        String[] subjects = {"roman", "magyar", "matek"};

        Bac bac = new Bac();
        bac.readNames("nevek1.txt");
        for (String subject: subjects) {
            bac.readSubject(subject);
        }

        bac.calcAverages();
        System.out.println("numPassed: " + bac.numPassed());

        bac.printFailed();
    }
}
