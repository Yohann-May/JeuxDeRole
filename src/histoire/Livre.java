package histoire;

import labyrinthe.*;
import protagonistes.Hero;
import protagonistes.Monstre;
import vue.BoundaryCreerLabyrinthe;
import vue.BoundaryHistoire;

/**
 * TODO commenter
 */
public class Livre {

    /**
     * TODO commenter
     */
    public static void main(String[] args) {
//        Salle enCours;
//        /* Creation un joueur */
        Hero hero = new Hero("Arthur", 10);
//        /* Creation labyrinthe */
//        Labyrinthe labyrinthe = new Labyrinthe(10, 10);
//
//        /* Ajout de monstres */
//        Monstre gobelin = new Monstre("Gobelin", 5);
//
//        Salle une = new Salle(new Position(0, 0), null, null);
//        Salle deux = new Salle(new Position(1, 0), gobelin, null);
//        Salle fin = new Salle(new Position(1, 1), null, null);
//        labyrinthe.ajouterSalle(une);
//        labyrinthe.ajouterSalle(deux);
//        labyrinthe.ajouterSalle(fin);
//        labyrinthe.ajouterPorte(une, deux);
//        labyrinthe.ajouterPorte(deux, fin);
//
//        /* Gestion des combats */
//        enCours = labyrinthe.deplacer(hero, "S");
//        System.out.println(enCours.contientMonstre());
//        System.out.println(enCours.contientTresor());
//        /* Combat entre monstre et joueur */
//        labyrinthe.combattre(hero, gobelin);
//        enCours = labyrinthe.deplacer(hero, "E");

        BoundaryHistoire histoire = new BoundaryHistoire(hero);
        histoire.setLabyrinthe(BoundaryCreerLabyrinthe.labyrintheStarter());
        histoire.tourJoueur();
        histoire.tourJoueur();
        histoire.tourJoueur();
        histoire.tourJoueur();
    }
}
