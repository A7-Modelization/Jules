package entites;



public abstract class Entites {
/**** VARIABLES ****/	
	
	protected int largeur, hauteur, xPos, yPos, dx, dy, dyinit;
	protected boolean vivant;
	
		
	
/**** CONSTRUCTEUR ****/
	
	// pas de constructeur
	
	
/**** METHODES ****/
	public int getLargeur() {return largeur;}
	
	public int getDyinit() {
		return dyinit;
}
	public void setDyinit(int dyinit) {
		this.dyinit = dyinit;
}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public boolean isVivant() {
		return vivant;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}

	
	
	
}