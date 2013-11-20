package hg.histo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonBarPanel extends JPanel{
	
	private JButton btZoomToFit = new JButton("Zoom Off");

	public ButtonBarPanel(){
		this.add(btZoomToFit);
		setBackground(Color.GREEN);

	}

	public JButton getBtZoomToFit() {
		return btZoomToFit;
	}

	public void setBtZoomToFit(JButton btZoomToFit) {
		this.btZoomToFit = btZoomToFit;
	}
	
	
}
