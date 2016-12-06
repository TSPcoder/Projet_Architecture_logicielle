package diagram;

import java.awt.Color;
import type.IType;

public interface IDiagram {
	
	public void addType(IType type);
	
	public void insertDiagram(IDiagram diagram);
	
	public void setColor(Color color);
	
	public void setThickness(int thickness);
	
}
