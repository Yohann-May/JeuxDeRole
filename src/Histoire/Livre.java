package Histoire;

import Position.*;
import Protagoniste.Hero;
import Protagoniste.Personnage;

public class Livre {
    private static Salle enCours;
    public static void main(String[] args) {
        // Créer joueur
        Hero hero = new Hero("Arthur", 10);
        // Créer labyrinthe
        Labyrinthe labyrinthe = new Labyrinthe(10, 10);
        Salle depart = new Salle(new Position(0, 0), null, null);
        Salle fin = new Salle(new Position(1, 0), null, null);
        enCours = depart;
        labyrinthe.ajouterSalle(depart);
        labyrinthe.ajouterSalle(fin); // Salle vide
        labyrinthe.ajouterPorte(depart, fin);
        // Déplacer dans labyrinthe
        labyrinthe.deplacer(hero, "S");
        labyrinthe.deplacer(hero, "S");
        labyrinthe.deplacer(hero, "S");
    }
}
