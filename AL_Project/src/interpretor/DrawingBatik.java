package interpretor;

import diagram.IDiagram;

public class DrawingBatik implements Drawing {

	private IDiagram diagram;
	private String svg_name;
	
	public DrawingBatik(IDiagram diagram, String name) {
		this.diagram = diagram;
		this.svg_name = name;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	public String getSVGName() {
		return this.svg_name;
	}

}
