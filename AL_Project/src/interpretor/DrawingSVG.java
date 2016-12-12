package interpretor;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import tools.Placement;
import type.Relation;
import type.Type;
import diagram.EmptyDiagramException;
import diagram.IDiagram;

/**
 * Cette classe permet une réprésentation du diagramme en utilisant la librairie batik
 * 
 * On utilise un objet de type SVGGraphics2D que l'on remplit
 * 
 */

public class DrawingSVG implements Drawing {

	private IDiagram diagram;
	private SVGGraphics2D svgGenerator;
	private PaintBrush paintBrush ;

	static int largeur = 200;
	
	// Ensembles des coins supérieur gauche des rectangles ;
	private HashMap<String, Curseur> coinsSuperieurGauche ;

	public DrawingSVG(IDiagram diagram, PaintBrush p) {
		this.diagram = diagram;
		this.paintBrush=p;
		this.coinsSuperieurGauche=new HashMap<>();
		this.generateAndDraw();
	}

	/**
	 * On génère le fichier SVG et on le remplit (en dessinant)
	 * 
	 */
	public void generateAndDraw() {
		// Création document SVG
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		SVGDocument doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);

		// Création convertisseur pour ce document
		this.svgGenerator = new SVGGraphics2D(doc);

		// On remplit l'objet avec les types contenus dans le diagramme
		try {
			this.draw();
			// Populate the document root with the generated SVG content.
			Element root = doc.getDocumentElement();
			svgGenerator.getRoot(root);
		} catch (EmptyDiagramException e) {
			e.printStackTrace();
		}
	}

	public IDiagram getDiagram() {
		return diagram;
	}

	public SVGGraphics2D getSvgGraphics() {
		return svgGenerator;
	}

	@Override
	public void draw() throws EmptyDiagramException {
		if (!diagram.isEmpty()) {
			
			// Création d'une instance de placement
			Placement p = new Placement();
			// Ce curseur représente le point supérieur gauche du premier objet (classe ou interface)
			Curseur depart = new Curseur(10, 10) ;
			// Ce curseur représente le point supérieur gauche de l'objet courant 
			Curseur coinSuperieurGauche = new Curseur(10, 10) ;
			
			for (int i = 0; i < diagram.getTypes().size(); i++) {
				Type t = diagram.getTypes().get(i);
				if (t.getType() == "Class" || t.getType() == "Interface") {
					
					// On remplit svgGenerator
					this.etiquetter(t,coinSuperieurGauche);
					String nomType = (String) t.getInfo("name");
					
					// On sauvegarde le coin supérieur gauche de notre rectangle
					this.coinsSuperieurGauche.put(nomType, new Curseur(coinSuperieurGauche));
					
					// Détermination du nouveau coin supérieur gauche pour les objets suivants
					p.algoPlacement();
					coinSuperieurGauche.setX(depart.getX() + p.getPlacementHorizontal()*3*largeur/2);
					coinSuperieurGauche.setY(depart.getY() + p.getLigneCourante()*4*largeur/3);
				}
				else{
					if (t.getType() == "Relation"){
						this.etiquetterRelation(t);			
					}
				}
			}
		}
	}
	
	/**
	 * Cette méthode permet d'afficher la relation entre deux types
	 * 
	 * à noter que la relation s'effectue du type d'entrée au type de sortie
	 * (l'ordre est donc essentiel !)
	 * 
	 * On va ici tracer une ligne entre le coin supérieur gauche et le coin
	 * inférieur gauche de notre classe
	 * 
	 */
	public void etiquetterRelation(Type t) {

		// On a ici toutes les relations (extends et implements) du type 1 (type
		// d'entrée)
		ArrayList<String> extendsType1 = (ArrayList<String>) t.getInfo("extends");
		ArrayList<String> implementsType1 = (ArrayList<String>) t.getInfo("implements");

		if (extendsType1.size() != 0 || implementsType1.size() != 0) {

			boolean existeRelation = false;
			boolean flechePleine = false;

			Type type1 = (((Relation) t).getEntry());
			Type type2 = (((Relation) t).getOutput());

			for (String nomType : extendsType1) {
				// Si on retrouve le nom du type 2 dans extendsType1, alors
				// type1 et type2 sont reliés par une relation de type extends
				if (type2.getInfo("name").equals(nomType)) {
					existeRelation = true;
					flechePleine = true;
				}
			}

			for (String nomType : implementsType1) {
				// Si on retrouve le nom du type 2 dans implementsType1, alors
				// type1 et type2 sont reliés par une relation de type
				// implements
				if (type2.getInfo("name").equals(nomType)) {
					existeRelation = true;
				}
			}

			if (existeRelation) {
				Curseur coinSuperieurGauche1 = coinsSuperieurGauche.get(type1.getInfo("name"));
				Curseur coinSuperieurGauche2 = coinsSuperieurGauche.get(type2.getInfo("name"));

				int hauteur2 = Placement.calculHauteur(coinSuperieurGauche2,type2);

				Curseur coinInferieurGauche2 = new Curseur(
						coinSuperieurGauche2.getX(),
						coinSuperieurGauche2.getY() + hauteur2);

				if (flechePleine) {
					svgGenerator.drawLine(coinSuperieurGauche1.getX(),
							coinSuperieurGauche1.getY(),
							coinInferieurGauche2.getX(),
							coinInferieurGauche2.getY());
				} else {
					final float dash1[] = { 10.0f };
					final BasicStroke dashed = new BasicStroke(1.0f,
							BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
							10.0f, dash1, 0.0f);
					Stroke previousStroke = svgGenerator.getStroke();
					svgGenerator.setStroke(dashed);

					svgGenerator.drawLine(coinSuperieurGauche1.getX(),
							coinSuperieurGauche1.getY(),
							coinInferieurGauche2.getX(),
							coinInferieurGauche2.getY());
					svgGenerator.setStroke(previousStroke);
				}
			}

		}
	}
	
	/**
	 * Cette méthode permet de créer le rectangle contenant les informations du
	 * type et de le remplir avec les couleurs associées
	 * 
	 */
	public void remplissage(Type t, Curseur c) {
		// Calcul de la hauteur du rectangle
		int hauteur = Placement.calculHauteur(c, t);

		// On commence par remplir le rectangle
		svgGenerator.setPaint(this.paintBrush.getCouleurRemplissage());
		svgGenerator.fill(new Rectangle(c.getX(), c.getY(), largeur, hauteur));

		// On trace ensuite le contour de ce rectangle
		svgGenerator.setPaint(this.paintBrush.getCouleurContour());
		svgGenerator.draw(new Rectangle(c.getX(), c.getY(), largeur, hauteur));
	}
	
	/**
	 * Cette méthode permet remplir l'objet SVG graphique nécessaire pour
	 * dessiner les classes ou les interfaces
	 */
	public void etiquetter(Type t, Curseur coin){
		Curseur depart = coin;
		Curseur curseurMobile = coin ;
		
		// Création et remplissage du rectangle
		this.remplissage(t, depart);
		
		// Texte à placer : 1ère partie
		String s = ("<< Java " + t.getType() + " >>") ;
		Curseur tailleTexte = Placement.tailleTexte(s);
		svgGenerator.drawString(s, curseurMobile.getX() + Placement.placeMilieuX(s,largeur), curseurMobile.getY() + tailleTexte.getY());
		curseurMobile = curseurMobile.down(tailleTexte.getY());
		
		s=(String) t.getInfo("name");
		tailleTexte = Placement.tailleTexte(s);
		svgGenerator.drawString(s, depart.getX() + Placement.placeMilieuX(s,largeur), curseurMobile.getY() + tailleTexte.getY());
		curseurMobile = curseurMobile.down(tailleTexte.getY());
		
		s=(String) t.getInfo("package");
		tailleTexte = Placement.tailleTexte(s);
		svgGenerator.drawString(s, depart.getX() + Placement.placeMilieuX(s,largeur), curseurMobile.getY() + tailleTexte.getY());
		curseurMobile = curseurMobile.down(tailleTexte.getY());
		
		// 1er trait de séparation
		curseurMobile = curseurMobile.down(tailleTexte.getY()/2);
		svgGenerator.drawLine(depart.getX(), curseurMobile.getY(), depart.getX() + largeur, curseurMobile.getY());
		
		// Variables d'instances
		int ecartDroit = Placement.tailleTexte(s).getY()/2 ; // hauteur de la string s
		curseurMobile.setX(ecartDroit + curseurMobile.getX());
		ArrayList<String> l = (ArrayList<String>) t.getInfo("variables");
		for (String var : l){
			s=var ;
			svgGenerator.drawString(s, curseurMobile.getX(), curseurMobile.getY() + tailleTexte.getY());
			curseurMobile = curseurMobile.down(tailleTexte.getY() + tailleTexte.getY()/2);
		}
		
		// 2e trait de séparation
		curseurMobile = curseurMobile.down(tailleTexte.getY()/2);
		svgGenerator.drawLine(depart.getX(), curseurMobile.getY(), depart.getX() + largeur, curseurMobile.getY());
		
		// Constructeur(s)
		l = (ArrayList<String>) t.getInfo("constructors");
		for (String constructor : l) {
			s = constructor;
			svgGenerator.drawString(s, curseurMobile.getX(),
					curseurMobile.getY() + tailleTexte.getY());
			curseurMobile = curseurMobile.down(tailleTexte.getY() + tailleTexte.getY()/2);
		}
		
		// Méthode(s)
		l = (ArrayList<String>) t.getInfo("methods");
		for (String method : l) {
			s = method;
			svgGenerator.drawString(s, curseurMobile.getX(),
					curseurMobile.getY() + tailleTexte.getY());
			curseurMobile = curseurMobile.down(tailleTexte.getY() + tailleTexte.getY()/3);
		}
		svgGenerator.setSVGCanvasSize(new Dimension(500, 500));
	}
	
}
