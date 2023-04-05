package vue;

import equipements.Arme;
import equipements.Armure;
import labyrinthe.Labyrinthe;
import labyrinthe.Position;
import labyrinthe.Salle;
import protagonistes.Hero;
import protagonistes.Monstre;

import java.util.Objects;

/**
 * TODO commenter
 */
public class BoundaryHistoire {
    private Hero hero;
    private Labyrinthe labyrinthe;

    /**
     * TODO commenter
     */
    public BoundaryHistoire(Hero hero) {
        this.hero = hero;
    }

    /**
     * TODO commenter
     */
    public void tourJoueur() {
        Salle enCours = this.labyrinthe.getSalle(this.hero.getPosition()); // Recuperation de la salle de depart
        // TODO afficher les deplacement possible pour le joueur
        // deplacement du joueur
        Salle suivante = this.labyrinthe.deplacer(hero, selectionDirection());
        // combat automatique
        if (suivante.contientMonstre()) { // combat si la salle contient un monstre
            if (this.labyrinthe.combattre(this.hero, suivante.getMonstre())) { // return true si fuite du hero
                // fuite, le monstre regagne sa vie
                suivante.getMonstre().setVie(suivante.getMonstre().getVieMax());
                System.out.println(this.hero.getNom() + " prend la fuite !");
                suivante = enCours;
            } else {
                // recuperation tresor (si present) car monstre vaincu
                this.hero.setVieMax(this.hero.getVieMax() + 1); // Augmentation de la vie max d'1pv
                this.hero.setVie(this.hero.getVieMax()); // Regeneration du hero
                enCours = suivante;
                if (enCours.contientTresor()) {
                    System.out.println(this.hero.getNom() + " trouve un " + enCours.getTresor().getNom());
                    this.hero.recupererEquipement(enCours.getTresor());
                }
            }
        }
    }

    private String selectionDirection() {
        String choix;
        do {
            System.out.print("Choisir une direction pour se deplacer (N, S, O, E) : ");
            choix = Clavier.entrerClavierString();
        } while (!choix.equals("N") && !choix.equals("S") && !choix.equals("O") && !choix.equals("E"));
        return choix;
    }

    public void setLabyrinthe(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
    }
}
