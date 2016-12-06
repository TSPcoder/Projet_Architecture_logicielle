package diagram;

import type.Type;

public interface IDiagram {
	
	public void addType(Type type);
	
	public void insertDiagram(IDiagram diagram);
	
}
