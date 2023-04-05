package labyrinthe;

import protagonistes.*;
import vue.Clavier;

public class Labyrinthe {
    private Salle[][] labyrinthe;

    public Labyrinthe(int x, int y) {
        this.labyrinthe = new Salle[x][y];
    }

    public void ajouterSalle(Salle salle) {
        this.labyrinthe[salle.getPosition().getX()][salle.getPosition().getY()] = salle;
    }

    public void ajouterPorte(Salle entree, Salle sortie) {
        entree.ajouterPorte(sortie);
        sortie.ajouterPorte(entree);
    }

    private Salle getSalle(Position position) {
        return labyrinthe[position.getX()][position.getY()];
    }

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
     * @return true si le hero fuit | false sinon
     */
    public boolean combattre(Hero hero, Monstre monstre) {
        int alea;
        boolean fuir;
        int choix;
        do {
            alea = (int) (Math.random() * 100);
            if (alea > 50) {
                hero.subirAttaque(1, monstre);
            } else {
                monstre.subirAttaque(1, hero);
            }
            // Fuir ou continuer
            do {
                System.out.println("Que voulez vous faire ?");
                System.out.println("1 - Fuir le combat");
                System.out.println("2 - Continuer le combat");
                System.out.print("Entrez un nombre : ");
                choix = Clavier.entrerClavierInt();
            } while (choix < 1 || choix > 2);
            fuir = choix == 1;
        } while ((hero.estMort() && monstre.estMort()) && !fuir);
        return fuir;
    }
}
