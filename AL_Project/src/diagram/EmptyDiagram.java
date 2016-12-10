package diagram;

import java.util.ArrayList;

import type.Type;

public class EmptyDiagram implements IDiagram {
	
	String title ;
	
	public EmptyDiagram(String title) {
		this.title= title + " - Diagramme vide";
	}
	
	@Override
	public void addType(Type type) {
		// Il n'y'a pas de types dans un diagramme vide !
	}

	@Override
	public IDiagram insertDiagram(IDiagram diagram) {
		return diagram ;
	}

	@Override
	public boolean isEmpty() {
		return true ;
	}

	@Override
	public ArrayList<Type> getTypes() throws EmptyDiagramException {
		throw new EmptyDiagramException();
	}

}
