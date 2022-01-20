package entites;

public class Collision {
	public boolean Int;

	public Collision(User user, Trafic trafic) {
		
		this.Int = this.Intersection(user, trafic);
		
	}
	public boolean Intersection(User user, Trafic trafic) {
		
		boolean x = false;
		boolean y = false;
		
		for ( int i=0; i < trafic.tabVoitures.size(); i++) {
			if (trafic.tabVoitures.get(i).getxPos()<= user.xPos & user.xPos <= trafic.tabVoitures.get(i).getxPos() + trafic.tabVoitures.get(i).largeur) {
				x = true;
			}
			if (trafic.tabVoitures.get(i).getxPos() <= user.xPos + user.largeur & user.getxPos() + user.largeur <= trafic.tabVoitures.get(i).getxPos() + trafic.tabVoitures.get(i).largeur ) {
				x = true;
			}
			if (trafic.tabVoitures.get(i).getyPos()<= user.yPos & user.yPos <= trafic.tabVoitures.get(i).getyPos() + trafic.tabVoitures.get(i).hauteur) {
				y = true;
			}
			if (trafic.tabVoitures.get(i).getyPos() <= user.yPos + user.hauteur & user.getyPos() + user.hauteur <= trafic.tabVoitures.get(i).getyPos() + trafic.tabVoitures.get(i).hauteur ) {
				y = true;
			}
			if (x == true & y == true) {
				return true;
			}
			x = false;
			y = false;
		}
		return false;
	}
}
