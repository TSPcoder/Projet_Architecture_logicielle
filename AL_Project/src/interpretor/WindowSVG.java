package interpretor;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.apache.batik.swing.JSVGCanvas;

import type.MyClass;
import type.Type;
import diagram.CurrentDiagram;

/**
 * Cette fenêtre permet d'afficher le document
 * 
 */
public class WindowSVG extends JFrame {
	
	public WindowSVG(int largeur, int hauteur) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JSVGCanvas canvas = new JSVGCanvas();
		setSize(largeur,hauteur);
		getContentPane().add(canvas);
		// canvas.setSVGDocument(doc);
		pack();
	}
	
	public static void main(String[] args) {
		
		/*
		ArrayList<Type> listeTypes = new ArrayList<>();
		listeTypes.add(new MyClass("type.Relation"));
		listeTypes.add(new MyClass("diagram.CurrentDiagram"));
		CurrentDiagram diag = new CurrentDiagram(listeTypes);
		
		DrawingBatik dessinSVG = new DrawingBatik(diag);
		dessinSVG.draw();
		
		WindowSVG w = new WindowSVG(400, 600);
		w.setVisible(true);
		*/
	}
}
