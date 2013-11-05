package hg.histo;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	private JMenuBar menu_bar1;
	private JMenu File, Edition,PropertyCells;
	private JMenuItem open, exit, image_show, image_hidden,addCell, changeColor;



	public Menu() {

	}
	
	public JMenuItem getAddCell() {
		return addCell;
	}

	public void setAddCell(JMenuItem addCell) {
		this.addCell = addCell;
	}

	public JMenuItem getChangeColor() {
		return changeColor;
	}

	public void setChangeColor(JMenuItem changeColor) {
		this.changeColor = changeColor;
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
		PropertyCells = new JMenu("PropertyCells");
		menu_bar1.add(File);
		menu_bar1.add(Edition);
		menu_bar1.add(PropertyCells);
		open = new JMenuItem("Open File");
		exit = new JMenuItem("Exit");
		image_show = new JMenuItem("Display Image");
		image_hidden = new JMenuItem("Hidden Image");
		addCell = new JMenuItem("Add a new type cell");
		changeColor = new JMenuItem("Change color of cell");
		File.add(open);
		File.add(exit);
		Edition.add(image_show);
		Edition.add(image_hidden);
	
		PropertyCells.add(addCell);
		PropertyCells.add(changeColor);

		return menu_bar1;
	}

	
}
