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
 * Classe BoundaryHistoire
 * Permet de gerer l'histoire d'un hero dans un labyrinthe
 */
public class BoundaryHistoire {
    private Hero hero;
    private Labyrinthe labyrinthe;

    /**
     * Constructeur de la classe BoundaryHistoire
     * @param hero hero de l'histoire
     */
    public BoundaryHistoire(Hero hero) {
        this.hero = hero;
    }

    /**
     * Realisation d'un tour pour le joueur
     */
    public void tourJoueur() {
        Salle enCours = this.labyrinthe.getSalle(this.hero.getPosition()); // Recuperation de la salle de depart
        // Affichage des directions possibles
        enCours.afficherDirectionPossible();
        // Deplacement du joueur
        Salle suivante = this.labyrinthe.deplacer(hero, selectionDirection());
        // combat automatique
        if (suivante.contientMonstre()) { // combat si la salle contient un monstre
            System.out.print(this.hero.getNom() + " rencontre un(e) " + suivante.getMonstre().getNom() + ". ");
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
                    System.out.println(this.hero.getNom() + " trouve un(e) " + enCours.getTresor().getNom());
                    this.hero.recupererEquipement(enCours.getTresor());
                }
            }
        }
    }

    /**
     * @return la direction selectionne au clavier
     */
    private String selectionDirection() {
        String choix;
        do {
            System.out.print("Choisir une direction pour se deplacer (N, S, O, E) : ");
            choix = Clavier.entrerClavierString();
        } while (!choix.equals("N") && !choix.equals("S") && !choix.equals("O") && !choix.equals("E"));
        return choix;
    }

    /**
     * Affecte un labyrinthe a l'histoire
     * @param labyrinthe labyrinthe a attribuer
     */
    public void setLabyrinthe(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
    }
}
