package diagram;

import java.util.ArrayList;

import type.Type;

/**
 * Instance représentant un diagramme UML contenant plusieurs types (classes, interfaces, relations...)
 *
 */

public class CurrentDiagram implements IDiagram {
	
	ArrayList<Type> types ;
	String title ;
	
	public CurrentDiagram(ArrayList<Type> l , String title) {
		this.types=l ;
		this.title=title;
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
		return types.size()==0;
	}

}
