package test;


import equipements.Arme;
import equipements.Armure;
import equipements.Equipement;
import labyrinthe.Labyrinthe;
import labyrinthe.Position;
import labyrinthe.Salle;
import protagonistes.Hero;
import protagonistes.Monstre;
import vue.BoundaryHistoire;

public class test {

	public static void main(String[] args) {
		Arme arme = new Arme("Arme", 4);
		Armure armure = new Armure("Armure", 3);
		Hero hero = new Hero("hero", 10);
		hero.recupererEquipement(arme);
		hero.recupererEquipement(armure);
		Labyrinthe lab = new Labyrinthe(10,10);
		Position position1 =new Position(1,1);
		Position position2 =new Position(1,2);
		Position position3 =new Position(7,8);
		Position position4 =new Position(3,4);
		Monstre monstre1 = new Monstre("monstre", 5);
		Equipement tresor = new Equipement("tresor");
		Salle salle1 = new Salle(position1,monstre1,tresor);
		Salle salle2 = new Salle(position2,monstre1,tresor);
		Salle salle3 = new Salle(position3,monstre1,tresor);
		Salle salle4 = new Salle(position4,monstre1,tresor);
		lab.ajouterSalle(salle1, salle2, salle3, salle4);
		BoundaryHistoire bdr = new BoundaryHistoire(hero);
		//bdr.setLabyrinthe(lab);
		bdr.sauvegarder();
		System.out.println("hero name : " + bdr.getHero().toString());
		System.out.println(" name : " + bdr.getLabyrinthe().toString());
		//bdr.getHero().toString();
		//bdr.getLabyrinthe().toString();
		
		
		
		//bdr.sauvegarder();
	}

}
