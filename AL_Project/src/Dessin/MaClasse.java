package Dessin;

import java.util.ArrayList;
import java.util.HashMap;

public class MaClasse implements Diagramme {
	
	// Dimensions du diagramme
	private Dimensions dim ;
	
	// Caractéristiques du diagramme
	Caracteristiques c ;
	
	// Coin supérieur gauche du rectangle
	Curseur p ;
	
	private HashMap<String, Object> etiquette ;
	
	public MaClasse(Curseur p , Caracteristiques c , HashMap<String, Object> etiquette, Dimensions dim) {
		this.p=p;
		this.c = c ;
		this.etiquette=etiquette ;
		this.dim=dim;
	}

	@Override
	public void ajouterType(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String decrireType(String Type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserer(Diagramme d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String conversionSvg() {
		String s = "";
		
		/* Cercle
		s += "<circle cx=\"" + 220 + "\" cy=\"" + 220 + "\" r=\"" + 100
				+ "\" stroke=\"" + c.getCouleurContour() + "\" stroke-width=\""
				+ c.getEpaisseurTrait() + "\" ";
		//*/
		// s += "\" fill=\"" + c.getCouleurRemplissage() + "\"/>\n";
		
		// Dessin du diagramme 
		
		s += "<rect x=\"" + p.getX() + "\" y=\"" + p.getY() + "\" width=\"" + dim.getLargeur()
				+"\" height=\""+ dim.getHauteur() +  "\" stroke=\"" + c.getCouleurContour() + "\" stroke-width=\""
				+ c.getEpaisseurTrait() + "\" ";
		s += "\" fill=\"" + c.getCouleurRemplissage() + "\"/>\n";
		
		s+=this.etiquetter(etiquette);
		
		
		return s;
	}

	@Override
	public String etiquetter(HashMap<String, Object> etiquette) {
		
		// On va modifier les coordonnées de ce point afin qu'il agisse en tant que curseur ;
		Curseur curseurMobile = p ;
		
		String s="";
		// On va placer le type de la classe
		curseurMobile = p.ajuster();
		curseurMobile = curseurMobile.right();
		
		s += "<text x=\"" + curseurMobile.getX() + "\" y=\"" + curseurMobile.getY() + "\">" + "<< Java Class >>" + "</text>";
		
		// On va placer le nom de la classe
		curseurMobile=curseurMobile.down();
		String nomClasse = (String) etiquette.get("name") ;
		s += "<text x=\"" + curseurMobile.getX() + "\" y=\"" + curseurMobile.getY() + "\">" + nomClasse + "</text>";
		
		// On va placer le nom du package
		curseurMobile=curseurMobile.down();
		curseurMobile=curseurMobile.right();
		String nomPackage = (String) etiquette.get("package") ;
		s += "<text x=\"" + curseurMobile.getX() + "\" y=\"" + curseurMobile.getY() + "\">" + nomPackage + "</text>";
		
		// On place la ligne noire
		curseurMobile=curseurMobile.down();
		s += "<line x1=\"" + p.getX() + "\" y1=\"" + curseurMobile.getY() + "\" x2=\"" + dim.getLargeur()
				+"\" y2=\""+ curseurMobile.getY() +  "\" stroke=\"" + c.getCouleurContour() + "\" ";
		
		// On place les attributs
		curseurMobile=curseurMobile.down();
		curseurMobile.setX(0);
		ArrayList<String> vars = (ArrayList<String>) etiquette.get("variables") ;
		System.out.println(vars);
		for (int i=0 ; i<vars.size() ; i++){
			s += "<text x=\"" + curseurMobile.getX() + "\" y=\"" + curseurMobile.getY() + "\">" + vars.get(i) + "</text>";
			curseurMobile=curseurMobile.down();
		}
		
		// On place la ligne noire
		curseurMobile=curseurMobile.down();
		s += "<line x1=\"" + curseurMobile.getX() + "\" y1=\"" + curseurMobile.getY() + "\" x2=\"" + dim.getLargeur()
				+"\" y2=\""+ curseurMobile.getY() +  "\" stroke=\"" + c.getCouleurContour() + "\" ";
		
		// On place les méthodes
		curseurMobile=curseurMobile.down();
		ArrayList<String> methods = (ArrayList<String>) etiquette.get("methods") ;
		for (String method : methods){
			s += "<text x=\"" + curseurMobile.getX() + "\" y=\"" + curseurMobile.getY() + "\">" + method + "</text>";
			curseurMobile=curseurMobile.down();
		}
		return s ;
		
	}

}
