package Dessin;

import java.util.ArrayList;
import java.util.HashMap;

public interface Diagramme {
	
	public void ajouterType (String type);
	public String decrireType (String Type);
	public void inserer (Diagramme d);
	
	// Conversion du fichier au format SVG
	public String conversionSvg() ;
	
	// Permet d'étiquetter le diagramme
	public String etiquetter (HashMap<String, Object> etiquette) ;
}
