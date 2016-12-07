package interpretor;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.svg.SVGDocument;

import diagram.IDiagram;

/**
 * Cette classe représente une représentation du diagramme en utilisant la librairie batik
 * 
 */

public class DrawingBatik implements Drawing {

	private IDiagram diagram;
	SVGGraphics2D svgGenerator ;
	
	public DrawingBatik(IDiagram diagram) {
		this.diagram = diagram;

		// Création document SVG
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		SVGDocument doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);

		// Création convertisseur pour ce document
		this.svgGenerator = new SVGGraphics2D(doc);
	}
	
	@Override
	public void draw() {
		if (!diagram.isEmpty()){
			
		}
	}
	
	public static void main(String[] args) {
		
	}

}
