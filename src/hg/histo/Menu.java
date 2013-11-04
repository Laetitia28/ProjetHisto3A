package hg.histo;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	private JMenuBar menu_bar1;
	private JMenu File, Edition;
	private JMenuItem open, exit, image_show, image_hidden;



	public Menu() {

	}
	public JMenuItem getImage_hidden() {
		return image_hidden;
	}

	public void setImage_hidden(JMenuItem image_hidden) {
		this.image_hidden = image_hidden;
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
		return image_show;
	}

	public void setImage(JMenuItem image) {
		this.image_show = image;
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
		image_show = new JMenuItem("Display Image");
		image_hidden = new JMenuItem("Hidden Image");
		File.add(open);
		File.add(exit);
		Edition.add(image_show);
		Edition.add(image_hidden);
	
		

		return menu_bar1;
	}

	
}
