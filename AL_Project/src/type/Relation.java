package type;

/**
 * Cette classe modélise une relation entre deux types
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

	@Override
	public Object getInfo(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		EnumerationTypes e = EnumerationTypes.RELATION;
		return e.toString();
	}


}
