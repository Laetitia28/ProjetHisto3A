package hg.histo;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Menu extends JMenuBar{


	private static final long serialVersionUID = 1L;
	private JMenuBar menu_bar1;
	private JMenu File, Edition,PropertyCells;
	private JMenuItem open, exit, image_show, image_hidden;

	private JRadioButtonMenuItem radioButtonMenuItemDisplay,RadioButtonMenuItemHidden;
  

	public Menu() {

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

		
		
		radioButtonMenuItemDisplay = new JRadioButtonMenuItem("Display Image radio");
		radioButtonMenuItemDisplay.setMnemonic(KeyEvent.VK_R);
		RadioButtonMenuItemHidden = new JRadioButtonMenuItem("Hidden Image radio");
		RadioButtonMenuItemHidden.setMnemonic(KeyEvent.VK_O);
        

        
		File.add(open);
		File.add(exit);

		ButtonGroup group = new ButtonGroup();
		group.add(radioButtonMenuItemDisplay);
		group.add(RadioButtonMenuItemHidden);
	    
       Edition.add(radioButtonMenuItemDisplay);
       Edition.add(RadioButtonMenuItemHidden);
		


		return menu_bar1;
	}

	public JMenu getEdition() {
		return Edition;
	}

	public void setEdition(JMenu edition) {
		Edition = edition;
	}

	public JMenu getPropertyCells() {
		return PropertyCells;
	}

	public void setPropertyCells(JMenu propertyCells) {
		PropertyCells = propertyCells;
	}

	public JRadioButtonMenuItem getRadioButtonMenuItemDisplay() {
		return radioButtonMenuItemDisplay;
	}

	public void setRadioButtonMenuItemDisplay(JRadioButtonMenuItem radioButtonMenuItemDisplay) {
		this.radioButtonMenuItemDisplay = radioButtonMenuItemDisplay;
	}

	public JRadioButtonMenuItem getRadioButtonMenuItemHidden() {
		return RadioButtonMenuItemHidden;
	}

	public void setRadioButtonMenuItemHidden(JRadioButtonMenuItem radioButtonMenuItemHidden) {
		RadioButtonMenuItemHidden = radioButtonMenuItemHidden;
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
}

	
