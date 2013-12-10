package hg.histo;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Menu extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menu_bar1;
	private JMenu File, Edition,PropertyCells;
	private JMenuItem open, exit, image_show, image_hidden,addCell, changeColor,list;
	private JRadioButtonMenuItem cb1,cb2;
	private JRadioButtonMenuItem radioButtonMenuItemDisplay,RadioButtonMenuItemHidden;
    public JRadioButtonMenuItem getCb1() {
		return cb1;
	}

	public void setCb1(JRadioButtonMenuItem cb1) {
		this.cb1 = cb1;
	}

	public JRadioButtonMenuItem getCb2() {
		return cb2;
	}

	public void setCb2(JRadioButtonMenuItem cb2) {
		this.cb2 = cb2;
	}

	FramCell fr;


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
		//image_show = new JMenuItem("Display Image");
		//image_hidden = new JMenuItem("Hidden Image");
		
		
		radioButtonMenuItemDisplay = new JRadioButtonMenuItem("Display Image");
		radioButtonMenuItemDisplay.setMnemonic(KeyEvent.VK_R);
		RadioButtonMenuItemHidden = new JRadioButtonMenuItem("Hidden Image");
		RadioButtonMenuItemHidden.setMnemonic(KeyEvent.VK_O);
        
		cb1 = new JRadioButtonMenuItem("Display Image");
		cb1.setMnemonic(KeyEvent.VK_R);
        cb2 = new JRadioButtonMenuItem("Hidden Image");
        cb2.setMnemonic(KeyEvent.VK_O);
      //  cb1.addActionListener(this);
      //  cb2.addActionListener(this);
        
		File.add(open);
		File.add(exit);
		//Edition.add(image_show);
		//Edition.add(image_hidden);
		ButtonGroup group = new ButtonGroup();
		group.add(radioButtonMenuItemDisplay);
		group.add(RadioButtonMenuItemHidden);
	    group.add(cb1);
	    group.add(cb2);
	    
	   Edition.add(cb1);
       Edition.add(cb2);
       
       Edition.add(radioButtonMenuItemDisplay);
       Edition.add(RadioButtonMenuItemHidden);
		
	
		//PropertyCells.add(addCell);
		//PropertyCells.add(changeColor);

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
}

	
