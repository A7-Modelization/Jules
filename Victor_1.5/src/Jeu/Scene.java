package Jeu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Ressources.Chrono;
import Ressources.Clavier;
import Ressources.Constantes;
import entites.Collision;
import entites.Entites;
import entites.Trafic;
import entites.User;
import entites.Voitures;
public class Scene extends JPanel implements MouseListener, ActionListener {
	public User user = new User();
	public Trafic trafic = new Trafic();
	private Font police;
	private JButton bouton;
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	public String Vitesse =Integer.toString(Voitures.Vitesse);
	public boolean status=true;
	private JSlider slider;
	private JTextField zonetxt;
	
/**** CONSTRUCTEUR ****/
	public Scene() {
		super();
		
		//Instanciation des boutons et label
		Proprietes_Contenant();
		
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
		this.setFocusable(true);
		if (status==true) {
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
		g2.clearRect(422, 485, 30, 20);
		g2.setFont(police);
		//g2.drawString(String.valueOf(col.Int), 150, 100);
		g2.drawString("la vitesse est "+ Voitures.Vitesse, 350,500 );
		
		}
		
		else if (status==false) {
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, Constantes.LARGEUR_FENETRE-Constantes.LARGEUR_ESPACE, Constantes.HAUTEUR_FENETRE);
		}
		
		
		/**
		lab1=new JLabel();
		this.lab1.setText(Vitesse);
		this.lab1.setBounds(350, 400, 100, 30);
		this.add(lab1);
		**/
		

		
	}

private void Proprietes_Contenant() {			
	// ajout des boutons
	this.setLayout(null);
	this.bouton = new JButton();
	this.bouton.setText("Afficher vitesse/ Actualiser");
	this.bouton.setBounds(307,450,186,15);
	this.add(bouton);
	this.bouton.addMouseListener(this);
	
	this.bouton1 = new JButton("Reprendre");
	this.bouton1.setBounds(300,50,100,20);
	this.add(bouton1);
	this.bouton1.addMouseListener(this);
	
	this.bouton2 = new JButton("Quitter");
	this.bouton2.setBounds(350,75,100,20); 
	this.add(bouton2);
	this.bouton2.addMouseListener(this);
	
	this.bouton3 = new JButton("Pause");
	this.bouton3.setBounds(400,50,100,20);
	this.add(bouton3);
	this.bouton3.addMouseListener(this);
	
	// instanciation du slider
	slider= new JSlider(0,10);
	slider.setMajorTickSpacing(5);
	slider.setMinorTickSpacing(1);
	slider.setValue(2);
	
	slider.setPaintLabels(true);
	slider.setPaintTicks(true);
	slider.requestFocusInWindow();
	
	slider.addChangeListener(new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			System.out.println(slider.getValue());
			slider.requestFocus();
			slider.setFocusable(false);
			Chrono.ajout_compte_tour=slider.getValue();
			//slider.removeChangeListener(this);
			}
	});
	this.add(slider);
	slider.setBounds(310, 380, 180, 50);
	
	zonetxt = new JTextField();
	zonetxt.setBounds(310, 300, 170, 30);
	zonetxt.setText("vitesse (dizaines seulement)");
	this.zonetxt.addActionListener(this);
	this.add(zonetxt);
}
	
@Override
public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	if (e.getSource() == this.bouton){
		Voitures.Vitesse= 90+ 10*Constantes.VITESSE_RELATIVE;
		//this.lab1.setText(Vitesse);
		this.requestFocusInWindow();}
	if (e.getSource()==this.bouton2) {
		System.exit(0);
		this.requestFocusInWindow();}
	if (e.getSource()==this.bouton3) {
		status=false;
		this.requestFocusInWindow();}
	if (e.getSource()==this.bouton1) {
		status=true;
		this.requestFocusInWindow();}
	/**if (e.getSource()==this.zonetxt) {
		status=false;
		this.requestFocusInWindow();
	}**/
	}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource()==this.zonetxt) {
		Constantes.VITESSE_RELATIVE=(Integer.parseInt(this.zonetxt.getText())-90)/10;
		int longueur=Main1.scene.trafic.tabVoitures.size();
		for (int i=0; i<longueur; i++) {
			Main1.scene.trafic.tabVoitures.get(i).setDy(Constantes.VITESSE_RELATIVE) // mettre le jeu en pause quannd saisi du texte
					;}
		this.requestFocusInWindow();
	}
	
}


	
}
