package vehicules;


import Ressources.Constantes;
import entites.Entites;
import entites.RandomValeur;

public class Camion extends Entites{
/**** VARIABLES ****/
	public static int vitesseRelativeCamion = RandomValeur.randomVitesse(Constantes.VITESSE_RELATIVE_CAMION_MIN, Constantes.VITESSE_RELATIVE_CAMION_MAX);
	public static int VitesseCamion =90 + 10*vitesseRelativeCamion;
	
	/**** CONSTRUCTEUR ****/
		
	public Camion(int X_POS_INIT) {
			
		// Initialisation des variables de la super classe
		super.xPos = X_POS_INIT;
		super.yPos = 0 - Constantes.HAUTEUR_CAMION;
		super.largeur = Constantes.LARGEUR_CAMION;
		super.hauteur = Constantes.HAUTEUR_CAMION;
		super.dx = 0;
		super.dy = vitesseRelativeCamion;

		}
		
		
	/**** METHODES ****/
	public int deplacementCamion() {
		// Renvoie la nouvelle position de la voiture 
		this.yPos = this.yPos + this.dy;
		return this.yPos;
		
	}
	
	public int freinageCamion() {
		this.dy = this.dy - 1;
		return this.dy;
	}
}