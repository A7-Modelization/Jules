package entites;

import java.util.*;

import javax.swing.ImageIcon;

import Jeu.Main1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import Ressources.Constantes;

public class Trafic {
	private ImageIcon icovoiture;
	private Image imgvoiture;
	private ImageIcon icovoiture1;
	private Image imgvoiture1;
	private final int HAUTEUR_IMG1=61;
	private final int HAUTEUR_IMG2=59;
	
	/**** VARIABLES ****/
	// Tableau contenant toutes les voitures
	public List<Voitures> tabVoitures = new ArrayList<Voitures>();
	
/**** CONSTRUCTEUR ****/
	
	public Trafic() {
		this.icovoiture=new ImageIcon(getClass().getResource("/images/png nvelle image40x61.jpg"));
		this.imgvoiture=this.icovoiture.getImage();
		this.icovoiture1=new ImageIcon(getClass().getResource("/images/pngfin40x59.jpg"));
		this.imgvoiture1=this.icovoiture1.getImage();
		
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
			g.drawImage(imgvoiture,this.tabVoitures.get(i).getxPos(), this.tabVoitures.get(i).deplacementVoiture(),Constantes.LARGEUR_VOITURE,HAUTEUR_IMG1, null);
			g.drawImage(imgvoiture1,Main1.scene.user.getxPos(),Main1.scene.user.getyPos(),Constantes.LARGEUR_VOITURE,HAUTEUR_IMG2, null);
		}
	}
}
