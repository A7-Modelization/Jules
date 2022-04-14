package vehicules;

import entites.Entites;

public class Vehicules extends Entites{
	
	
	
/**** CONSTRUCTEUR ****/
	
	// pas de constructeur
	
	
/**** METHODES ****/
	public static Object getMoto(int X_POS_INIT)
	{
		Moto Moto = new Moto(X_POS_INIT);
		return Moto;
	}
	
	public static Object getCamion(int X_POS_INIT)
	{
		Camion Camion = new Camion(X_POS_INIT);
		return Camion;
	}
	
	public static Object getVoiture(int X_POS_INIT)
	{
		Voiture Voiture = new Voiture(X_POS_INIT);
		return Voiture;
	}

}