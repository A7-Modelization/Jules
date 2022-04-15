package Game;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;

import Ressources.Chrono;
import Ressources.Constantes;
import entites.Entites;
import Simulation.Trafic;

// importer entités, trafic



public class Scene extends JPanel{
	
/**** VARIABLES ****/
public Trafic trafic;
	
/**** CONSTRUCTEUR ****/
	
	public Scene() {
	
	/**** ATTRIBUTS ****/
		super();
		
		// Instanciation trafic
		trafic = new Trafic();
		
		// Instanciation du chrono, ATTTENTION toujours l'instancier à la fin
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();

	}
	
	/**** METHODES ****/
	
	public void paintComponent(Graphics g) {
		
		Graphics g2 = (Graphics2D) g;
		
		// Dessin du fond d'écran
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
		
		// Dessin des lignes blacnhes 
		g2.setColor(Color.WHITE);
		g2.fillRect(0, Constantes.HAUTEUR_FENETRE/3-2*Constantes.EPAISSEUR_LIGNE, Constantes.LARGEUR_FENETRE, Constantes.EPAISSEUR_LIGNE);
		g2.fillRect(0 ,2*Constantes.HAUTEUR_FENETRE/3-2*Constantes.EPAISSEUR_LIGNE, Constantes.LARGEUR_FENETRE, Constantes.EPAISSEUR_LIGNE);
		
		// Dessin trafic
		trafic.gestion();
		
		g2.setColor(Color.RED);
		int l = trafic.listev1.size();
		for(int i=0; i<l ; i++) {
			Entites vehicule = trafic.listev1.get(i);
			g2.fillRect(vehicule.deplacement(), vehicule.getyPos(), vehicule.getHauteur(), vehicule.getLargeur());
		}
		int l2 = trafic.listev2.size();
		for(int i=0; i<l2 ; i++) {
			Entites vehicule = trafic.listev2.get(i);
			g2.fillRect(vehicule.deplacement(), vehicule.getyPos(), vehicule.getHauteur(), vehicule.getLargeur());
		}
		int l3 = trafic.listev3.size();
		for(int i=0; i<l3 ; i++) {
			Entites vehicule = trafic.listev3.get(i);
			g2.fillRect(vehicule.deplacement(), vehicule.getyPos(), vehicule.getHauteur(), vehicule.getLargeur());
		}
	}
}