package SVG_Graphviz;
import java.io.File;

public class Main {
	
	public static void main(String[] args) {
	/*	ExportSVG e = new ExportSVG() ;
		e.addln(e.start_graph());
		e.addln("A [shape = square , label = \"Je suis un \ningénieur GIPAD\" ]");
		e.addln("A -> B ");
		e.addln("C -> B [style=dotted,label=\"Interface\"] ");
		e.addln("B -> E " );
		e.addln("E -> C [style=dotted, color=red]");
		e.addln(e.end_graph());
		System.out.println(e.getDotSource());
		
		*/
		ExportSVG exportSVG = new ExportSVG() ;
		DessinDepuisClasse ddc = new DessinDepuisClasse(ExportSVG.class, exportSVG);
		ddc.writeClass();
		ddc.end();
	}
}
