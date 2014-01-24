package hg.hist.MVC;

import hg.histo.Cell;
import hg.histo.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
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
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.view.mxGraph;

public class View extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Controller controller;
	RequestFram frame2 = new RequestFram();

	private Menu menu = new Menu();
	private JPanel down = new JPanel(new GridLayout(0, 1));
	private JPanel optionBox = new JPanel();
	private JPanel buttonBar = new JPanel();
	private JPanel panelContainRequestField = new JPanel();;
	private JPanel panelAdvancedRequest = new JPanel();

	private JButton btZoomToFit = new JButton("Zoom Off");
	private JButton btDisplay = new JButton("Display");
	private JButton buttonAdvancedRequest = new JButton("Advanced Request");
	private JButton buttonCancel = new JButton("Cancel");
	private JButton buttonGo = new JButton("Go");

	private mxGraph graph = new mxGraph();
	private Object parent = graph.getDefaultParent();
	private mxGraphComponent graphComponent;

	private JFileChooser chooser = new JFileChooser();

	private JCheckBox checkAll = new JCheckBox("All cells");
	private JCheckBox checkBox;

	private JTextField textFieldRequest = new JTextField("Enter Users Requests");
	private JLabel label = new JLabel("Request");
	private String stringRequest;

	private Font police = new Font("Arial", Font.BOLD, 14);

	private HashMap<String, JMenuItem> JMenuItems = new HashMap<String, JMenuItem>();
	private HashMap<String, JCheckBox> listOfCheckBox = new HashMap<String, JCheckBox>();

	public View(Controller controller) {
		super("Frame Cell! MVC ");
		this.controller = controller;

		// Create mxgraphComponent with properties
		graphComponent = new mxGraphComponent(graph);
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

		// create list of cells
		controller.setListCell(controller.getPath_current());

		// create color of cell
		controller.MapColorCell();

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
		down.setBackground(Color.GREEN);
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
			listOfCheckBox.put(key.toString(), checkBox);
			down.add(checkBox);
		}

		panelContainRequestField.add(label);
		panelContainRequestField.add(textFieldRequest);
		panelContainRequestField.add(buttonGo);
		panelContainRequestField.add(buttonCancel);

		getContentPane().add(panelContainRequestField, BorderLayout.PAGE_END);

		panelAdvancedRequest.add(buttonAdvancedRequest);

		// Ada ButtonDisplay in down JPanel
		down.add(btDisplay, BorderLayout.CENTER);

		// Ada JPanel down ie check box in OptionBox JPanel
		optionBox.add(down);
		optionBox.add(buttonBar, BorderLayout.CENTER);// because Zoom is on
														// NORTH
		optionBox.add(panelAdvancedRequest, BorderLayout.AFTER_LAST_LINE);

		getContentPane().add(optionBox, BorderLayout.EAST);
		setJMenuBar(menu.buildMenu());

		// Add actionListener au btApply

		frame2.getBtApply().addActionListener(this);
		this.textFieldRequest.setPreferredSize(new Dimension(950, 30));
		this.textFieldRequest.setForeground(Color.BLUE);
		this.textFieldRequest.setFont(police);
		this.textFieldRequest.setText("No request advanced");

		// Add ActionListener elements
		menu.getExit().addActionListener(this);
		menu.getOpen().addActionListener(this);
		menu.getPropertyCells().addActionListener(this);
		this.btZoomToFit.addActionListener(this);
		this.btDisplay.addActionListener(this);
		menu.getRadioButtonMenuItemDisplay().addActionListener(this);
		menu.getRadioButtonMenuItemHidden().addActionListener(this);
		buttonGo.addActionListener(this);
		buttonAdvancedRequest.addActionListener(this);

		getContentPane().add(graphComponent);
	}

	public View() {

	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == menu.getExit()) {
			this.setVisible(false);
		}

		if (e.getSource() == menu.getOpen()) {
			chooser.showOpenDialog(null);
			chooser.setApproveButtonText("Choose File...");
			controller.ChangeFile(chooser, graphComponent, graph);
			for (String key : listOfCheckBox.keySet()) {
				down.remove(listOfCheckBox.get(key));
			}

			down.remove(btDisplay);
			listOfCheckBox.clear();
			for (String key : controller.getMapColor().keySet()) {
				checkBox = new JCheckBox(key.toString());
				// checkBox.setName("CheckBox_" + key.toString());
				checkBox.setSelected(false);
				listOfCheckBox.put(key.toString(), checkBox);
				// System.out.println("key : "+key);
				down.add(checkBox);
			}
			down.add(btDisplay, BorderLayout.CENTER);
			this.setVisible(true);

			JMenuItems.clear();

			controller.ChangeColorOfCell(menu, getJMenuItems());

			for (String a : getJMenuItems().keySet()) {
				System.out.println("jk : " + a);
			}
			for (String a : getJMenuItems().keySet()) {
				getJMenuItems().get(a).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						String[] list = { "red", "green", "blue", "yellow",
								"black", "white", "orange", "purple" };
						JComboBox jcb = new JComboBox(list);
						jcb.setEditable(false);
						jcb.getSelectedItem();
						JOptionPane.showMessageDialog(null, jcb,
								event.getActionCommand(),
								JOptionPane.QUESTION_MESSAGE);
						getController().setCellselected(
								event.getActionCommand());
						System.out.println("chosenCell:"
								+ getController().getCellselected());
						getController().setColor(
								jcb.getSelectedItem().toString());
						System.out.println("chosenColor:"
								+ getController().getColor());
						getController().changeMap(
								getController().getCellselected(),
								getController().getColor());
						getController().displaySelectedCells(
								getController().getCellselected(), graph);
					}
				});
			}

		}
		if (e.getSource() == btZoomToFit) {
			graphComponent.zoom(controller.newScale(graphComponent));
			graphComponent.getGraphControl().scrollRectToVisible(
					new Rectangle(0, 0, 0, 0));
		}
		if (e.getSource() == menu.getRadioButtonMenuItemHidden()) {
			System.out.println("Display");
			graphComponent.setBackgroundImage(new ImageIcon(
					"src/ressources/Back_White.png"));
			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}
		if (e.getSource() == menu.getRadioButtonMenuItemDisplay()) {
			System.out.println("Hidden");
			ImageIcon img = new ImageIcon(controller.getPath_image());
			img = Controller.scale(controller.getPath_image(),
					(int) (img.getIconWidth() * 0.4),
					(int) (img.getIconHeight() * 0.4));
			graphComponent.setBackgroundImage(img);
			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}
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
		if (e.getSource() == buttonAdvancedRequest) {
			frame2.setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
		if (e.getSource() == frame2.getBtApply()) {

			System.out.println("Je suis dans le champs text");
			setStringRequest(frame2.getStringTypeCell() + ":"
					+ frame2.getStringAreaSup() + ":"
					+ frame2.getStringAreaInf() + ":"
					+ frame2.getStringSphericitySup() + ":"
					+ frame2.getStringSphericityInf() + ":"
					+ frame2.getStringBorderSup() + ":"
					+ frame2.getStringBorderInf());

			this.textFieldRequest.setText("Type of Cell : "
					+ frame2.getStringTypeCell() + "; Area : Sup "
					+ frame2.getStringAreaSup() + " and Inf "
					+ frame2.getStringAreaInf() + "; Sphericity : Sup "
					+ frame2.getStringSphericitySup() + " and Inf "
					+ frame2.getStringSphericityInf() + "; Border : Sup "
					+ frame2.getStringBorderSup() + " and Inf "
					+ frame2.getStringBorderInf());
			// tester le type de cellules
			// methode pour avce type de champs
			// recuperer la liste
			List<Cell> listRequestFram = new ArrayList<Cell>();
			for(Cell c : controller.getListCells()){
				if(c.getClass_name().equals(frame2.getStringTypeCell())){
					System.out.println("Type cell selected is "
							+ c.getClass_name());	
					listRequestFram.add(c);
				}
				else {
					System.out.println("Type cell selected is "
							+frame2.getStringTypeCell());
					listRequestFram=controller.getListCells();
				}
				
			}
			listRequestFram = controller.SortListCell("Border",  frame2.getStringBorderSup(),  frame2.getStringBorderInf(), listRequestFram);
			listRequestFram = controller.SortListCell("Area",  frame2.getStringAreaSup(),  frame2.getStringAreaInf(), listRequestFram);
			listRequestFram = controller.SortListCell("Sphericity",  frame2.getStringSphericitySup(),  frame2.getStringSphericityInf(), listRequestFram);

		
			
		}

	}

	public HashMap<String, JMenuItem> getJMenuItems() {
		return JMenuItems;
	}

	public void setJMenuItems(HashMap<String, JMenuItem> jMenuItems) {
		JMenuItems = jMenuItems;
	}

	public String getStringRequest() {
		return stringRequest;
	}

	public void setStringRequest(String stringRequest) {
		this.stringRequest = stringRequest;
	}
}
