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
	String title ;
	
	public CurrentDiagram(ArrayList<Type> l) {
		this.types=l ;
	}
	
	public ArrayList<Type> getTypes() {
		return types;
	}
	
	public Type getType(int i) {
		return types.get(i);
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
		return types.size()==0;
	}

	@Override
	public void etiquetter(String nomDiagramme) {
		this.title=nomDiagramme;
	}

}
