package diagram;

import java.util.ArrayList;

import type.Type;

public class EmptyDiagram implements IDiagram {
	
	ArrayList<Type> types ;
	
	public EmptyDiagram() {
		this.types=new ArrayList<>();
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
	public Type getType(int i) {
		// TODO Auto-generated method stub
		return null ;
	}

	@Override
	public ArrayList<Type> getTypes() {
		// TODO Auto-generated method stub
		return types;
	}

}