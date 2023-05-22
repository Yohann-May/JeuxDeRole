package labyrinthe;



import protagonistes.*;
import vue.Clavier;

/**
 * Classe Labyrinthe
 * Contient la "map" du jeu sous forme de tableau
 */
public class Labyrinthe {
    private Salle[][] labyrinthe;
    
    
    public Salle[][] getLabyrinthe(){
    	return this.labyrinthe;
    }

    
    
    public Labyrinthe() {
    }

	/**
     * Constructeur de la classe Labyrinthe
     * @param x le nombre de ligne dans le tableau
     * @param y le nombre de colonne dans le tableau
     */
    public Labyrinthe(int x, int y) {
        this.labyrinthe = new Salle[x][y];
    }

    /**
     * Ajoute une/des salle(s) au labyrinthe
     * @param salles salle(s) a ajouter
     */
    public void ajouterSalle(Salle... salles) {
    	System.out.println("length of salles : " + salles.length);
        for (Salle salle : salles) {
            this.labyrinthe[salle.getPosition().getX()][salle.getPosition().getY()] = salle;
        }
    }

    /**
     * Ajoute une porte entre deux salles
     * @param entree salle d'ou l'on vient
     * @param sortie salle vers ou l'on se dirige
     */
    public void ajouterPorte(Salle entree, Salle sortie) {
        entree.ajouterPorte(sortie);
        sortie.ajouterPorte(entree);
    }

    /**
     * @param position position de la salle recherchee
     * @return la salle à la position donne
     */
    public Salle getSalle(Position position) {
        return labyrinthe[position.getX()][position.getY()];
    }

    /**
     * Deplace le personnage dans la direction donnee
     * @param personnage personnage a deplacer
     * @param direction direction dans laquelle aller
     * @return la salle dans laquelle le personnage vient de se deplacer
     */
    public Salle deplacer(Personnage personnage, String direction) {
       Position[] portes = getSalle(personnage.getPosition()).getPortes();
        switch (direction) {
            case "N" -> {
                if (portes[0] != null) {
                    System.out.println(personnage.getNom() + " se deplace vers le Nord");
                    personnage.seDeplacer(portes[0]);
                }
                else
                    System.out.println("Il n'y a pas de porte vers le Nord");
            }
            case "S" -> {
                if (portes[1] != null) {
                System.out.println(personnage.getNom() + " se deplace vers le Sud");
                    personnage.seDeplacer(portes[1]);
                }
                else
                    System.out.println("Il n'y a pas de porte vers le Sud");
            }
            case "O" -> {
                if (portes[2] != null) {
                    System.out.println(personnage.getNom() + " se deplace vers l'Ouest");
                    personnage.seDeplacer(portes[2]);
                }
                else
                    System.out.println("Il n'y a pas de porte vers l'Ouest");
            }
            case "E" -> {
                if (portes[3] != null) {
                    System.out.println(personnage.getNom() + " se deplace vers l'Est");
                    personnage.seDeplacer(portes[3]);
                }
                else
                    System.out.println("Il n'y a pas de porte vers l'Est");
            }
            default -> System.out.println("Il n'y a pas de porte dans cette direction");
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
