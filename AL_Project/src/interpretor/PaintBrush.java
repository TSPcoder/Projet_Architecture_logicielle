package interpretor;

import java.awt.Color;

public class PaintBrush {
	private int epaisseurTrait ;
	private Color couleurContour ;
	private Color couleurRemplissage ;
	
	public PaintBrush(int epaisseur , Color couleurC, Color couleurR) {
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

	public Color getCouleurContour() {
		return couleurContour;
	}

	public void setCouleurContour(Color couleur) {
		this.couleurContour = couleur;
	}

	public Color getCouleurRemplissage() {
		return couleurRemplissage;
	}

	public void setCouleurRemplissage(Color couleurRemplissage) {
		this.couleurRemplissage = couleurRemplissage;
	}
}
