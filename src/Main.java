import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Main {
	public static void main (String args[]) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		MenuIHC menu = new MenuIHC();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setBackground(Color.white);
		menu.setSize(500, 350);
		menu.setResizable(false);
		menu.setVisible(true);		
		menu.setLocation(dim.width/2-menu.getSize().width/2, dim.height/2-menu.getSize().height/2);
	}
}
