package type;

import java.util.HashMap;

import tools.InfoFinder;

/**
 * MyInterface représente l'objet Interface dans un diagramme UML
 */
public class MyInterface implements Type {

	HashMap<String, Object> label;

	/**
	 * Le constructeur initialise l'étiquette "label"
	 * 
	 * @param nameClasse
	 *            String
	 */
	public MyInterface(String nameInterface) {
		try {
			this.label = InfoFinder.info(Class.forName(nameInterface));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getInfo(String key) {
		return this.label.get(key);
	}

	@Override
	public String getType() {
		EnumerationTypes e = EnumerationTypes.INTERFACE;
		return e.toString();
	}

}
