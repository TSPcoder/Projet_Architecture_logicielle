package Dessin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestExportSvg {
	
	public String nomFichier ;
	public int hauteurFichier ; // Largeur du Canvas svg
	public int largeurFichier ; // Longueur du Canvas svg
	public ArrayList<Diagramme> diagrammes ; // ensemble des diagrammes de classes 
	
	public TestExportSvg(String nomFichier, Curseur p , Dimensions dimFigure, Dimensions dimClasse , Caracteristiques c, HashMap<String, Object> etiquette) {
		this.nomFichier=nomFichier;
		this.largeurFichier = dimFigure.getLargeur() ;
		this.hauteurFichier = dimFigure.getHauteur() ;
		this.diagrammes = new ArrayList<Diagramme>();
		
		// Test : ajout d'une classe
		this.diagrammes.add(new MaClasse(p,c, etiquette,dimClasse));
	}
	
	public void creer() {
		BufferedWriter res;
		try {
			res = new BufferedWriter(new FileWriter(nomFichier+".html"));

			res.write("<!DOCTYPE html>");
			res.newLine();
			res.write("<html>");
			res.newLine();
			res.write("<body>");
			res.newLine();
			// Dimensions dim = new Dimensions(largeur, longueur);
			res.write("<svg height=\""+hauteurFichier+"\" width=\""+largeurFichier+"\">");
			for (Diagramme d : diagrammes) {

				res.write(d.conversionSvg());
				res.newLine();
			}

			res.write("</svg>\n" + "</body>\n" + "</html>\n");
			res.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
