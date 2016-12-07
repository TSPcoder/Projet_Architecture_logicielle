package interpretor;

public class Pinceau {
	private int epaisseurTrait ;
	private String couleurContour ;
	private String couleurRemplissage ;
	
	public Pinceau(int epaisseur , String couleurC, String couleurR) {
		this.couleurContour = couleurC;
		this.couleurRemplissage=couleurR;
		this.epaisseurTrait = epaisseur;
	}

	public int getEpaisseurTrait() {
		return epaisseurTrait;
	}

	public void setEpaisseurTrait(int epaisseurTrait) {
		this.epaisseurTrait = epaisseurTrait;
	}

	public String getCouleurContour() {
		return couleurContour;
	}

	public void setCouleurContour(String couleur) {
		this.couleurContour = couleur;
	}

	public String getCouleurRemplissage() {
		return couleurRemplissage;
	}

	public void setCouleurRemplissage(String couleurRemplissage) {
		this.couleurRemplissage = couleurRemplissage;
	}
}
