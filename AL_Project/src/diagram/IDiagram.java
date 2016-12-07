package diagram;

import java.util.ArrayList;

import type.Type;

/**
 * Cette interface représente notre diagramme avec l'ensemble des composants UML
 * 
 * Les composants sont représentés par des types
 *
 */

public interface IDiagram {
	
	/** Permet l'ajout d'un type dans le diagramme */
	public void addType(Type type);
	
	/** Permet L'insertion d'un diagramme à l'intérieur d'un autre diagramme */
	public IDiagram insertDiagram(IDiagram diagram);
	
	/** Vérifie si le diagramme est vide */
	public boolean isEmpty() ;
	
	/** Obtention du diagramme */
	public Type getType(int i);
	
	/** Ensemble des types du diagramme */
	public ArrayList<Type> getTypes();
	
	/** Donne un nom au diagramme */
	public void etiquetter (String nomDiagramme);
}
