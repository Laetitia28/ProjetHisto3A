package hg.hist.MVC;

import hg.histo.Menu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.view.mxGraph;

public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Controller controller;
	private RequestFram frame2;

	private Menu menu = new Menu();
	private JPanel down = new JPanel(new GridLayout(0, 1));
	private JPanel optionBox = new JPanel();
	private JPanel buttonBar = new JPanel();
	private JPanel panelContainRequestField = new JPanel(new BorderLayout());;
	private JPanel panelAdvancedRequest = new JPanel(new BorderLayout());

	private JButton btZoomToFit = new JButton("Zoom Off");
	private JButton btDisplay = new JButton("Display");
	private JButton buttonAdvancedRequest = new JButton("Advanced Request");
	private JButton buttonClear = new JButton("Init Request");


	private mxGraph graph = new mxGraph();
	private Object parent = graph.getDefaultParent();
	private mxGraphComponent graphComponent;

	private JFileChooser chooser = new JFileChooser();

	private JCheckBox checkAll = new JCheckBox("All cells");
	private JCheckBox checkBox;

	
	//private JTextField textFieldRequest = new JTextField("Enter Users Requests");
	private JLabel textFieldRequest = new JLabel("Enter Users Requests");
	
	private JLabel labelTitleRequest = new JLabel("Request : ");
	private String stringRequest;

	private Font police = new Font("Arial", Font.BOLD, 14);

	//private HashMap<String, JMenuItem> JMenuItems = new HashMap<String, JMenuItem>();
	private HashMap<String, JCheckBox> listOfCheckBox = new HashMap<String, JCheckBox>();

	public View() {

	}

	public View(Controller controller) {
		super("Frame Cell! MVC ");

		this.controller = controller;

		
		// Create mxgraphComponent with properties
		graphComponent = new mxGraphComponent(graph);
		
		//On va chercher private ImageIcon img  de controller
		graphComponent.setBounds(0, 0, (int) (controller.getImg()
				.getIconWidth() * 0.4), (int) (controller.getImg()
				.getIconHeight() * 0.4));
		graphComponent.setPreferredSize(new Dimension((int) (controller
				.getImg().getIconWidth() * 0.4), (int) (controller.getImg()
				.getIconHeight() * 0.4)));
		graphComponent.setGridVisible(true);
		graphComponent.setGridColor(Color.BLACK);
		graphComponent.setConnectable(false);
		graphComponent.getViewport().setOpaque(true);

		// Options of mxGraph
		graph.setCellsCloneable(false);
		graph.setCellsDeletable(false);
		graph.setCellsMovable(false);
		graph.setCellsSelectable(false);
		graph.setCellsResizable(false);

		//create the graph
		controller.initFrame(graph, graphComponent);
		
		
		optionBox.setLayout(new BorderLayout());
		optionBox.setPreferredSize(new Dimension(200, 200));
		buttonBar.add(btZoomToFit);

		// Zoom out graph
		final mxGraphOutline graphOutline = new mxGraphOutline(graphComponent);
		graphOutline.setPreferredSize(new Dimension(150, 150));
		optionBox.add(graphOutline, BorderLayout.NORTH);

		// Check Box
		Border border = BorderFactory.createTitledBorder("Selected Cell");
		down.setBorder(border);
		//down.setBackground(Color.GREEN);
		down.setBounds(0, 200, 200, 300);
		down.setOpaque(true);
		down.setLayout(new GridLayout(10, 1));

		checkAll.setSelected(true);
		down.add(checkAll);

		// Check Box
		for (String key : controller.getMapColor().keySet()) {
			checkBox = new JCheckBox(key.toString());
			checkBox.setName("CheckBox_" + key.toString());
			checkBox.setSelected(false);
			checkBox.setForeground(getController().stringToColor(getController().getMapColor().get(key)));
			//checkBox.setBackground(getController().stringToColor(getController().getMapColor().get(key)));
			listOfCheckBox.put(key.toString(), checkBox);
			down.add(checkBox);
		}
		
		this.labelTitleRequest.setBorder(new EmptyBorder(0,10,0,0));
		this.labelTitleRequest.setFont(police);
		panelContainRequestField.add(labelTitleRequest,BorderLayout.WEST);
		panelContainRequestField.add(textFieldRequest);

		getContentPane().add(panelContainRequestField, BorderLayout.PAGE_END);

		panelAdvancedRequest.add(buttonAdvancedRequest,BorderLayout.NORTH);
		panelAdvancedRequest.add(Box.createRigidArea(new Dimension(5,15)));
		panelAdvancedRequest.add(buttonClear,BorderLayout.SOUTH);

		// Ada ButtonDisplay in down JPanel
		down.add(btDisplay, BorderLayout.CENTER);

		// Ada JPanel down ie check box in OptionBox JPanel
		optionBox.add(down);
		optionBox.add(buttonBar, BorderLayout.CENTER);// because Zoom is on NORTH
		optionBox.add(panelAdvancedRequest, BorderLayout.AFTER_LAST_LINE);

		getContentPane().add(optionBox, BorderLayout.EAST);
		setJMenuBar(menu.buildMenu());

		//frame2 = new RequestFram();
		frame2 =  new RequestFram(controller.getMaxArea(),controller.getMaxSphericity(),controller.getMaxBorder(),controller.getMinArea(),controller.getMinSphericity(),controller.getMinBorder());
		
		// Add actionListener au btApply
		frame2.getBtClear().addActionListener(this);
		frame2.getBtApply().addActionListener(this);
		
		this.textFieldRequest.setPreferredSize(new Dimension(900, 40));
		this.textFieldRequest.setForeground(Color.BLUE);
		this.textFieldRequest.setFont(police);
		this.textFieldRequest.setText("No request advanced");

		
		for(String key : controller.getMapColor().keySet()){
			JMenuItem a = new JMenuItem(key.toString());
			a.setName("menuItem_"+key.toString());
			a.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {

					JComboBox comboBox = new JComboBox(getController().getListColor());
					comboBox.setEditable(false);
					comboBox.getSelectedItem();
					JOptionPane.showMessageDialog(null, comboBox, event.getActionCommand(),JOptionPane.QUESTION_MESSAGE);
					
					//debug
					System.out.println("chosen Cell : "+event.getActionCommand() );
					System.out.println("chosen Color : " + comboBox.getSelectedItem().toString());
					
					//change mapColor with new value of type cell selected
					getController().changeMapColor(event.getActionCommand(),comboBox.getSelectedItem().toString());
					graph.setCellsDeletable(true);
					graph.removeCells(graph.getChildVertices(parent));
					graph.refresh();
					graph.setCellsDeletable(false);
					getController().changeFrame(getController().getPath_current(), graph,graphComponent);
				}
			});
			menu.getPropertyCells().add(a);
			
		}
		
		// Add ActionListener elements
		menu.getExit().addActionListener(this);
		menu.getOpen().addActionListener(this);
		menu.getPropertyCells().addActionListener(this);
		this.btZoomToFit.addActionListener(this);
		this.btDisplay.addActionListener(this);
		menu.getRadioButtonMenuItemDisplay().addActionListener(this);
		menu.getRadioButtonMenuItemHidden().addActionListener(this);
		buttonClear.addActionListener(this);
		buttonAdvancedRequest.addActionListener(this);

		getContentPane().add(graphComponent);
	}




	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == menu.getExit()) {
			this.setVisible(false);
		}
		
		//Search New File
		if (e.getSource() == menu.getOpen()) {
			
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setApproveButtonText("Choose File...");
			
			controller.ChangeFile(chooser, graphComponent, graph);
			for (String key : listOfCheckBox.keySet()) {
				down.remove(listOfCheckBox.get(key));
			}

			down.remove(btDisplay);
			listOfCheckBox.clear();
			for (String key : controller.getMapColor().keySet()) {
				checkBox = new JCheckBox(key.toString());
				checkBox.setName("CheckBox_" + key.toString());
				checkBox.setSelected(false);
				checkBox.setForeground(getController().stringToColor(getController().getMapColor().get(key)));
				listOfCheckBox.put(key.toString(), checkBox);
				// System.out.println("key : "+key);
				down.add(checkBox);
			}
			down.add(btDisplay, BorderLayout.CENTER);
			this.setVisible(true);

			menu.getPropertyCells().removeAll();
		
			for(String key : controller.getMapColor().keySet()){
				JMenuItem a = new JMenuItem(key.toString());
				a.setName("menuItem_"+key.toString());
				a.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent event) {

						JComboBox comboBox = new JComboBox(getController().getListColor());
						comboBox.setEditable(false);
						comboBox.getSelectedItem();
						JOptionPane.showMessageDialog(null, comboBox, event.getActionCommand(),JOptionPane.QUESTION_MESSAGE);
						
						//debug
						System.out.println("chosen Cell : "+event.getActionCommand() );
						System.out.println("chosen Color : " + comboBox.getSelectedItem().toString());
						
						//change mapColor with new value of type cell selected
						getController().changeMapColor(event.getActionCommand(),comboBox.getSelectedItem().toString());
						graph.setCellsDeletable(true);
						graph.removeCells(graph.getChildVertices(parent));
						graph.refresh();
						graph.setCellsDeletable(false);
						getController().changeFrame(getController().getPath_current(), graph,graphComponent);
					}
				});
				menu.getPropertyCells().add(a);
				
			}
		}
		
		//Zoom
		if (e.getSource() == btZoomToFit) {
			graphComponent.zoom(controller.newScale(graphComponent));
			graphComponent.getGraphControl().scrollRectToVisible(
					new Rectangle(0, 0, 0, 0));
		}
		
		//Hide BakcGround
		if (e.getSource() == menu.getRadioButtonMenuItemHidden()) {
			System.out.println("Hidden");
			
			graphComponent.setBackgroundImage(new ImageIcon(this.getClass().getClassLoader().getResource("ressources/Back_White.png").getFile()));
			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}
		
		//Display BackGround
		if (e.getSource() == menu.getRadioButtonMenuItemDisplay()) {
			
			//debug
			System.out.println("Display");
			System.out.println("getpath_image : " + controller.getPath_image());
			
			ImageIcon img;
			if(!(controller.getPath_image()).equals("ressources/image0046.jpg")){
				img = new ImageIcon(controller.getPath_image());
			}
			else{
				img = new ImageIcon(this.getClass().getClassLoader().getResource("ressources/image0046.jpg"));
			}
			img = controller.scale(controller.getPath_image(), (int) (img.getIconWidth() * 0.4),
					(int) (img.getIconHeight() * 0.4));
			
			graphComponent.setBackgroundImage(img);
			
			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}
		
		//Show cells selected
		if (e.getSource() == btDisplay) {

			graph.setCellsDeletable(true);
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);
			if (checkAll.isSelected()) {
				controller.changeFrame(controller.getPath_current(), graph,
						graphComponent);
			}
			for (String p : listOfCheckBox.keySet()) {
				if (listOfCheckBox.get(p).isSelected()) {
					controller.displaySelectedCells(p, graph);
				}
			}
		}
		
		//open new Frame
		if (e.getSource() == buttonAdvancedRequest) {
			
			frame2.init(controller.getMaxArea(), controller.getMaxSphericity(), controller.getMaxBorder(),controller.getMinArea(), controller.getMinSphericity(), controller.getMinBorder(),controller.getMapColor());
			
			frame2.setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
		
		//Clear the selection of FrameRequest + remove Cells
		if(e.getSource() == buttonClear){
			
			textFieldRequest.setText("No Request ");

			controller.getTemp().clear();
			
			graph.setCellsDeletable(true);
			
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);
			
			controller.changeFrame(controller.getPath_current(), graph,graphComponent);
		}
		
		//Clear the selection of FrameRequest + remove Cells
		if(e.getSource() == frame2.getBtClear()){

			textFieldRequest.setText("No Request ");
			
			//Clear list 
			controller.getTemp().clear();
			
			graph.setCellsDeletable(true);
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);
			
			controller.changeFrame(controller.getPath_current(), graph,graphComponent);
			
		}

		
		//treat request
		if (e.getSource() == frame2.getBtApply()) {

			
			setStringRequest(frame2.getStringTypeCell() + "Type  "
					+ frame2.getStringAreaSup() + " Area Sup  "
					+ frame2.getStringAreaInf() + " Area Inf  "
					+ frame2.getStringSphericitySup() + " Shpericity Sup  "
					+ frame2.getStringSphericityInf() + " Sphericity Inf  "
					+ frame2.getStringBorderSup() + " Border Sup  "
					+ frame2.getStringBorderInf()+ " Border Inf  ");
			//degub
			System.out.println("Je suis dans le champs text ; "+ getStringRequest());
			
			this.textFieldRequest.setText("Type of Cell : "
					+ frame2.getStringTypeCell() + " ; Area : Sup "
					+ frame2.getStringAreaSup() + " and Inf "
					+ frame2.getStringAreaInf() + "; Sphericity : Sup "
					+ frame2.getStringSphericitySup() + " and Inf "
					+ frame2.getStringSphericityInf() + "; Border : Sup "
					+ frame2.getStringBorderSup() + " and Inf "
					+ frame2.getStringBorderInf());
			
			graph.setCellsDeletable(true);
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);
			
			controller.secondSortListCell(frame2.getStringBorderSup(), frame2.getStringBorderInf(), frame2.getStringSphericitySup(), frame2.getStringBorderInf(), frame2.getStringAreaSup(), frame2.getStringAreaInf(), frame2.getStringTypeCell(),this.graph);
	
			
		}

	}

	public String getStringRequest() {
		return stringRequest;
	}

	public void setStringRequest(String stringRequest) {
		this.stringRequest = stringRequest;
	}
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
