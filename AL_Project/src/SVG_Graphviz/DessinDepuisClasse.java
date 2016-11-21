package SVG_Graphviz;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import tools.InfoFinder;

public class DessinDepuisClasse {
	
	private HashMap<String, Object> hm ;
	private ExportSVG exSVG ;
	private String a;
	
	public DessinDepuisClasse(Class c , ExportSVG exSVG ){
		this.hm = InfoFinder.info(c) ;
		this.exSVG = exSVG ;
		this.exSVG.addln(this.exSVG.start_graph());
	}
	/*public void writeInterfaces(){
		ArrayList<String> s = (ArrayList<String>) this.hm.get("implements") ;
		for(String str : s){
			Class c ;
			try {
				c = Class.forName(str);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	*/
	public void writeClass(){
		this.a = " A [ " ;
		if("class" == hm.get("type")){
			this.a = this.a + "shape = square , color = green ," ;
		}
		else{
			this.a = this.a + " color = blue ,";
		}
		this.a = this.a + "label = \"" + hm.get("name") + "\n\n Constructeur(s) :\n" ; 
		ArrayList<String> array =  (ArrayList<String>) hm.get("constructors") ;
		for( String s : array ){
			this.a = this.a + s + "\n" ;
		}
		ArrayList<String> array2 =  (ArrayList<String>) hm.get("methods") ;
		for( String s : array2 ){
			this.a = this.a + s + "\n" ;
		}
		this.a=this.a+"\" ]\n ";
		
	}
	
	public void end(){
		this.exSVG.addln(this.a);
		this.exSVG.addln(this.exSVG.end_graph());
		System.out.println(this.exSVG.getDotSource());
		File out = new File("./out."+ExportSVG.fileType);  
		this.exSVG.writeSVG(this.exSVG.getGraph(this.exSVG.getDotSource()), out );
	}

}
