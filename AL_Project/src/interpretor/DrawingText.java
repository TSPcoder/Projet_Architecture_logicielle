package interpretor;

import java.util.ArrayList;

import type.MyClass;
import type.Type;
import diagram.CurrentDiagram;
import diagram.EmptyDiagramException;
import diagram.IDiagram;

/**
 * Cette classe représente une représentation du diagramme sous forme de texte
 * 
 */

public class DrawingText implements Drawing {
	IDiagram diagram ;
	
	public DrawingText(IDiagram d) {
		this.diagram=d;
	}

	@Override
	public void draw() throws EmptyDiagramException {
		String s = "" ;
		if (!diagram.isEmpty()){
			for (int i = 0 ; i < diagram.getTypes().size() ; i++){
				// On récupère les types du diagrammes
				Type t = diagram.getTypes().get(i);
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
	
	
	// 1er test
	public static void main(String[] args) {
		ArrayList<Type> listeTypes = new ArrayList<>();
		listeTypes.add(new MyClass("type.Relation"));
		listeTypes.add(new MyClass("diagram.CurrentDiagram"));
		String title = "Mon diagramme texte" ;
		CurrentDiagram diag = new CurrentDiagram(listeTypes , title);
		DrawingText dessinTexte = new DrawingText(diag);
		try {
			dessinTexte.draw();
		} catch (EmptyDiagramException e) {
			System.out.println("Diagramme Vide !");
			e.printStackTrace();
		}
	}

}
