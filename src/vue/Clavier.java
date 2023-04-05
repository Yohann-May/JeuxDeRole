package vue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    public static int entrerClavierInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Vous devez entrer un entier.");
            scanner.next();
            return entrerClavierInt();
        }
    }

    public static String entrerClavierString() {
        return scanner.next();
    }

}
