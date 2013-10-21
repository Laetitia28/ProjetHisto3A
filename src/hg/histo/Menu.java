package hg.histo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Menu extends JMenuBar{
	
	public Menu(){
	}
	public JMenuBar buildMenu(){
		JMenuBar menu_bar1= new JMenuBar();
		JMenu menu1 = new JMenu("Fichier");
        JMenu menu2 = new JMenu("Edition");
        JMenuItem Ouvrir = new JMenuItem("Ouvrir Fichier");
		JMenuItem Quitter = new JMenuItem("Quitter");
		JMenuItem image = new JMenuItem("Afficher Image");
		JMenuItem copier = new JMenuItem("Copier");
		JMenuItem coller = new JMenuItem("Coller");
		menu1.add(Ouvrir);
		menu1.add(Quitter);
		menu2.add(image);
		menu2.add(copier);
		menu2.add(coller);
	/* Ajouter les menu sur la bar de menu */
		menu_bar1.add(menu1);
		menu_bar1.add(menu2);
		return menu_bar1;
	
	}
	
	

}
