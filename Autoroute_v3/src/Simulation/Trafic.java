package Simulation;

import java.util.LinkedList;
import java.util.List;

import entites.Entites;
import vehicules.Camion;
import vehicules.Moto;
import vehicules.User;
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
    public User user;
    

	
	/* Constructeur */
	public Trafic() {
		listev1= new LinkedList<Entites>();
		listev2= new LinkedList<Entites>();
		listev3= new LinkedList<Entites>();
		for (int i=1; i<1000; i++) {
			if (i==500) {
				user= new User();
				listev2.add(user);
			}
			else {
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
				if (randvehi<1.48) {vehicule =new Moto(125000-250*i,450);}
				else if (randvehi < 2.96) {vehicule =new Voiture(125000-250*i,450);}
				else {vehicule =new Camion(125000-250*i,450);}
				listev3.add(vehicule);
				}	
			}
		}
	}
	
	public LinkedList<Entites> voie(int i) {
		if (i>0 && i<150) {
			return listev1;
		} else if (i>=150 && i<350) {
			return listev2;
		} else {
			return listev3;
		}
	}
	
	
	public static int[] binarySearchWide(LinkedList<Entites> L, int f, int l, int pos, int val1, int val2){
		int[] L1 =new int[2];
		if (l >= f){
	      int mid = (int)f + (l - f)/2;
	      if (L.get(mid).getxPos() > pos && L.get(mid +1).getxPos() < pos){
	    	  if((L.get(mid).getxPos()> val1 && L.get(mid).getxPos()< val2) || (L.get(mid+1).getxPos()> val1 && L.get(mid+1).getxPos()< val2)) {
	    		  L1[0]=0;
	    		  L1[1]=mid;
	    		  return L1;
	    		}
	      }
	      if (L.get(mid+1).getxPos() < pos){
	        //recherche dans le sous-tableau ? gauche
	        return binarySearchWide(L, mid+1, l, pos, val1, val2); 
	      }else{
	        //recherche dans le sous-tableau ? droit
	        return binarySearchWide(L, f, mid-1, pos, val1, val2); 
	      }
	    }
	    L1[0]=1;
	    L1[1]=(int)f + (l - f)/2;
		return L1;
	   }

	
	public int[] voiture_a_gauche(Entites A) {
		int[] L =new int[2];
		if (A.getyPos()>350) {
			L[0]=0;
			L[1]=-1;
			return L;
		}
		int [] h= binarySearchWide(voie(A.getyPos()+200),0,voie(A.getyPos()).size(),A.getxPos(),A.getxPos()+2*A.getHauteur(),A.getxPos()-3*A.getHauteur());
		return h;
	}
	
	public int[] voiture_a_droite(Entites A) {
		int[] L=new int[2];
		if (A.getyPos() <150) {
			L[0]=0;
			L[1]=-1;
			return L;
		}
	    return binarySearchWide(voie(A.getyPos()-200),0,voie(A.getyPos()).size(),A.getxPos(),A.getxPos()+2*A.getHauteur(),A.getxPos()-3*A.getHauteur());
}
	public void vitesse_croisiere(Entites A, int a) {
		int c = binarySearchWide(voie(A.getyPos()),0,voie(A.getyPos()).size(),A.getxPos(),A.getxPos()+1,A.getxPos()-1)[0];
		if (voie(A.getyPos()).get(c+1).getxPos()<A.getxPos() - a && A.getDx() < A.getDxinit()) {A.setDx(A.getDx()-1);}; 
	}
	
	
}

