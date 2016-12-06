package type;

public class Relation implements Type {

	private Classe entry;
	private Classe output;
	
	public Relation(Classe entry, Classe output) {
		this.entry = entry;
		this.output = output;
	}
	
	public Classe getEntry() {
		return this.entry;
	}
	
	public Classe getOutput() {
		return this.output;
	}

}
