package vehicules;


import Ressources.Constantes;
import entites.Entites;
import entites.RandomValeur;

public class Moto extends Entites{
/**** VARIABLES ****/
	public static int vitesseRelativeMoto = RandomValeur.randomVitesse(Constantes.VITESSE_RELATIVE_MOTO_MIN, Constantes.VITESSE_RELATIVE_MOTO_MAX);
	public static int VitesseCamion =90 + 10*vitesseRelativeMoto;
	
	/**** CONSTRUCTEUR ****/
		
	public Moto(int X_POS_INIT) {
			
		// Initialisation des variables de la super classe
		super.xPos = X_POS_INIT;
		super.yPos = 0 - Constantes.HAUTEUR_MOTO;
		super.largeur = Constantes.LARGEUR_MOTO;
		super.hauteur = Constantes.HAUTEUR_MOTO;
		super.dx = 0;
		super.dy = vitesseRelativeMoto;

		}
		
		
	/**** METHODES ****/
	public int deplacementMoto() {
		// Renvoie la nouvelle position de la voiture 
		this.yPos = this.yPos + this.dy;
		return this.yPos;
	}
	public int freinageCamion() {
		this.dy = this.dy - 1;
		return this.dy;
	}
}
