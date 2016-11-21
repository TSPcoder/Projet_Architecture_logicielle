package Dessin;

public class Caracteristiques {
	
	// Caractéristiques du diagramme : sa forme, sa couleur de remplissage etc..
	
	private int epaisseurTrait ;
	private String couleurContour ;
	private String couleurRemplissage ;
	
	// private Dimensions diag ;
	
	private FormeFleche formefleche ;
	
	// Type du diagramme : carré, cercle etc..
	private FormeType formetype ;
	
	public Caracteristiques(int epaisseur , String couleurC, String couleurR) {
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
