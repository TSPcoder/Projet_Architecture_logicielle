package interpretor;

import diagram.IDiagram;

/**
 * Cette interface représente l'interprétation de notre langage
 * 
 * C'est ici que l'on interprète notre langage (sous forme de SVG ou de texte...)
 *
 */

public interface Drawing {

	/** Permet d'afficher le dessin sous la forme demandée (XML, texte etc..)  */
	public void display();
}
