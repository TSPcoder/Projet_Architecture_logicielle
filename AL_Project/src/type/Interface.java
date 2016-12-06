package type;

public class Interface implements Type {

	@Override
	public Object getInfo(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		EnumerationTypes e = EnumerationTypes.INTERFACE;
		return e.toString();
	}

}
