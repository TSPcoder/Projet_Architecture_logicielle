package type;

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
	public void etiquetter() {
		// TODO Auto-generated method stub
		
	}

}
