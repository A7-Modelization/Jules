package Jeu;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Ressources.Constantes;

public class Main {

	/**** VARIABLES ****/
	
	public static Scene scene;
	
	
	/**** METHODES ****/
	public static void main(String[] args) {
		// Creation de la fen?tre
		JFrame fenetre = new JFrame("Jeu");
		fenetre.setSize(Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setAlwaysOnTop(true);
		
		// Association du panneau Scene ? la fen?tre
		scene = new Scene();		
		fenetre.setContentPane(scene);
		
		
				
		fenetre.setVisible(true);
	}


}