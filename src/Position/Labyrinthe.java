package Position;

import Protagoniste.*;
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

    public void deplacer(Personnage personnage, String direction) {
       int x = personnage.getPosition().getX();
       int y = personnage.getPosition().getY();
        switch (direction) {
            case "N" -> {
                if (getSalle(new Position(x - 1, y)) != null) {
                    x -= 1;
                    System.out.println(personnage.getNom() + " se deplace vers le Nord");
                }
                else
                    System.out.println("Il n'y a pas de salle vers le Nord");
            }
            case "S" -> {
                if (getSalle(new Position(x + 1, y)) != null) {
                    x += 1;
                System.out.println(personnage.getNom() + " se deplace vers le Sud");
                }
                else
                    System.out.println("Il n'y a pas de salle vers le Sud");
            }
            case "O" -> {
                if (getSalle(new Position(x, y - 1)) != null) {
                    y -= 1;
                    System.out.println(personnage.getNom() + " se deplace vers l'Ouest");
                }
                else
                    System.out.println("Il n'y a pas de salle vers l'Ouest");
            }
            case "E" -> {
                if (getSalle(new Position(x, y + 1)) != null) {
                    y += 1;
                    System.out.println(personnage.getNom() + " se deplace vers l'Est");
                }
                else
                    System.out.println("Il n'y a pas de salle vers l'Est");
            }
            default -> {
                System.out.println("Il n'y a pas de salle dans cette direction");
            }
        }
        personnage.seDeplacer(new Position(x, y));
    }
}
