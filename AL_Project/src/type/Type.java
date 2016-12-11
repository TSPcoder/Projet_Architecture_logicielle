package type;

/**
 * Le Type représente les objets de notre diagramme (les composants UML tels que
 * la classe, les flêches etc..)
 *
 */

public interface Type {

	/** Permet d'obtenir l'information relative à la chaîne de caractère s  */
	public Object getInfo(String s);
	
	/** Permet d'obtenir la nature du type (Classe, Interface ...) */
	public String getType();

}
