package hg.histo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CheckBoxPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btDisplay=new JButton("Display");

	private JCheckBox checkAll;
	private JCheckBox checkBox ;
	
	
	public CheckBoxPanel(GridLayout gridLayout){
		Border border = BorderFactory.createTitledBorder("Selected Cell");
		setBorder(border);
		setBackground(Color.BLUE);
		setBounds(0, 200, 150, 200);
		setOpaque(true);
		checkAll = new JCheckBox("All cells");
		checkAll.setSelected(true);
		add(checkAll);

		
		
		
		add(btDisplay,BorderLayout.CENTER);

		
	}

	public JButton getBtDisplay() {
		return btDisplay;
	}

	public void setBtDisplay(JButton btDisplay) {
		this.btDisplay = btDisplay;
	}
	
}
