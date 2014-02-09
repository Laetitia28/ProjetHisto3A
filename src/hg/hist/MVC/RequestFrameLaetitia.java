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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

	
	public class RequestFrameLaetitia extends JFrame implements ActionListener,
			ChangeListener {
		

		private static final long serialVersionUID = 123456L;
		
		private JLabel labelDisplayTypeCell = new JLabel("Choose cells to display");
		private JLabel labelChooseType = new JLabel("Choose your Cellule type");
		private JLabel labelSphericity = new JLabel("Choose your spherecity ");
		private JLabel labelArea = new JLabel("Choose your area (pxl) ");
		private JLabel labelBorder = new JLabel("Choose your border (pxl) ");

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

		private JButton btFinish = new JButton("Finish");
		private JButton btApply = new JButton("Apply");
		private JButton btClear = new JButton("Clear");

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
		
		private ButtonGroup groupButton = new ButtonGroup();
		private JRadioButton btRadio_AllCell = new JRadioButton("All Cells", true);

		private JCheckBox btCheck_AllCell = new JCheckBox("All Cells",true);
		
		private List<JCheckBox> listCheckBox = new ArrayList<JCheckBox>();
		
	//	private List<CellRequested> listRequested = new ArrayList<CellRequested>();
		private String radioSelected = "All Cells";
	/*	
		private double default_AreaSup;
		private double default_AreaInf;
		private double default_SphericitySup;
		private double default_SphericityInf;
		private double default_BorderSup ;
		private double default_BorderInf ;
		*/

		//AreaMax SphMax BorderMax AreaMin ShpMoin BorderMin
		private ControllerRequest contR;
		
		public RequestFrameLaetitia(ControllerRequest contR,double maxArea, double maxSphericity ,double maxBorder , double minArea ,double minSphericity , double minBorder) 
		{

			this.contR = contR;
			
			System.out.println("MaxParams \n"+ " Area : " + maxArea+ " Sphericity :" + maxSphericity+ " Border : " +maxBorder);
			System.out.println("MinParams \n "+" Area : " + minArea+ " Sphericity :" + minSphericity+ " Border : " +minBorder);
			
			//Size of Frame
			this.setSize(950, 600);
			
		// If value < 0 then this.slider not works , so change value
		contR.setDefault_AreaSup(adaptValue(maxArea));
		contR.setDefault_AreaInf(adaptValue(minArea));
		contR.setDefault_SphericitySup(adaptValue(maxSphericity));
		contR.setDefault_SphericityInf(adaptValue(minSphericity));
		contR.setDefault_BorderSup (adaptValue(maxBorder));
		contR.setDefault_BorderInf (adaptValue(minBorder));

			System.out.println("Max default \n "+"Area : " + contR.getDefault_AreaSup()+ " Sphericity : " + contR.getDefault_SphericitySup()+ " Border : " +contR.getDefault_BorderSup());
			System.out.println("Min defualt \n "+"Area : " + contR.getDefault_AreaInf()+ " Sphericity : " +contR.getDefault_SphericityInf()+ " Border : " +contR.getDefault_BorderInf());
				
			//Verifier les valeurs
			this.sliderSphericitySup = new JSlider(JSlider.HORIZONTAL,(int)contR.getDefault_SphericityInf(), (int)contR.getDefault_SphericitySup() ,(int) contR.getDefault_SphericityInf());
			this.sliderSphericityInf = new JSlider(JSlider.HORIZONTAL,(int)contR.getDefault_SphericityInf(), (int)contR.getDefault_SphericitySup(),(int) contR.getDefault_SphericitySup());
			
			this.sliderAreaSup = new JSlider(JSlider.HORIZONTAL, (int)contR.getDefault_AreaInf(), (int)contR.getDefault_AreaSup() ,(int) contR.getDefault_AreaInf());
			this.sliderAreaInf = new JSlider(JSlider.HORIZONTAL,(int)contR.getDefault_AreaInf(), (int)contR.getDefault_AreaSup(),(int) contR.getDefault_AreaSup());				
			
			this.sliderBorderSup = new JSlider(JSlider.HORIZONTAL,(int)contR.getDefault_BorderInf(), (int)contR.getDefault_BorderSup(),(int) contR.getDefault_BorderInf());
			this.sliderBorderInf = new JSlider(JSlider.HORIZONTAL,(int)contR.getDefault_BorderInf(), (int)contR.getDefault_BorderSup(),(int) contR.getDefault_BorderSup());
			
			this.panelTotal.setBackground(Color.white);
			
			this.add(panelTotal);
			
			// choisir la cellule

		//	this.rubrique0.setPreferredSize(new Dimention(1000,100));
			this.rubrique0.setBackground(Color.GREEN);
			
		//	this.rubrique1.setPreferredSize(new Dimension(1000, 100));
			this.rubrique1.setBackground(Color.RED);

			//put a line a separator
			Border blackline = BorderFactory.createLineBorder(Color.black);
			this.paneCellule.setBorder(blackline);
			this.paneCellule.setBounds(0, 200, 150, 200);
			this.paneCellule.setOpaque(true);
			this.paneCellule.setBackground(Color.GREEN);
			this.paneCellule.setPreferredSize(new Dimension(600, 50));
			this.paneCellule.setLayout(new GridLayout(3,3));
			
			
			this.paneCellDisplay.setBorder(blackline);
			this.paneCellDisplay.setBounds(0, 200, 150, 200);
			this.paneCellDisplay.setOpaque(true);
			this.paneCellDisplay.setBackground(Color.GREEN);
			this.paneCellDisplay.setPreferredSize(new Dimension(600, 50));
			this.paneCellDisplay.setLayout(new GridLayout(3, 3));
			
			this.btCheck_AllCell.setName("All Cells");
			this.listCheckBox.add(btCheck_AllCell);
			this.paneCellDisplay.add(btCheck_AllCell);

			
			this.groupButton.add(btRadio_AllCell);			
			this.paneCellule.add(btRadio_AllCell);
			this.btRadio_AllCell.addActionListener(new StateListener());
			
			///RUBRIQUE 0 
			//To center the this.label
			this.labelDisplayTypeCell.setHorizontalAlignment(JLabel.CENTER);
			this.labelDisplayTypeCell.setVerticalAlignment(JLabel.CENTER);
			this.rubrique0.add(this.labelDisplayTypeCell, BorderLayout.NORTH);
			this.rubrique0.add(this.paneCellDisplay, BorderLayout.CENTER);
			
			
			////RUBRIQUE 1
			//To center the this.label
			this.labelChooseType.setHorizontalAlignment(JLabel.CENTER);
			this.labelChooseType.setVerticalAlignment(JLabel.CENTER);
			this.rubrique1.add(this.labelChooseType, BorderLayout.NORTH);
			this.rubrique1.add(this.paneCellule, BorderLayout.CENTER);
			
			
			//RUBRIQUE 2 AREA 
			
			//this.rubrique2.setPreferredSize(new Dimension(1100, 100));
			this.rubrique2.setBackground(Color.YELLOW);
					
			this.paneAreaSup.setLayout(new GridBagLayout());
			GridBagConstraints gc = new GridBagConstraints();
			gc.weightx = 3 ;
			gc.weighty = 1 ;
			this.paneAreaSup.setBackground(Color.ORANGE);
		//	this.paneAreaSup.setPreferredSize(new Dimension(600, 50));
			
			
			this.paneAreaInf.setLayout(new GridBagLayout());
			GridBagConstraints gcAreaInf = new GridBagConstraints();
			gcAreaInf.weightx = 3 ;
			gcAreaInf.weighty = 1 ;
			this.paneAreaInf.setBackground(Color.ORANGE);
		//	this.paneAreaInf.setPreferredSize(new Dimension(600, 50));

			
			//Area
			//Sup
			this.sliderDisplayAreaSup.setText("Value");
			this.sliderDisplayAreaSup.setPreferredSize(new Dimension(50, 45));
			this.sliderDisplayAreaSup.setForeground(Color.BLUE);
			
			//Inf
			this.sliderDisplayAreaInf.setText("Value");
			this.sliderDisplayAreaInf.setPreferredSize(new Dimension(50, 45));
			this.sliderDisplayAreaInf.setForeground(Color.BLUE);

			//Sup
			Dimension d = this.sliderAreaSup.getPreferredSize();  
			this.sliderAreaSup.setPreferredSize(new Dimension(d.width+200,d.height+30)); 	
			this.sliderAreaSup.setMajorTickSpacing(1000);
			this.sliderAreaSup.setMinorTickSpacing(100);
			this.sliderAreaSup.setPaintTicks(true);
			this.sliderAreaSup.setPaintLabels(true);

			//Inf
			this.sliderAreaInf.setPreferredSize(new Dimension(this.sliderAreaInf.getPreferredSize().width+200,this.sliderAreaInf.getPreferredSize().height+30)); 
			this.sliderAreaInf.setMajorTickSpacing(1000);
			this.sliderAreaInf.setMinorTickSpacing(100);
			this.sliderAreaInf.setPaintTicks(true);
			this.sliderAreaInf.setPaintLabels(true);

			//Listener
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
			
			//Sup
			gc.anchor = GridBagConstraints.LINE_START;
			
			gc.fill = GridBagConstraints.HORIZONTAL;
			gc.gridx = 0;
			gc.gridy = 0 ; 
			gc.gridwidth = 1;
			this.paneAreaSup.add(new JLabel("Superior"),gc);
			
			gc.fill = GridBagConstraints.HORIZONTAL;
			gc.gridx = 0;
			gc.gridy = 1 ; 
			gc.gridwidth = 1;
			this.paneAreaSup.add(this.sliderAreaSup,gc);
			
			gc.gridx = 2;
			gc.gridy = 1 ; 
			this.paneAreaSup.add(this.sliderDisplayAreaSup,gc);
			
			
			//Inf
			gcAreaInf.anchor = GridBagConstraints.LINE_START;
			gcAreaInf.fill = GridBagConstraints.HORIZONTAL;
			gcAreaInf.gridx = 0;
			gcAreaInf.gridy = 0 ; 
			gcAreaInf.gridwidth = 1;
			this.paneAreaInf.add(new JLabel("Inferior"),gcAreaInf);
			
			gcAreaInf.fill = GridBagConstraints.HORIZONTAL;
			gcAreaInf.gridx = 0;
			gcAreaInf.gridy = 1 ;
			gcAreaInf.gridwidth = 1;
			this.paneAreaInf.add(this.sliderAreaInf,gcAreaInf);
			
			gcAreaInf.gridx = 2;
			gcAreaInf.gridy = 1 ; 
			this.paneAreaInf.add(this.sliderDisplayAreaInf,gcAreaInf);
			

			//this.rubrique 2 
			GridBagConstraints contraintes = new GridBagConstraints();
			contraintes.fill = GridBagConstraints.BOTH;
			contraintes.insets = new Insets(5, 5, 5, 5);

			contraintes.ipady=contraintes.anchor=GridBagConstraints.CENTER;;
			contraintes.weightx = 2;
			contraintes.weighty = 2;
			
			contraintes.gridx = 0;
			contraintes.gridy = 0;
			contraintes.gridwidth = 2;
			contraintes.anchor = GridBagConstraints.NORTH;
			
			this.rubrique2.add(this.labelArea,contraintes);
			
			contraintes.fill = GridBagConstraints.BOTH;
			contraintes.gridx = 0 ;
			contraintes.gridy = 1;
			contraintes.gridwidth = 1;
			this.rubrique2.add(this.paneAreaSup,contraintes);
			
			contraintes.gridx = 1;
			contraintes.gridy = 1;
			contraintes.gridwidth = 1;
			this.rubrique2.add(this.paneAreaInf,contraintes);

			// RUBRIQUE 3 Shpericity

			//this.rubrique3.setPreferredSize(new Dimension(1100, 100));
			this.rubrique3.setBackground(Color.YELLOW);

			//sup
			this.paneSphereSup.setLayout(new GridBagLayout());
			GridBagConstraints gcSphericitySup = new GridBagConstraints();
			gcSphericitySup.weightx = 3 ;
			gcSphericitySup.weighty = 1 ;
			this.paneSphereSup.setBackground(Color.RED);
			//this.paneSphereSup.setPreferredSize(new Dimension(600, 50));
			
			//Inf
			this.paneSphereInf.setLayout(new GridBagLayout());
			GridBagConstraints gcSphericityInf = new GridBagConstraints();
			gcSphericityInf.weightx = 3 ;
			gcSphericityInf.weighty = 1 ;
			this.paneSphereInf.setBackground(Color.GREEN);
			//this.paneSphereInf.setPreferredSize(new Dimension(600, 50));

			
			//sphericity
			//Sup
			this.sliderDisplaySphericitySup.setText("Value");
			this.sliderDisplaySphericitySup.setPreferredSize(new Dimension(50, 45));
			this.sliderDisplaySphericitySup.setForeground(Color.BLUE);
			
			//Inf
			this.sliderDisplaySphericityInf.setText("Value");
			this.sliderDisplaySphericityInf.setPreferredSize(new Dimension(50, 45));
			this.sliderDisplaySphericityInf.setForeground(Color.BLUE);

			
			//Sup
			this.sliderSphericitySup.setPreferredSize(new Dimension(this.sliderSphericitySup.getPreferredSize().width+200,this.sliderSphericitySup.getPreferredSize().height+30));
			this.sliderSphericitySup.setMajorTickSpacing(50);
			this.sliderSphericitySup.setMinorTickSpacing(10);
			this.sliderSphericitySup.setPaintTicks(true);
			this.sliderSphericitySup.setPaintLabels(true);

			//Inf
			this.sliderSphericityInf.setPreferredSize(new Dimension(this.sliderSphericityInf.getPreferredSize().width+200,this.sliderSphericityInf.getPreferredSize().height+30));
			this.sliderSphericityInf.setMajorTickSpacing(50);
			this.sliderSphericityInf.setMinorTickSpacing(10);	
			this.sliderSphericityInf.setPaintTicks(true);
			this.sliderSphericityInf.setPaintLabels(true);

			//Listeners
			this.sliderSphericityInf.addChangeListener(this);
			this.sliderSphericitySup.addChangeListener(this);

			this.sliderDisplaySphericitySup.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent ke) {
					String typed =sliderDisplaySphericitySup.getText();
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

			//Sup
					gcSphericitySup.anchor = GridBagConstraints.LINE_START;					
					gcSphericitySup.fill = GridBagConstraints.HORIZONTAL;
					gcSphericitySup.gridx = 0;
					gcSphericityInf.gridwidth = 1;
					gcSphericitySup.gridy = 0 ; 
					this.paneSphereSup.add(new JLabel("Superior"),gcSphericitySup);
					
					gcSphericitySup.fill = GridBagConstraints.HORIZONTAL;
					gcSphericitySup.gridx = 0;
					gcSphericitySup.gridy = 1 ; 
					gcSphericitySup.gridwidth = 1;
					this.paneSphereSup.add(this.sliderSphericitySup,gcSphericitySup);
								
					gcSphericitySup.fill = GridBagConstraints.BOTH;
					gcSphericitySup.weightx= 0.7;
					gcSphericitySup.gridx = 3;
					gcSphericitySup.gridy = 1 ;
					this.paneSphereSup.add(this.sliderDisplaySphericitySup,gcSphericitySup);
					
					
					//Inf
					gcSphericityInf.anchor = GridBagConstraints.LINE_START;						
					gcSphericityInf.fill = GridBagConstraints.HORIZONTAL;
					gcSphericityInf.gridx = 0;
					gcSphericityInf.gridy = 0 ; 
					gcSphericityInf.gridwidth = 1;
					this.paneSphereInf.add(new JLabel("Inferior"),gcSphericityInf);
					
					gcSphericityInf.fill = GridBagConstraints.HORIZONTAL;
					gcSphericityInf.gridx = 0;
					gcSphericityInf.gridy = 1 ;
					gcSphericityInf.gridwidth = 1 ;
					this.paneSphereInf.add(this.sliderSphericityInf,gcSphericityInf);
					gcSphericityInf.fill = GridBagConstraints.BOTH;
					gcSphericityInf.weightx= 0.7;
					gcSphericityInf.gridx = 3;
					gcSphericityInf.gridy = 1; 
					this.paneSphereInf.add(this.sliderDisplaySphericityInf,gcSphericityInf);
					

					//this.rubrique 2 
					GridBagConstraints contraintesSphericity = new GridBagConstraints();
					contraintesSphericity.fill = GridBagConstraints.BOTH;
					contraintesSphericity.insets = new Insets(5, 5, 5, 5);

					contraintesSphericity.ipady=contraintesSphericity.anchor=GridBagConstraints.CENTER;;
					contraintesSphericity.weightx = 2;
					contraintesSphericity.weighty = 2;
					
					contraintesSphericity.gridx = 0;
					contraintesSphericity.gridy = 0;
					contraintesSphericity.gridwidth = 2;
					contraintesSphericity.anchor = GridBagConstraints.NORTH;
				    String j =10+"<sup>-4</sup>";

					this.labelSphericity.setText("<html>"+ this.labelSphericity.getText()+" (" + j+" pxl ) </html>");
					this.rubrique3.add(this.labelSphericity,contraintesSphericity);
					
					contraintesSphericity.fill = GridBagConstraints.BOTH;
					contraintesSphericity.gridx = 0 ;
					contraintesSphericity.gridy = 1;
					contraintesSphericity.gridwidth = 1;
					this.rubrique3.add(this.paneSphereSup,contraintesSphericity);
					
					contraintesSphericity.gridx = 1;
					contraintesSphericity.gridy = 1;
					contraintesSphericity.gridwidth = 1;
					this.rubrique3.add(this.paneSphereInf,contraintesSphericity);

			// RuBRIQUE 4 
			//Border

			//this.rubrique4.setPreferredSize(new Dimension(1100, 100));
			this.rubrique4.setBackground(Color.YELLOW);

			this.paneBorderSup.setLayout(new GridBagLayout());
			GridBagConstraints gcBorderSup  = new GridBagConstraints();
			gcBorderSup.weightx = 3;
			gcBorderSup.weightx = 1;
			this.paneBorderSup.setBackground(Color.BLUE);
			//this.paneBorderSup.setPreferredSize(new Dimension(600, 50));
			
			this.paneBorderInf.setLayout(new GridBagLayout());
			GridBagConstraints gcBorderInf  = new GridBagConstraints();
			gcBorderInf.weightx = 3;
			gcBorderInf.weightx = 1;
			this.paneBorderInf.setBackground(Color.white);
			//this.paneBorderInf.setPreferredSize(new Dimension(600, 50));

			//Border 
			//Sup
			this.sliderDisplayBorderSup.setText("Value");
			this.sliderDisplayBorderSup.setPreferredSize(new Dimension(50, 45));
			this.sliderDisplayBorderSup.setForeground(Color.BLUE);
			
			//Inf
			this.sliderDisplayBorderInf.setText("Value");
			this.sliderDisplayBorderInf.setPreferredSize(new Dimension(50, 45));
			this.sliderDisplayBorderInf.setForeground(Color.BLUE);

			//Sup
			this.sliderBorderSup.setPreferredSize(new Dimension(this.sliderBorderSup.getPreferredSize().width+200,this.sliderBorderSup.getPreferredSize().height+30));
			this.sliderBorderSup.setMajorTickSpacing(50);
			this.sliderBorderSup.setMinorTickSpacing(10);
			this.sliderBorderSup.setPaintTicks(true);
			this.sliderBorderSup.setPaintLabels(true);

			//Inf
			this.sliderBorderInf.setPreferredSize(new Dimension(this.sliderBorderInf.getPreferredSize().width+200,this.sliderBorderInf.getPreferredSize().height+30));
			this.sliderBorderInf.setMajorTickSpacing(50);
			this.sliderBorderInf.setMinorTickSpacing(10);
			this.sliderBorderInf.setPaintTicks(true);
			this.sliderBorderInf.setPaintLabels(true);

			//Listener
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

					//Sup
			gcBorderSup.anchor = GridBagConstraints.LINE_START;					
			gcBorderSup.fill = GridBagConstraints.HORIZONTAL;
			gcBorderSup.gridx = 0;
			gcBorderSup.gridy = 0 ; 
			this.paneBorderSup.add(new JLabel("Superior"),gcBorderSup);
			
										
					gcBorderSup.fill = GridBagConstraints.HORIZONTAL;
					gcBorderSup.gridx = 0;
					gcBorderSup.gridy = 1 ; 
					this.paneBorderSup.add(this.sliderBorderSup,gcBorderSup);
					
					gcBorderSup.gridx = 2;
					gcBorderSup.gridy = 1 ; 
					this.paneBorderSup.add(this.sliderDisplayBorderSup,gcBorderSup);
					
					//Inf
					
					gcBorderInf.anchor = GridBagConstraints.LINE_START;				
					gcBorderInf.fill = GridBagConstraints.HORIZONTAL;
					gcBorderInf.gridx = 0;
					gcBorderInf.gridy = 0 ; 
					this.paneBorderInf.add(new JLabel("Inferior"),gcBorderInf);
					
					
					gcBorderInf.fill = GridBagConstraints.HORIZONTAL;
					gcBorderInf.gridx = 0;
					gcBorderInf.gridy = 1 ;
					gcBorderInf.weightx=1;

					this.paneBorderInf.add(this.sliderBorderInf,gcBorderInf);
					
					gcBorderInf.gridx = 2;
					gcBorderInf.gridy = 1;							; 
					this.paneBorderInf.add(this.sliderDisplayBorderInf,gcBorderInf);
					
					//this.rubrique 4 
					GridBagConstraints contraintesBorder = new GridBagConstraints();
					contraintesBorder.fill = GridBagConstraints.BOTH;
					contraintesBorder.insets = new Insets(5, 5, 5, 5);

					contraintesBorder.ipady=contraintesBorder.anchor=GridBagConstraints.CENTER;;
					contraintesBorder.weightx = 2;
					contraintesBorder.weighty = 2;
					
					contraintesBorder.gridx = 0;
					contraintesBorder.gridy = 0;
					contraintesBorder.gridwidth = 2;
					contraintesBorder.anchor = GridBagConstraints.NORTH;
					this.rubrique4.add(this.labelBorder,contraintesBorder);
					
					contraintesBorder.fill = GridBagConstraints.BOTH;
					contraintesBorder.gridx = 0 ;
					contraintesBorder.gridy = 1;
					contraintesBorder.gridwidth = 1;
					this.rubrique4.add(this.paneBorderSup,contraintesBorder);
					
					contraintesBorder.gridx = 1;
					contraintesBorder.gridy = 1;
					contraintesBorder.gridwidth = 1;
					this.rubrique4.add(this.paneBorderInf,contraintesBorder);
					
			this.paneEnd.setPreferredSize(new Dimension(900, 100));
			this.paneEnd.setBackground(Color.white);

			btFinish.addActionListener(this);
			btApply.addActionListener(this);
			btClear.addActionListener(this);
		
			
			this.paneEnd.add(btFinish, BorderLayout.WEST);
			this.paneEnd.add(btApply, BorderLayout.WEST);
			this.paneEnd.add(btClear, BorderLayout.WEST);

			JSeparator p = new JSeparator(SwingConstants.HORIZONTAL);
			p.setBackground(Color.BLACK);
			p.setPreferredSize(new Dimension(p.getWidth()+100, p.getHeight()+20));
			
			this.panelTotal.add(this.rubrique0);
			this.panelTotal.add(this.rubrique1);
			this.panelTotal.add(this.rubrique2);
			this.panelTotal.add(this.rubrique3);
			this.panelTotal.add(this.rubrique4);
			//this.panelTotal.add(p,BorderLayout);
			this.panelTotal.add(this.paneEnd);
		}

		public void stateChanged(ChangeEvent event) {
			// this.sliderBorderSup
			if (event.getSource() == this.sliderBorderSup) {
				this.sliderDisplayBorderSup.setText(String.valueOf(this.sliderBorderSup.getValue()));
				System.out.println("BorderSup : "+ String.valueOf(this.sliderBorderSup.getValue()));
				System.out.println("radioSelected : "+ getRadioSelected());
				for(int i = 0 ;i<contR.getListRequested().size();i++){
					if((contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						contR.getListRequested().get(i).setBorderSup(Double.valueOf(this.sliderBorderSup.getValue()));
					}
				}
			}
			// SliderBorderInf
			if (event.getSource() == this.sliderBorderInf) {
				this.sliderDisplayBorderInf.setText(String.valueOf(this.sliderBorderInf.getValue()));
				System.out.println("BorderInf : "+ String.valueOf(this.sliderBorderInf.getValue()));
				
				System.out.println("radioSelected : "+ getRadioSelected());
				for(int i = 0 ;i<contR.getListRequested().size();i++){
					if((contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						contR.getListRequested().get(i).setBorderInf(Double.valueOf(this.sliderBorderInf.getValue()));
					}
				}

			}
			
			// SliderSphericitySup
			if (event.getSource() == this.sliderSphericitySup) {
				
				double a = this.sliderSphericitySup.getValue()*0.001;
				System.out.println("a"+ a);

				this.sliderDisplaySphericitySup.setText(String.valueOf(String.valueOf(Math.floor(a*1e2)/1e2)));
				System.out.println("SphéericitySup : "+ String.valueOf(String.valueOf(Math.floor(a*1e2)/1e2)));
			
				System.out.println("radioSelected : "+ getRadioSelected());
				for(int i = 0 ;i<contR.getListRequested().size();i++){
					if((contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						contR.getListRequested().get(i).setSphericitySup(Double.valueOf(this.sliderSphericitySup.getValue())*0.001);
					}
				}


			}
			// SliderSphericityInf
			if (event.getSource() == this.sliderSphericityInf) {
				double a = this.sliderSphericityInf.getValue()*0.001;
				 
				this.sliderDisplaySphericityInf.setText(String.valueOf(Math.floor(a*1e2)/1e2));
				System.out.println("SphericityInf : "+ String.valueOf(Math.floor(a*1e2)/1e2));
				
				System.out.println("radioSelected : "+ getRadioSelected());
				
				for(int i = 0 ;i<contR.getListRequested().size();i++){
					if((contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						contR.getListRequested().get(i).setSphericityInf(Double.valueOf(this.sliderSphericityInf.getValue())*0.001);
					}
				}
			}

			// SliderAreaSup
			if (event.getSource() == this.sliderAreaSup) {

				this.sliderDisplayAreaSup.setText(String.valueOf(this.sliderAreaSup.getValue()));
				System.out.println("AreaSup : "+ String.valueOf(this.sliderAreaSup.getValue()));
					
				System.out.println("radioSelected : "+ getRadioSelected());
				for(int i = 0 ;i<contR.getListRequested().size();i++){
					if((contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						contR.getListRequested().get(i).setAreaSup(Double.valueOf(this.sliderAreaSup.getValue()));
					}
				}
			}
			// SlierAreaInf
			if (event.getSource() == this.sliderAreaInf) {

				this.sliderDisplayAreaInf.setText(String.valueOf(this.sliderAreaInf.getValue()));
				System.out.println("AreaInf : "+ String.valueOf(this.sliderAreaInf.getValue()));
				
				System.out.println("radioSelected : "+ getRadioSelected());
				for(int i = 0 ;i<contR.getListRequested().size();i++){
					if((contR.getListRequested().get(i).getName()).equals(getRadioSelected())){
						contR.getListRequested().get(i).setAreaInf(Double.valueOf(this.sliderAreaInf.getValue()));
					}
				}
				
			}

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btFinish) {
				System.out.println("It is finish ! RequestFrame");
				
				this.btRadio_AllCell.setSelected(true);
				this.btCheck_AllCell.setSelected(true);
					
				this.sliderAreaInf.setValue((int)contR.getDefault_AreaSup());
				this.sliderAreaSup.setValue((int)contR.getDefault_AreaInf());
				this.sliderBorderInf.setValue((int)contR.getDefault_BorderSup());
				this.sliderBorderSup.setValue((int)contR.getDefault_BorderInf());
				this.sliderSphericityInf.setValue((int)contR.getDefault_SphericitySup());
				this.sliderSphericitySup.setValue((int)contR.getDefault_SphericityInf());

				this.sliderDisplayAreaSup.setText(String.valueOf(Math.floor(contR.getDefault_AreaInf()*1e2)/1e2));
				this.sliderDisplayAreaInf.setText(String.valueOf(Math.floor(contR.getDefault_AreaSup()*1e2)/1e2));
				this.sliderDisplayBorderInf.setText(String.valueOf(Math.floor(contR.getDefault_BorderSup()*1e2)/1e2));
				this.sliderDisplayBorderSup.setText(String.valueOf(Math.floor(contR.getDefault_BorderInf()*1e2)/1e2));
				this.sliderDisplaySphericityInf.setText(String.valueOf(Math.floor(contR.getDefault_SphericitySup()*1e2)/1e2));
				this.sliderDisplaySphericitySup.setText(String.valueOf(Math.floor(contR.getDefault_SphericityInf()*1e2)/1e2));
				
				
				this.setVisible(false);
			}
			if (e.getSource() == btClear) {
				
				System.out.println("It is Clear RequestFrame !");
				//radio_All cell true
				this.btRadio_AllCell.setSelected(true);
				
				//init check box
				for(JCheckBox ch :  listCheckBox){
					ch.setSelected(false);
				}
				this.btCheck_AllCell.setSelected(true);

				//clear list with paramast
				for(CellRequested cr : contR.getListRequested()){
					cr.setAreaInf(contR.getDefault_AreaSup());
					cr.setAreaSup(contR.getDefault_AreaInf());

					cr.setBorderInf(contR.getDefault_BorderSup());
					cr.setBorderSup(contR.getDefault_BorderInf());

					cr.setSphericityInf(contR.getDefault_SphericitySup()*0.001);
					cr.setSphericitySup(contR.getDefault_SphericityInf()*0.001);

				}
				
				for(int i = 0 ;i<contR.getListRequested().size() ; i++){
					System.out.println(contR.getListRequested().get(i).toString());
				}
				this.sliderAreaInf.setValue((int)contR.getDefault_AreaSup());
				this.sliderAreaSup.setValue((int)contR.getDefault_AreaInf());
				this.sliderBorderInf.setValue((int)contR.getDefault_BorderSup());
				this.sliderBorderSup.setValue((int)contR.getDefault_BorderInf());
				this.sliderSphericityInf.setValue((int)contR.getDefault_SphericitySup());
				this.sliderSphericitySup.setValue((int)contR.getDefault_SphericityInf());

				this.sliderDisplayAreaSup.setText(String.valueOf(Math.floor(contR.getDefault_AreaInf()*1e2)/1e2));
				this.sliderDisplayAreaInf.setText(String.valueOf(Math.floor(contR.getDefault_AreaSup()*1e2)/1e2));
				this.sliderDisplayBorderInf.setText(String.valueOf(Math.floor(contR.getDefault_BorderSup()*1e2)/1e2));
				this.sliderDisplayBorderSup.setText(String.valueOf(Math.floor(contR.getDefault_BorderInf()*1e2)/1e2));
				this.sliderDisplaySphericityInf.setText(String.valueOf(Math.floor(contR.getDefault_SphericitySup()*1e2)/1e2));
				this.sliderDisplaySphericitySup.setText(String.valueOf(Math.floor(contR.getDefault_SphericityInf()*1e2)/1e2));
				
			
				this.setVisible(true);
				
			}
		

			if (e.getSource() == btApply) {
				System.out.println("It is apply from RequestFram !");

			
			//debug
			for(int i = 0 ; i<contR.getListRequested().size();i++){
				System.out.println("element :" + contR.getListRequested().get(i).toString());
			}	
				
				this.setVisible(true);
			}
			
		}

		class StateListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Cellule : "+ ((JRadioButton) e.getSource()).getText());
				
				setRadioSelected(((JRadioButton) e.getSource()).getText());

				
				for(CellRequested cr : contR.getListRequested()){
					if(cr.getName().equals(getRadioSelected())){
						System.out.println("\n "+cr.toString());
						
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
					for (int i = 0; i < contR.getListRequested().size(); i++) {
						if ((ch.getName()).equals(contR.getListRequested().get(i).getName())) {
									contR.getListRequested().get(i).setSelected(true);
						}
					}
				}
				else{
					//System.out.println("I am not selected : " + ch.getName());
					for (int i = 0; i < contR.getListRequested().size(); i++) {
						if ((ch.getName()).equals(contR.getListRequested().get(i).getName())) {
									contR.getListRequested().get(i).setSelected(false);
						}
					}
				}
			}
		}
		public void init(double maxArea, double maxSphericity, double maxBorder, double minArea, double minSphericity, double minBorder,HashMap<String, String> mapForRadioButton){

		// If value < 0 then this.slider not works , so change value
		contR.setDefault_AreaSup(adaptValue(maxArea));
		contR.setDefault_AreaInf(adaptValue(minArea));
		contR.setDefault_SphericitySup(adaptValue(maxSphericity));
		contR.setDefault_SphericityInf(adaptValue(minSphericity));
		contR.setDefault_BorderSup(adaptValue(maxBorder));
		contR.setDefault_BorderInf(adaptValue(minBorder));

		
		this.sliderSphericityInf.setMaximum((int) contR.getDefault_SphericitySup());
		this.sliderSphericityInf.setMinimum((int) contR.getDefault_SphericityInf());
		this.sliderSphericityInf.setValue((int) contR.getDefault_SphericitySup());
		this.sliderSphericityInf.setMajorTickSpacing(50);
		this.sliderSphericityInf.setMinorTickSpacing(10);

		this.sliderSphericitySup.setMaximum((int) contR.getDefault_SphericitySup());
		this.sliderSphericitySup.setMinimum((int) contR.getDefault_SphericityInf());
		this.sliderSphericitySup.setValue((int) contR.getDefault_SphericityInf());
		this.sliderSphericitySup.setMajorTickSpacing(50);
		this.sliderSphericitySup.setMinorTickSpacing(10);

		this.sliderAreaInf.setMaximum((int) contR.getDefault_AreaSup());
		this.sliderAreaInf.setMinimum((int) contR.getDefault_AreaInf());
		this.sliderAreaInf.setValue((int) contR.getDefault_AreaSup());
		this.sliderAreaInf.setMajorTickSpacing(1000);
		this.sliderAreaInf.setMinorTickSpacing(100);

		this.sliderAreaSup.setMaximum((int) contR.getDefault_AreaSup());
		this.sliderAreaSup.setMinimum((int) contR.getDefault_AreaInf());
		this.sliderAreaSup.setValue((int) contR.getDefault_AreaInf());
		this.sliderAreaSup.setMajorTickSpacing(1000);
		this.sliderAreaSup.setMinorTickSpacing(100);

		this.sliderBorderInf.setMaximum((int) contR.getDefault_BorderSup());
		this.sliderBorderInf.setMinimum((int) contR.getDefault_BorderInf());
		this.sliderBorderInf.setValue((int) contR.getDefault_BorderSup());
		this.sliderBorderInf.setMajorTickSpacing(50);
		this.sliderBorderInf.setMinorTickSpacing(10);

		this.sliderBorderSup.setMaximum((int) contR.getDefault_BorderSup());
		this.sliderBorderSup.setMinimum((int) contR.getDefault_BorderInf());
		this.sliderBorderSup.setValue((int) contR.getDefault_BorderInf());
		this.sliderBorderSup.setMajorTickSpacing(50);
		this.sliderBorderSup.setMinorTickSpacing(10);


		this.sliderDisplayAreaSup.setText(String.valueOf(Math.floor(contR.getDefault_AreaInf()*1e2)/1e2));
		this.sliderDisplayAreaInf.setText(String.valueOf(Math.floor(contR.getDefault_AreaSup()*1e2)/1e2));
		this.sliderDisplayBorderInf.setText(String.valueOf(Math.floor(contR.getDefault_BorderSup()*1e2)/1e2));
		this.sliderDisplayBorderSup.setText(String.valueOf(Math.floor(contR.getDefault_BorderInf()*1e2)/1e2));
		this.sliderDisplaySphericityInf.setText(String.valueOf(0.001*Math.floor(contR.getDefault_SphericitySup()*1e2)/1e2));
		this.sliderDisplaySphericitySup.setText(String.valueOf(0.001*Math.floor(contR.getDefault_SphericityInf()*1e2)/1e2));
		
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
		
		// Bouttons checkBox
		// delete all buttons in listCheckBox
		for (int i= 0;i<listCheckBox.size();i++) {
			System.out.println("I delete checkBox : "+listCheckBox.get(i).getName());
			listCheckBox.remove(i);
		}
		// delete in paneCell
		this.paneCellDisplay.removeAll();
		
		
		// Recreate buttons in listCheckBox
		btCheck_AllCell.setSelected(true);
		btCheck_AllCell.setName("All Cells");
		listCheckBox.add(btCheck_AllCell);
		this.paneCellDisplay.add(btCheck_AllCell);

		// Recreate buttons in this.groupButton
		btRadio_AllCell.setSelected(true);
		this.groupButton.add(btRadio_AllCell);
		this.paneCellule.add(btRadio_AllCell);
		
		for (String key_radio : mapForRadioButton.keySet()) {
			System.out.println("key_radio : " + key_radio);
			JRadioButton btRadio_Map = new JRadioButton(key_radio);
			btRadio_Map.setName(key_radio);
			this.groupButton.add(btRadio_Map);
			btRadio_Map.addActionListener(new StateListener());
			this.paneCellule.add(btRadio_Map);
			
			System.out.println("key_btCheck : " + key_radio);
			JCheckBox btCheck_Map = new JCheckBox(key_radio);
			btCheck_Map.setName(key_radio);
			this.paneCellDisplay.add(btCheck_Map);
			listCheckBox.add(btCheck_Map);

		}
		this.rubrique1.add(this.paneCellule);
		this.rubrique0.add(this.paneCellDisplay);
		
		System.out.println("count listCheckBox : " + listCheckBox.size());
		
		contR.getListRequested().clear();
		
		for(String h : mapForRadioButton.keySet()){
			CellRequested cr = new CellRequested(h, false, minArea, maxArea, minSphericity, maxSphericity, minBorder, maxBorder);
			contR.getListRequested().add(cr);
		}
		contR.getListRequested().add(new CellRequested("All Cells", false,minArea, maxArea, minSphericity, maxSphericity, minBorder, maxBorder));
		//debug
		for(int i= 0; i<contR.getListRequested().size();i++ ){
			System.out.println("listRequested init " + contR.getListRequested().get(i).toString());
		}
		
		//debug
		for(int i= 0; i<listCheckBox.size();i++ ){
			System.out.println("listCheckBox init " + listCheckBox.get(i).getName());
		}
		
		setRadioSelected("All Cells");
		
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

		public JButton getBtClear() {
			return btClear;
		}

		public void setBtClear(JButton btClear) {
			this.btClear = btClear;
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

		public void setBtFinish(JButton btFinish) {
			this.btFinish = btFinish;
		}

		public ControllerRequest getContR() {
			return contR;
		}

		public void setContR(ControllerRequest contR) {
			this.contR = contR;
		}

	}
