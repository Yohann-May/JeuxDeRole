package Histoire;

import Position.*;
import Protagoniste.Hero;
import Protagoniste.Personnage;

public class Livre {
    public static void main(String[] args) {
        /* Creation un joueur */
        Hero hero = new Hero("Arthur", 10);
        /* Creation labyrinthe */
        Labyrinthe labyrinthe = new Labyrinthe(10, 10);
        Salle une = new Salle(new Position(0, 0), null, null);
        Salle deux = new Salle(new Position(1, 0), null, null);
        Salle fin = new Salle(new Position(1, 1), null, null);
        labyrinthe.ajouterSalle(une);
        labyrinthe.ajouterSalle(deux);
        labyrinthe.ajouterSalle(fin);
        labyrinthe.ajouterPorte(une, deux);
        labyrinthe.ajouterPorte(deux, fin);

        /* Deplacement dans le labyrinthe sans prendre en compte les portes */
        labyrinthe.deplacer(hero, "S"); // Peut se deplacer car porte existe
        labyrinthe.deplacer(hero, "N"); // Peut se deplacer car porte existe
        labyrinthe.deplacer(hero, "S"); // Peut se deplacer car porte existe
        labyrinthe.deplacer(hero, "E"); // Ne peut pas se deplacer car pas de porte
        labyrinthe.deplacer(hero, "O"); // Ne peut pas se deplacer car pas de porte
        labyrinthe.deplacer(hero, "N"); // Ne peut pas se deplacer car pas de porte
        labyrinthe.deplacer(hero, "N"); // Ne peut pas se deplacer car pas de porte
    }
}
