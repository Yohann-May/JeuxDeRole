package vue;

import equipements.Arme;
import equipements.Armure;
import labyrinthe.Labyrinthe;
import labyrinthe.Position;
import labyrinthe.Salle;
import protagonistes.Monstre;

/**
 * Classe BoundaryCreerLabyrinthe
 * Permet de creer des labyrinthe par un maitre du jeu ou automatiquement
 */
public class BoundaryCreerLabyrinthe {
    /**
     * Creation d'un labyrinthe par un maitre du jeu
     * @return le labyrinthe cree
     */
    public static Labyrinthe creerLabyrinthe() {
    	return BoundaryMaitreDuJeu.creerLabyrinthe();
    }

    /**
     * @return un labyrinthe generer automatiquement
     */
    public static Labyrinthe labyrintheStarter() {
        Labyrinthe labyrinthe = new Labyrinthe(6, 6);
        // 5 monstres
        Monstre gobelin = new Monstre("Gobelin", 5);
        Monstre squelette = new Monstre("Squelette", 5);
        Monstre loup = new Monstre("Loup", 5);
        Monstre gobelin2 = new Monstre("Gobelin", 5);
        Monstre orc = new Monstre("Orc", 5);
        // 3 tresors
        Arme epee = new Arme("Epee", 3);
        Armure armureCuir = new Armure("Armure de cuir", 5);
        Arme epeeLongue = new Arme("Epee Longue", 5);
        // 19 sales
        Salle un = new Salle(new Position(0, 0), null, null); // Salle de départ ne possède pas de monstre
        Salle deux = new Salle(new Position(1, 0), null, null);
        Salle trois = new Salle(new Position(1, 1), gobelin, null);
        Salle quatre = new Salle(new Position(2, 1), null, null);
        Salle cinq = new Salle(new Position(3, 1), squelette, epee);
        Salle six = new Salle(new Position(4, 1), null, null);
        Salle sept = new Salle(new Position(5, 1), null, null);
        Salle huit = new Salle(new Position(5, 0), loup, null);
        Salle neuf = new Salle(new Position(3, 2), null, null);
        Salle dix = new Salle(new Position(3, 3), null, null);
        Salle onze = new Salle(new Position(3, 4), null, null);
        Salle douze = new Salle(new Position(2, 4), null, null);
        Salle treize = new Salle(new Position(1, 4), null, null);
        Salle quatorze = new Salle(new Position(0, 4), null, null);
        Salle quinze = new Salle(new Position(0, 3), null, null);
        Salle seize = new Salle(new Position(0, 2), gobelin2, armureCuir);
        Salle dixsept = new Salle(new Position(4, 4), orc, epeeLongue);
        Salle dixhuit = new Salle(new Position(4, 5), null, null);
        Salle dixneuf = new Salle(new Position(5, 5), null, null); // Salle de fin
        // Ajout des salles au labyrinthe
        labyrinthe.ajouterSalle(un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize, dixsept, dixhuit, dixneuf);
        // Ajout des portes aux salles
        labyrinthe.ajouterPorte(un, deux);
        labyrinthe.ajouterPorte(deux, trois);
        labyrinthe.ajouterPorte(trois, quatre);
        labyrinthe.ajouterPorte(quatre, cinq);
        labyrinthe.ajouterPorte(cinq, six);
        labyrinthe.ajouterPorte(cinq, neuf);
        labyrinthe.ajouterPorte(six, sept);
        labyrinthe.ajouterPorte(sept, huit);
        labyrinthe.ajouterPorte(neuf, dix);
        labyrinthe.ajouterPorte(dix, onze);
        labyrinthe.ajouterPorte(onze, douze);
        labyrinthe.ajouterPorte(onze, dixsept);
        labyrinthe.ajouterPorte(douze, treize);
        labyrinthe.ajouterPorte(treize, quatorze);
        labyrinthe.ajouterPorte(quatorze, quinze);
        labyrinthe.ajouterPorte(quinze, seize);
        labyrinthe.ajouterPorte(dixsept, dixhuit);
        labyrinthe.ajouterPorte(dixhuit, dixneuf);
        return labyrinthe;
    }
}
