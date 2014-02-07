package hg.hist.MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

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
	private JLabel labelSphericity = new JLabel("Choose your Spherecity");
	private JLabel labelArea = new JLabel("Choose your Area");
	private JLabel labelBorder = new JLabel("Choose your Border");

	private JPanel panelTotal = new JPanel();
	private JPanel paneCellule = new JPanel();
	private JPanel paneSphereSup = new JPanel();
	private JPanel paneSphereInf = new JPanel();
	private JPanel paneAreaSup = new JPanel();
	private JPanel paneAreaInf = new JPanel();
	private JPanel paneBorderSup = new JPanel();
	private JPanel paneBorderInf = new JPanel();
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

	private JPanel rubrique1 = new JPanel(new BorderLayout());
	private JPanel rubrique2 = new JPanel(new GridBagLayout());
	private JPanel rubrique3 = new JPanel(new GridBagLayout());
	private JPanel rubrique4 = new JPanel(new GridBagLayout());

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

/*
	private double maxArea;
	private double maxSphericity;
	private double maxBorder;
	private double minArea;
	private double minSphericity;
	private double minBorder;
	*/
	//AreaMax SphMax BorderMax AreaMin ShpMoin BorderMin
	//public RequestFram( ) {

	public RequestFram(double maxArea, double maxSphericity ,double maxBorder , double minArea ,double minSphericity , double minBorder,HashMap<String, String> mapForRadioButton) {

		System.out.println("A : " + maxArea+ "S :" + maxSphericity+ " B" +maxBorder);
		System.out.println("A : " + minArea+ "S :" + minSphericity+ " B" +minBorder);
		//Size of Frame
		this.setSize(1200, 600);
		
		 default_stringAreaSup = minArea;
		 default_stringAreaInf = maxArea;
		 default_stringSphericitySup = minSphericity;
		 default_stringSphericityInf = maxSphericity;
		 default_stringBorderSup = minBorder;
		 default_stringBorderInf = maxBorder;

		 stringAreaSup = default_stringAreaSup;
		 stringAreaInf = default_stringAreaInf;
		 stringSphericitySup = default_stringSphericitySup;
		 stringSphericityInf = default_stringSphericityInf;
		 stringBorderSup = default_stringBorderSup;
		 stringBorderInf = default_stringBorderInf;
		
		maxArea = adaptValue(maxArea);
		maxSphericity = adaptValue(maxSphericity);
		maxBorder = adaptValue(maxBorder);
		minArea = adaptValue(minArea);
		minSphericity = adaptValue(minSphericity);
		minBorder = adaptValue(minBorder);	
					
		System.out.println("A : " + maxArea+ "S :" + maxSphericity+ " B" +maxBorder);
		System.out.println("A : " + minArea+ "S :" + minSphericity+ " B" +minBorder);
			
		//Verifier les valeurs
		sliderSphericitySup = new JSlider(JSlider.HORIZONTAL,(int)minSphericity, (int)maxSphericity ,(int) (((maxSphericity-minSphericity)/2)+minSphericity));
		sliderSphericityInf = new JSlider(JSlider.HORIZONTAL,(int)minSphericity, (int)maxSphericity,(int) (((maxSphericity-minSphericity)/2)+minSphericity));
		
		sliderAreaSup = new JSlider(JSlider.HORIZONTAL, (int)minArea, (int)maxArea,(int) (((maxArea-minArea)/2)+minArea));
		sliderAreaInf = new JSlider(JSlider.HORIZONTAL,(int)minArea, (int)maxArea,(int) (((maxArea-minArea)/2)+minArea));				
		
		sliderBorderSup = new JSlider(JSlider.HORIZONTAL,(int)minBorder, (int)maxBorder,(int) (((maxBorder-minBorder)/2)+minBorder));
		sliderBorderInf = new JSlider(JSlider.HORIZONTAL,(int)minBorder, (int)maxBorder,(int) (((maxBorder-minBorder)/2)+minBorder));
		
		panelTotal.setBackground(Color.white);
		
		this.add(panelTotal);
		
		// choisir la cellule

		rubrique1.setPreferredSize(new Dimension(1000, 100));
		rubrique1.setBackground(Color.RED);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		paneCellule.setBorder(blackline);
		paneCellule.setBounds(0, 200, 150, 200);
		paneCellule.setOpaque(true);
		paneCellule.setBackground(Color.GREEN);
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

		////RUBRIQUE 1
		//To center le label
		LabelChooseType.setHorizontalAlignment(JLabel.CENTER);
		LabelChooseType.setVerticalAlignment(JLabel.CENTER);
		rubrique1.add(LabelChooseType, BorderLayout.NORTH);
		rubrique1.add(paneCellule, BorderLayout.CENTER);
		
		
		//RUBRIQUE 2 AREA 
		
		rubrique2.setPreferredSize(new Dimension(1100, 100));
		rubrique2.setBackground(Color.YELLOW);
				
		paneAreaSup.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 3 ;
		gc.weighty = 0 ;
		paneAreaSup.setBackground(Color.BLUE);
		paneAreaSup.setPreferredSize(new Dimension(600, 50));
		
		
		paneAreaInf.setLayout(new GridBagLayout());
		GridBagConstraints gcAreaInf = new GridBagConstraints();
		gcAreaInf.weightx = 3 ;
		gcAreaInf.weighty = 0 ;
		paneAreaInf.setBackground(Color.ORANGE);
		paneAreaInf.setPreferredSize(new Dimension(400, 50));

		
		//Area
		//Sup
		sliderDisplayAreaSup.setText("Value");
		sliderDisplayAreaSup.setPreferredSize(new Dimension(50, 45));
		sliderDisplayAreaSup.setForeground(Color.BLUE);
		
		//Inf
		sliderDisplayAreaInf.setText("Value");
		sliderDisplayAreaInf.setPreferredSize(new Dimension(50, 45));
		sliderDisplayAreaInf.setForeground(Color.BLUE);

		//Sup
		Dimension d = sliderAreaSup.getPreferredSize();  
		sliderAreaSup.setPreferredSize(new Dimension(d.width+200,d.height+30)); 	
		sliderAreaSup.setMajorTickSpacing(1000);
		sliderAreaSup.setMinorTickSpacing(100);
		sliderAreaSup.setPaintTicks(true);
		sliderAreaSup.setPaintLabels(true);

		//Inf
		sliderAreaInf.setPreferredSize(new Dimension(sliderAreaInf.getPreferredSize().width+200,sliderAreaInf.getPreferredSize().height+30)); 
		sliderAreaInf.setMajorTickSpacing(1000);
		sliderAreaInf.setMinorTickSpacing(100);
		sliderAreaInf.setPaintTicks(true);
		sliderAreaInf.setPaintLabels(true);

		//Listener
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
		
		//Sup
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.gridx = 0 ;
		gc.gridy = 0 ;
		paneAreaSup.add(btSupArea ,gc);
		
		gc.weightx=1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 1;
		gc.gridy = 0 ; 
		paneAreaSup.add(sliderAreaSup,gc);
		
		gc.gridx = 2;
		gc.gridy = 0 ; 
		paneAreaSup.add(sliderDisplayAreaSup,gc);
		
		
		//Inf
		gcAreaInf.anchor = GridBagConstraints.LINE_START;
		gcAreaInf.weightx = 0.5;
		gcAreaInf.gridx = 0 ;
		gcAreaInf.gridy = 0 ;
		paneAreaInf.add(btInfArea ,gcAreaInf);
		
		gcAreaInf.weightx=1;
		gcAreaInf.fill = GridBagConstraints.HORIZONTAL;
		gcAreaInf.gridx = 1;
		gcAreaInf.gridy = 0 ; 
		paneAreaInf.add(sliderAreaInf,gcAreaInf);
		
		gcAreaInf.gridx = 2;
		gcAreaInf.gridy = 0 ; 
		paneAreaInf.add(sliderDisplayAreaInf,gcAreaInf);
		

		//rubrique 2 
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.fill = GridBagConstraints.BOTH;
		contraintes.insets = new Insets(5, 5, 5, 5);

		contraintes.ipady=contraintes.anchor=GridBagConstraints.CENTER;;
		contraintes.weightx = 2;
		contraintes.weighty = 2;
		
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
		contraintes.fill = GridBagConstraints.CENTER;
		rubrique2.add(labelArea,contraintes);
		
		contraintes.fill = GridBagConstraints.BOTH;
		contraintes.gridx = 0 ;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		rubrique2.add(paneAreaSup,contraintes);
		
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		rubrique2.add(paneAreaInf,contraintes);

		// RUBRIQUE 3 Shpericity

		rubrique3.setPreferredSize(new Dimension(1100, 100));
		rubrique3.setBackground(Color.YELLOW);

		//sup
		paneSphereSup.setLayout(new GridBagLayout());
		GridBagConstraints gcSphericitySup = new GridBagConstraints();
		gcSphericitySup.weightx = 3 ;
		gcSphericitySup.weighty = 0 ;
		paneSphereSup.setBackground(Color.RED);
		paneSphereSup.setPreferredSize(new Dimension(600, 50));
		
		//Inf
		paneSphereInf.setLayout(new GridBagLayout());
		GridBagConstraints gcSphericityInf = new GridBagConstraints();
		gcSphericityInf.weightx = 3 ;
		gcSphericityInf.weighty = 0 ;
		paneSphereInf.setBackground(Color.GREEN);
		paneSphereInf.setPreferredSize(new Dimension(600, 50));

		
		//sphericity
		//Sup
		sliderDisplaySphericitySup.setText("Value");
		sliderDisplaySphericitySup.setPreferredSize(new Dimension(50, 45));
		sliderDisplaySphericitySup.setForeground(Color.BLUE);
		
		//Inf
		sliderDisplaySphericityInf.setText("Value");
		sliderDisplaySphericityInf.setPreferredSize(new Dimension(50, 45));
		sliderDisplaySphericityInf.setForeground(Color.BLUE);

		
		//Sup
		sliderSphericitySup.setPreferredSize(new Dimension(sliderSphericitySup.getPreferredSize().width+200,sliderSphericitySup.getPreferredSize().height+30));
		sliderSphericitySup.setMajorTickSpacing(50);
		sliderSphericitySup.setMinorTickSpacing(10);
		sliderSphericitySup.setPaintTicks(true);
		sliderSphericitySup.setPaintLabels(true);

		//Inf
		sliderSphericityInf.setPreferredSize(new Dimension(sliderSphericityInf.getPreferredSize().width+200,sliderSphericityInf.getPreferredSize().height+30));
		sliderSphericityInf.setMajorTickSpacing(50);
		sliderSphericityInf.setMinorTickSpacing(10);	
		sliderSphericityInf.setPaintTicks(true);
		sliderSphericityInf.setPaintLabels(true);

		//Listeners
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

		//Sup
				gcSphericitySup.anchor = GridBagConstraints.LINE_START;
				gcSphericitySup.weightx = 0.5;
				gcSphericitySup.gridx = 0 ;
				gcSphericitySup.gridy = 0 ;
				paneSphereSup.add(btSupSphericity ,gcSphericitySup);
				
				gcSphericitySup.weightx=1;
				gcSphericitySup.fill = GridBagConstraints.HORIZONTAL;
				gcSphericitySup.gridx = 1;
				gcSphericitySup.gridy = 0 ; 
				paneSphereSup.add(sliderSphericitySup,gcSphericitySup);
							
				gcSphericitySup.fill = GridBagConstraints.HORIZONTAL;
				gcSphericitySup.gridx = 2;
				gcSphericitySup.gridy = 0 ;
				paneSphereSup.add(sliderDisplaySphericitySup,gcSphericitySup);
				
				
				//Inf
				gcSphericityInf.anchor = GridBagConstraints.LINE_START;
				gcSphericityInf.weightx = 0.5;
				gcSphericityInf.gridx = 0 ;
				gcSphericityInf.gridy = 0 ;
				paneSphereInf.add(btInfSphericity ,gcSphericityInf);
				
				gcSphericityInf.weightx=1;
				gcSphericityInf.fill = GridBagConstraints.HORIZONTAL;
				gcSphericityInf.gridx = 1;
				gcSphericityInf.gridy = 0 ; 
				paneSphereInf.add(sliderSphericityInf,gcSphericityInf);
				
				gcSphericityInf.gridx = 2;
				gcSphericityInf.gridy = 0 ; 
				paneSphereInf.add(sliderDisplaySphericityInf,gcSphericityInf);
				

				//rubrique 2 
				GridBagConstraints contraintesSphericity = new GridBagConstraints();
				contraintesSphericity.fill = GridBagConstraints.BOTH;
				contraintesSphericity.insets = new Insets(5, 5, 5, 5);

				contraintesSphericity.ipady=contraintesSphericity.anchor=GridBagConstraints.CENTER;;
				contraintesSphericity.weightx = 2;
				contraintesSphericity.weighty = 2;
				
				contraintesSphericity.gridx = 0;
				contraintesSphericity.gridy = 0;
				contraintesSphericity.gridwidth = 3;
				contraintesSphericity.anchor = GridBagConstraints.NORTH;
			    String j =10+"<sup>-4</sup>";

				labelSphericity.setText("<html>"+ labelSphericity.getText()+" (" + j+" pxl ) </html>");
				rubrique3.add(labelSphericity,contraintesSphericity);
				
				contraintesSphericity.fill = GridBagConstraints.BOTH;
				contraintesSphericity.gridx = 0 ;
				contraintesSphericity.gridy = 1;
				contraintesSphericity.gridwidth = 1;
				rubrique3.add(paneSphereSup,contraintesSphericity);
				
				contraintesSphericity.gridx = 1;
				contraintesSphericity.gridy = 1;
				contraintesSphericity.gridwidth = 1;
				rubrique3.add(paneSphereInf,contraintesSphericity);

		// R*uBRIQUE 4 
		//Border

		rubrique4.setPreferredSize(new Dimension(1100, 100));
		rubrique4.setBackground(Color.YELLOW);

		paneBorderSup.setLayout(new GridBagLayout());
		GridBagConstraints gcBorderSup  = new GridBagConstraints();
		gcBorderSup.weightx = 3;
		gcBorderSup.weightx = 0;
		paneBorderSup.setBackground(Color.BLUE);
		paneBorderSup.setPreferredSize(new Dimension(600, 50));
		
		paneBorderInf.setLayout(new GridBagLayout());
		GridBagConstraints gcBorderInf  = new GridBagConstraints();
		gcBorderInf.weightx = 3;
		gcBorderInf.weightx = 0;
		paneBorderInf.setBackground(Color.white);
		paneBorderInf.setPreferredSize(new Dimension(600, 50));

		//Border 
		//Sup
		sliderDisplayBorderSup.setText("Value");
		sliderDisplayBorderSup.setPreferredSize(new Dimension(50, 45));
		sliderDisplayBorderSup.setForeground(Color.BLUE);
		
		//Inf
		sliderDisplayBorderInf.setText("Value");
		sliderDisplayBorderInf.setPreferredSize(new Dimension(50, 45));
		sliderDisplayBorderInf.setForeground(Color.BLUE);

		//Sup
		sliderBorderSup.setPreferredSize(new Dimension(sliderBorderSup.getPreferredSize().width+200,sliderBorderSup.getPreferredSize().height+30));
		sliderBorderSup.setMajorTickSpacing(50);
		sliderBorderSup.setMinorTickSpacing(10);
		sliderBorderSup.setPaintTicks(true);
		sliderBorderSup.setPaintLabels(true);

		//Inf
		sliderBorderInf.setPreferredSize(new Dimension(sliderBorderInf.getPreferredSize().width+200,sliderBorderInf.getPreferredSize().height+30));
		sliderBorderInf.setMajorTickSpacing(50);
		sliderBorderInf.setMinorTickSpacing(10);
		sliderBorderInf.setPaintTicks(true);
		sliderBorderInf.setPaintLabels(true);

		//Listener
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

				//Sup
				gcBorderSup.anchor = GridBagConstraints.LINE_START;
				gcBorderSup.weightx = 0.5;
				gcBorderSup.gridx = 0 ;
				gcBorderSup.gridy = 0 ;
				paneBorderSup.add(btSupBorder ,gcBorderSup);
				
				gcBorderSup.weightx=1;
				gcBorderSup.fill = GridBagConstraints.HORIZONTAL;
				gcBorderSup.gridx = 1;
				gcBorderSup.gridy = 0 ; 
				paneBorderSup.add(sliderBorderSup,gcBorderSup);
				
				gcBorderSup.gridx = 2;
				gcBorderSup.gridy = 0 ; 
				paneBorderSup.add(sliderDisplayBorderSup,gcBorderSup);
				
				//Inf
				gcBorderInf.anchor = GridBagConstraints.LINE_START;
				gcBorderInf.weightx = 0.5;
				gcBorderInf.gridx = 0 ;
				gcBorderInf.gridy = 0 ;
				paneBorderInf.add(btInfBorder ,gcBorderInf);
				
				gcBorderInf.weightx=1;
				gcBorderInf.fill = GridBagConstraints.HORIZONTAL;
				gcBorderInf.gridx = 1;
				gcBorderInf.gridy = 0 ; 
				paneBorderInf.add(sliderBorderInf,gcBorderInf);
				
				gcBorderInf.gridx = 2;
				gcBorderInf.gridy = 0 ; 
				paneBorderInf.add(sliderDisplayBorderInf,gcBorderInf);
				
				//rubrique 4 
				GridBagConstraints contraintesBorder = new GridBagConstraints();
				contraintesBorder.fill = GridBagConstraints.BOTH;
				contraintesBorder.insets = new Insets(5, 5, 5, 5);

				contraintesBorder.ipady=contraintesBorder.anchor=GridBagConstraints.CENTER;;
				contraintesBorder.weightx = 2;
				contraintesBorder.weighty = 2;
				
				contraintesBorder.gridx = 0;
				contraintesBorder.gridy = 0;
				contraintesBorder.gridwidth = 2;
				contraintesBorder.fill = GridBagConstraints.CENTER;
				rubrique4.add(labelBorder,contraintesBorder);
				
				contraintesBorder.fill = GridBagConstraints.BOTH;
				contraintesBorder.gridx = 0 ;
				contraintesBorder.gridy = 1;
				contraintesBorder.gridwidth = 1;
				rubrique4.add(paneBorderSup,contraintesBorder);
				
				contraintesBorder.gridx = 1;
				contraintesBorder.gridy = 1;
				contraintesBorder.gridwidth = 1;
				rubrique4.add(paneBorderInf,contraintesBorder);
				/*
		paneBorderSup.add(btSupBorder, BorderLayout.WEST);
		paneBorderSup.add(sliderBorderSup);
		paneBorderSup.add(sliderDisplayBorderSup);
		paneBorderInf.add(btInfBorder, BorderLayout.WEST);
		paneBorderInf.add(sliderBorderInf);
		paneBorderInf.add(sliderDisplayBorderInf);

		rubrique4.add(labelBorder, BorderLayout.NORTH);
		rubrique4.add(paneBorderSup);
		rubrique4.add(paneBorderSup);
		*/

		paneEnd.setPreferredSize(new Dimension(1200, 100));
		paneEnd.setBackground(Color.white);

		btFinish.addActionListener(this);
		btApply.addActionListener(this);
		btClear.addActionListener(this);
	

		paneEnd.add(btFinish, BorderLayout.WEST);
		paneEnd.add(btApply, BorderLayout.WEST);
		paneEnd.add(btClear, BorderLayout.WEST);

		panelTotal.add(rubrique1);
		panelTotal.add(rubrique2);
		panelTotal.add(rubrique3);
		panelTotal.add(rubrique4);
		panelTotal.add(paneEnd, BorderLayout.SOUTH);

	}



	public void stateChanged(ChangeEvent event) {
		// sliderBorderSup
		if (event.getSource() == sliderBorderSup) {
			sliderDisplayBorderSup.setText(String.valueOf(sliderBorderSup
					.getValue()));
			System.out.println("BorderSup : "+ String.valueOf(sliderBorderSup.getValue()));
			this.stringBorderSup = Double.valueOf(sliderBorderSup.getValue());

		}
		// SliderBorderInf
		if (event.getSource() == sliderBorderInf) {
			sliderDisplayBorderInf.setText(String.valueOf(sliderBorderInf.getValue()));
			System.out.println("BorderInf : "+ String.valueOf(sliderBorderInf.getValue()));
			this.stringBorderInf = Double.valueOf(sliderBorderInf.getValue());

		}
		
		// SliderSphericitySup
		if (event.getSource() == sliderSphericitySup) {
			sliderDisplaySphericitySup.setText(String.valueOf(sliderSphericitySup.getValue()*0.001));
			System.out.println("SphéericitySup : "+ String.valueOf(sliderSphericitySup.getValue()*0.001));
			this.stringSphericitySup = Double.valueOf(sliderSphericitySup.getValue()*0.001);

		}
		// SliderSphericityInf
		if (event.getSource() == sliderSphericityInf) {
			
			sliderDisplaySphericityInf.setText(String.valueOf(sliderSphericityInf.getValue()*0.001));
			System.out.println("SphéericityInf : "+ String.valueOf(sliderSphericityInf.getValue()*0.001));
			if(btInfSphericity.isSelected()){
				this.stringSphericityInf = Double.valueOf(sliderSphericityInf.getValue()*0.001);
			}
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
				this.stringAreaSup = Math.floor(default_stringAreaSup*1e5)/1e5;
	//			System.out.println("Sup Area : " + this.stringAreaSup);
				sliderDisplayAreaSup.setText(String.valueOf(this.stringAreaSup));

			}

			if (btInfArea.isSelected()) {
		//		System.out.println("btInfArea is Selected : "
			//			+ this.stringAreaInf);

			} else {
				this.stringAreaInf = Math.floor(default_stringAreaInf*1e5)/1e5;
				//System.out.println("Inf Area : " + this.stringAreaInf);
				sliderDisplayAreaInf.setText(String.valueOf(this.stringAreaInf));

			}

			if (btSupSphericity.isSelected()) {
				System.out.println("btSupSphericity is Selected : "+ this.stringSphericitySup);

			} else // valeur par defaut
			{
				this.stringSphericitySup = Math.floor(default_stringSphericitySup*1e5)/1e5;
				System.out.println("Sup Sphericity defualt: "+ this.stringSphericitySup);
				sliderDisplaySphericitySup.setText(String.valueOf(this.stringSphericitySup));

			}

			if (btInfSphericity.isSelected()) {
				System.out.println("btInfSphericity is Selected : "
						+ this.stringSphericityInf);

			} else {
				this.stringSphericityInf = Math.floor(default_stringSphericityInf * 1e5)/1e5;
				System.out.println("Inf Sphericity  default: "+ this.stringSphericityInf);			
				sliderDisplaySphericityInf.setText(String.valueOf(this.stringSphericityInf));

			}

			if (btSupBorder.isSelected()) {
				//System.out.println("btSupBorder is Selected  : "
					//	+ this.stringBorderSup);

			} else // valeur par defaut
			{
				this.stringBorderSup =  Math.floor(default_stringBorderSup * 1e5)/1e5;;
				sliderDisplayBorderSup.setText(String.valueOf(this.stringBorderSup));

				///	System.out.println("Sup Border : " + this.stringBorderSup);

			}
			if (btInfBorder.isSelected()) {
				//System.out.println("btInfBorder is Selected : "
					//	+ this.stringBorderInf);

			} else {
				this.stringBorderInf =  Math.floor(default_stringBorderInf * 1e5)/1e5;;
				sliderDisplayBorderInf.setText(String.valueOf(this.stringBorderInf));
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
	
	public void init(double maxArea, double maxSphericity, double maxBorder, double minArea, double minSphericity, double minBorder){
		
		maxArea = adaptValue(maxArea);
		maxSphericity = adaptValue(maxSphericity);
		maxBorder = adaptValue(maxBorder);
		minArea = adaptValue(minArea);
		minSphericity = adaptValue(minSphericity);
		minBorder = adaptValue(minBorder);	
		
		sliderSphericityInf.setMaximum((int)maxSphericity);
		sliderSphericityInf.setMinimum((int)minSphericity);
		sliderSphericityInf.setValue((int)((maxSphericity-minSphericity)/2 - minSphericity));
		sliderSphericityInf.setMajorTickSpacing(50);
		sliderSphericityInf.setMinorTickSpacing(10);
		
		sliderSphericitySup.setMaximum((int)maxSphericity);
		sliderSphericitySup.setMinimum((int)minSphericity);
		sliderSphericitySup.setValue((int)((maxSphericity-minSphericity)/2 - minSphericity));
		sliderSphericitySup.setMajorTickSpacing(50);
		sliderSphericitySup.setMinorTickSpacing(10);
		
		sliderAreaInf.setMaximum((int)maxArea);
		sliderAreaInf.setMinimum((int)minArea);
		sliderAreaInf.setValue((int)((maxArea-minArea)/2 - minArea));
		sliderAreaInf.setMajorTickSpacing(1000);
		sliderAreaInf.setMinorTickSpacing(100);
		
		sliderAreaSup.setMaximum((int)maxArea);
		sliderAreaSup.setMinimum((int)minArea);
		sliderAreaSup.setValue((int)((maxArea-minArea)/2 - minArea));
		sliderAreaSup.setMajorTickSpacing(1000);
		sliderAreaSup.setMinorTickSpacing(100);
		
		sliderBorderInf.setMaximum((int)maxBorder);
		sliderBorderInf.setMinimum((int)minBorder);
		sliderBorderInf.setValue((int)((maxBorder-minBorder)/2 - minBorder));
		sliderBorderInf.setMajorTickSpacing(50);
		sliderBorderInf.setMinorTickSpacing(10);
		
		sliderBorderSup.setMaximum((int) maxBorder);
		sliderBorderSup.setMinimum((int) minBorder);
		sliderBorderSup.setValue((int) ((maxBorder - minBorder) / 2 - minBorder));
		sliderBorderSup.setMajorTickSpacing(50);
		sliderBorderSup.setMinorTickSpacing(10);

		default_stringAreaSup = minArea;
		default_stringAreaInf = maxArea;
		default_stringSphericitySup = minSphericity * 0.001;
		default_stringSphericityInf = maxSphericity * 0.001;
		default_stringBorderSup = minBorder;
		default_stringBorderInf = maxBorder;
		
		 setStringAreaSup(default_stringAreaSup);
		 setStringAreaInf(default_stringAreaInf);
		 setStringSphericitySup( default_stringSphericitySup*0.001);
		 setStringSphericityInf( default_stringSphericityInf*0.001);
		 setStringBorderSup(default_stringBorderSup);
		 setStringBorderInf( default_stringBorderInf);
		
		System.out.println("Init A : " + maxArea+ " S :" + maxSphericity+ " B : " +maxBorder);
		System.out.println("Init A : " + minArea+ " S :" + minSphericity+ " B : " +minBorder);
		
		System.out.println("Init 2  A : " + stringAreaSup+ " S :" + stringSphericitySup+ " B : " +stringBorderSup);
		System.out.println("Init  2 A : " + stringAreaInf+ " S :" + stringSphericityInf+ " B : " +stringBorderInf);
		
	}

	public double adaptValue(double e){
		if(e<1){
			e = e *1000;
		}
		return e;
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

/*
	public double getMaxArea() {
		return maxArea;
	}

	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}

	public double getMaxSphericity() {
		return maxSphericity;
	}



	public void setMaxSphericity(double maxSphericity) {
		this.maxSphericity = maxSphericity;
	}

	public double getMaxBorder() {
		return maxBorder;
	}

	public void setMaxBorder(double maxBorder) {
		this.maxBorder = maxBorder;
	}

	public double getMinArea() {
		return minArea;
	}

	public void setMinArea(double minArea) {
		this.minArea = minArea;
	}

	public double getMinSphericity() {
		return minSphericity;
	}

	public void setMinSphericity(double minSphericity) {
		this.minSphericity = minSphericity;
	}

	public double getMinBorder() {
		return minBorder;
	}

	public void setMinBorder(double minBorder) {
		this.minBorder = minBorder;
	}
*/

}