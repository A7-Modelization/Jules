package Ressources;

public class Constantes {
	/*******************FENETRE*******************/
	// Dimensions de la fenetre
	public static final int LARGEUR_FENETRE = 500;
	public static final int LARGEUR_ESPACE = 200;
	public static final int HAUTEUR_FENETRE = 600;
	public static final int MARGE_FENETRE = 50;
	
	// Dimensions des lignes
	public static final int EPAISSEUR_LIGNE = 10;
	
	/*******************UTILISATEUR******************/
	// Dimensions de la voiture de l'utilisateur
	public static final int LARGEUR_USER = 40;
	public static final int HAUTEUR_USER = 60;
	
	// Position initiale de la voiture de l'utilisateur
	public final static int X_POS_INIT_USER = (LARGEUR_FENETRE-LARGEUR_ESPACE - LARGEUR_USER)/ 2;
	public final static int Y_POS_USER = 450;	
	
	// Unité de déplacement de la voiture de l'utilisateur
	public final static int DX_USER = 2;
	
	// Limite de déplacement de la voiture de l'utilisateur
	public final static int LIMITE_GAUCHE_USER = 30;
	public final static int LIMITE_DROITE_USER = 220;
	
	/***************VOITURES TRAFIC*************/
	// Dimensions de la voiture
	public static final int LARGEUR_VOITURE = 40;
	public static final int HAUTEUR_VOITURE = 60;
	
	/******************TRAFIC******************/
	public static final float FREQUENCE_APPARITION = 2; //2sec
	public static int VITESSE_RELATIVE = 2;
	
	/******************TEMPS*******************/
	// Temps de la boucle
	public final static int TEMPS_BOUCLE = 5; // 5 ms
	public static final int NOMBRE_BOUCLES = 250;
	
}
