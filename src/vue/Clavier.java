package vue;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Clavier
 * Permet de saisir au clavier dans le jeu
 */
public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @return entier saisit au clavier
     */
    public static int entrerClavierInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Vous devez entrer un entier.");
            scanner.next();
            return entrerClavierInt();
        }
    }

    /**
     * @return texte entrer au clavier
     */
    public static String entrerClavierString() {
        return scanner.next();
    }

}
