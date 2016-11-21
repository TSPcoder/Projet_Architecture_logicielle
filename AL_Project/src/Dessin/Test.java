package Dessin;

import java.util.ArrayList;
import java.util.HashMap;

import tools.InfoFinder;

public class Test {
	public static void main(String[] args) {
		
		String couleurContour = "black";
		String couleurRemplissage = "white";
		int epaisseurTrait = 3 ;
		
		// Dimensions du Canvas svg
		int longueur = 500 ;
		int largeur = 500 ;
		
		// Dimensions du diagramme de classe
		int largeurClasse = 200 ;
		int hauteurClasse = 400 ;
		
		HashMap<String, Object> infoClasse = InfoFinder.info(Caracteristiques.class) ;
		
		TestExportSvg test = new TestExportSvg("test", new Curseur(0,0), new Dimensions(largeur, longueur), new Dimensions(hauteurClasse, largeurClasse),
				new Caracteristiques(epaisseurTrait, couleurContour, couleurRemplissage), infoClasse);
		
		// Crée le fichier html avec le canvas svg
		test.creer();
		
		System.out.println(InfoFinder.methods(Caracteristiques.class).get(0));
	}
}
