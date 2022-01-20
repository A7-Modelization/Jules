package entites;
import Ressources.Constantes;
public class Voitures extends Entites {
/**** VARIABLES ****/
	public static int Vitesse =90 + 10*Constantes.VITESSE_RELATIVE;
	
	/**** CONSTRUCTEUR ****/
		
	public Voitures(int X_POS_INIT) {
			
		// Initialisation des variables de la super classe
		super.xPos = X_POS_INIT;
		super.yPos = 0 - Constantes.HAUTEUR_VOITURE;
		super.largeur = Constantes.LARGEUR_VOITURE;
		super.hauteur = Constantes.HAUTEUR_VOITURE;
		super.dx = 0;
		super.dy = Constantes.VITESSE_RELATIVE;
	}
		
		
	/**** METHODES ****/
	public int deplacementVoiture() {
		// Renvoie la nouvelle position de la voiture 
		this.yPos = this.yPos + this.dy;
		return this.yPos;
	}
}
