package Ressources;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Jeu.Main1;
import Jeu.Scene;
import entites.Entites;


public class Clavier implements KeyListener{
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){Main1.scene.user.setDx(Constantes.DX_USER);}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){Main1.scene.user.setDx(-Constantes.DX_USER);}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			//Constantes.VITESSE_RELATIVE=Constantes.VITESSE_RELATIVE +3;
			//int longueur=Main1.scene.trafic.tabVoitures.size();
			//for (int i=0; i<longueur; i++) {
				//Main1.scene.trafic.tabVoitures.get(i).setDy(Main1.scene.trafic.tabVoitures.get(i).getDy()+3);}
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {Main1.scene.user.setDx(0);
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Chrono.ajout_compte_tour =Chrono.ajout_compte_tour +1;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
