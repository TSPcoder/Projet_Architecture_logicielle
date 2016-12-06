package type;

public enum EnumerationTypes {
	CLASSE ("Class") , INTERFACE ("Interface") , RELATION ("Relation") ;
	
	private String nameType = "";
	
	EnumerationTypes(String type) {
		this.nameType=type;
	}
	
	public String toString(){
		return this.nameType ;
	}
	
	
}
