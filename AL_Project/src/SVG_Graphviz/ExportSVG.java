package SVG_Graphviz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class ExportSVG {
	
	private final String tempPath = "./";
	// path du fichier dot.exe � mettre ici 
	private final String dotPath ="C:/Users/Tom Bigault/Desktop/Architecture Logicielle/dot/bin/dot.exe";
	public final static String fileType = "svg";
	private final int[] dpiSizes = {46, 51, 57, 63, 70, 78, 86, 96, 106, 116, 128, 141, 155, 170, 187, 206, 226, 249};
    private int currentDpiPos = 2;
	
    private StringBuilder graph ;
    
    public ExportSVG(){
    	this.graph = new StringBuilder() ;
    }
    
    public String start_graph() {
        return "digraph G {";
    }
    
    public String end_graph() {
        return "}";
    }
    public void addln(String line) {
        this.graph.append(line + "\n");
    }
    
    public void clearGraph(){
        this.graph = new StringBuilder();
    }
	
    public String getDotSource() {
        return this.graph.toString();
    }
    
    
    public byte[] getSVG( File file){
    	File graph_svg;
        byte[] imgSVG = null;

        try {
            graph_svg = File.createTempFile("graph_", "."+this.fileType , new File(this.tempPath));
            Runtime rt = Runtime.getRuntime();

            String[] args = { this.dotPath, "-T"+this.fileType,
            		"-Kdot" , "-Gdpi=" + dpiSizes[this.currentDpiPos],
            		file.getAbsolutePath(), "-o", graph_svg.getAbsolutePath() };
            Process p = rt.exec(args);
            p.waitFor();

            FileInputStream in = new FileInputStream(graph_svg.getAbsolutePath());
            imgSVG = new byte[in.available()];
            
            in.read(imgSVG);
            if( in != null ) {
                in.close();
            }
            if (graph_svg.delete() == false) {
                System.err.println("Attention: " + graph_svg.getAbsolutePath() + "ne peut pas �tre effac�!");
            }
        }
        catch (java.io.IOException | InterruptedException ioe) {
            ioe.printStackTrace();
        }
		return imgSVG;
	}
    
    public int writeSVG(byte[] img, File file){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            
            fos.write(img);
            fos.close();
            
        } catch (java.io.IOException ioe) { return -1 ;}
        return 1;
        
    }
    
    public byte[] getGraph(String dotSource){
        
    	File graph;
        byte[] img = null;

        graph = writeSource(dotSource);
		if (graph != null)
		{
		    img = getSVG(graph);
		    if (graph.delete() == false) {
		        System.err.println("Atention: " + graph.getAbsolutePath() + "ne peut pas �tre effac�!");
		    }
		    return img;
		}
		return null;
		
    }

	private File writeSource(String str) {
		 File temp;
	        try {
	            temp = File.createTempFile("graph_", ".dot.tmp", new File(this.tempPath));
	            FileWriter fout = new FileWriter(temp);
	            fout.write(str);
	            fout.close();
	        }
	        catch (Exception e) {
	            System.err.println("Error: Ecriture Dot dans fichier temporaire!");
	            return null;
	        }
	        return temp;
	}


}
