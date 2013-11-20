package hg.histo;
import java.awt.BorderLayout;

import javax.swing.JPanel;


public class OptionBaxPanel extends JPanel{
	
	private ButtonBarPanel buttonBar = new ButtonBarPanel();

	public OptionBaxPanel(){
		this.add(buttonBar,BorderLayout.CENTER);//because Zoom is on NORTH

	}

	public ButtonBarPanel getButtonBar() {
		return buttonBar;
	}

	public void setButtonBar(ButtonBarPanel buttonBar) {
		this.buttonBar = buttonBar;
	}
	

}
