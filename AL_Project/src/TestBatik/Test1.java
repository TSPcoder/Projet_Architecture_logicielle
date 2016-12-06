package TestBatik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TextArea;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.JFrame;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.bridge.SVGDocumentBridge;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import Dessin.Curseur;

public class Test1 {
	
	static int largeur = 200 ;
	static int hauteur = 300 ;

	public void paint(Graphics2D g2d) {
		g2d.setPaint(Color.red);
		g2d.fill(new Rectangle(10, 10, 100, 100));
	}
	
	public static Curseur tailleTexte(String texte){
		//String texte = "Hello World";
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
		Font font = new Font("Tahoma", Font.PLAIN, 12);
		int textwidth = (int)(font.getStringBounds(texte, frc).getWidth());
		int textheight = (int)(font.getStringBounds(texte, frc).getHeight());
		System.out.println("largeur texte : " + textwidth);
		System.out.println("hauteur texte : " + textheight);
		return new Curseur(textwidth, textheight);
	}
	
	public static int placeMilieuX (String texte){
		Curseur taille = tailleTexte(texte);
		return (largeur/2 - taille.getX()/2) ;
	}
	
	public static void etiquetter(SVGGraphics2D svgGenerator){
		
		Curseur depart = new Curseur(10,10);
		Curseur curseurMobile = depart ;
		
		svgGenerator.setPaint(Color.black);
		
		svgGenerator.drawRect(curseurMobile.getX(), curseurMobile.getY(), largeur, hauteur);
		svgGenerator.drawLine(curseurMobile.getX(), hauteur/3, curseurMobile.getX() + largeur, hauteur/3);
		
		// Texte à placer 
		String s = ("<< Java Class >>") ;
		Curseur tailleTexte = tailleTexte(s);
		svgGenerator.drawString(s, curseurMobile.getX() + largeur/2 - tailleTexte.getX()/2, curseurMobile.getY() + tailleTexte.getY());
		curseurMobile = curseurMobile.down(tailleTexte.getY());
		
		s=("Test1");
		tailleTexte = tailleTexte(s);
		svgGenerator.drawString(s, depart.getX() + largeur/2 - tailleTexte.getX()/2, curseurMobile.getY() + tailleTexte.getY());
		
		
		svgGenerator.setSVGCanvasSize(new Dimension(500, 500));
		
	}

	public static void main(String[] args) throws IOException {

		/*
		 * // Get a DOMImplementation. DOMImplementation domImpl =
		 * GenericDOMImplementation .getDOMImplementation();
		 * 
		 * // Create an instance of org.w3c.dom.Document. String svgNS =
		 * "http://www.w3.org/2000/svg"; Document document =
		 * domImpl.createDocument(svgNS, "svg", null);
		 * 
		 * // Create an instance of the SVG Generator. SVGGraphics2D
		 * svgGenerator = new SVGGraphics2D(document);
		 * 
		 * // Ask the test to render into the SVG Graphics2D implementation.
		 * Test1 test = new Test1(); test.paint(svgGenerator);
		 * 
		 * // Finally, stream out SVG to the standard output using // UTF-8
		 * encoding. boolean useCSS = true; // we want to use CSS style
		 * attributes Writer out = new OutputStreamWriter(System.out, "UTF-8");
		 * svgGenerator.stream(out, useCSS);
		 */

		// DESSIN

		// Création document SVG.
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
	    String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
	    SVGDocument doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);
	    
	 // Create a converter for this document.
	    SVGGraphics2D svgGenerator = new SVGGraphics2D(doc);

		Shape rectangle = new Rectangle(10, 10, 50, 100);
		etiquetter(svgGenerator);
		
		/*
		svgGenerator.translate(60, 0);
		svgGenerator.setPaint(Color.green);
		svgGenerator.fill(rectangle);
		svgGenerator.translate(60, 0);
		svgGenerator.setPaint(Color.blue);
		svgGenerator.fill(rectangle);
		
		*/
		
		// Populate the document root with the generated SVG content.
		Element root = doc.getDocumentElement();
		svgGenerator.getRoot(root);
		
		// Display the document.
		JSVGCanvas canvas = new JSVGCanvas();
		JFrame f = new JFrame();
		int largeur = 400 ;
		int hauteur = 600 ;
		f.setSize(largeur,hauteur);
		f.getContentPane().add(canvas);
		canvas.setSVGDocument(doc);
		//f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JFREESVG
		/*
		 * Graphics2D g2 = new SVGGraphics2D(300, 200); g2.setPaint(Color.RED);
		 * g2.draw(new Rectangle(10, 10, 280, 180)); String svgElement =
		 * g2.getSVGElement(); System.out.println(svgElement);
		 */
	}
}
