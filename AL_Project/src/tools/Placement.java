package tools;

import interpretor.Curseur;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

/**
 * Cette classe regroupe des fonctions nécessaires au placement des différents
 * éléments pour le dessin SVG (avec batik)
 * 
 */

public class Placement {
	
	int placementHorizontal ; // Nombre d'éléments moins un présents sur la ligne courante
	int ligneCourante ; // Ligne courante
	
	public Placement() {
		placementHorizontal=0;
		ligneCourante=0 ;
	}
	
	public int getPlacementHorizontal() {
		return placementHorizontal;
	}
	
	public void setPlacementHorizontal(int placementHorizontal) {
		this.placementHorizontal = placementHorizontal;
	}

	public int getLigneCourante() {
		return ligneCourante;
	}

	public void setLigneCourante(int placementVertical) {
		this.ligneCourante = placementVertical;
	}
	
	/**
	 * Cette méthode va permettre de gérer le placement des types dans le
	 * diagramme (représentation SVG)
	 * 
	 * On place aligné au maximum 4 objets (classe ou interface). On saute
	 * ensuite une ligne et on recommence
	 */
	public void algoPlacement() {
		if (placementHorizontal < 3) {
			placementHorizontal++;
		} else {
			// On a placé 4 éléments sur une même ligne
			placementHorizontal = 0;
			ligneCourante++;
		}
	}
	
	/**
	 * Cette méthode donne la taille du texte qui est écrit (largeur - hauteur)
	 */
	public static Curseur tailleTexte(String texte){
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
		Font font = new Font("Tahoma", Font.PLAIN, 12);
		int textwidth = (int)(font.getStringBounds(texte, frc).getWidth());
		int textheight = (int)(font.getStringBounds(texte, frc).getHeight());
		return new Curseur(textwidth, textheight);
	}
	
	/**
	 * Cette méthode permet de calculer la position où le texte doit commencer
	 * afin qu'il soit placé au milieu du diagramme
	 */
	public static int placeMilieuX(String texte, int largeur) {
		Curseur taille = tailleTexte(texte);
		return (largeur / 2 - taille.getX() / 2);
	}
}
