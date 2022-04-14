package vehicules;


import Ressources.Constantes;
import entites.Entites;
import entites.RandomValeur;

public class Voiture extends Entites{
/**** VARIABLES ****/
	public static int vitesseRelativeVoiture = RandomValeur.randomVitesse(Constantes.VITESSE_RELATIVE_VOITURE_MIN, Constantes.VITESSE_RELATIVE_VOITURE_MAX);
	public static int VitesseCamion =90 + 10*vitesseRelativeVoiture;
	
	/**** CONSTRUCTEUR ****/
		
	public Voiture(int X_POS_INIT, int Y_POS_INIT) {
			
		// Initialisation des variables de la super classe
		super.xPos = X_POS_INIT;
		super.yPos = Y_POS_INIT; 
		super.largeur = Constantes.LARGEUR_VOITURE;
		super.hauteur = Constantes.HAUTEUR_VOITURE;
		super.dx = 0;
		super.dy = vitesseRelativeVoiture;
		super.dyinit = vitesseRelativeVoiture;

		}
		
		
	/**** METHODES ****/
	public int deplacementVoiture() {
		// Renvoie la nouvelle position de la voiture 
		this.yPos = this.yPos + this.dy;
		return this.yPos;
	}
	
	public int freinageVoiture() {
		this.dy = this.dy - 1;
		return this.dy;
	}
}