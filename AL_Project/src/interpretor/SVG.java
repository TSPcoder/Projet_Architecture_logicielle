package interpretor;

import diagram.IDiagram;

public class SVG implements Dessin {

	private IDiagram diagram;
	private String svg_name;
	
	public SVG(IDiagram diagram, String name) {
		this.diagram = diagram;
		this.svg_name = name;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IDiagram getDiagram() {
		// TODO Auto-generated method stub
		return this.diagram;
	}
	
	public String getSVGName() {
		return this.svg_name;
	}

}
