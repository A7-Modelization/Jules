package Jeu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Ressources.Chrono;
import Ressources.Clavier;
import Ressources.Constantes;
import entites.Collision;
import entites.Entites;
import entites.Trafic;
import entites.User;
import entites.Voitures;
public class Scene extends JPanel implements MouseListener {
	public User user = new User();
	public Trafic trafic = new Trafic();
	private Font police;
	private JLabel lab1;
	private JButton bouton;

	
/**** CONSTRUCTEUR ****/
	public Scene() {
		super();
		
		//Instanciation des boutons et label
		propCont();
		// Instanciation du clavier
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		
		// Instanciation du chrono
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		
		/**
		//Provisoire
		police = new Font("Arial", Font.PLAIN,18);
		**/

	}
	
/**** METHODES ****/
	
	public void paintComponent(Graphics g) {
		
		Graphics g2 = (Graphics2D) g;
		
		// Dessin du fond d'écran
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Constantes.LARGEUR_FENETRE-Constantes.LARGEUR_ESPACE, Constantes.HAUTEUR_FENETRE);
		
		// Dessin des lignes blacnhes 
		g2.setColor(Color.WHITE);
		g2.fillRect((Constantes.LARGEUR_FENETRE-Constantes.LARGEUR_ESPACE)/3-Constantes.EPAISSEUR_LIGNE, 0 , Constantes.EPAISSEUR_LIGNE,Constantes.HAUTEUR_FENETRE);
		g2.fillRect(2*(Constantes.LARGEUR_FENETRE-Constantes.LARGEUR_ESPACE)/3-Constantes.EPAISSEUR_LIGNE, 0 , Constantes.EPAISSEUR_LIGNE,Constantes.HAUTEUR_FENETRE);
		
		// Dessin de la voiture de l'utilisateur
		g2.setColor(Color.RED);
		g2.fillRect(this.user.deplacementUser(), this.user.getyPos(),Constantes.LARGEUR_USER,Constantes.HAUTEUR_USER);
		
		// Dessin du trafic
		if (Ressources.Chrono.compteTours > Constantes.NOMBRE_BOUCLES) {
			this.trafic.initTab();
			Ressources.Chrono.compteTours = 0;
		}
		trafic.dessinTrafic(g2);
		
		// GAME OVER, collision
		Collision col = new Collision(user, trafic);
		if (col.Int == true) {
				System.exit(1000);
		}
		/**
		g2.setFont(police);
		g2.drawString(String.valueOf(col.Int), 150, 100);
		**/
	}

private void propCont() {			
	// ajout des boutons
	bouton = new JButton();
	this.bouton.setText("afficher vitesse");
	this.bouton.setBounds(350,350,100,30);
	this.add(bouton);
	this.bouton.addMouseListener(this);
	
	//label vitesse
	lab1= new JLabel();
	this.lab1.setText("Vitesse");
	this.lab1.setBounds(Constantes.LARGEUR_FENETRE-170,Constantes.HAUTEUR_FENETRE-100 , 140, 30);
	this.add(lab1);
}
	
	
@Override
public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	if (e.getSource() == this.bouton){
		Voitures.Vitesse= 80+ 10*Main1.scene.user.getDy();
		this.lab1.setText("la vitesse est "+ Voitures.Vitesse + " km/h");
		this.requestFocusInWindow();
	 	
		}
	}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


	
}
