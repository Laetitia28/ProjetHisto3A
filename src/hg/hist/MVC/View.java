package hg.hist.MVC;

import hg.histo.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
	private RequestFrameLaetitia frame2;
	private ControllerRequest contR;

	private Menu menu = new Menu();
	private JPanel down = new JPanel(new GridLayout(0, 1));
	private JPanel optionBox = new JPanel();
	private JPanel buttonBar = new JPanel();
	private JPanel panelContainRequestField = new JPanel(new BorderLayout());;
	private JPanel panelAdvancedRequest = new JPanel(new BorderLayout());

	private JButton btZoomToFit = new JButton("Zoom Off");
	private JButton btDisplay = new JButton("Display");
	private JButton buttonAdvancedRequest = new JButton("Advanced Request");
	private JButton buttonInitRequest = new JButton("Init Request");

	private mxGraph graph = new mxGraph();
	private Object parent = graph.getDefaultParent();
	private mxGraphComponent graphComponent;

	private JFileChooser chooser = new JFileChooser();

	private JCheckBox checkAll = new JCheckBox("All cells");
	private JCheckBox checkBox;

	private JComboBox comboBoxRequest = new JComboBox();

	private JLabel labelTitleRequest = new JLabel("Request : ");
	private Font police = new Font("Arial", Font.BOLD, 14);

	private HashMap<String, JCheckBox> listOfCheckBox = new HashMap<String, JCheckBox>();

	ComboBoxRenderer renderer = new ComboBoxRenderer();

	public View() {

	}

	public View(Controller controller) {

		super("Frame Cell! MVC ");

		comboBoxRequest.setRenderer(renderer);

		this.controller = controller;
		contR = new ControllerRequest();

		// Create mxgraphComponent with properties
		graphComponent = new mxGraphComponent(graph);

		// On va chercher private ImageIcon img de controller
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
		
		graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
			 public void mousePressed(MouseEvent e) {
			      if (e.getClickCount() == 1) {
			        // Get Cell under Mousepointer
			        int x = e.getX(), y = e.getY();
			        
			        Object cell = graphComponent.getCellAt(x, y);
			        // Print Cell Label
			        if (cell != null) {
			        	System.out.println(graph.convertValueToString(cell));
			        	System.out.println("x :"+ x + "y : "+ y);

			        }
			      }
			 }
		
		});
		// create the graph
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
		// down.setBackground(Color.GREEN);
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
			checkBox.setForeground(getController().stringToColor(
					getController().getMapColor().get(key)));
			// checkBox.setBackground(getController().stringToColor(getController().getMapColor().get(key)));
			listOfCheckBox.put(key.toString(), checkBox);
			down.add(checkBox);
		}

		comboBoxRequest.addItem("No Request");
		this.labelTitleRequest.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.labelTitleRequest.setFont(police);
		this.panelContainRequestField.add(labelTitleRequest, BorderLayout.WEST);
		this.panelContainRequestField.add(comboBoxRequest);

		getContentPane().add(panelContainRequestField, BorderLayout.PAGE_END);

		panelAdvancedRequest.add(buttonAdvancedRequest, BorderLayout.NORTH);
		panelAdvancedRequest.add(Box.createRigidArea(new Dimension(5, 15)));
		panelAdvancedRequest.add(buttonInitRequest, BorderLayout.SOUTH);

		// Ada ButtonDisplay in down JPanel
		down.add(btDisplay, BorderLayout.SOUTH);

		setJMenuBar(menu.buildMenu());

		frame2 = new RequestFrameLaetitia(contR, controller.getMaxArea(),
				controller.getMaxSphericity(), controller.getMaxBorder(),
				controller.getMinArea(), controller.getMinSphericity(),
				controller.getMinBorder());

		// Add actionListener
		frame2.getBtClear().addActionListener(this);
		frame2.getBtApply().addActionListener(this);
		frame2.getBtFinish().addActionListener(this);

		for (String key : controller.getMapColor().keySet()) {
			JMenuItem a = new JMenuItem(key.toString());
			a.setName("menuItem_" + key.toString());
			a.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {

					JComboBox comboBox = new JComboBox(getController()
							.getListColor());
					comboBox.setEditable(false);
					comboBox.getSelectedItem();
					JOptionPane.showMessageDialog(null, comboBox,
							event.getActionCommand(),
							JOptionPane.QUESTION_MESSAGE);

					// debug
					System.out.println("chosen Cell : "
							+ event.getActionCommand());
					System.out.println("chosen Color : "
							+ comboBox.getSelectedItem().toString());

					// change mapColor with new value of type cell selected
					getController().changeMapColor(event.getActionCommand(),
							comboBox.getSelectedItem().toString());

					graph.setCellsDeletable(true);
					graph.removeCells(graph.getChildVertices(parent));
					graph.refresh();
					graph.setCellsDeletable(false);

					getController().changeFrame(
							getController().getPath_current(), graph,
							graphComponent);
					for (String key : getController().getMapColor().keySet()) {
						System.out.println("key map :" + key
								+ getController().getMapColor().get(key));
					}

					// change down panel
					for (String key : listOfCheckBox.keySet()) {
						down.remove(listOfCheckBox.get(key));
					}

					down.remove(btDisplay);
					listOfCheckBox.clear();
					for (String key : getController().getMapColor().keySet()) {
						checkBox = new JCheckBox(key.toString());
						checkBox.setName("CheckBox_" + key.toString());
						checkBox.setSelected(false);
						checkBox.setForeground(getController().stringToColor(
								getController().getMapColor().get(key)));
						listOfCheckBox.put(key.toString(), checkBox);
						down.add(checkBox);
					}

					down.add(btDisplay, BorderLayout.CENTER);
					optionBox.add(down);
					optionBox.add(buttonBar, BorderLayout.CENTER);// because
																	// Zoom is
																	// on NORTH
					optionBox.add(panelAdvancedRequest,
							BorderLayout.AFTER_LAST_LINE);
					getContentPane().add(optionBox, BorderLayout.EAST);
					getContentPane().validate();

				}
			});
			menu.getPropertyCells().add(a);
			// Ada JPanel down ie check box in OptionBox JPanel
			optionBox.add(down);
			optionBox.add(buttonBar, BorderLayout.CENTER);// because Zoom is north
			optionBox.add(panelAdvancedRequest, BorderLayout.AFTER_LAST_LINE);
			getContentPane().add(optionBox, BorderLayout.EAST);
		}

		// Add ActionListener elements
		menu.getExit().addActionListener(this);
		menu.getOpen().addActionListener(this);
		menu.getPropertyCells().addActionListener(this);
		menu.getMoreInformations().addActionListener(this);
		this.btZoomToFit.addActionListener(this);
		this.btDisplay.addActionListener(this);
		menu.getRadioButtonMenuItemDisplay().addActionListener(this);
		menu.getRadioButtonMenuItemHidden().addActionListener(this);
		buttonInitRequest.addActionListener(this);
		buttonAdvancedRequest.addActionListener(this);

		getContentPane().add(graphComponent);
	}

	class ComboBoxRenderer extends DefaultListCellRenderer {

		private static final long serialVersionUID = 1L;

		public ComboBoxRenderer() {
			setOpaque(true);
		}

		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {

			JLabel c = (JLabel) super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);

			if (value.toString().equals("Next")) {
				c.setBackground(Color.GRAY);
			}

			return this;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == menu.getExit()) {
			this.setVisible(false);
		}

		// Search New File
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
				checkBox.setForeground(getController().stringToColor(
						getController().getMapColor().get(key)));
				listOfCheckBox.put(key.toString(), checkBox);
				down.add(checkBox);
			}
			down.add(btDisplay, BorderLayout.CENTER);
			menu.getPropertyCells().removeAll();

			for (String key : controller.getMapColor().keySet()) {
				JMenuItem a = new JMenuItem(key.toString());
				a.setName("menuItem_" + key.toString());
				a.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {

						JComboBox comboBox = new JComboBox(getController()
								.getListColor());
						comboBox.setEditable(false);
						comboBox.getSelectedItem();
						JOptionPane.showMessageDialog(null, comboBox,
								event.getActionCommand(),
								JOptionPane.QUESTION_MESSAGE);

						// debug
						System.out.println("chosen Cell : "
								+ event.getActionCommand());
						System.out.println("chosen Color : "
								+ comboBox.getSelectedItem().toString());

						// change mapColor with new value of type cell selected
						getController().changeMapColor(
								event.getActionCommand(),
								comboBox.getSelectedItem().toString());

						graph.setCellsDeletable(true);
						graph.removeCells(graph.getChildVertices(parent));
						graph.refresh();
						graph.setCellsDeletable(false);
						getController().changeFrame(
								getController().getPath_current(), graph,
								graphComponent);

						// change down panel
						for (String key : listOfCheckBox.keySet()) {
							down.remove(listOfCheckBox.get(key));
						}

						down.remove(btDisplay);
						listOfCheckBox.clear();
						for (String key : getController().getMapColor()
								.keySet()) {
							checkBox = new JCheckBox(key.toString());
							checkBox.setName("CheckBox_" + key.toString());
							checkBox.setSelected(false);
							checkBox.setForeground(getController()
									.stringToColor(
											getController().getMapColor().get(
													key)));
							listOfCheckBox.put(key.toString(), checkBox);
							down.add(checkBox);
						}

						down.add(btDisplay, BorderLayout.CENTER);
						optionBox.add(down);
						optionBox.add(buttonBar, BorderLayout.CENTER);// because
																		// Zoom
																		// is on
																		// NORTH
						optionBox.add(panelAdvancedRequest,
								BorderLayout.AFTER_LAST_LINE);
						getContentPane().add(optionBox, BorderLayout.EAST);
						getContentPane().validate();
					}
				});
				menu.getPropertyCells().add(a);

			}
		}

		// Zoom
		if (e.getSource() == btZoomToFit) {
			graphComponent.zoom(controller.newScale(graphComponent));
			graphComponent.getGraphControl().scrollRectToVisible(
					new Rectangle(0, 0, 0, 0));
		}

		// Hide BakcGround
		if (e.getSource() == menu.getRadioButtonMenuItemHidden()) {
			System.out.println("Hidden");

			graphComponent.setBackgroundImage(new ImageIcon(this.getClass()
					.getClassLoader().getResource("ressources/Back_White.png")
					.getFile()));
			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}

		// Display BackGround
		if (e.getSource() == menu.getRadioButtonMenuItemDisplay()) {

			// debug
			System.out.println("Display");
			System.out.println("getpath_image : " + controller.getPath_image());

			ImageIcon img;
			if (!(controller.getPath_image())
					.equals("ressources/image0046.jpg")) {
				img = new ImageIcon(controller.getPath_image());
			} else {
				img = new ImageIcon(this.getClass().getClassLoader()
						.getResource("ressources/image0046.jpg"));
			}
			img = controller.scale(controller.getPath_image(),
					(int) (img.getIconWidth() * 0.4),
					(int) (img.getIconHeight() * 0.4));

			graphComponent.setBackgroundImage(img);

			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}

		// Show cells selected
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

		// open new Frame
		if (e.getSource() == buttonAdvancedRequest) {

			frame2.init(controller.getMaxArea(), controller.getMaxSphericity(),
					controller.getMaxBorder(), controller.getMinArea(),
					controller.getMinSphericity(), controller.getMinBorder(),
					controller.getMapColor());
			frame2.setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}

		// remove Cells button InitRequest
		if (e.getSource() == buttonInitRequest) {

			while (comboBoxRequest.getItemCount() > 0) {
				comboBoxRequest.removeItemAt(0);
			}
			comboBoxRequest.addItem("No Request");
			graph.setCellsDeletable(true);
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);

			controller.changeFrame(controller.getPath_current(), graph,
					graphComponent);

		}

		if (e.getSource() == frame2.getBtClear()) {

			while (comboBoxRequest.getItemCount() > 0) {
				comboBoxRequest.removeItemAt(0);
			}
			comboBoxRequest.addItem("No Request");

			// earse graph
			graph.setCellsDeletable(true);
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);

			controller.changeFrame(controller.getPath_current(), graph,
					graphComponent);
		}

		if (e.getSource() == frame2.getBtFinish()) {
			System.out.println("Finist Main frame");

			// buttonAdvancedRequest.setEnabled(true);

		}

		if (e.getSource() == menu.getMoreInformations()) {
			// debug
			System.out.println("more informations");

			String a = "";
			for (String key : getController().getMapColor().keySet()) {
				a = a + "There are "
						+ getController().giveMeInformations().get(key) + " "
						+ key + " in " + getController().getMapColor().get(key)
						+ " color " + "\n";
			}
			JOptionPane.showMessageDialog(View.this, "Informations : \n" + a);

		}

		// treat request
		if (e.getSource() == frame2.getBtApply()) {
			System.out.println("Main Fram");

			// earse graph
			graph.setCellsDeletable(true);
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);

			frame2.checkButtons();

			boolean found = false;

			getController().sortListFromRequest(
					frame2.getContR().getListRequested(), this.graph,
					frame2.getBtCheck_AllCell().isSelected());

			comboBoxRequest.addItem("Next");
			for (CellRequested cr : frame2.getContR().getListRequested()) {
				if (cr.isSelected()) {
					found = true;
					comboBoxRequest.addItem(cr.toShow());
				}
			}
			if (found == true) {
				comboBoxRequest.removeItem("No Request");
			}
		}
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
