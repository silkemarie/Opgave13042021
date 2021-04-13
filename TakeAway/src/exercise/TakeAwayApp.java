package exercise;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class TakeAwayApp {

    static Scanner scanner = new Scanner(System.in);
    static final int LEVERING = 30;
    static final double RABAT = 0.9; //10 procent rabat

    // Bemærk at main uddelegerer delopgaverne i købsprocessen
    public static void main(String[] args) {
        int pris = 0; // pris uden evt. rabat og leveringsomkostninger
        boolean levering = ønskesLevering();
        udskrivMenu();
        int menuValg = vælgFraMenuKort();
        pris += findPris(menuValg);
        double samletPris = beregnSamletPris(pris, levering);
        udskrivPris(samletPris);
    }

    public static boolean ønskesLevering() {
        System.out.print("Ønsker du hjemmelevering? ja/nej ");
        String svar = scanner.nextLine();
        if (svar.equals("ja")) {
            return true;
        } else return false;
    }

    public static void udskrivMenu() {
        System.out.println("Velkommen til Fresh Fast Food");
        System.out.println("1. Baconburger \t\t79 kr");
        System.out.println("2. Cheeseburger \t89 kr");
        System.out.println("3. Veggieburger \t79 kr");
        System.out.println("4. Trøffelmayo \t\t10 kr");
        System.out.println("5. Chilimayo \t\t10 kr");
    }

    public static double findPris(int menuValg) {
        switch (menuValg) {
            case 1:
            case 3:
                return 79;
            case 2:
                return 89;
            case 4:
            case 5:
                return 10;
            default:
                return 0;
        }
    }

    public static double beregnSamletPris(int løbendePris, boolean levering) {
        double samletPris = løbendePris;
        if (erDetRabatDag()) {
            samletPris *= RABAT;
        }
        if (levering) {
            samletPris += LEVERING;
        }
        return samletPris;
    }

    public static int vælgFraMenuKort() {
        System.out.print("Vælg fra menukort: ");
        int svar = scanner.nextInt();

        //Fejlhåndtering
        if (svar < 1 || svar > 5) {
            return -1;
        } else return svar;
    }

    // metoden er private, fordi det er hjælpemetode
    private static boolean erDetRabatDag() {
        LocalDate idag = LocalDate.now();
        DayOfWeek dag = idag.getDayOfWeek();
        // Onsdag er rabatdag
        return dag == DayOfWeek.WEDNESDAY;
    }

    public static void udskrivPris(double samletPris) {
        System.out.printf("\nDin pris er %.2f kr. \n", samletPris);
        System.out.println("Tak for nu. Vi håber snart at se dig igen.");
        System.out.println("Husk, at der er altid 10 % rabat om onsdagen.");
        System.out.println("Følg os på instagram og facebook :-) ");
    }
}
