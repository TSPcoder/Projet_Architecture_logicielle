package type;

import java.util.HashMap;

import tools.InfoFinder;

/**
 * Cette classe modélise une relation entre le type entry et le type output
 * 
 * Elle peut être ici de deux types : extends ou implements
 * 
 */

public class Relation implements Type {

	private Type entry;
	private Type output;
	
	public Relation(Type entry, Type output) {
		this.entry = entry;
		this.output = output;
	}
	
	public Type getEntry() {
		return this.entry;
	}
	
	public Type getOutput() {
		return this.output;
	}
	
	/**
	 * On suppose que les informations sur le type de départ sont toujours
	 * suffisantes pour trouver la relation entre les deux types
	 */
	@Override
	public Object getInfo(String s) {
		return this.entry.getInfo(s);
	}

	@Override
	public String getType() {
		EnumTypes e = EnumTypes.RELATION;
		return e.toString();
	}


}
