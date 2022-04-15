package Simulation;

import java.util.LinkedList;
import java.util.List;

import entites.Entites;
import vehicules.Camion;
import vehicules.Moto;
import vehicules.Voiture;

public class Trafic {
	
	/* Variables */	
	public LinkedList<Entites> listev1;
	public LinkedList<Entites> listev2;
	public LinkedList<Entites> listev3;
    public static int randfile;
    public static double randvehi;
    public Entites vehicule;
    public static double randdep;
    

	
	/* Constructeur */
	public Trafic() {
		listev1= new LinkedList<Entites>();
		listev2= new LinkedList<Entites>();
		listev3= new LinkedList<Entites>();
		for (int i=1; i<1000; i++) {
			randfile = (int)(Math.random()*3);
			randvehi = Math.random()*3;
			if (randfile==0) {
				if (randvehi<0.3) {vehicule =new Moto(125000-250*i,50);}
				else if (randvehi < 1.5) {vehicule= new Voiture(125000-250*i,50);}
				else {vehicule =new Camion(125000-250*i,50);}
				listev1.add(vehicule);	
			}
			else if (randfile==1) {
				if (125000-250*i < 800 || 125000-250*i > 1100) {
					if (randvehi<1.15) {vehicule =new Moto(125000-250*i,250);}
					else if (randvehi < 2.3) {vehicule =new Voiture(125000-250*i,250);}
					else {vehicule =new Camion(125000-250*i,250);}
					listev2.add(vehicule);
				}
			}
			else {
				if (randvehi<1.48) {vehicule =new Moto(125000-250*i,500);}
				else if (randvehi < 2.96) {vehicule =new Voiture(125000-250*i,500);}
				else {vehicule =new Camion(125000-250*i,500);}
				listev3.add(vehicule);
				}	
			}
		/*Vehicules user = new Vehicules.getVoiture(950);	*/
	}


	
	@SuppressWarnings("rawtypes")
	public LinkedList voie(int i) {
		if (i==1) {
			return listev1;
		} else if (i==2) {
			return listev2;
		} else {
			return listev3;
		}
	}
	
	
	
	
	public void freinage(Entites A, Entites B) {
		//programme qui déteremine si la voiture A doit freiner pour ne pas rentrer en collision avec la voiture B
		if (B.getxPos()-A.getxPos()< 1.05*Ressources.Constantes.HAUTEUR_CAMION || A.getDx()>B.getDx()) /*freinage d'urgence*/ {
			A.setDx(A.getDx()-2);
		} else if (B.getxPos()-A.getxPos()< 1.5*Ressources.Constantes.HAUTEUR_CAMION || A.getDx()>B.getDx())/*freinage normal*/ {
			A.setDx(A.getDx()-1);
		} else if (B.getxPos()-A.getxPos()> Ressources.Constantes.HAUTEUR_CAMION && A.getDx()<A.getDxinit()) {
			A.setDx(A.getDx()+1); // Interessant si on pouvait mettre +0.2 ou alors augmenter échelle des possibilités de vitesse
		}
		
	}
	public static int binarySearch(LinkedList<Entites> L, int f, int l, int val1, int val2){
	    if (l >= f){
	      int mid = (int)f + (l - f)/2;
	      if (L.get(mid).getxPos() >val1 && L.get(mid).getxPos() < val2){
	        return mid;
	      }
	      if (L.get(mid).getxPos() > val2){
	        //recherche dans le sous-tableau à gauche
	        return binarySearch(L, f, mid-1, val1, val2); 
	      }else{
	        //recherche dans le sous-tableau à droit
	        return binarySearch(L, mid+1, l, val1, val2); 
	      }
	    }
	    return -1;
	   }
	
	public boolean depassement(Entites A, Entites B) {
		if (A.getyPos()==2) {
			return false;
		}
		randdep= Math.random()*2;
		if (A.getDx()-B.getDx()> 20 || randdep<1) {
			if (binarySearch(voie(A.getyPos()),0,voie(A.getyPos()).size()-1,A.getxPos()-100,A.getxPos()+100)==-1) {return true;}
		}
		return false;
	}
	public void changement_voie(LinkedList<Entites> L1, LinkedList<Entites> L2) {
		
	}

	
	
	public void gestion() {
	
	// gestion distance inter-vehicules
		for (int i=1;i<listev1.size()-1;i++) {
			freinage(listev1.get(i+1),listev1.get(i));
			}
		for (int i=1;i<listev2.size()-1;i++) {
			freinage(listev2.get(i+1),listev2.get(i));
			}
		for (int i=1;i<listev3.size()-1;i++) {
			freinage(listev3.get(i+1),listev3.get(i));
			}
	
	// gestion depassements 
	/**if (depassement==true) {
		changement_voie(i,i+1);
	}**/
	}




}

