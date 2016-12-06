package diagram;

import type.Type;

public class EmptyDiagram implements IDiagram {
	
	
	@Override
	public void addType(Type type) {
		// Il n'y'a pas de types dans un diagramme vide !
	}

	@Override
	public void insertDiagram(IDiagram diagram) {
		// TODO Auto-generated method stub
		
	}

}
