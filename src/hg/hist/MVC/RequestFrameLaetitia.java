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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
		
			
public class RequestFrameLaetitia extends JFrame implements ActionListener,	ChangeListener {
				
		
		private static final long serialVersionUID = 123456L;
		
	
			
		private JLabel labelDisplayTypeCell = new JLabel("Choose cells to display");
		private JLabel labelChooseType = new JLabel("Choose cells to filter ");
		private JLabel labelNeighbourhood0= new JLabel("Select your target cellule");
		private JLabel labelNeighbourhood1= new JLabel("Near To ");
		private JLabel labelSphericity = new JLabel("Choose your spherecity ");
		private JLabel labelArea = new JLabel("Choose your area (pxl) ");
		private JLabel labelBorder = new JLabel("Choose your border (pxl) ");
		private JLabel labelDescription= new JLabel("Don't forget to display the target cells before applying.");
	    private JLabel labelDescription2= new JLabel("Then select one or more target cells and the neighbourd cells.");
		private JLabel labelImage = new JLabel(new ImageIcon("images/w.jpg"));
		
		private JPanel panelTotal = new JPanel();
		
		private JPanel paneCellDisplay = new JPanel();
		private JPanel paneCellule = new JPanel();
		private JPanel paneSphereSup = new JPanel();
		private JPanel paneSphereInf = new JPanel();
		private JPanel paneAreaSup = new JPanel();
		private JPanel paneAreaInf = new JPanel();
		private JPanel paneBorderSup = new JPanel();
		private JPanel paneBorderInf = new JPanel();
		private JPanel paneEnd = new JPanel();
		
		private JPanel paneNeighbourhood = new JPanel();
		private JPanel paneCellDisplayNeighbourhood = new JPanel();
		private JPanel paneCelluleNeighbourhood = new JPanel();
		private JPanel paneButtonsNeighbourhood = new JPanel();

		
		private JButton btFinish = new JButton("Finish");
		private JButton btApply = new JButton("Apply");
		private JButton btClear = new JButton("Clear");
		private JButton btAddOneConstraintNeighbourhood = new JButton("AddConstraint");
		private JButton btClearNeighbourhood = new JButton("Clear");
		
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
		
		private JPanel rubrique0 = new JPanel(new BorderLayout());
		private JPanel rubrique1 = new JPanel(new BorderLayout());
		private JPanel rubrique2 = new JPanel(new GridBagLayout());
		private JPanel rubrique3 = new JPanel(new GridBagLayout());
		private JPanel rubrique4 = new JPanel(new GridBagLayout());
		
		private JPanel rubrique0N = new JPanel(new BorderLayout());
		private JPanel rubrique1N = new JPanel(new BorderLayout());
		private JPanel rubriqueInfo = new JPanel(new BorderLayout());
		private ButtonGroup groupButton = new ButtonGroup();
		
		private JCheckBox btCheckRadio_AllCell = new JCheckBox("All Cells");
		private JCheckBox btCheck_AllCell = new JCheckBox("All Cells");	
		private JCheckBox btCheck_AllCellNeighborhood = new JCheckBox("All Cells");	
		
		
		private JCheckBox btCheckNeighbourhoodPaneCellule_AllCell = new JCheckBox("All Cells");
		private List<JCheckBox> listCheckBox = new ArrayList<JCheckBox>();
		private List<JCheckBox> listCheckBoxNeighborhood = new ArrayList<JCheckBox>();
		private List<JCheckBox> listCheckBoxPaneCelluleNeighborhood = new ArrayList<JCheckBox>();
		
		private String radioSelected = "Tumor nucleus";

		private boolean btCheckRadio_AllCellSelected = false;
		
		private JTabbedPane tabbedPane = new JTabbedPane();
		
		private final static String PARAMETERS = "Search using parameters of cells";
		private final static String NEIGHBOURHOOD = "Search using neighbourhood";
		
		private JComboBox comboBox = new JComboBox();

		
		private ControllerRequest contR;
		
