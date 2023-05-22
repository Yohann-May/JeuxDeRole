package vue;

import equipements.Arme;
import equipements.Armure;
import equipements.Equipement;
import labyrinthe.Labyrinthe;
import labyrinthe.Position;
import labyrinthe.Salle;
import protagonistes.Hero;
import protagonistes.Monstre;

public class BoundaryMaitreDuJeu {
    public static Labyrinthe creerLabyrinthe() {
        boolean fin;
        int x, y;
        Labyrinthe l;
        Salle entree, sortie;
        do {
            System.out.print("Taille X du labyrinthe = ");
            x = Clavier.entrerClavierInt();
            System.out.print("Taille Y du labyrinthe = ");
            y = Clavier.entrerClavierInt();
        } while (x < 1 || y < 1);
        l = new Labyrinthe(x, y);
        do {
            l.ajouterSalle(creerSalle(x, y));
            System.out.print("Est-ce la derniere salle (1) Oui - (2) Non ?");
            fin = Clavier.entrerClavierInt() == 1;
        } while (!fin);
        do {
            entree = entrerPosition(l);
            sortie = entrerPosition(l);
            l.ajouterPorte(entree, sortie);
            System.out.print("Est-ce la derniere porte (1) Oui - (2) Non ?");
            fin = Clavier.entrerClavierInt() == 1;
        } while (!fin);
        return l;
    }

    private static Salle entrerPosition(Labyrinthe l) {
        int x, y;
        Salle s;
        do {
            System.out.print("Position X : ");
            x = Clavier.entrerClavierInt();
            System.out.print("Position Y : ");
            y = Clavier.entrerClavierInt();
        } while (x < 0 || y < 0);
        s = l.getSalle(new Position(x, y));
        return s;
    }

    /**
     * @return une salle creer par un maitre du jeu
     */
    public static Salle creerSalle(int xMax, int yMax) {
        int x, y;
        Monstre m = null;
        Equipement e = null;
        System.out.println("========================");
        System.out.println("  Creation d'une salle  ");
        System.out.println("========================");
        do {
            System.out.println("Donnez la position : ");
            System.out.print("X = ");
            x = Clavier.entrerClavierInt();
            System.out.print("Y = ");
            y = Clavier.entrerClavierInt();
            if (x > xMax || y > yMax)
                System.out.println("La position doit etre comprise dans la taille du labyrinthe (X=" + xMax + " Y=" + yMax);
        } while (x < xMax && y < yMax);
        System.out.print("Voulez-vous creer un Monstre dans cette salle (Oui (1) - Non (2)) ? ");
        if (Clavier.entrerClavierInt() == 1)
            m = BoundaryMaitreDuJeu.creerMonstre();
        System.out.print("Voulez-vous creer un Tresor dans cette salle (Oui (1) - Non (2)) ? ");
        if (Clavier.entrerClavierInt() == 1)
            e = BoundaryMaitreDuJeu.creerEquipement();
        return new Salle(new Position(x, y), m, e);
    }

    /**
     * @return un monstre cree par le maitre du jeu
     */
    private static Monstre creerMonstre() {
        System.out.println("========================");
        System.out.println(" Creation d'un monstre ");
        System.out.println("========================");
        System.out.print("Nom du monstre : ");
        return new Monstre(Clavier.entrerClavierString(), 5);
    }

    /**
     * @return un equipement (tresor) cree par le maitre du jeu
     */
    private static Equipement creerEquipement() {
        String nom;
        int d, choix;
        Equipement e = new Equipement(null);
        System.out.println("========================");
        System.out.println("Creation d'un equipement");
        System.out.println("========================");
        System.out.print("Arme (1) ou Armure (2) ? ");
        choix = Clavier.entrerClavierInt();
        switch (choix) {
            case 1 -> {
                System.out.print("Nom de l'arme : ");
                nom = Clavier.entrerClavierString();
                System.out.print("Degats de l'arme : ");
                d = Clavier.entrerClavierInt();
                e = new Arme(nom, d);
            }
            case 2 -> {
                System.out.print("Nom de l'armure : ");
                nom = Clavier.entrerClavierString();
                System.out.print("Vie de l'armure : ");
                d = Clavier.entrerClavierInt();
                e = new Armure(nom, d);
            }
        }
        return e;
    }
    /**
     * @return un Hero cree par le maitre du jeu avec une vie de 10
     */
    public static Hero creerPersonnage() {
        System.out.println("========================");
        System.out.println(" Creation d'un personnage ");
        System.out.println("========================");
        System.out.print("Nom du personnage : ");
        return new Hero(Clavier.entrerClavierString(), 10);
    }
}
