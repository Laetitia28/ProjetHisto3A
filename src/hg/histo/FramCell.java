package hg.histo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.view.mxGraph;

public class FramCell extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;


	private String img_default = "src/ressources/image0046.jpg";
	private String path_image = img_default;
	private String path_excel_default = "src/ressources/image0046.csv";
	private String path_current = path_excel_default;

	private JCheckBox checkAll;
	private JCheckBox checkBox ;
	private JRadioButton btRadio1;
	private JRadioButton btRadio2;
	private JRadioButton btRadio3;
	private JRadioButton btRadio4;
	private JRadioButton btRadio5;
	private JRadioButton btRadio6;
	private JRadioButton btRadio7;
	private JRadioButton btRadio8;
	private JRadioButton btRadio9;
	

	/*
	private JCheckBox check_Tumor;
	private JCheckBox check_Granulocyte_nucleus;
	private JCheckBox check_Lymphocyte;
	private JCheckBox check_NucleusDAB;
	private JCheckBox check_NucleusDAB_PRB;
	 */
	private JTextField request;
	private JLabel label;
	private JButton validate;
	private JButton cancel;
	private JPanel containerequest;
    private JMenuItem newCell;
	//private Hashtable<String,String> tableCell = new Hashtable< String,String>();
	private HashMap<String, String> m = new HashMap<String,String>();
	//private enum enumColorCell {black,blue,gray,green,white,orange,red,yellow,pink};

	Menu menu=new Menu();
	Treatment treat=new Treatment();
	JPanel down = new JPanel(new GridLayout(0,1));
	JPanel optionBox = new JPanel();
	JPanel buttonBar = new JPanel();
	JButton btZoomToFit = new JButton("Zoom Off");
	JButton btDisplay=new JButton("Display");
	JLabel Cellule1;
	JLabel Cellule2;
	JLabel Cellule3;
	JLabel Cellule4;
	JLabel Sphericity;
	JLabel Area;
	JLabel Border;
	JPanel panel;
	JPanel paneCellule;
	JPanel paneSphere;
	JPanel paneArea;
	JPanel paneBorder;
	JPanel paneEnd;
	JButton btSup,btInf,btEt,btOu,btOk,btApply;
	JButton btSup2,btInf2,btEt2,btOu2,btSup3,btInf3,btEt3,btOu3;
	JSlider slider;
	JSlider slider2;
	JSlider slider3;
	JTextField sliderDisplay;
	JTextField sliderDisplay2;
	JTextField sliderDisplay3;
	JPanel rubrique1;
	JPanel rubrique2;
	JPanel rubrique3;
	JPanel rubrique4;
	static final int SLIDER_INIT =125 ;
	static final int SLIDER_MIN =0;
	static final int SLIDER_MAX =250;
	ButtonGroup g ;
	mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
	mxGraphComponent graphComponent ;

	SearchFile searchFile ;

	List<Cell> listCells;

	ImageIcon img = new ImageIcon(img_default);
	HashMap<String,JCheckBox> checkBoxes = new HashMap<String,JCheckBox>();


	
	public FramCell() {

		super("Frame Cell!");
		listCells = new ArrayList<Cell>();
  
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setBounds(0, 0, (int)(img.getIconWidth()*0.4), (int)(img.getIconHeight()*0.4));

		graphComponent.setPreferredSize(new Dimension( (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4)));

		graphComponent.setGridVisible(true);
		graphComponent.setGridColor(Color.BLACK);
		graphComponent.setConnectable(false);
		graphComponent.getViewport().setOpaque(true);

		graph.setCellsCloneable(false);
		graph.setCellsDeletable(false);
		graph.setCellsMovable(false);
		graph.setCellsSelectable(false);
		graph.setCellsResizable(false);

		listCells = setListCell(path_current);

		//create color of cell
		MapColorCell();

		optionBox.setLayout(new BorderLayout());   	
		//buttonBar.setLayout(new FlowLayout());

		buttonBar.add(btZoomToFit);



		//Zoom out graph
		final mxGraphOutline graphOutline = new mxGraphOutline(graphComponent);
		graphOutline.setPreferredSize(new Dimension(150, 150));
		optionBox.add(graphOutline, BorderLayout.NORTH);



		//Check Box 
		Border border = BorderFactory.createTitledBorder("Selected Cell");
		down.setBorder(border);
		down.setBackground(Color.BLUE);
		down.setBounds(0, 200, 150, 200);
		down.setOpaque(true);

		//creation des checkbox

		checkAll = new JCheckBox("All cells");
		checkAll.setSelected(true);
		down.add(checkAll);

		for(String key : m.keySet()){

			checkBox = new JCheckBox(key.toString());
			checkBox.setName("CheckBox_" + key.toString());
			checkBox.setSelected(false);
			checkBoxes.put(key.toString(), checkBox);
			down.add(checkBox);
			//System.out.println(checkBox.getName());
		}
		//Ada ButtonDisplay in  down  JPanel
		down.add(btDisplay,BorderLayout.CENTER);

		//Ada JPanel down ie check box in OptionBox JPanel
		optionBox.add(down);
		optionBox.add(buttonBar,BorderLayout.CENTER);//because Zoom is on NORTH
		
		getContentPane().add(graphComponent);

		containerequest = new JPanel();

		Font police = new Font("Arial", Font.BOLD, 14);
		request =new JTextField("Enter Users Request");
		request.setPreferredSize(new Dimension(950, 30));
		request.setForeground(Color.BLUE);
		request.setFont(police);
		label = new JLabel("Request");
		validate=new JButton("Request");
		validate.addActionListener(this);
		cancel=new JButton("Cancel");


		containerequest.add(label);
		containerequest.add(request);
		containerequest.add(validate);
		containerequest.add(cancel);

		getContentPane().add(containerequest,BorderLayout.PAGE_END);


		getContentPane().add(optionBox, BorderLayout.EAST);

		setJMenuBar(menu.buildMenu());

		//Add ActionListener elements				
		menu.getExit().addActionListener(this);
		//menu.getImage_hidden().addActionListener(this);
		//menu.getImage().addActionListener(this);
		menu.getOpen().addActionListener(this);
		//menu.getAddCell().addActionListener(this);
		//menu.getChangeColor().addActionListener(this);
		menu.getCb1().addActionListener(this);
		menu.getCb2().addActionListener(this);
		btZoomToFit.addActionListener(this);
		btDisplay.addActionListener(this);
		treat.addCellWithMap(menu);
		getContentPane().add(graphComponent);

	}


	public void initFrame(){
		graph.getModel().beginUpdate();
		try
		{
			for (Cell c : listCells) {

				Object v1 = graph
						.insertVertex(parent, null, c.getClass_name(),
								c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
								"shape=ellipse;per=ellipsePerimeter;fillColor="
										+ m.get(c.getClass_name()));
			}
		} finally {
			graph.getModel().endUpdate();
		}
		//display background
		graphComponent.setBackgroundImage(new ImageIcon("src/ressources/image0046.jpg"));			
		ImageIcon img = new ImageIcon(img_default);
		img = scale(img_default, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
		graphComponent.setBackgroundImage(img);			

		getContentPane().add(graphComponent);
	}
	public static ImageIcon scale(String source, int width, int height) {

		ImageIcon icon = new ImageIcon(source);
		Image imag = icon.getImage();
		BufferedImage bi = new BufferedImage(imag.getWidth(null), imag.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(imag, 0, 0, width, height, null);
		ImageIcon newIcon = new ImageIcon(bi);
		return newIcon;
	}
	public void changeFrame(String path){


		graph.setCellsDeletable(true);
		this.graph.removeCells(this.graph.getChildVertices(this.parent));
		graph.refresh();
		graph.setCellsDeletable(false);
		listCells.clear();
		listCells = setListCell(path);

		
		graph.getModel().beginUpdate();
		try
		{
			for (Cell c : listCells) {

				Object v2 = graph
						.insertVertex(parent, null, c.getClass_name(),
								c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
								"shape=ellipse;per=ellipsePerimeter;fillColor="
										+ m.get(c.getClass_name()));
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		//display background

		ImageIcon img = new ImageIcon(path_image);
		img = scale(path_image, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
		graphComponent.setBackgroundImage(img);	
		getContentPane().add(graphComponent, BorderLayout.CENTER);

	}
	public void displaySelectedCells(String nameSelected){
		graph.getModel().beginUpdate();
		try
		{
			for (Cell c : listCells) {
				if(c.getClass_name().equals(nameSelected)){

					Object v2 = graph
							.insertVertex(parent, null, c.getClass_name(),
									c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
									"shape=ellipse;per=ellipsePerimeter;fillColor="
											+ m.get(c.getClass_name()));
				}
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}

	}
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == menu.getExit() ){
			FramCell.this.setVisible(false);
		}
		
		if( e.getSource() == menu.getCb2()){
			graphComponent.setBackgroundImage(new ImageIcon("src/ressources/Back_White.png"));			
			getContentPane().add(graphComponent);
			graphComponent.refresh();
			}
		if(e.getSource() == menu.getCb1() ){
			//display or remove image 
			
			ImageIcon img = new ImageIcon(path_image);
			img = scale(path_image, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
			graphComponent.setBackgroundImage(img);			
			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}
		if(e.getSource() == validate){
			JFrame frame2 = new JFrame("Advanced Request");
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setSize(800,1000);
			frame2.setVisible(true);
			frame2.setLayout(new BorderLayout());
			JPanel panel=new JPanel();
			panel.setBackground(Color.white);
			frame2.add(panel);
			//choisir la cellule
			rubrique1 = new JPanel();//contient les cellule
			rubrique1.setPreferredSize(new Dimension(1200,100));
			rubrique1.setBackground(Color.white);
			Cellule1= new JLabel("Choose your Cellule");
		    paneCellule = new JPanel();
		    Border blackline = BorderFactory.createLineBorder(Color.black);
		    paneCellule.setBorder(blackline);
		    paneCellule.setBounds(0, 200, 150, 200);
			paneCellule.setOpaque(true);
			paneCellule.setBackground(Color.white);
			paneCellule.setPreferredSize(new Dimension(600,50));;
			paneCellule.setLayout(new GridLayout(3,3));
		    g =new ButtonGroup();
		    btRadio1= new JRadioButton("AllCells",true);
		    btRadio2= new JRadioButton("NucleusDAB+PRD+");
		    btRadio3= new JRadioButton("Lymphocyte Nucleus");
		    btRadio4= new JRadioButton("Tumor nucleus");
		    btRadio5= new JRadioButton("NucleusPRD+");
		    btRadio6= new JRadioButton("Granulocyte nucleus");
		    btRadio7= new JRadioButton("Nucleus DAB+");
		    btRadio8= new JRadioButton("OO");
		    btRadio9= new JRadioButton("NN");
		   
		    
		    g.add(btRadio1);
		    g.add(btRadio2);
		    g.add(btRadio3);
		    g.add(btRadio4);
			g.add(btRadio4);
			g.add(btRadio5);
			g.add(btRadio6);
			g.add(btRadio7);
			g.add(btRadio8);
			g.add(btRadio9);
			paneCellule.add(btRadio1);
			paneCellule.add(btRadio2);
			paneCellule.add(btRadio3);
			paneCellule.add(btRadio4);
			paneCellule.add(btRadio5);
			paneCellule.add(btRadio6);
			paneCellule.add(btRadio7);
			paneCellule.add(btRadio8);
			paneCellule.add(btRadio9);
			rubrique1.add(Cellule1,BorderLayout.NORTH);
			rubrique1.add(paneCellule,BorderLayout.NORTH);
			//choisir la sphericite
			rubrique2 = new JPanel();//contient les cellule
			rubrique2.setPreferredSize(new Dimension(1200,100));
			rubrique2.setBackground(Color.white);
			Sphericity = new JLabel("Choose your Spherecity");
			paneSphere=new JPanel();
			paneSphere.setLayout(new GridLayout(1,4));
			paneSphere.setBackground(Color.white);
			paneSphere.setPreferredSize(new Dimension(300,30));
			
			btSup2=new JButton("Sup");
	        btInf2=new JButton("Inf");
	        btEt2=new JButton("ET");
			btOu2=new JButton("OU");
		    sliderDisplay2 =new JTextField();
		    sliderDisplay2.setText("Value of slider");
		    sliderDisplay2.setPreferredSize(new Dimension(100,30));
		    sliderDisplay2.setForeground(Color.BLUE);
		    slider2 =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		    slider2.setMajorTickSpacing(50);
		    slider2.setMinorTickSpacing(1);
		    slider2.setPaintTicks(true);
		    slider2.setPaintLabels(true);
		    slider2.addChangeListener(new ChangeListener(){
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                sliderDisplay2.setText(String.valueOf(slider2.getValue()));
	            }
	        });
		    sliderDisplay2.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplay2.getText();
	                slider2.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                slider2.setValue(value);
	            }
	        });
			paneSphere.add(btSup2,BorderLayout.WEST);
			paneSphere.add(btInf2,BorderLayout.CENTER);
			paneSphere.add(btEt2,BorderLayout.WEST);
			paneSphere.add(btOu2,BorderLayout.CENTER);
			//paneSphere.add(slider,BorderLayout.EAST);
			rubrique2.add(Sphericity,BorderLayout.NORTH);
			rubrique2.add(paneSphere,BorderLayout.WEST);
			rubrique2.add(slider2);
			rubrique2.add(sliderDisplay2);
			
			
			
			//choisir la surface
			   
			rubrique3 = new JPanel();//contient les cellule
			rubrique3.setPreferredSize(new Dimension(1200,100));
			rubrique3.setBackground(Color.white);
		    Area = new JLabel("Choose your Area");
			paneArea=new JPanel();
			paneArea.setLayout(new GridLayout(1,4));
			paneArea.setBackground(Color.white);
			paneArea.setPreferredSize(new Dimension(300,30));
			
			btSup=new JButton("Sup");
	        btInf=new JButton("Inf");
	        btEt=new JButton("ET");
			btOu=new JButton("OU");
		    sliderDisplay =new JTextField();
		    sliderDisplay.setText("Value of slider");
		    sliderDisplay.setPreferredSize(new Dimension(100,30));
		    sliderDisplay.setForeground(Color.BLUE);
		    slider =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		    slider.setMajorTickSpacing(50);
		    slider.setMinorTickSpacing(1);
		    slider.setPaintTicks(true);
		    slider.setPaintLabels(true);
		    slider.addChangeListener(new ChangeListener(){
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                sliderDisplay.setText(String.valueOf(slider.getValue()));
	            }
	        });
		    sliderDisplay.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplay.getText();
	                slider.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                slider.setValue(value);
	            }
	        });
			paneArea.add(btSup,BorderLayout.WEST);
			paneArea.add(btInf,BorderLayout.CENTER);
			paneArea.add(btEt,BorderLayout.WEST);
			paneArea.add(btOu,BorderLayout.CENTER);
			
			rubrique3.add(Area,BorderLayout.NORTH);
			rubrique3.add(paneArea,BorderLayout.WEST);
			rubrique3.add(slider);
			rubrique3.add(sliderDisplay);
		
			
			//choisir area
			   
		rubrique4 = new JPanel();//contient les cellule
		rubrique4.setPreferredSize(new Dimension(1200,100));
		rubrique4.setBackground(Color.white);
	    Border= new JLabel("Choose your Border");
	    paneBorder=new JPanel();
		paneBorder.setLayout(new GridLayout(1,4));
		paneBorder.setBackground(Color.white);
		paneBorder.setPreferredSize(new Dimension(300,30));
					
		btSup3=new JButton("Su");
	    btInf3=new JButton("In");
	    btEt3=new JButton("ET");
		btOu3=new JButton("OU");
		sliderDisplay3 =new JTextField();
		sliderDisplay3.setText("Value of slider");
		sliderDisplay3.setPreferredSize(new Dimension(100,30));
	    sliderDisplay3.setForeground(Color.BLUE);
	    slider3 =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		slider3.setMajorTickSpacing(50);
		slider3.setMinorTickSpacing(1);
	    slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
		  slider3.addChangeListener(new ChangeListener(){
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                sliderDisplay3.setText(String.valueOf(slider3.getValue()));
	            }
	        });
		    sliderDisplay3.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplay3.getText();
	                slider3.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                slider3.setValue(value);
	            }
	        });
		paneBorder.add(btSup3,BorderLayout.WEST);
		paneBorder.add(btInf3,BorderLayout.CENTER);
		paneBorder.add(btEt3,BorderLayout.WEST);
		paneBorder.add(btOu3,BorderLayout.CENTER);
					
		rubrique4.add(Border,BorderLayout.NORTH);
		rubrique4.add(paneBorder,BorderLayout.WEST);
		rubrique4.add(slider3);
		rubrique4.add(sliderDisplay3);
				
        paneEnd =new JPanel();
        paneEnd.setPreferredSize(new Dimension(1200,100));
        paneEnd.setBackground(Color.white);
		btOk=new JButton("Ok");
	    btApply=new JButton("Apply");
	    paneEnd.add(btOk,BorderLayout.WEST);
	    paneEnd.add(btApply,BorderLayout.WEST);
	    
			
			
			panel.add(rubrique1);
	        panel.add(rubrique2);
	        panel.add(rubrique3);
	        panel.add(rubrique4);
			panel.add(paneEnd,BorderLayout.SOUTH);
			
			//panel.add(btApply,BorderLayout.SOUTH);
			//panel.add(btOk,BorderLayout.SOUTH);
			
		}
		if(e.getSource() == menu.getOpen()){

			JFileChooser chooser = new JFileChooser();

			chooser.setApproveButtonText("Choose File..."); // intitulé du
			// bouton
			chooser.showOpenDialog(null); // affiche la boite de dialogue
			path_current = chooser.getSelectedFile().getAbsolutePath();
			System.out.println("Path selected current : " + path_current);

			StringTokenizer st = new StringTokenizer(path_current, "."); 

			while (st.hasMoreTokens()) { 

				//System.out.println("token:"+st.nextToken()); 

				String path_initial = st.nextToken();
				System.out.println("path_initial : " + path_initial); 

				String ext=st.nextToken();
				System.out.println("ext : " + ext);

				if(ext.equals("csv")){
					System.out.println("Ceci est un bon fichier ");
					System.out.println(ext);

					//remplace .cvs to jpg
					String newPath1=ext.replace(ext.charAt(0), 'j');
					String newPath2=newPath1.replace(ext.charAt(1), 'p');
					String newPath3=newPath2.replace(ext.charAt(2), 'g');

					// creation de path.jpg
					path_image = path_initial +"."+ newPath3;

					System.out.println("path_image " + path_image);

					// aller chercher path.jpg dans le dossier

					searchFile = new SearchFile(path_image);
					boolean found = searchFile.searchFileImage(searchFile.name, searchFile.filePath);
					if (found ){
						System.out.println("ok found file .jpg ");
						JOptionPane.showMessageDialog(graphComponent, "File .jpn  found ! Name is :"+path_image,"avertissement",
								JOptionPane.WARNING_MESSAGE);
						FramCell.this.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(graphComponent, "File .jpn not found ! Default image is image0046 ",
								"avertissement",
								JOptionPane.ERROR_MESSAGE);
						System.out.println("Ko not found .jpg ");
						path_image = img_default;
						FramCell.this.setVisible(true);
					}

					//if .cvs is found then display new graph
					System.out.println("path using with change Frame"+ path_current);
					changeFrame(path_current);

				}

				else if (!ext.equals("csv")){
					System.out.println("Ceci n'est pas un bon fichier ");

					JOptionPane.showMessageDialog(graphComponent, "File choosen is not expected",
							"avertissement",
							JOptionPane.ERROR_MESSAGE);
					FramCell.this.setVisible(false);


				}

			} 

		}
		if(e.getSource() == btZoomToFit){

			double newScale = 1;

			Dimension graphSize = graphComponent.getGraphControl().getSize();

			Dimension viewPortSize = graphComponent.getViewport().getSize();

			int gw = (int) graphSize.getWidth();
			int gh = (int) graphSize.getHeight();
			System.out.println("size graphSize : " + gw);
			System.out.println("size graphSize : " + gh);

			System.out.println("size viewPortSize : " + (int) viewPortSize.getWidth());
			System.out.println("size viewPortSiee : " + (int) viewPortSize.getHeight());

			if (gw > 0 && gh > 0) {
				int w = (int) viewPortSize.getWidth();
				int h = (int) viewPortSize.getHeight();
				newScale = Math.min((double) w / gw, (double) h / gh);
			}
			graphComponent.zoom(newScale);
			graphComponent.getGraphControl().scrollRectToVisible(new Rectangle(0,0,0,0));
		}
		
		//for(String element : treat.JMenuItems.keySet()){ 
		   if(e.getSource() == treat.JMenuItems.get("Nucleus_PRD+")){
			   
		    	System.out.println("ele:"+ treat.JMenuItems.keySet());
			    System.out.println("loooooooolllll");
			String[] list = {"RED", "GREEN", "BLUE","YELLOW", "BLACK", "WHITE","ORANGE", "PURPLE"};
			JComboBox jcb = new JComboBox(list);
			jcb.setEditable(false);
			jcb.getSelectedItem();
			JOptionPane.showMessageDialog( null, jcb,e.getActionCommand(),JOptionPane.QUESTION_MESSAGE);
			treat.setCellselected(e.getActionCommand());
			System.out.println("chosenCell:" + treat.getCellselected());
			treat.setColor(jcb.getSelectedItem().toString());
			System.out.println("chosenColor:" + treat.getColor());
			treat.changeMap(treat.getCellselected(), treat.getColor());
			changeFrame(path_current);
			
		//}
			
		
		}
	
		if(e.getSource() == btDisplay){
			graph.setCellsDeletable(true);
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);
			if(checkAll.isSelected()){
				changeFrame(path_current);
			}
			for(String p : checkBoxes.keySet()){
				if(checkBoxes.get(p).isSelected()){
					displaySelectedCells(p);
				}}}}
			
	

	
	public List<Cell> setListCell(String path){
		File myFile = new File(path);
		FillCellWithCSV f;
		try {
			f = new FillCellWithCSV(myFile);
			List<Cell> listcells = f.allCells();
			return listcells;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setListCell(path_excel_default);
		}
		return null;



	}

	public void MapColorCell(){
		
		
		
	     m.put("Tumor nucleus","red");
		
		m.put("Granulocyte nucleus", "yellow");
		m.put("Lymphocyte Nucleus", "green");
		m.put("Nucleus DAB+ PRD+", "black");
		//m.put(celselected, color);
		//System.out.println(m.keySet());



	}
	
	
}
