package vue;


import labyrinthe.Labyrinthe;
import labyrinthe.Salle;
import protagonistes.Hero;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



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

    public void histoire() {
        // TODO coder la méthode suivante
        // Commencer par choisir la partie en appelant choixPartie()
        // Une fois le labyrinthe chargé réaliser le tour d'un joueur jusqu'à la fin
        // Enregistrer si fin
    }

    /**
     * Choix du mode de jeux parmi : <br>
     *     - Charger une ancienne partie <br>
     *     - Commencer une nouvelle partie : <br>
     *         + Génération automatique <br>
     *         + Création du labyrinthe <br>
     */
    public void choixPartie() {
        int choix, choix2;
        do {
            System.out.print(
                    """
                            =================================
                            1 - Charger l'ancienne Partie
                            2 - Commencer une nouvelle partie
                            =================================
                            Faites votre choix :\s""");
            choix = Clavier.entrerClavierInt();
        } while (choix != 1 && choix != 2);
        switch (choix) {
            case 1 -> this.charger();
            case 2 -> {
                do {
                    System.out.print(
                            """
                                    ========================================
                                    1 - Jouer avec un labyrinthe automatique
                                    2 - Créer votre labyrinthe
                                    ========================================
                                    Faites votre choix :\s""");
                    choix2 = Clavier.entrerClavierInt();
                } while (choix2 != 1 && choix2 != 2);
                switch (choix2) {
                    case 1 -> this.labyrinthe = BoundaryCreerLabyrinthe.labyrintheStarter();
                    case 2 -> this.labyrinthe = BoundaryCreerLabyrinthe.creerLabyrinthe();
                }
            }
        }
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

    /**
     * Enregistrer dans un fichier json l'histoire
     */
    public void sauvegarder() {

        // Créer un objet ObjectMapper pour convertir l'objet en JSON
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Convertir l'objet en JSON et l'enregistrer dans un fichier
            mapper.writeValue(new File(".\\vue\\hero.json"), this.hero);
            System.out.println("Le hero a été converti en JSON et enregistré dans le fichier hero.json");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors la sauvegarde du hero : " + e.getMessage());
        }
        
        try {
            mapper.writeValue(new File(".\\vue\\labyrinthe.json"), this.labyrinthe);
            System.out.println("Labyrinthe a été converti en JSON et enregistré dans le fichier Labyrinthe.json");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de sauvegarde de labyrinthe : " + e.getMessage());
        }
        
        
        
    }

    public Hero getHero() {
		return hero;
	}

	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}

	/**
     * Charger une histoire a partir d'un nom donné
     */
    public void charger() {
    	// Créer un objet ObjectMapper pour convertir l'objet en JSON
        ObjectMapper mapper = new ObjectMapper();
        try {
        	File fileHero = new File(".\\vue\\hero.json");
            this.hero= mapper.readValue(fileHero, Hero.class);
            System.out.println("Le Hero a bien été chargé");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de chargement du hero : " + e.getMessage());
        }
        
        try {
        	File fileLab = new File(".\\vue\\labyrinthe.json");
        	Labyrinthe labyrintheRecuperer = mapper.readValue(fileLab, Labyrinthe.class);
        	this.setLabyrinthe(labyrintheRecuperer);
            System.out.println("La labyrinthe a bien été chargé");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de chargement du hero : " + e.getMessage());
        }
        
    }
    
   
       
}
