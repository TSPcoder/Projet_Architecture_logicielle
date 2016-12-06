package type;

import java.util.HashMap;

import tools.InfoFinder;

public class MyClass implements Type {
	
	HashMap<String, Object> label ;
	
	/**
	 * Le constructeur initialise l'étiquette  
	 * 
	 * @param nameClasse String
	 */
	public MyClass(String nameClass)  {
		try {
			this.label=InfoFinder.info(Class.forName(nameClass)) ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public HashMap<String, Object> getLabel() {
		return label;
	}
	
	public Object getInfo(String key){
		return this.label.get(key);
	}
	
	
	
	
	

}
