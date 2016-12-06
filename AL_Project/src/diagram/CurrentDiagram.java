package diagram;

import java.util.ArrayList;

import type.Type;

/**
 * Instance représentant un diagramme UML contenant plusieurs types (classes, interfaces, relations...)
 *
 */

public class CurrentDiagram implements IDiagram {
	
	// Ensemble des types de notre diagramme
	// Ces types sont divers : classes, interfaces, relations ...
	ArrayList<Type> types ;
	
	public CurrentDiagram(ArrayList<Type> l) {
		this.types=l ;
	}
	
	@Override
	public void addType(Type type) {
		// On ajoute le type
		this.types.add(type);
	}

	@Override
	public void insertDiagram(IDiagram diagram) {
		// TODO Auto-generated method stub
		
	}

}
