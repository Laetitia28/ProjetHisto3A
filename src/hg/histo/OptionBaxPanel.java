package hg.histo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphOutline;


public class OptionBaxPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonBarPanel buttonBar = new ButtonBarPanel();
	CheckBoxPanel down = new CheckBoxPanel(new GridLayout(0,1));
	private JButton btZoomToFit = new JButton("Zoom Off");
    private JPanel panel1;

	public OptionBaxPanel(){
		panel1=new JPanel();
<<<<<<< HEAD
=======
		//panel1.add(btZoomToFit)
>>>>>>> 0b16ca6449ceb41d3f2aa127b980980362d4f4c2
		add(btZoomToFit);//because Zoom is on NORTH

		add(down,BorderLayout.SOUTH);
	

	}

	public ButtonBarPanel getButtonBar() {
		return buttonBar;
	}

	public void setButtonBar(ButtonBarPanel buttonBar) {
		this.buttonBar = buttonBar;
	}
	

}
