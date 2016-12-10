package Tests;

import interpretor.DrawingSVG;

import java.util.ArrayList;

import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.svg.SVGDocument;

import diagram.CurrentDiagram;
import type.MyClass;
import type.Type;

public class TestDisplaySVG {
	
	JSVGCanvas canvas ;
	
	public TestDisplaySVG() {
		
		// Création d'un diagramme et du dessin associé sous format SVG
		ArrayList<Type> listeTypes = new ArrayList<>();
		listeTypes.add(new MyClass("type.Relation"));
		listeTypes.add(new MyClass("diagram.CurrentDiagram"));
		listeTypes.add(new MyClass("type.Interface"));
		listeTypes.add(new MyClass("diagram.EmptyDiagram"));
		listeTypes.add(new MyClass("type.MyClass"));
		CurrentDiagram diag = new CurrentDiagram(listeTypes, "diagramme test");
		DrawingSVG drawingSVG = new DrawingSVG(diag);
		
		// On affecte le document SVG au canvas
		SVGDocument doc = (SVGDocument) drawingSVG.getSvgGraphics().getDOMFactory();
		canvas = new JSVGCanvas();
		canvas.setSVGDocument(doc);
	}

	public JSVGCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(JSVGCanvas canvas) {
		this.canvas = canvas;
	}
	
}
