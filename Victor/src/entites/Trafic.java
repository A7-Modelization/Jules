package entites;

import java.util.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Ressources.Constantes;

public class Trafic {
	/**** VARIABLES ****/
	// Tableau contenant toutes les voitures
	public List<Voitures> tabVoitures = new ArrayList<Voitures>();
	
/**** CONSTRUCTEUR ****/
	
	public Trafic() {
		
		this.initTab();
		
	}
	public void initTab() {
		Random r = new Random();
		int n = r.nextInt(3);
		if (n==0) {
			Voitures v = new Voitures((Constantes.LARGEUR_FENETRE-Constantes.LARGEUR_ESPACE)/6-Constantes.LARGEUR_VOITURE/2);
			this.tabVoitures.add(v);
		}
		if (n==1) {
			Voitures v = new Voitures((Constantes.LARGEUR_FENETRE-Constantes.LARGEUR_ESPACE)/2-Constantes.LARGEUR_VOITURE/2);
			this.tabVoitures.add(v);
		}
		if (n==2) {
			Voitures v = new Voitures(5*(Constantes.LARGEUR_FENETRE-Constantes.LARGEUR_ESPACE)/6-Constantes.LARGEUR_VOITURE/2);
			this.tabVoitures.add(v);
		}
		
	}
	public void dessinTrafic(Graphics g) {
		Graphics g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		
		// dessin du trafic
		int l = this.tabVoitures.size();
		for(int i=0; i<l ; i++) {
			g2.fillRect(this.tabVoitures.get(i).getxPos(), this.tabVoitures.get(i).deplacementVoiture(),Constantes.LARGEUR_VOITURE,Constantes.HAUTEUR_VOITURE);
		}
	}
}