		public RequestFrameLaetitia(ControllerRequest contR,double maxArea, double maxSphericity ,double maxBorder , double minArea ,double minSphericity , double minBorder) 
		{

		this.contR = contR;

		comboBox.addItem("No Request");

		System.out.println("MaxParamsReceive \n" + " Area : " + maxArea
				+ " Sphericity :" + maxSphericity + " Border : " + maxBorder);
		System.out.println("MinParamsReceive \n " + " Area : " + minArea
				+ " Sphericity :" + minSphericity + " Border : " + minBorder);

		// Size of Frame
		this.setSize(500, 750);

		// If value < 0 then this.slider not works , so change value
		this.contR.setDefault_AreaSup(adaptValue(maxArea));
		this.contR.setDefault_AreaInf(adaptValue(minArea));
		this.contR.setDefault_SphericitySup(adaptValue(maxSphericity));
		this.contR.setDefault_SphericityInf(adaptValue(minSphericity));
		this.contR.setDefault_BorderSup(adaptValue(maxBorder));
		this.contR.setDefault_BorderInf(adaptValue(minBorder));

		System.out.println("Max default \n " + "Area : "
				+ this.contR.getDefault_AreaSup() + " Sphericity : "
				+ this.contR.getDefault_SphericitySup() + " Border : "
				+ this.contR.getDefault_BorderSup());
		System.out.println("Min defualt \n " + "Area : "
				+ this.contR.getDefault_AreaInf() + " Sphericity : "
				+ this.contR.getDefault_SphericityInf() + " Border : "
				+ this.contR.getDefault_BorderInf());

		// Verifier les valeurs
		this.sliderSphericitySup = new JSlider(JSlider.HORIZONTAL,
				(int) this.contR.getDefault_SphericityInf(),
				(int) this.contR.getDefault_SphericitySup(),
				(int) this.contR.getDefault_SphericityInf());
		this.sliderSphericityInf = new JSlider(JSlider.HORIZONTAL,
				(int) this.contR.getDefault_SphericityInf(),
				(int) this.contR.getDefault_SphericitySup(),
				(int) this.contR.getDefault_SphericitySup());

		this.sliderAreaSup = new JSlider(JSlider.HORIZONTAL,
				(int) this.contR.getDefault_AreaInf(),
				(int) this.contR.getDefault_AreaSup(),
				(int) this.contR.getDefault_AreaInf());
		this.sliderAreaInf = new JSlider(JSlider.HORIZONTAL,
				(int) this.contR.getDefault_AreaInf(),
				(int) this.contR.getDefault_AreaSup(),
				(int) this.contR.getDefault_AreaSup());

		this.sliderBorderSup = new JSlider(JSlider.HORIZONTAL,
				(int) this.contR.getDefault_BorderInf(),
				(int) this.contR.getDefault_BorderSup(),
				(int) this.contR.getDefault_BorderInf());
		this.sliderBorderInf = new JSlider(JSlider.HORIZONTAL,
				(int) this.contR.getDefault_BorderInf(),
				(int) this.contR.getDefault_BorderSup(),
				(int) this.contR.getDefault_BorderSup());

		this.panelTotal.setBackground(Color.white);

		

		// choisir la cellule

		// this.rubrique0.setPreferredSize(new Dimention(1000,100));
	    this.rubrique0.setBackground(Color.darkGray);

		// this.rubrique1.setPreferredSize(new Dimension(1000, 100));
        this.rubrique1.setBackground(Color.darkGray);

		// put a line a separator
		Border blackline = BorderFactory.createLineBorder(Color.black);
		this.paneCellule.setBorder(blackline);
		this.paneCellule.setBounds(0, 200, 150, 200);
		this.paneCellule.setOpaque(true);
	//	this.paneCellule.setBackground(Color.GREEN);
		this.paneCellule.setLayout(new GridLayout(3, 3));

		this.paneCelluleNeighbourhood.setBorder(blackline);
		this.paneCelluleNeighbourhood.setBounds(0, 200, 150, 200);
		this.paneCelluleNeighbourhood.setOpaque(true);
	//	this.paneCelluleNeighbourhood.setBackground(Color.GREEN);
		this.paneCelluleNeighbourhood.setLayout(new GridLayout(3, 3));
		
		
		this.paneCellDisplay.setBorder(blackline);
		this.paneCellDisplay.setBounds(0, 200, 150, 200);
		this.paneCellDisplay.setOpaque(true);
		//this.paneCellDisplay.setBackground(Color.GREEN);
		this.paneCellDisplay.setLayout(new GridLayout(3, 3));
		
		this.paneCellDisplayNeighbourhood.setBorder(blackline);
		this.paneCellDisplayNeighbourhood.setBounds(0, 200, 150, 200);
		this.paneCellDisplayNeighbourhood.setOpaque(true);
	   // this.paneCellDisplayNeighbourhood.setBackground(Color.red);
		this.paneCellDisplayNeighbourhood.setLayout(new GridLayout(3, 3));

		this.btCheck_AllCell.setName("All Cells");
		this.listCheckBox.add(btCheck_AllCell);	
		
		this.btCheck_AllCell.addActionListener(this);
		this.paneCellDisplay.add(btCheck_AllCell);
		//paleNeighobohoohd
		
		this.btCheck_AllCellNeighborhood.setName("All Cells");
		this.listCheckBoxNeighborhood.add(btCheck_AllCellNeighborhood);
		
		this.btCheck_AllCellNeighborhood.addActionListener(this);
		this.paneCellDisplayNeighbourhood.add(btCheck_AllCellNeighborhood);

		
		this.btCheckNeighbourhoodPaneCellule_AllCell.setName("All Cells");
		this.listCheckBoxPaneCelluleNeighborhood.add(btCheckNeighbourhoodPaneCellule_AllCell);
		
		this.btCheckNeighbourhoodPaneCellule_AllCell.addActionListener(this);
		this.paneCelluleNeighbourhood.add(btCheckNeighbourhoodPaneCellule_AllCell);

		this.paneCellule.add(btCheckRadio_AllCell);
		this.btCheckRadio_AllCell.addActionListener(this);


		// /RUBRIQUE 0
		// To center the this.label
		this.labelDisplayTypeCell.setHorizontalAlignment(JLabel.CENTER);
		this.labelDisplayTypeCell.setVerticalAlignment(JLabel.CENTER);
		this.labelDisplayTypeCell.setForeground(Color.RED);
		this.rubrique0.add(this.labelDisplayTypeCell, BorderLayout.NORTH);
		this.rubrique0.add(this.paneCellDisplay, BorderLayout.CENTER);

		// //RUBRIQUE 1
		// To center the this.label
		this.labelChooseType.setHorizontalAlignment(JLabel.CENTER);
		this.labelChooseType.setVerticalAlignment(JLabel.CENTER);
		this.labelChooseType.setForeground(Color.RED);
		this.rubrique1.add(this.labelChooseType, BorderLayout.NORTH);
		this.rubrique1.add(this.paneCellule, BorderLayout.CENTER);

		// RUBRIQUE 2 AREA

		//this.rubrique2.setPreferredSize(new Dimension(1000, 1000));
	    this.rubrique2.setBackground(Color.darkGray);

		this.paneAreaSup.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 3;
		gc.weighty = 1;
	//	this.paneAreaSup.setBackground(Color.ORANGE);
		//this.paneAreaSup.setPreferredSize(new Dimension(435, 60));

		this.paneAreaInf.setLayout(new GridBagLayout());
		GridBagConstraints gcAreaInf = new GridBagConstraints();
		gcAreaInf.weightx = 3;
		gcAreaInf.weighty = 1;
	//	this.paneAreaInf.setBackground(Color.ORANGE);
		//this.paneAreaInf.setPreferredSize(new Dimension(435, 60));

		// Area
		// Sup
		this.sliderDisplayAreaSup.setPreferredSize(new Dimension(50, 45));
	//	this.sliderDisplayAreaSup.setForeground(Color.BLUE);

		// Inf
		this.sliderDisplayAreaInf.setPreferredSize(new Dimension(50, 45));
	//	this.sliderDisplayAreaInf.setForeground(Color.BLUE);

		// Sup
		//Dimension d = this.sliderAreaSup.getPreferredSize();
	//	this.sliderAreaSup.setPreferredSize(new Dimension(d.width + 200,		d.height + 30));
		this.sliderAreaSup.setMajorTickSpacing(1000);
		this.sliderAreaSup.setMinorTickSpacing(100);
		this.sliderAreaSup.setPaintTicks(true);
		this.sliderAreaSup.setPaintLabels(true);

		// Inf
		//this.sliderAreaInf.setPreferredSize(new Dimension(this.sliderAreaInf.getPreferredSize().width + 200, this.sliderAreaInf.getPreferredSize().height + 30));
		this.sliderAreaInf.setMajorTickSpacing(1000);
		this.sliderAreaInf.setMinorTickSpacing(100);
		this.sliderAreaInf.setPaintTicks(true);
		this.sliderAreaInf.setPaintLabels(true);

		// Listener
		this.sliderAreaSup.addChangeListener(this);
		this.sliderAreaInf.addChangeListener(this);

		this.sliderDisplayAreaSup.addKeyListener(new KeyAdapter() {
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
		this.sliderDisplayAreaInf.addKeyListener(new KeyAdapter() {
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

		// Sup
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		this.paneAreaSup.add(new JLabel("Superior"), gc);

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		this.paneAreaSup.add(this.sliderAreaSup, gc);

		gc.fill = GridBagConstraints.BOTH;

		gc.weightx = 0.7;
		gc.gridx = 3;
		gc.gridy = 1;
		this.paneAreaSup.add(this.sliderDisplayAreaSup, gc);

		// Inf
		gcAreaInf.anchor = GridBagConstraints.LINE_START;
		gcAreaInf.fill = GridBagConstraints.HORIZONTAL;
		gcAreaInf.gridx = 0;
		gcAreaInf.gridy = 0;
		gcAreaInf.gridwidth = 1;
		this.paneAreaInf.add(new JLabel("Inferior"), gcAreaInf);

		gcAreaInf.fill = GridBagConstraints.HORIZONTAL;
		gcAreaInf.gridx = 0;
		gcAreaInf.gridy = 1;
		gcAreaInf.gridwidth = 1;
		this.paneAreaInf.add(this.sliderAreaInf, gcAreaInf);

		gcAreaInf.fill = GridBagConstraints.BOTH;
		gcAreaInf.weightx = 0.7;
		gcAreaInf.gridx = 3;
		gcAreaInf.gridy = 1;
		this.paneAreaInf.add(this.sliderDisplayAreaInf, gcAreaInf);

		// this.rubrique 2
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.fill = GridBagConstraints.BOTH;
		contraintes.insets = new Insets(2, 5, 2, 5);

		//contraintes.ipady = contraintes.anchor = GridBagConstraints.CENTER;
		/*
		contraintes.weightx = 2;
		contraintes.weighty = 2;*/
		
		 contraintes.weightx = 1;
		 contraintes.weighty = 3;
		/*
		 * contraintes.gridx = 0; contraintes.gridy = 0; contraintes.gridwidth =
		 * 1;
		 */
/*		 
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
	*/	
			contraintes.gridx = 0;
			contraintes.gridy = 0;
			contraintes.gridwidth = 1;

	//	contraintes.anchor = GridBagConstraints.;
		contraintes.fill = GridBagConstraints.BOTH;
         this.labelArea.setForeground(Color.red);
		this.rubrique2.add(this.labelArea, contraintes);

		contraintes.fill = GridBagConstraints.BOTH;
/*		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
	*/
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;

		this.rubrique2.add(this.paneAreaSup, contraintes);
		/*
		 * contraintes.gridx = 0; contraintes.gridy = 2;
		 */
		/*contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;*/
		contraintes.gridx = 0;
		contraintes.gridy = 3;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;

		this.rubrique2.add(this.paneAreaInf, contraintes);

		// RUBRIQUE 3 Shpericity

		// this.rubrique3.setPreferredSize(new Dimension(1100, 100));
	    this.rubrique3.setBackground(Color.darkGray);

		// sup
		this.paneSphereSup.setLayout(new GridBagLayout());
		GridBagConstraints gcSphericitySup = new GridBagConstraints();
		gcSphericitySup.weightx = 3;
		gcSphericitySup.weighty = 1;
	//	this.paneSphereSup.setBackground(Color.RED);
		// this.paneSphereSup.setPreferredSize(new Dimension(600, 50));

		// Inf
		this.paneSphereInf.setLayout(new GridBagLayout());
		GridBagConstraints gcSphericityInf = new GridBagConstraints();
		gcSphericityInf.weightx = 3;
		gcSphericityInf.weighty = 1;
	//	this.paneSphereInf.setBackground(Color.GREEN);
		// this.paneSphereInf.setPreferredSize(new Dimension(600, 50));

		// sphericity
		// Sup
		this.sliderDisplaySphericitySup.setPreferredSize(new Dimension(50, 45));
	//	this.sliderDisplaySphericitySup.setForeground(Color.BLUE);

		// Inf
		this.sliderDisplaySphericityInf.setPreferredSize(new Dimension(50, 45));
	//	this.sliderDisplaySphericityInf.setForeground(Color.BLUE);

		// Sup
		//this.sliderSphericitySup.setPreferredSize(new Dimension(
			//	this.sliderSphericitySup.getPreferredSize().width + 200,
			//	this.sliderSphericitySup.getPreferredSize().height + 30));
		this.sliderSphericitySup.setMajorTickSpacing(50);
		this.sliderSphericitySup.setMinorTickSpacing(10);
		this.sliderSphericitySup.setPaintTicks(true);
		this.sliderSphericitySup.setPaintLabels(true);

		// Inf
	//	this.sliderSphericityInf.setPreferredSize(new Dimension(
		//		this.sliderSphericityInf.getPreferredSize().width + 200,
		//		this.sliderSphericityInf.getPreferredSize().height + 30));
		this.sliderSphericityInf.setMajorTickSpacing(50);
		this.sliderSphericityInf.setMinorTickSpacing(10);
		this.sliderSphericityInf.setPaintTicks(true);
		this.sliderSphericityInf.setPaintLabels(true);

		// Listeners
		this.sliderSphericityInf.addChangeListener(this);
		this.sliderSphericitySup.addChangeListener(this);

		this.sliderDisplaySphericitySup.addKeyListener(new KeyAdapter() {
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
		this.sliderDisplaySphericityInf.addKeyListener(new KeyAdapter() {
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

		// Sup
		gcSphericitySup.anchor = GridBagConstraints.LINE_START;
		gcSphericitySup.fill = GridBagConstraints.HORIZONTAL;
		gcSphericitySup.gridx = 0;
		gcSphericityInf.gridwidth = 1;
		gcSphericitySup.gridy = 0;
		this.paneSphereSup.add(new JLabel("Superior"), gcSphericitySup);

		gcSphericitySup.fill = GridBagConstraints.HORIZONTAL;
		gcSphericitySup.gridx = 0;
		gcSphericitySup.gridy = 1;
		gcSphericitySup.gridwidth = 1;
		this.paneSphereSup.add(this.sliderSphericitySup, gcSphericitySup);

		gcSphericitySup.fill = GridBagConstraints.BOTH;
		gcSphericitySup.weightx = 0.7;
		gcSphericitySup.gridx = 3;
		gcSphericitySup.gridy = 1;
		this.paneSphereSup
				.add(this.sliderDisplaySphericitySup, gcSphericitySup);

		// Inf
		gcSphericityInf.anchor = GridBagConstraints.LINE_START;
		gcSphericityInf.fill = GridBagConstraints.HORIZONTAL;
		gcSphericityInf.gridx = 0;
		gcSphericityInf.gridy = 0;
		gcSphericityInf.gridwidth = 1;
		this.paneSphereInf.add(new JLabel("Inferior"), gcSphericityInf);

		gcSphericityInf.fill = GridBagConstraints.HORIZONTAL;
		gcSphericityInf.gridx = 0;
		gcSphericityInf.gridy = 1;
		gcSphericityInf.gridwidth = 1;
		this.paneSphereInf.add(this.sliderSphericityInf, gcSphericityInf);
		gcSphericityInf.fill = GridBagConstraints.BOTH;
		gcSphericityInf.weightx = 0.7;
		gcSphericityInf.gridx = 3;
		gcSphericityInf.gridy = 1;
		this.paneSphereInf
				.add(this.sliderDisplaySphericityInf, gcSphericityInf);

		// this.rubrique 2
		GridBagConstraints contraintesSphericity = new GridBagConstraints();
		contraintesSphericity.fill = GridBagConstraints.BOTH;
		contraintesSphericity.insets =  new Insets(2, 5, 2, 5);

	//	contraintesSphericity.ipady = contraintesSphericity.anchor = GridBagConstraints.CENTER;
		
		contraintesSphericity.weightx = 1;
		contraintesSphericity.weighty = 3;

		contraintesSphericity.gridx = 0;
		contraintesSphericity.gridy = 0;
		//contraintesSphericity.gridwidth = 2;
		contraintesSphericity.anchor = GridBagConstraints.NORTH;
		String j = 10 + "<sup>-4</sup>";

		this.labelSphericity.setText("<html>" + this.labelSphericity.getText()
				+ " (" + j + " pxl ) </html>");
		this.labelSphericity.setForeground(Color.red);
		this.rubrique3.add(this.labelSphericity, contraintesSphericity);

		contraintesSphericity.fill = GridBagConstraints.BOTH;
		contraintesSphericity.gridx = 0;
		contraintesSphericity.gridy = 2;
		contraintesSphericity.gridwidth = 1;
		this.rubrique3.add(this.paneSphereSup, contraintesSphericity);

		contraintesSphericity.gridx = 0;
		contraintesSphericity.gridy = 3;
		contraintesSphericity.gridwidth = 1;
		this.rubrique3.add(this.paneSphereInf, contraintesSphericity);

		// RuBRIQUE 4
		// Border

		// this.rubrique4.setPreferredSize(new Dimension(1100, 100));
		this.rubrique4.setBackground(Color.darkGray);

		this.paneBorderSup.setLayout(new GridBagLayout());
		GridBagConstraints gcBorderSup = new GridBagConstraints();
		gcBorderSup.weightx = 3;
		gcBorderSup.weighty = 1;
	//	this.paneBorderSup.setBackground(Color.BLUE);
		// this.paneBorderSup.setPreferredSize(new Dimension(600, 50));

		this.paneBorderInf.setLayout(new GridBagLayout());
		GridBagConstraints gcBorderInf = new GridBagConstraints();
		gcBorderInf.weightx = 3;
		gcBorderInf.weighty = 1;
	//	this.paneBorderInf.setBackground(Color.white);
		// this.paneBorderInf.setPreferredSize(new Dimension(600, 50));

		// Border
		// Sup
		this.sliderDisplayBorderSup.setPreferredSize(new Dimension(50, 45));
	//	this.sliderDisplayBorderSup.setForeground(Color.BLUE);

		// Inf
		this.sliderDisplayBorderInf.setPreferredSize(new Dimension(50, 45));
	//	this.sliderDisplayBorderInf.setForeground(Color.BLUE);

		// Sup
		//this.sliderBorderSup.setPreferredSize(new Dimension(
			//	this.sliderBorderSup.getPreferredSize().width + 200,
			//	this.sliderBorderSup.getPreferredSize().height + 30));
		this.sliderBorderSup.setMajorTickSpacing(50);
		this.sliderBorderSup.setMinorTickSpacing(10);
		this.sliderBorderSup.setPaintTicks(true);
		this.sliderBorderSup.setPaintLabels(true);

		// Inf
		//this.sliderBorderInf.setPreferredSize(new Dimension(
			//	this.sliderBorderInf.getPreferredSize().width + 200,
			//	this.sliderBorderInf.getPreferredSize().height + 30));
		this.sliderBorderInf.setMajorTickSpacing(50);
		this.sliderBorderInf.setMinorTickSpacing(10);
		this.sliderBorderInf.setPaintTicks(true);
		this.sliderBorderInf.setPaintLabels(true);

		// Listener
		this.sliderBorderSup.addChangeListener(this);
		this.sliderBorderInf.addChangeListener(this);

		this.sliderDisplayBorderSup.addKeyListener(new KeyAdapter() {
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

		this.sliderDisplayBorderInf.addKeyListener(new KeyAdapter() {
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
		
		// Sup
		gcBorderSup.anchor = GridBagConstraints.LINE_START;
		gcBorderSup.fill = GridBagConstraints.HORIZONTAL;
		gcBorderSup.gridx = 0;
		gcBorderSup.gridy = 0;
		gcBorderSup.gridwidth = 1;
		this.paneBorderSup.add(new JLabel("Superior"), gcBorderSup);

		gcBorderSup.fill = GridBagConstraints.HORIZONTAL;
		gcBorderSup.gridx = 0;
		gcBorderSup.gridy = 1;
		gcBorderSup.gridwidth = 1;

		this.paneBorderSup.add(this.sliderBorderSup, gcBorderSup);
		gcBorderSup.fill = GridBagConstraints.BOTH;
		gcBorderSup.gridx = 3;
		gcBorderSup.gridy = 1;
		gcBorderSup.weightx = 0.7;
		this.paneBorderSup.add(this.sliderDisplayBorderSup, gcBorderSup);

		// Inf

		gcBorderInf.anchor = GridBagConstraints.LINE_START;
		gcBorderInf.fill = GridBagConstraints.HORIZONTAL;
		gcBorderInf.gridx = 0;
		gcBorderInf.gridy = 0;
		gcBorderInf.gridwidth = 1;
		this.paneBorderInf.add(new JLabel("Inferior"), gcBorderInf);

		gcBorderInf.fill = GridBagConstraints.HORIZONTAL;
		gcBorderInf.gridx = 0;
		gcBorderInf.gridy = 1;
		gcBorderInf.gridwidth = 1;

		this.paneBorderInf.add(this.sliderBorderInf, gcBorderInf);
		gcBorderInf.fill = GridBagConstraints.BOTH;
		gcBorderInf.weightx = 0.7;
		gcBorderInf.gridx = 3;
		gcBorderInf.gridy = 1;
		this.paneBorderInf.add(this.sliderDisplayBorderInf, gcBorderInf);

		// this.rubrique 4
		GridBagConstraints contraintesBorder = new GridBagConstraints();
		contraintesBorder.fill = GridBagConstraints.BOTH;
		contraintesBorder.insets = new Insets(2, 5, 5, 5);

	//	contraintesBorder.ipady = contraintesBorder.anchor = GridBagConstraints.CENTER;
		
		contraintesBorder.weightx = 1;
		contraintesBorder.weighty = 3;

		contraintesBorder.gridx = 0;
		contraintesBorder.gridy = 0;
		contraintesBorder.gridwidth = 1;
		contraintesBorder.anchor = GridBagConstraints.NORTH;
		this.labelBorder.setForeground(Color.red);
		this.rubrique4.add(this.labelBorder, contraintesBorder);

		contraintesBorder.fill = GridBagConstraints.BOTH;
		contraintesBorder.gridx = 0;
		contraintesBorder.gridy = 1;
		contraintesBorder.gridwidth = 1;
		this.rubrique4.add(this.paneBorderSup, contraintesBorder);

		contraintesBorder.gridx = 0;
		contraintesBorder.gridy = 3;
		contraintesBorder.gridwidth = 1;
		this.rubrique4.add(this.paneBorderInf, contraintesBorder);
					
			//this.paneEnd.setPreferredSize(new Dimension(900, 100));
			this.paneEnd.setBackground(Color.white);
		
			this.btFinish.addActionListener(this);
			this.btApply.addActionListener(this);
			this.btClear.addActionListener(this);
			this.btAddOneConstraintNeighbourhood.addActionListener(this);
			this.btClearNeighbourhood.addActionListener(this);
			
			this.paneEnd.add(btFinish, BorderLayout.WEST);
			this.paneEnd.add(btApply, BorderLayout.WEST);
			this.paneEnd.add(btClear, BorderLayout.WEST);
		/*
			JSeparator p = new JSeparator(SwingConstants.HORIZONTAL);
			p.setBackground(Color.BLACK);
			p.setPreferredSize(new Dimension(p.getWidth()+100, p.getHeight()+20));
			*/
			//GridLayout experimentLayout = new GridLayout(6,1);
			
			
			
			
			GridBagConstraints c = new GridBagConstraints();
			this.panelTotal.setLayout(new GridBagLayout());
			c.weightx = 1;
			c.weighty = 7;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			this.panelTotal.add(this.rubrique0,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			c.weightx = 0.5;

			this.panelTotal.add(this.rubrique1,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			this.panelTotal.add(this.rubrique2,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			this.panelTotal.add(this.rubrique3,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			this.panelTotal.add(this.rubrique4,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 6;
			c.insets = new Insets(5, 5, 5, 5);
			this.panelTotal.add(this.paneEnd,c);
			
			
			this.tabbedPane.add(PARAMETERS,panelTotal);
			
			
			//**************************************Onglet2*******************************************\\
			
			GridBagConstraints cNeighbouhood = new GridBagConstraints( );
			
			this.paneNeighbourhood.setLayout(new GridBagLayout());
			cNeighbouhood.weightx = 1;
			cNeighbouhood.weighty = 0;
			cNeighbouhood.insets=new Insets(5, 0, 5, 0);
			cNeighbouhood.fill = GridBagConstraints.HORIZONTAL;
			
			cNeighbouhood.gridx = 0;
			cNeighbouhood.gridy = 0;
			
			this.rubriqueInfo.add(labelDescription,BorderLayout.NORTH);		
			this.rubriqueInfo.add(labelDescription2,BorderLayout.SOUTH);
			this.paneNeighbourhood.add(rubriqueInfo,cNeighbouhood);
			//this.paneNeighbourhood.add(labelDescription,cNeighbouhood);
			
			cNeighbouhood.gridx = 0;
			cNeighbouhood.gridy = 1;
			
			this.rubrique0N.setBackground(Color.darkGray);
			this.labelNeighbourhood0.setHorizontalAlignment(JLabel.CENTER);
			this.labelNeighbourhood0.setVerticalAlignment(JLabel.CENTER);
			this.labelNeighbourhood0.setForeground(Color.RED);
			this.rubrique0N.add(this.labelNeighbourhood0, BorderLayout.NORTH);
			this.rubrique0N.add(this.paneCellDisplayNeighbourhood, BorderLayout.CENTER);
			
			//this.paneCellDisplayNeighbourhood.setBackground(Color.RED);
		   this.paneNeighbourhood.add(rubrique0N,cNeighbouhood);
		   //this.paneNeighbourhood.add(paneCellDisplayNeighbourhood,cNeighbouhood);
			
			cNeighbouhood.fill = GridBagConstraints.HORIZONTAL;
			cNeighbouhood.gridx = 0;
			cNeighbouhood.gridy = 2;
			
			
			
			this.rubrique1N.setBackground(Color.darkGray);
			this.labelNeighbourhood1.setHorizontalAlignment(JLabel.CENTER);
			this.labelNeighbourhood1.setVerticalAlignment(JLabel.CENTER);
			this.labelNeighbourhood1.setForeground(Color.RED);
			this.rubrique1N.add(this.labelNeighbourhood1, BorderLayout.NORTH);
			this.rubrique1N.add(this.paneCelluleNeighbourhood, BorderLayout.CENTER);
			
			//this.paneCellDisplayNeighbourhood.setBackground(Color.RED);
		    this.paneNeighbourhood.add(rubrique1N,cNeighbouhood);
			//this.paneNeighbourhood.add(rubrique1Neighbood,cNeighbouhood);
			//this.paneNeighbourhood.add(paneCelluleNeighbourhood,cNeighbouhood);
			
			
			cNeighbouhood.fill = GridBagConstraints.BOTH;
			cNeighbouhood.gridx = 0;
			cNeighbouhood.gridy = 3;
			
			this.paneButtonsNeighbourhood.add(this.btAddOneConstraintNeighbourhood);
			
			this.paneButtonsNeighbourhood.add(this.btClearNeighbourhood);

			this.paneNeighbourhood.add(comboBox,cNeighbouhood);

			cNeighbouhood.fill = GridBagConstraints.BOTH;
			cNeighbouhood.weighty=0.5;
			cNeighbouhood.gridx = 0;
			cNeighbouhood.gridy = 4;
			this.paneNeighbourhood.add(this.paneButtonsNeighbourhood,cNeighbouhood);
			
			this.tabbedPane.add(NEIGHBOURHOOD,paneNeighbourhood);
			
			this.add(tabbedPane);
		}
		
		public void stateChanged(ChangeEvent event) {
			// this.sliderBorderSup
		if (event.getSource() == this.sliderBorderSup) {

			this.sliderDisplayBorderSup.setText(String.valueOf(this.sliderBorderSup.getValue()));
			System.out.println("BorderSup : "
					+ String.valueOf(this.sliderBorderSup.getValue()));
			System.out.println("radioSelected : " + getRadioSelected());
			
			// si le boutton radio All Cell est selectionné
			if (btCheckRadio_AllCell.isSelected()) {					
						// pour toute la liste des cells avce parametres
						for (CellRequested cr : this.contR.getListRequested()) {
								cr.setBorderSup(Double.valueOf(this.sliderBorderSup.getValue()));								
						}
					
				
			} else {
				for (int i = 0; i < this.contR.getListRequested().size(); i++) {
					if ((this.contR.getListRequested().get(i).getName())
							.equals(getRadioSelected())) {
						this.contR.getListRequested().get(i).setBorderSup(Double.valueOf(this.sliderBorderSup.getValue()));
					}
				}
			}
		}
			// SliderBorderInf
			if (event.getSource() == this.sliderBorderInf) {
				this.sliderDisplayBorderInf.setText(String.valueOf(this.sliderBorderInf.getValue()));
				System.out.println("BorderInf : "+ String.valueOf(this.sliderBorderInf.getValue()));				
				System.out.println("radioSelected : "+ getRadioSelected());
				// si le boutton radio All Cell est selectionné
				if (btCheckRadio_AllCell.isSelected()) {
							// pour toute la liste des cells avce parametres
							for (CellRequested cr : this.contR.getListRequested()) {								
									cr.setBorderSup(Double.valueOf(this.sliderBorderInf.getValue()));
							}
						
					
				} else {
				for(int i = 0 ;i<this.contR.getListRequested().size();i++){
					if((this.contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						this.contR.getListRequested().get(i).setBorderInf(Double.valueOf(this.sliderBorderInf.getValue()));
					}
				}
		
			}
			}
			// SliderSphericitySup
			if (event.getSource() == this.sliderSphericitySup) {
				
				double a = this.sliderSphericitySup.getValue()*0.001;
				System.out.println("a"+ a);
		
				this.sliderDisplaySphericitySup.setText(String.valueOf(String.valueOf(Math.floor(a*1e2)/1e2)));
				System.out.println("SphéericitySup : "+ String.valueOf(String.valueOf(Math.floor(a*1e2)/1e2)));
			
				// si le boutton radio All Cell est selectionné
				if (btCheckRadio_AllCell.isSelected()) {
							// pour toute la liste des cells avce parametres
							for (CellRequested cr : this.contR.getListRequested()) {
									cr.setSphericitySup(Double.valueOf(this.sliderSphericitySup.getValue())*0.001);
								}
							}
						
					
				 else {
				System.out.println("radioSelected : "+ getRadioSelected());
				for(int i = 0 ;i<this.contR.getListRequested().size();i++){
					if((this.contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						this.contR.getListRequested().get(i).setSphericitySup(Double.valueOf(this.sliderSphericitySup.getValue())*0.001);
					}
				}
			}
		
		
			}
			// SliderSphericityInf
			if (event.getSource() == this.sliderSphericityInf) {
				double a = this.sliderSphericityInf.getValue()*0.001;
				 
				this.sliderDisplaySphericityInf.setText(String.valueOf(Math.floor(a*1e2)/1e2));
				System.out.println("SphericityInf : "+ String.valueOf(Math.floor(a*1e2)/1e2));
				System.out.println("radioSelected : "+ getRadioSelected());
				// si le boutton radio All Cell est selectionné
				if (btCheckRadio_AllCell.isSelected()) {
							// pour toute la liste des cells avce parametres
							for (CellRequested cr : this.contR.getListRequested()) {
								// on recherche celles qui ont le meme nom que les
								// checkboxs cochées
									cr.setSphericityInf(Double.valueOf(this.sliderSphericityInf.getValue())*0.001);
								}
							
						
					
				} else {
				for(int i = 0 ;i<this.contR.getListRequested().size();i++){
					if((this.contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						this.contR.getListRequested().get(i).setSphericityInf(Double.valueOf(this.sliderSphericityInf.getValue())*0.001);
					}
				}
			}
			}
		
			// SliderAreaSup
			if (event.getSource() == this.sliderAreaSup) {
		
				this.sliderDisplayAreaSup.setText(String.valueOf(this.sliderAreaSup.getValue()));
				System.out.println("AreaSup : "+ String.valueOf(this.sliderAreaSup.getValue()));
					
				System.out.println("radioSelected : "+ getRadioSelected());
				
				// si le boutton radio All Cell est selectionné
				if (btCheckRadio_AllCell.isSelected()) {
							// pour toute la liste des cells avce parametres
							for (CellRequested cr : this.contR.getListRequested()) {
									cr.setAreaSup(Double.valueOf(this.sliderAreaSup.getValue()));
								
							}
						
					
				} else {
				for(int i = 0 ;i<this.contR.getListRequested().size();i++){
					if((this.contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						this.contR.getListRequested().get(i).setAreaSup(Double.valueOf(this.sliderAreaSup.getValue()));
					}
				}
			}
			}
			// SlierAreaInf
			if (event.getSource() == this.sliderAreaInf) {
		
				this.sliderDisplayAreaInf.setText(String.valueOf(this.sliderAreaInf.getValue()));
				System.out.println("AreaInf : "+ String.valueOf(this.sliderAreaInf.getValue()));
				
				System.out.println("radioSelected : "+ getRadioSelected());
				// si le boutton radio All Cell est selectionné
				if (btCheckRadio_AllCell.isSelected()) {
							// pour toute la liste des cells avce parametres
							for (CellRequested cr : this.contR.getListRequested()) {
								// on recherche celles qui ont le meme nom que les
								// checkboxs cochées
									cr.setAreaInf(Double.valueOf(this.sliderAreaInf.getValue()));
								
							}
						
					
				} else {
				for(int i = 0 ;i<this.contR.getListRequested().size();i++){
					if((this.contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						this.contR.getListRequested().get(i).setAreaInf(Double.valueOf(this.sliderAreaInf.getValue()));
					}
				}
				}
			}
			//debug
			for(int i= 0; i<this.contR.getListRequested().size();i++ ){
				System.out.println("listRequested init " + this.contR.getListRequested().get(i).toString());
			}
		
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Si on coche btCheck_AllCell
			if(e.getSource() == this.btCheck_AllCell){
				System.out.println("All Cells check");
								
				for(JCheckBox ch : listCheckBox){
					ch.setSelected(false);
				}
				btCheck_AllCell.setSelected(true);
				
				//On veut afficher toutes les cellules 
				for(CellRequested cr : this.contR.getListRequested()){
					cr.setSelected(true);
				}

			}
			//Si on coche BtCheckRadio_AllCell()
		if (e.getSource() == getBtCheckRadio_AllCell()) {

			if (this.btCheckRadio_AllCellSelected == false) {
				
				//on grise les boutons 
				Enumeration<AbstractButton> elements = this.groupButton.getElements();
				while (elements.hasMoreElements()) {
					AbstractButton button = (AbstractButton) elements.nextElement();
					button.setEnabled(false);
					button.setSelected(false);
				}
				btCheckRadio_AllCellSelected = true;
			}
			else
			{
				Enumeration<AbstractButton> elements = this.groupButton.getElements();
				while (elements.hasMoreElements()) {
					AbstractButton button = (AbstractButton) elements.nextElement();
					button.setEnabled(true);
					
				}
				getBtCheckRadio_AllCell().setSelected(false);
				btCheckRadio_AllCellSelected = false;
				
			}
			
		}
			if(e.getSource() == this.btClearNeighbourhood){
				
				for(CellRequested cr : this.contR.getListRequested()){
					cr.setNeighbourhood("");
					
				}
				for(JCheckBox ch : listCheckBoxNeighborhood){
					ch.setSelected(false);
				}
				for(JCheckBox ch : listCheckBoxPaneCelluleNeighborhood){
					ch.setSelected(false);
				}
				while (comboBox.getItemCount() > 0) {
					comboBox.removeItemAt(0);
				}
				comboBox.addItem("No Request");
				
				
			}
			if(e.getSource() == this.btAddOneConstraintNeighbourhood){
				boolean present= false;
				comboBox.addItem("Next");
				for(JCheckBox ch : this.listCheckBoxNeighborhood){

					if(ch.isSelected()){
						System.out.println(ch.toString());

						for(JCheckBox ch2 : listCheckBoxPaneCelluleNeighborhood){

							if(ch2.isSelected()){
								System.out.println("ch2 \n" + ch2.toString());

								for (int i = 0; i < this.contR.getListRequested().size(); i++) {
									if ((ch.getName()).equals(this.contR.getListRequested().get(i).getName())) {
										if(!this.contR.getListRequested().get(i).getNeighbourhood().contains(ch2.getName())){
											present= true;
												this.contR.getListRequested().get(i).setNeighbourhood(this.contR.getListRequested().get(i).getNeighbourhood() +" " + ch2.getName());
												this.comboBox.addItem(this.contR.getListRequested().get(i).getName() +  " near to " + this.contR.getListRequested().get(i).getNeighbourhood());
									}}
								}
							}
						}
					}
				}
				
				if(present = true){
					comboBox.removeItem("No Request");
				}
				//afficher la liste
				for(CellRequested cr : this.contR.getListRequested()){
					System.out.println(cr.toString());
				}
			}
			if (e.getSource() == this.btFinish) {
				System.out.println("It is finish ! RequestFrame");
					
				this.sliderAreaInf.setValue((int)this.contR.getDefault_AreaSup());
				this.sliderAreaSup.setValue((int)this.contR.getDefault_AreaInf());
				this.sliderBorderInf.setValue((int)this.contR.getDefault_BorderSup());
				this.sliderBorderSup.setValue((int)this.contR.getDefault_BorderInf());
				this.sliderSphericityInf.setValue((int)this.contR.getDefault_SphericitySup());
				this.sliderSphericitySup.setValue((int)this.contR.getDefault_SphericityInf());
		
				this.sliderDisplayAreaSup.setText(String.valueOf(Math.floor(this.contR.getDefault_AreaInf()*1e2)/1e2));
				this.sliderDisplayAreaInf.setText(String.valueOf(Math.floor(this.contR.getDefault_AreaSup()*1e2)/1e2));
				this.sliderDisplayBorderInf.setText(String.valueOf(Math.floor(this.contR.getDefault_BorderSup()*1e2)/1e2));
				this.sliderDisplayBorderSup.setText(String.valueOf(Math.floor(this.contR.getDefault_BorderInf()*1e2)/1e2));
				this.sliderDisplaySphericityInf.setText(String.valueOf(Math.floor(this.contR.getDefault_SphericitySup()*1e2)/1e2));
				this.sliderDisplaySphericitySup.setText(String.valueOf(Math.floor(this.contR.getDefault_SphericityInf()*1e2)/1e2));
				
				
				this.setVisible(false);
			}
			if (e.getSource() == this.btClear) {
				
				System.out.println("It is Clear RequestFrame !");
				//radio_All cell true
				//this.btRadio_AllCell.setSelected(true);
				
				//init check box
				for(JCheckBox ch :  listCheckBox){
					ch.setSelected(false);
				}
				//this.btCheck_AllCell.setSelected(true);
		
				//clear list with paramast
				for(CellRequested cr : this.contR.getListRequested()){
					cr.setAreaInf(this.contR.getDefault_AreaSup());
					cr.setAreaSup(this.contR.getDefault_AreaInf());
		
					cr.setBorderInf(this.contR.getDefault_BorderSup());
					cr.setBorderSup(this.contR.getDefault_BorderInf());
		
					cr.setSphericityInf(this.contR.getDefault_SphericitySup()*0.001);
					cr.setSphericitySup(this.contR.getDefault_SphericityInf()*0.001);
		
				}
				
				for(int i = 0 ;i<this.contR.getListRequested().size() ; i++){
					System.out.println(this.contR.getListRequested().get(i).toString());
				}
				this.sliderAreaInf.setValue((int)this.contR.getDefault_AreaSup());
				this.sliderAreaSup.setValue((int)this.contR.getDefault_AreaInf());
				this.sliderBorderInf.setValue((int)this.contR.getDefault_BorderSup());
				this.sliderBorderSup.setValue((int)this.contR.getDefault_BorderInf());
				this.sliderSphericityInf.setValue((int)this.contR.getDefault_SphericitySup());
				this.sliderSphericitySup.setValue((int)this.contR.getDefault_SphericityInf());
		
				this.sliderDisplayAreaSup.setText(String.valueOf(Math.floor(this.contR.getDefault_AreaInf()*1e2)/1e2));
				this.sliderDisplayAreaInf.setText(String.valueOf(Math.floor(this.contR.getDefault_AreaSup()*1e2)/1e2));
				this.sliderDisplayBorderInf.setText(String.valueOf(Math.floor(this.contR.getDefault_BorderSup()*1e2)/1e2));
				this.sliderDisplayBorderSup.setText(String.valueOf(Math.floor(this.contR.getDefault_BorderInf()*1e2)/1e2));
				this.sliderDisplaySphericityInf.setText(String.valueOf(Math.floor(this.contR.getDefault_SphericitySup()*1e2)/1e2));
				this.sliderDisplaySphericitySup.setText(String.valueOf(Math.floor(this.contR.getDefault_SphericityInf()*1e2)/1e2));
				
			
				this.setVisible(true);
				
			}
		
		
			if (e.getSource() == this.btApply) {
				System.out.println("It is apply from RequestFram !");
				String h = "";
				for(CellRequested cr : getContR().getListRequested()){
					if((cr.getAreaInf()-cr.getAreaSup())<0){
						h = h+" For : "+ cr.getName() + " AreaInf is superior to AreaSup \n";
						//JOptionPane.showMessageDialog(RequestFrameLaetitia.this,"Warning : \n"+"" "AreaInf is superior to AreaSup");
					}
					if((cr.getSphericityInf()-cr.getSphericitySup())<0){
						h = h+" For : "+ cr.getName() + " SphericityInf is superior to SphericitySup \n";
					}
					if((cr.getBorderInf()-cr.getBorderSup())<0){
						h = h+" For : "+ cr.getName() + " BorderInf is superior to BorderSup \n";

					}
				}
				if(!h.equals("")){
				JOptionPane.showMessageDialog(RequestFrameLaetitia.this,"Warning : \n"+ h);
				}
			
			//debug
			for(int i = 0 ; i<this.contR.getListRequested().size();i++){
				System.out.println("element :" + this.contR.getListRequested().get(i).toString());
			}	
				
				this.setVisible(true);
			}
			
		}
		
		class StateListener implements ActionListener {
		
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Cellule : "+ ((JRadioButton) e.getSource()).getText());
				setRadioSelected(((JRadioButton) e.getSource()).getText());

						
				///Affichage des donnees pre existantes
				for(CellRequested cr : contR.getListRequested()){
					if(cr.getName().equals(getRadioSelected())){
						
						
						sliderAreaInf.setValue((int)cr.getAreaInf());
						sliderAreaSup.setValue((int)cr.getAreaSup());
						sliderBorderInf.setValue((int)cr.getBorderInf());
						sliderBorderSup.setValue((int)cr.getBorderSup());
						double valI = cr.getSphericityInf()*1000;
						System.out.println("inf :"+cr.getSphericityInf()*1000);
						sliderSphericityInf.setValue((int)valI);
						double valS = cr.getSphericitySup()*1000;
						sliderSphericitySup.setValue((int)valS);
						
					}
				}
			}
		}
		
		public void checkButtons(){
			System.out.println("check Button method");
			for (JCheckBox ch : this.listCheckBox) {				
				if (ch.isSelected()) {
					//System.out.println("I am selected : " + ch.getName());
					for (int i = 0; i < this.contR.getListRequested().size(); i++) {
						if ((ch.getName()).equals(this.contR.getListRequested().get(i).getName())) {
									this.contR.getListRequested().get(i).setSelected(true);
						}
					}
				}
				else{
					//System.out.println("I am not selected : " + ch.getName());
					for (int i = 0; i < this.contR.getListRequested().size(); i++) {
						if ((ch.getName()).equals(this.contR.getListRequested().get(i).getName())) {
									this.contR.getListRequested().get(i).setSelected(false);
						}
					}
				}
			}
			//il faut traiter le cas ou All Cells est coché
			if(btCheck_AllCell.isSelected()){
				for (int i = 0; i < this.contR.getListRequested().size(); i++) {
						this.contR.getListRequested().get(i).setSelected(true);
					}
			}
		}
		public void init(HashMap<String,JCheckBox> mapCheckBoxView,double maxArea, double maxSphericity, double maxBorder, double minArea, double minSphericity, double minBorder,HashMap<String, String> mapForRadioButton){
		
		// If value < 0 then this.slider not works , so change value
		this.contR.setDefault_AreaSup(adaptValue(maxArea));
		this.contR.setDefault_AreaInf(adaptValue(minArea));
		this.contR.setDefault_SphericitySup(adaptValue(maxSphericity)+1);
		this.contR.setDefault_SphericityInf(adaptValue(minSphericity)-1);
		this.contR.setDefault_BorderSup(adaptValue(maxBorder));
		this.contR.setDefault_BorderInf(adaptValue(minBorder));
		
		
		this.sliderSphericityInf.setMaximum((int) this.contR.getDefault_SphericitySup());
		this.sliderSphericityInf.setMinimum((int) this.contR.getDefault_SphericityInf());
		this.sliderSphericityInf.setValue((int) this.contR.getDefault_SphericitySup());
		this.sliderSphericityInf.setMajorTickSpacing(50);
		this.sliderSphericityInf.setMinorTickSpacing(10);
		
		this.sliderSphericitySup.setMaximum((int) this.contR.getDefault_SphericitySup());
		this.sliderSphericitySup.setMinimum((int) this.contR.getDefault_SphericityInf());
		this.sliderSphericitySup.setValue((int) this.contR.getDefault_SphericityInf());
		this.sliderSphericitySup.setMajorTickSpacing(50);
		this.sliderSphericitySup.setMinorTickSpacing(10);
		
		this.sliderAreaInf.setMaximum((int) this.contR.getDefault_AreaSup());
		this.sliderAreaInf.setMinimum((int) this.contR.getDefault_AreaInf());
		this.sliderAreaInf.setValue((int) this.contR.getDefault_AreaSup());
		this.sliderAreaInf.setMajorTickSpacing(1000);
		this.sliderAreaInf.setMinorTickSpacing(100);
		
		this.sliderAreaSup.setMaximum((int) this.contR.getDefault_AreaSup());
		this.sliderAreaSup.setMinimum((int) this.contR.getDefault_AreaInf());
		this.sliderAreaSup.setValue((int) this.contR.getDefault_AreaInf());
		this.sliderAreaSup.setMajorTickSpacing(1000);
		this.sliderAreaSup.setMinorTickSpacing(100);
		
		this.sliderBorderInf.setMaximum((int) this.contR.getDefault_BorderSup());
		this.sliderBorderInf.setMinimum((int) this.contR.getDefault_BorderInf());
		this.sliderBorderInf.setValue((int) this.contR.getDefault_BorderSup());
		this.sliderBorderInf.setMajorTickSpacing(50);
		this.sliderBorderInf.setMinorTickSpacing(10);
		
		this.sliderBorderSup.setMaximum((int) this.contR.getDefault_BorderSup());
		this.sliderBorderSup.setMinimum((int) this.contR.getDefault_BorderInf());
		this.sliderBorderSup.setValue((int) this.contR.getDefault_BorderInf());
		this.sliderBorderSup.setMajorTickSpacing(50);
		this.sliderBorderSup.setMinorTickSpacing(10);
		
		
		this.sliderDisplayAreaSup.setText(String.valueOf(Math.floor(this.contR.getDefault_AreaInf()*1e2)/1e2));
		this.sliderDisplayAreaInf.setText(String.valueOf(Math.floor(this.contR.getDefault_AreaSup()*1e2)/1e2));
		this.sliderDisplayBorderInf.setText(String.valueOf(Math.floor(this.contR.getDefault_BorderSup()*1e2)/1e2));
		this.sliderDisplayBorderSup.setText(String.valueOf(Math.floor(this.contR.getDefault_BorderInf()*1e2)/1e2));
		this.sliderDisplaySphericityInf.setText(String.valueOf(0.001*Math.floor(this.contR.getDefault_SphericitySup())));
		this.sliderDisplaySphericitySup.setText(String.valueOf(0.001*Math.floor(this.contR.getDefault_SphericityInf())));
		
		System.out.println("Init max : " + maxArea + " S :" + maxSphericity	+ " B : " + maxBorder);
		System.out.println("Init min : " + minArea + " S :" + minSphericity + " B : " + minBorder);
		
		// Bouttons radios
		// delete all buttons in GroupButton
		Enumeration<AbstractButton> elements = this.groupButton.getElements();
		while (elements.hasMoreElements()) {
			System.out.println("I delete");
			AbstractButton button = (AbstractButton) elements.nextElement();
			this.groupButton.remove(button);
		}
		// delete in paneCell
		this.paneCellule.removeAll();
		this.paneCelluleNeighbourhood.removeAll();
		
		// Bouttons checkBox
		// delete all buttons in listCheckBox
		for (int i= 0;i<listCheckBox.size();i++) {
			System.out.println("I delete checkBox : "+listCheckBox.get(i).getName());
			listCheckBox.remove(i);
			listCheckBoxNeighborhood.remove(i);
			listCheckBoxPaneCelluleNeighborhood.remove(i);
		}
		// delete in paneCell
		this.paneCellDisplay.removeAll();
		this.paneCellDisplayNeighbourhood.removeAll();
		
		// Recreate btCheck_AllCell in listCheckBox
		btCheck_AllCell.setName("All Cells");
		listCheckBox.add(btCheck_AllCell);
		this.paneCellDisplay.add(btCheck_AllCell);
		
		btCheck_AllCellNeighborhood.setName("All Cells");
		listCheckBoxNeighborhood.add(btCheck_AllCellNeighborhood);
		listCheckBoxPaneCelluleNeighborhood.add(btCheckNeighbourhoodPaneCellule_AllCell);
		
		this.paneCellDisplayNeighbourhood.add(btCheck_AllCellNeighborhood);
		
		// Recreate buttons in this.groupButton
		this.paneCellule.add(btCheckRadio_AllCell);
		this.paneCelluleNeighbourhood.add(btCheckNeighbourhoodPaneCellule_AllCell);
		
		for (String key_radio : mapForRadioButton.keySet()) {
			JRadioButton btRadio_Map = new JRadioButton(key_radio);
			btRadio_Map.setName(key_radio);
			this.groupButton.add(btRadio_Map);
			btRadio_Map.addActionListener(new StateListener());
			this.paneCellule.add(btRadio_Map);
			
			final JCheckBox btCheck_Map = new JCheckBox(key_radio);
			btCheck_Map.setName(key_radio);
			btCheck_Map.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(btCheck_Map.isSelected()){
						
						Enumeration<AbstractButton> elements = groupButton.getElements();
						while (elements.hasMoreElements()) {
							AbstractButton button = (AbstractButton) elements.nextElement();
							button.setEnabled(true);
						}
						btCheckRadio_AllCell.setSelected(false);
						btCheckRadio_AllCellSelected = false;
						btCheck_AllCell.setSelected(false);
						
					}
				}
			});
			
			final JCheckBox btCheck_MapNeighborhoodPaneCellule = new JCheckBox(key_radio);
			btCheck_MapNeighborhoodPaneCellule.setName(key_radio);
			this.paneCelluleNeighbourhood.add(btCheck_MapNeighborhoodPaneCellule);	
			this.listCheckBoxPaneCelluleNeighborhood.add(btCheck_MapNeighborhoodPaneCellule);

			final JCheckBox btCheck_MapNeighborhood = new JCheckBox(key_radio);
			btCheck_MapNeighborhood.setName(key_radio);
			btCheck_MapNeighborhood.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(btCheck_MapNeighborhood.isSelected()){
						
						for(JCheckBox ch :listCheckBoxPaneCelluleNeighborhood ){
							ch.setSelected(false);
						}
						
					}
				}
			});
			
			
			this.paneCellDisplay.add(btCheck_Map);
			this.paneCellDisplayNeighbourhood.add(btCheck_MapNeighborhood);
			
			this.listCheckBox.add(btCheck_Map);			
			this.listCheckBoxNeighborhood.add(btCheck_MapNeighborhood);
			
			for(JCheckBox ck : listCheckBoxPaneCelluleNeighborhood){
				System.out.println(ck.getName());
			}
			System.out.println("size : " + listCheckBoxPaneCelluleNeighborhood.size());
		}
		//this.paneNeighbourhood.add(this.paneCellDisplayNeighbourhood);		
		//this.paneNeighbourhood.add(this.paneCelluleNeighbourhood);		

		
		this.rubrique1.add(this.paneCellule);
		this.rubrique0.add(this.paneCellDisplay);
				
		this.contR.getListRequested().clear();
		
		for(String h : mapForRadioButton.keySet()){
			CellRequested cr = new CellRequested(h, false, minArea, maxArea, minSphericity, maxSphericity, minBorder, maxBorder,"");
			this.contR.getListRequested().add(cr);
		}
		this.contR.getListRequested().add(new CellRequested("All Cells", false,minArea, maxArea, minSphericity, maxSphericity, minBorder, maxBorder,""));
		/*
		//debug
		for(int i= 0; i<this.contR.getListRequested().size();i++ ){
			System.out.println("listRequested init " + this.contR.getListRequested().get(i).toString());
		}
		
		//debug
		for(int i= 0; i<listCheckBox.size();i++ ){
			System.out.println("listCheckBox init " + listCheckBox.get(i).getName());
		}
		*/
		setRadioSelected("All Cells");
		
		for(String key : mapCheckBoxView.keySet()){
			if((mapCheckBoxView.get(key).isSelected())){
				for(JCheckBox chbox : listCheckBox){
					if(chbox.getName().equals(mapCheckBoxView.get(key).getName())){
						chbox.setSelected(true);
					}
				}
				
			}
		}
			
		}
		
			public double adaptValue(double e){
				if(e<1){
					e = (e *1000);
				}
				return e;
			}
	
			public JButton getBtApply() {
				return btApply;
			}
		
			public JButton getBtClear() {
				return btClear;
			}
		
	
			public String getRadioSelected() {
				return radioSelected;
			}
			public void setRadioSelected(String radioSelected) {
				this.radioSelected = radioSelected;
			}
		
		
			public JButton getBtFinish() {
				return btFinish;
			}
		

		
			public ControllerRequest getContR() {
				return this.contR;
			}
		
			public void setContR(ControllerRequest contR) {
				this.contR = contR;
			}

			public JCheckBox getBtCheckRadio_AllCell() {
				return btCheckRadio_AllCell;
			}

			public JCheckBox getBtCheck_AllCell() {
				return btCheck_AllCell;
			}


	
		
		}
