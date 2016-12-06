package interpretor;

import java.util.ArrayList;

import type.MyClass;
import type.Type;
import diagram.CurrentDiagram;
import diagram.IDiagram;

public class DrawingText implements Drawing {
	IDiagram d ;
	
	public DrawingText(IDiagram d) {
		this.d=d;
	}

	@Override
	public void display() {
		String s = "" ;
		if (!d.isEmpty()){
			for (int i = 0 ; i < d.getTypes().size() ; i++){
				Type t = d.getType(i);
				if(t.getType()=="Class"){
					s+= "Type numéro " + (i+1) + " : Classe \"" + t.getInfo("name") + "\" \n" ;
					
					s+= "\nConstructeur(s) :\n" ;
					ArrayList<String> array =  (ArrayList<String>) t.getInfo("constructors") ;
					for( String str : array ){
						s+= str + "\n" ;
					}
					
					s+= "\nMéthode(s) :\n" ;
					array =  (ArrayList<String>) t.getInfo("methods") ;
					for( String str : array ){
						s+= str + "\n" ;
					}
					s+="\n\n";
				}
			}
		}
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		ArrayList<Type> listeTypes = new ArrayList<>();
		listeTypes.add(new MyClass("type.Relation"));
		listeTypes.add(new MyClass("diagram.CurrentDiagram"));
		CurrentDiagram diag = new CurrentDiagram(listeTypes);
		DrawingText dessinTexte = new DrawingText(diag);
		dessinTexte.display();
	}

}
