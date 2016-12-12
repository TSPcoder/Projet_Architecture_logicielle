package type;

public enum EnumTypes {
	CLASSE ("Class") , INTERFACE ("Interface") , RELATION ("Relation") ;
	
	private String nameType = "";
	
	EnumTypes(String type) {
		this.nameType=type;
	}
	
	public String toString(){
		return this.nameType ;
	}
	
	
}
