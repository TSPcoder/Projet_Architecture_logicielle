package type;

public class Relation implements IType {

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

}
