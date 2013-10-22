package hg.histo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	private JMenuBar menu_bar1;
	private JMenu File, Edition;
	private JMenuItem open, exit, image;

	public Menu() {

	}

	public JMenuItem getExit() {
		return exit;
	}

	public JMenuItem getOpen() {
		return open;
	}

	public void setOpen(JMenuItem open) {
		this.open = open;
	}

	public JMenuItem getImage() {
		return image;
	}

	public void setImage(JMenuItem image) {
		this.image = image;
	}

	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}

	public JMenuBar buildMenu() {
		menu_bar1 = new JMenuBar();
		File = new JMenu("File");
		Edition = new JMenu("Edition");
		menu_bar1.add(File);
		menu_bar1.add(Edition);
		open = new JMenuItem("Open File");
		exit = new JMenuItem("Exit");
		image = new JMenuItem("Display Image");
		File.add(open);
		File.add(exit);
		Edition.add(image);
	
		

		image.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		return menu_bar1;
	}

	
}
