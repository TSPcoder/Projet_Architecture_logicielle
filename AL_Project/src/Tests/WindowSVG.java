package Tests;

import javax.swing.JFrame;

/**
 * Cette fenêtre permet d'afficher le document
 * 
 */
public class WindowSVG extends JFrame {
	
	public WindowSVG(int largeur, int hauteur) {
		this.setTitle("Fenêtre SVG");
		this.setSize(largeur,hauteur);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// On crée une instance de test
		TestDisplaySVG test = new TestDisplaySVG();
		
		getContentPane().add(test.getCanvas());
		this.pack();
	}
	
	public static void main(String[] args) {
		WindowSVG w = new WindowSVG(500, 700);
		w.setVisible(true);
	}
}
