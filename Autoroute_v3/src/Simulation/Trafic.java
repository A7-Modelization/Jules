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
		user= new User();
		listev2.add(user);
	}


	
	@SuppressWarnings("rawtypes")
	public LinkedList voie(int i) {
		if (i>0 && i<150) {
			return listev1;
		} else if (i>=150 && i<350) {
			return listev2;
		} else {
			return listev3;
		}
	}
	
	
	
	
	public void freinage(Entites A, Entites B) {
		//programme qui déteremine si la voiture A doit freiner pour ne pas rentrer en collision avec la voiture B
		if (A.getxPos()-B.getxPos()< 1.2*B.getHauteur() && A.getDx()<B.getDx()) /*freinage d'urgence*/ {
			A.setDx(A.getDx()+5);
		} else if (A.getxPos()-B.getxPos()< 1.7*B.getHauteur() && A.getDx()<B.getDx())/*freinage normal*/ {
			A.setDx(A.getDx()+2);
		} else if (A.getxPos()-B.getxPos()> 2*B.getHauteur() && A.getDx()>A.getDxinit()) {
			A.setDx(A.getDx()-1); // Interessant si on pouvait mettre +0.2 ou alors augmenter échelle des possibilités de vitesse
		}
		
	}
	public static int binarySearchWide(LinkedList<Entites> L, int f, int l, int val1, int val2){
	    if (l >= f){
	      int mid = (int)f + (l - f)/2;
	      if (L.get(mid).getxPos() >val1 && L.get(mid).getxPos() < val2){
	        return 15000;
	      }
	      if (L.get(mid).getxPos() > val2){
	        //recherche dans le sous-tableau à gauche
	        return binarySearchWide(L, mid+1, l, val1, val2); 
	      }else{
	        //recherche dans le sous-tableau à droit
	        return binarySearchWide(L, f, mid-1, val1, val2); 
	      }
	    }
	    return (int)f + (l - f)/2;
	   }
	
	public static int binarySearch(LinkedList<Entites> L1, int first, int last, int key){  
        if (last>=first){  
            int mid = first + (last - first)/2;  
            if (L1.get(mid).getxPos() == key){  
            return mid;  
            }  
            if (L1.get(mid).getxPos() > key){  
            return binarySearch(L1, first, mid-1, key);//search in left subarray  
            }else{  
            return binarySearch(L1, mid+1, last, key);//search in right subarray  
            }  
        }  
        return -1;
	}
	
	public int depassement(Entites A, Entites B) {
		//détermine si la j-eme voiture de la liste peut dépasser celle qui est devant elle
		// renvoie l'indice de la voiture devant laquelle elle sera si elle change de file
		if (A.getyPos()>260) {
			return 15000;
		}
		//randdep= Math.random()*2;
		if (A.getDx()-B.getDx()<0)/** || randdep<1)**/ {
			int h=binarySearchWide(voie(A.getyPos()),0,voie(A.getyPos()).size()-1,A.getxPos()-70,A.getxPos()+70);
			if (h!=15000) {return h;}
		}
		return 15000;
	}
	public void changement_voie(int ancien, int nouveau, LinkedList<Entites> L1, LinkedList<Entites> L2) {
		L2.add(nouveau, L1.get(ancien));
		L1.remove(ancien);
		L2.get(nouveau).setyPos(L2.get(nouveau).getyPos()+200);
		/**for (int i=0; i<100;i++) {
			L2.get(nouveau).setyPos(L2.get(nouveau).getyPos()+2);
		}**/
	}	
	
	public void gestion() {
	
	// gestion distance inter-vehicules + gestion dépassements
		for (int i=1;i<listev1.size()-1;i++) {
			freinage(listev1.get(i),listev1.get(i+1));
			int h=depassement(listev1.get(i),listev1.get(i+1));
			if (h!=15000){
				while (listev1.get(i).getxPos()>listev2.get(h).getxPos() || listev1.get(i).getxPos()<listev2.get(h+1).getxPos()) {
					if (listev1.get(i).getxPos()>listev2.get(h).getxPos()) {
						h=h-1;
					} else {
						h=h+1;
					}
				}
				changement_voie(i,h,listev1,listev2);
			}
			}
		for (int i=1;i<listev2.size()-1;i++) {
			freinage(listev2.get(i),listev2.get(i+1));
			int h=depassement(listev2.get(i),listev2.get(i+1));
			if (h!=15000){
				while (listev2.get(i).getxPos()>listev3.get(h).getxPos() || listev2.get(i).getxPos()<listev3.get(h+1).getxPos()) {
					if (listev2.get(i).getxPos()>listev3.get(h).getxPos()) {
						h=h-1;
					} else {
						h=h+1;
					}
				}
				changement_voie(i,h,listev2,listev3);
			}
			}
		for (int i=1;i<listev3.size()-1;i++) {
			freinage(listev3.get(i),listev3.get(i+1));
			}
	}




}

