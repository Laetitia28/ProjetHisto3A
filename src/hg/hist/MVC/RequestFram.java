package hg.hist.MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RequestFram extends JFrame implements ActionListener,
		ChangeListener {

	private static final long serialVersionUID = 123456L;

	private JLabel LabelChooseType = new JLabel("Choose your Cellule");
	private JLabel Sphericity = new JLabel("Choose your Spherecity");
	private JLabel Area = new JLabel("Choose your Area");
	private JLabel Border = new JLabel("Choose your Border");

	private JPanel panel = new JPanel();
	private JPanel paneCellule = new JPanel();
	private JPanel paneSphere = new JPanel();
	private JPanel paneSphere2 = new JPanel();
	private JPanel paneArea = new JPanel();
	private JPanel paneArea2 = new JPanel();
	private JPanel paneBorder = new JPanel();
	private JPanel paneBorder2 = new JPanel();
	private JPanel paneEnd = new JPanel();

	private JButton btFinish = new JButton("Finish");
	private JButton btApply = new JButton("Apply");
	private JButton btClear = new JButton("Clear");

	private JCheckBox btSupSphericity = new JCheckBox("Sup");
	private JCheckBox btInfSphericity = new JCheckBox("Inf");

	private JCheckBox btSupArea = new JCheckBox("Sup");
	private JCheckBox btInfArea = new JCheckBox("Inf");

	private JCheckBox btSupBorder = new JCheckBox("Sup");
	private JCheckBox btInfBorder = new JCheckBox("Inf");

	private JSlider sliderSphericitySup ; 
	private JSlider sliderSphericityInf ;
	private JSlider sliderAreaSup ;
	private JSlider sliderAreaInf ;
	private JSlider sliderBorderSup ;
	private JSlider sliderBorderInf;

	private JTextField sliderDisplaySphericitySup = new JTextField();
	private JTextField sliderDisplaySphericityInf = new JTextField();
	private JTextField sliderDisplayAreaSup = new JTextField();
	private JTextField sliderDisplayAreaInf = new JTextField();
	private JTextField sliderDisplayBorderSup = new JTextField();
	private JTextField sliderDisplayBorderInf = new JTextField();

	private JPanel rubrique1 = new JPanel();
	private JPanel rubrique2 = new JPanel();
	private JPanel rubrique3 = new JPanel();
	private JPanel rubrique4 = new JPanel();

	private ButtonGroup groupButton = new ButtonGroup();;

	private JRadioButton btRadio1 = new JRadioButton("All Cells", true);
	private JRadioButton btRadio2 = new JRadioButton("Nucleus DAB+ PRD+");
	private JRadioButton btRadio3 = new JRadioButton("Lymphocyte Nucleus");
	private JRadioButton btRadio4 = new JRadioButton("Tumor nucleus");
	private JRadioButton btRadio5 = new JRadioButton("NucleusPRD+");
	private JRadioButton btRadio6 = new JRadioButton("Granulocyte nucleus");
	private JRadioButton btRadio7 = new JRadioButton("Nucleus DAB+");

	private String stringTypeCell = "All Cells";
	
	private double default_stringAreaSup;
	private double default_stringAreaInf;
	private double default_stringSphericitySup;
	private double default_stringSphericityInf;
	private double default_stringBorderSup ;
	private double default_stringBorderInf ;
	
	private double stringAreaSup;
	private double stringAreaInf;
	private double stringSphericitySup;
	private double stringSphericityInf;
	private double stringBorderSup ;
	private double stringBorderInf;


	public RequestFram(double maxArea, double maxSphericity, double maxBorder ,double minArea ,double minSphericity , double minBorder ) {


		double default_stringAreaSup = minArea;
		 double default_stringAreaInf = maxArea;
		 double default_stringSphericitySup = minSphericity;
		double default_stringSphericityInf = maxSphericity;
		double default_stringBorderSup = minBorder;
		double default_stringBorderInf = maxBorder;
		
		
		 double stringAreaSup = default_stringAreaSup;
		 double stringAreaInf = default_stringAreaInf;
		 double stringSphericitySup = default_stringSphericitySup;
		 double stringSphericityInf = default_stringSphericityInf;
		 double stringBorderSup = default_stringBorderSup;
		 double stringBorderInf = default_stringBorderInf;
		
		sliderSphericitySup = new JSlider(JSlider.HORIZONTAL,
				(int)minSphericity, (int)maxSphericity,(int) (maxSphericity-minSphericity)/2);
		
		sliderSphericityInf = new JSlider(JSlider.HORIZONTAL,
				(int)minSphericity, (int)maxSphericity,(int) (maxSphericity-minSphericity)/2);
		sliderAreaSup = new JSlider(JSlider.HORIZONTAL, (int)minArea, (int)maxArea,(int) (maxArea-minArea)/2);
		sliderAreaInf = new JSlider(JSlider.HORIZONTAL,(int)minArea, (int)maxArea,(int) (maxArea-minArea)/2);
				
		sliderBorderSup = new JSlider(JSlider.HORIZONTAL,
				(int)minBorder, (int)maxBorder,(int) (maxBorder-minBorder)/2);
		sliderBorderInf = new JSlider(JSlider.HORIZONTAL,
				(int)minBorder, (int)maxBorder,(int) (maxBorder-minBorder)/2);
		
		this.setSize(800, 600);

		panel.setBackground(Color.white);
		this.add(panel);
		// choisir la cellule

		rubrique1.setPreferredSize(new Dimension(1200, 100));
		rubrique1.setBackground(Color.white);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		paneCellule.setBorder(blackline);
		paneCellule.setBounds(0, 200, 150, 200);
		paneCellule.setOpaque(true);
		paneCellule.setBackground(Color.white);
		paneCellule.setPreferredSize(new Dimension(600, 50));
		
		paneCellule.setLayout(new GridLayout(3, 3));

		groupButton.add(btRadio1);
		groupButton.add(btRadio2);
		groupButton.add(btRadio3);
		groupButton.add(btRadio4);
		groupButton.add(btRadio4);
		groupButton.add(btRadio5);
		groupButton.add(btRadio6);
		groupButton.add(btRadio7);


		paneCellule.add(btRadio1);
		paneCellule.add(btRadio2);
		paneCellule.add(btRadio3);
		paneCellule.add(btRadio4);
		paneCellule.add(btRadio5);
		paneCellule.add(btRadio6);
		paneCellule.add(btRadio7);


		btRadio1.addActionListener(new StateListener());
		btRadio2.addActionListener(new StateListener());
		btRadio3.addActionListener(new StateListener());
		btRadio4.addActionListener(new StateListener());
		btRadio5.addActionListener(new StateListener());
		btRadio6.addActionListener(new StateListener());
		btRadio7.addActionListener(new StateListener());


		rubrique1.add(LabelChooseType, BorderLayout.NORTH);
		rubrique1.add(paneCellule, BorderLayout.NORTH);

		// choisir la surface

		rubrique2.setPreferredSize(new Dimension(1200, 100));
		rubrique2.setBackground(Color.white);

		paneArea.setLayout(new GridLayout(1, 3));
		paneArea.setBackground(Color.white);
		paneArea.setPreferredSize(new Dimension(400, 50));
		
		paneArea2.setLayout(new GridLayout(1, 3));
		paneArea2.setBackground(Color.white);
		paneArea2.setPreferredSize(new Dimension(400, 50));

		
		//Area
		sliderDisplayAreaSup.setText("Value");
		sliderDisplayAreaSup.setPreferredSize(new Dimension(100, 30));
		sliderDisplayAreaSup.setForeground(Color.BLUE);
		
		sliderDisplayAreaInf.setText("Value");
		sliderDisplayAreaInf.setPreferredSize(new Dimension(100, 30));
		sliderDisplayAreaInf.setForeground(Color.BLUE);


		sliderAreaSup.setMajorTickSpacing(500);
		sliderAreaSup.setMinorTickSpacing(200);
		sliderAreaSup.setPaintTicks(true);
		sliderAreaSup.setPaintLabels(true);

		sliderAreaInf.setMajorTickSpacing(50);
		sliderAreaInf.setMinorTickSpacing(1);
		sliderAreaInf.setPaintTicks(true);
		sliderAreaInf.setPaintLabels(true);

		sliderAreaSup.addChangeListener(this);
		sliderAreaInf.addChangeListener(this);

		sliderDisplayAreaSup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				String typed = sliderDisplayAreaSup.getText();
				sliderAreaSup.setValue(0);
				if (!typed.matches("\\d+")) {
					return;
				}
				int value = Integer.parseInt(typed);
				sliderAreaSup.setValue(value);
			}
		});
		sliderDisplayAreaInf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				String typed = sliderDisplayAreaInf.getText();
				sliderAreaInf.setValue(0);
				if (!typed.matches("\\d+")) {
					return;
				}
				int value = Integer.parseInt(typed);
				sliderAreaInf.setValue(value);
			}
		});

		paneArea.add(btSupArea, BorderLayout.WEST);
		paneArea.add(sliderAreaSup,BorderLayout.CENTER);
		paneArea.add(sliderDisplayAreaSup);
		
		paneArea2.add(btInfArea, BorderLayout.WEST);
		paneArea2.add(sliderAreaInf);
		paneArea2.add(sliderDisplayAreaInf);

		rubrique2.add(Area, BorderLayout.NORTH);
		rubrique2.add(paneArea);
		rubrique2.add(paneArea2);

		// choisir la sphericité

		rubrique3.setPreferredSize(new Dimension(1200, 100));
		rubrique3.setBackground(Color.white);

		paneSphere.setLayout(new GridLayout(1, 3));
		paneSphere.setBackground(Color.white);
		paneSphere.setPreferredSize(new Dimension(400, 50));
		paneSphere2.setLayout(new GridLayout(1, 3));
		paneSphere2.setBackground(Color.white);
		paneSphere2.setPreferredSize(new Dimension(400, 50));

		
		//sphericity
		sliderDisplaySphericitySup.setText("Value");
		sliderDisplaySphericitySup.setPreferredSize(new Dimension(100, 30));
		sliderDisplaySphericitySup.setForeground(Color.BLUE);
		
		sliderDisplaySphericityInf.setText("Value");
		sliderDisplaySphericityInf.setPreferredSize(new Dimension(100, 30));
		sliderDisplaySphericityInf.setForeground(Color.BLUE);

		sliderSphericitySup.setMajorTickSpacing(50);
		sliderSphericitySup.setMinorTickSpacing(1);
		sliderSphericitySup.setPaintTicks(true);
		sliderSphericitySup.setPaintLabels(true);

		sliderSphericityInf.setMajorTickSpacing(50);
		sliderSphericityInf.setMinorTickSpacing(1);
		sliderSphericityInf.setPaintTicks(true);
		sliderSphericityInf.setPaintLabels(true);

		sliderSphericityInf.addChangeListener(this);
		sliderSphericitySup.addChangeListener(this);

		sliderDisplaySphericitySup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				String typed = sliderDisplaySphericitySup.getText();
				sliderSphericitySup.setValue(0);
				if (!typed.matches("\\d+")) {
					return;
				}
				int value = Integer.parseInt(typed);
				sliderSphericitySup.setValue(value);
			}
		});
		sliderDisplaySphericityInf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				String typed = sliderDisplaySphericityInf.getText();
				sliderSphericityInf.setValue(0);
				if (!typed.matches("\\d+")) {
					return;
				}
				int value = Integer.parseInt(typed);
				sliderSphericityInf.setValue(value);
			}
		});

		paneSphere.add(btSupSphericity, BorderLayout.WEST);
		paneSphere.add(sliderSphericitySup);
		paneSphere.add(sliderDisplaySphericitySup);
		paneSphere2.add(btInfSphericity, BorderLayout.WEST);
		paneSphere2.add(sliderSphericityInf);
		paneSphere2.add(sliderDisplaySphericityInf);

		rubrique3.add(Sphericity, BorderLayout.NORTH);
		rubrique3.add(paneSphere);
		rubrique3.add(paneSphere2);

		// choisir Border

		rubrique4.setPreferredSize(new Dimension(1200, 100));
		rubrique4.setBackground(Color.white);

		paneBorder.setLayout(new GridLayout(1, 3));
		paneBorder.setBackground(Color.white);
		paneBorder.setPreferredSize(new Dimension(400, 50));
		paneBorder2.setLayout(new GridLayout(1, 3));
		paneBorder2.setBackground(Color.white);
		paneBorder2.setPreferredSize(new Dimension(400, 50));

		sliderDisplayBorderSup.setText("Value");
		sliderDisplayBorderSup.setPreferredSize(new Dimension(100, 30));
		sliderDisplayBorderSup.setForeground(Color.BLUE);
		sliderDisplayBorderInf.setText("Value");
		sliderDisplayBorderInf.setPreferredSize(new Dimension(100, 30));
		sliderDisplayBorderInf.setForeground(Color.BLUE);

		sliderBorderSup.setMajorTickSpacing(50);
		sliderBorderSup.setMinorTickSpacing(1);
		sliderBorderSup.setPaintTicks(true);
		sliderBorderSup.setPaintLabels(true);

		sliderBorderInf.setMajorTickSpacing(50);
		sliderBorderInf.setMinorTickSpacing(1);
		sliderBorderInf.setPaintTicks(true);
		sliderBorderInf.setPaintLabels(true);

		sliderBorderSup.addChangeListener(this);
		sliderBorderInf.addChangeListener(this);

		sliderDisplayBorderSup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				String typed = sliderDisplayBorderSup.getText();
				sliderBorderSup.setValue(0);
				if (!typed.matches("\\d+")) {
					return;
				}
				int value = Integer.parseInt(typed);
				sliderBorderSup.setValue(value);
			}
		});

		sliderDisplayBorderInf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				String typed = sliderDisplayBorderInf.getText();
				sliderBorderInf.setValue(0);
				if (!typed.matches("\\d+")) {
					return;
				}
				int value = Integer.parseInt(typed);
				sliderBorderInf.setValue(value);
			}
		});

		paneBorder.add(btSupBorder, BorderLayout.WEST);
		paneBorder.add(sliderBorderSup);
		paneBorder.add(sliderDisplayBorderSup);
		paneBorder2.add(btInfBorder, BorderLayout.WEST);
		paneBorder2.add(sliderBorderInf);
		paneBorder2.add(sliderDisplayBorderInf);

		rubrique4.add(Border, BorderLayout.NORTH);
		rubrique4.add(paneBorder);
		rubrique4.add(paneBorder2);

		paneEnd.setPreferredSize(new Dimension(1200, 100));
		paneEnd.setBackground(Color.white);

		btFinish.addActionListener(this);
		btApply.addActionListener(this);
		btClear.addActionListener(this);
	

		paneEnd.add(btFinish, BorderLayout.WEST);
		paneEnd.add(btApply, BorderLayout.WEST);
		paneEnd.add(btClear, BorderLayout.WEST);

		panel.add(rubrique1);
		panel.add(rubrique2);
		panel.add(rubrique3);
		panel.add(rubrique4);
		panel.add(paneEnd, BorderLayout.SOUTH);

	}



	public void stateChanged(ChangeEvent event) {
		// sliderBorderSup
		if (event.getSource() == sliderBorderSup) {
			sliderDisplayBorderSup.setText(String.valueOf(sliderBorderSup
					.getValue()));
			System.out.println("BorderSup : "
					+ String.valueOf(sliderBorderSup.getValue()));
			this.stringBorderSup = Double.valueOf(sliderBorderSup.getValue());

		}
		// SliderBorderInf
		if (event.getSource() == sliderBorderInf) {
			sliderDisplayBorderInf.setText(String.valueOf(sliderBorderInf
					.getValue()));
			System.out.println("BorderInf : "
					+ String.valueOf(sliderBorderInf.getValue()));
			this.stringBorderInf = Double.valueOf(sliderBorderInf.getValue());

		}
		// SliderSphericitySup

		if (event.getSource() == sliderSphericitySup) {
			sliderDisplaySphericitySup.setText(String
					.valueOf(sliderSphericitySup.getValue()));
			System.out.println("SphéericitySup : "
					+ String.valueOf(sliderSphericitySup.getValue()));
			this.stringSphericitySup = Double.valueOf(sliderSphericitySup
					.getValue());

		}
		// SliderSphericityInf
		if (event.getSource() == sliderSphericityInf) {
			sliderDisplaySphericityInf.setText(String
					.valueOf(sliderSphericityInf.getValue()));
			System.out.println("SphéericityInf : "
					+ String.valueOf(sliderSphericityInf.getValue()));
			this.stringSphericityInf = Double.valueOf(sliderSphericityInf
					.getValue());

		}

		// SliderAreaSup
		if (event.getSource() == sliderAreaSup) {
			sliderDisplayAreaSup.setText(String.valueOf(sliderAreaSup
					.getValue()));
			System.out.println("AreaSup : "
					+ String.valueOf(sliderAreaSup.getValue()));
			this.stringAreaSup = Double.valueOf(sliderAreaSup.getValue());

		}
		// SlierAreaInf
		if (event.getSource() == sliderAreaInf) {

			sliderDisplayAreaInf.setText(String.valueOf(sliderAreaInf
					.getValue()));
			System.out.println("AreaInf : "
					+ String.valueOf(sliderAreaInf.getValue()));
			this.stringAreaInf = Double.valueOf(sliderAreaInf.getValue());

		}

	}

	/*
	 * public String getSelectedButtonText(ButtonGroup buttonGroup) { for
	 * (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
	 * .hasMoreElements();) { AbstractButton button = buttons.nextElement();
	 * 
	 * if (button.isSelected()) { stringResultOfRequest = button.getText();
	 * System.out.println("butoon is selected : " + button.getText()); return
	 * stringResultOfRequest; } }
	 * 
	 * return stringResultOfRequest; }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btFinish) {
			System.out.println("It is finish !");
			this.setVisible(false);
		}
		if (e.getSource() == btClear) {
			System.out.println("It is Clear rf !");
			this.btRadio1.setSelected(true);
			
			this.sliderAreaInf.setValue(150);
			this.sliderAreaSup.setValue(150);
			this.sliderBorderInf.setValue(150);
			this.sliderBorderSup.setValue(150);
			this.sliderSphericityInf.setValue(150);
			this.sliderSphericitySup.setValue(150);
		
			this.sliderDisplayAreaSup.setText("Value");
			this.sliderDisplayAreaInf.setText("Value");
			this.sliderDisplayBorderInf.setText("Value");
			this.sliderDisplayBorderSup.setText("Value");
			this.sliderDisplaySphericityInf.setText("Value");
			this.sliderDisplaySphericitySup.setText("Value");
			this.setVisible(true);
			
		}

		if (e.getSource() == btApply) {
			System.out.println("It is apply from RequestFram !");

			if (btSupArea.isSelected()) {
			//	System.out.println("btSupArea is Selected : "
//						+ this.stringAreaSup);

			} else // valeur par defaut
			{
				this.stringAreaSup = default_stringAreaSup;
	//			System.out.println("Sup Area : " + this.stringAreaSup);

			}

			if (btInfArea.isSelected()) {
		//		System.out.println("btInfArea is Selected : "
			//			+ this.stringAreaInf);

			} else {
				this.stringAreaInf = default_stringAreaInf;
				//System.out.println("Inf Area : " + this.stringAreaInf);

			}

			if (btSupSphericity.isSelected()) {
				//System.out.println("btSupSphericity is Selected : "
					//	+ this.stringSphericitySup);

			} else // valeur par defaut
			{
				this.stringSphericitySup = default_stringSphericitySup;
				//System.out.println("Sup Sphericity : "
				//		+ this.stringSphericitySup);

			}

			if (btInfSphericity.isSelected()) {
				//System.out.println("btInfSphericity is Selected : "
					//	+ this.stringAreaInf);

			} else {
				this.stringSphericityInf = default_stringSphericityInf;
			//	System.out.println("Inf Sphericity : "
					//	+ this.stringSphericityInf);

			}

			if (btSupBorder.isSelected()) {
				//System.out.println("btSupBorder is Selected  : "
					//	+ this.stringBorderSup);

			} else // valeur par defaut
			{
				this.stringBorderSup = default_stringBorderSup;
			///	System.out.println("Sup Border : " + this.stringBorderSup);

			}
			if (btInfBorder.isSelected()) {
				//System.out.println("btInfBorder is Selected : "
					//	+ this.stringBorderInf);

			} else {
				this.stringBorderInf = default_stringBorderInf;
			//	System.out.println("Inf Border : " + this.stringBorderInf);

			}
			this.setVisible(true);
		}
	}

	class StateListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("Cellule : "
					+ ((JRadioButton) e.getSource()).getText());
			setStringTypeCell(((JRadioButton) e.getSource()).getText());
		}
	}

	public JButton getBtApply() {
		return btApply;
	}

	public String getStringTypeCell() {
		return stringTypeCell;
	}

	public void setStringTypeCell(String stringTypeCell) {
		this.stringTypeCell = stringTypeCell;
	}

	public void setBtApply(JButton btApply) {
		this.btApply = btApply;
	}

	public double getStringAreaSup() {
		return stringAreaSup;
	}

	public void setStringAreaSup(double stringAreaSup) {
		this.stringAreaSup = stringAreaSup;
	}

	public double getStringAreaInf() {
		return stringAreaInf;
	}

	public void setStringAreaInf(double stringAreaInf) {
		this.stringAreaInf = stringAreaInf;
	}

	public double getStringSphericitySup() {
		return stringSphericitySup;
	}

	public void setStringSphericitySup(double stringSphericitySup) {
		this.stringSphericitySup = stringSphericitySup;
	}

	public double getStringSphericityInf() {
		return stringSphericityInf;
	}

	public void setStringSphericityInf(double stringSphericityInf) {
		this.stringSphericityInf = stringSphericityInf;
	}

	public double getStringBorderSup() {
		return stringBorderSup;
	}

	public void setStringBorderSup(double stringBorderSup) {
		this.stringBorderSup = stringBorderSup;
	}

	public double getStringBorderInf() {
		return stringBorderInf;
	}

	public void setStringBorderInf(double stringBorderInf) {
		this.stringBorderInf = stringBorderInf;
	}

	public JButton getBtClear() {
		return btClear;
	}

	public void setBtClear(JButton btClear) {
		this.btClear = btClear;
	}




}