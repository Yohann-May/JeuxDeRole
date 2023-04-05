package labyrinthe;

import protagonistes.*;
import vue.Clavier;

/**
 * TODO commenter
 */
public class Labyrinthe {
    private Salle[][] labyrinthe;

    /**
     * TODO commenter
     */
    public Labyrinthe(int x, int y) {
        this.labyrinthe = new Salle[x][y];
    }

    /**
     * TODO commenter
     */
    public void ajouterSalle(Salle... salles) {
        for (int i = 0; i < salles.length; i++) {
            this.labyrinthe[salles[i].getPosition().getX()][salles[i].getPosition().getY()] = salles[i];
        }
    }

    /**
     * TODO commenter
     */
    public void ajouterPorte(Salle entree, Salle sortie) {
        entree.ajouterPorte(sortie);
        sortie.ajouterPorte(entree);
    }

    /**
     * TODO commenter
     */
    public Salle getSalle(Position position) {
        return labyrinthe[position.getX()][position.getY()];
    }

    /**
     * TODO commenter
     */
    public Salle deplacer(Personnage personnage, String direction) {
       Salle[] portes = getSalle(personnage.getPosition()).getPortes();
        switch (direction) {
            case "N" -> {
                if (portes[0] != null) {
                    System.out.println(personnage.getNom() + " se deplace vers le Nord");
                    personnage.seDeplacer(portes[0].getPosition());
                }
                else
                    System.out.println("Il n'y a pas de porte vers le Nord");
            }
            case "S" -> {
                if (portes[1] != null) {
                System.out.println(personnage.getNom() + " se deplace vers le Sud");
                    personnage.seDeplacer(portes[1].getPosition());
                }
                else
                    System.out.println("Il n'y a pas de porte vers le Sud");
            }
            case "O" -> {
                if (portes[2] != null) {
                    System.out.println(personnage.getNom() + " se deplace vers l'Ouest");
                    personnage.seDeplacer(portes[2].getPosition());
                }
                else
                    System.out.println("Il n'y a pas de porte vers l'Ouest");
            }
            case "E" -> {
                if (portes[3] != null) {
                    System.out.println(personnage.getNom() + " se deplace vers l'Est");
                    personnage.seDeplacer(portes[3].getPosition());
                }
                else
                    System.out.println("Il n'y a pas de porte vers l'Est");
            }
            default -> {
                System.out.println("Il n'y a pas de porte dans cette direction");
            }
        }
        return this.labyrinthe[personnage.getPosition().getX()][personnage.getPosition().getY()];
    }

    /**
     * Combat entre un monstre et un joueur, un seul tour
     * @param hero joueur
     * @param monstre monstre
     * @return true si le hero fuit | false si le combat se fini par la mort d'un des protagonistes
     */
    public boolean combattre(Hero hero, Monstre monstre) {
        int alea;
        boolean fuir;
        int choix;
        do {
            /* Le hero choisit de fuir ou combattre */
            do {
                System.out.print("Voulez vous Fuir (1) ou Combattre (2) ? ");
                choix = Clavier.entrerClavierInt();
            } while (choix < 1 || choix > 2);
            fuir = choix == 1; // true si le hero decide de fuir
            if (!fuir) {
                /* Degats aleatoires */
                alea = (int) (Math.random() * 100);
                if (alea > 50) {
                    hero.subirAttaque(monstre); // Le hero subit des degats
                } else {
                    monstre.subirAttaque(hero); // Le monstre subit des degats
                }
            }
        } while ((hero.estMort() && monstre.estMort()) && !fuir);
        return fuir; // renvoie la decision du hero s'il fuit
    }
}
