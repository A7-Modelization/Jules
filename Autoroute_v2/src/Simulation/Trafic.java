package Simulation;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import entites.Entites;
import vehicules.Camion;
import vehicules.Moto;
import vehicules.Vehicules;
import vehicules.Voiture;

public class Trafic {
	
	/* Variables */	
	public static LinkedList<Entites> listev1;
	public static LinkedList<Entites> listev2;
	public static LinkedList<Entites> listev3;
    public static int randfile;
    public static double randvehi;
    public Entites vehicule;
    

	
	/* Constructeur */
	public Trafic() {
		listev1= new LinkedList<Entites>();
		listev2= new LinkedList<Entites>();
		listev3= new LinkedList<Entites>();
		for (int i=1; i<1000; i++) {
			randfile = (int)(Math.random()*3);
			randvehi = Math.random()*3;
			if (randfile==0) {
				if (randvehi<0.3) {vehicule =new Moto(125000-250*i);}
				else if (randvehi < 1.5) {vehicule= new Voiture(125000-250*i);}
				else {vehicule =new Camion(125000-250*i);}
				listev1.add(vehicule);	
			}
			else if (randfile==1) {
				if (125000-250*i < 800 || 125000-250*i > 1100) {
					if (randvehi<1.15) {vehicule =new Moto(125000-250*i);}
					else if (randvehi < 2.3) {vehicule =new Voiture(125000-250*i);}
					else {vehicule =new Camion(125000-250*i);}
					listev2.add(vehicule);
				}
			}
			else {
				if (randvehi<1.48) {vehicule =new Moto(125000-250*i);}
				else if (randvehi < 2.96) {vehicule =new Voiture(125000-250*i);}
				else {vehicule =new Camion(125000-250*i);}
				listev3.add(vehicule);
				}	
			}
		/*Vehicules user = new Vehicules.getVoiture(950);	*/
	}








}
