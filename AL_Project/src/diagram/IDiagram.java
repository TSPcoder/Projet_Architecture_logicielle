package diagram;

import type.Type;

/**
 * Cette interface représente notre diagramme avec l'ensemble des composants UML
 * 
 * Les composants sont représentés par des types
 *
 */

public interface IDiagram {
	
	// Permet l'ajout d'un type dans le diagramme
	public void addType(Type type);
	
	// Permet L'insertion d'un diagramme à l'intérieur d'un autre diagramme
	public void insertDiagram(IDiagram diagram);
	
}
