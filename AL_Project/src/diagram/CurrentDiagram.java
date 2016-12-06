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
	
	public ArrayList<Type> getTypes() {
		return types;
	}

	@Override
	public void addType(Type type) {
		// On ajoute le type
		this.types.add(type);
	}

	@Override
	public IDiagram insertDiagram(IDiagram diagram) {
		if (!diagram.isEmpty()){
			CurrentDiagram d = (CurrentDiagram) diagram ;
			types.addAll(d.getTypes());
		}
		return this ;
	}

	@Override
	public boolean isEmpty() {
		return types.size()>0;
	}

}
