package hg.histo;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonBarPanel extends JPanel{
	
	private JButton btZoomToFit = new JButton("Zoom Off");

	public ButtonBarPanel(){
		this.add(btZoomToFit);

	}

	public JButton getBtZoomToFit() {
		return btZoomToFit;
	}

	public void setBtZoomToFit(JButton btZoomToFit) {
		this.btZoomToFit = btZoomToFit;
	}
	
	
}
