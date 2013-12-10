package hg.hist.MVC;

import hg.histo.Cell;
import hg.histo.FramCell;
import hg.histo.Menu;
import hg.histo.SearchFile;
import hg.histo.Treatment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.view.mxGraph;

public class View extends JFrame implements Observer, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Controller controller;
	
	private String img_default = "src/ressources/image0046.jpg";
	private String path_image = img_default;
	private String path_excel_default = "src/ressources/image0046.csv";
	private String path_current = path_excel_default;
	
	private HashMap<String, String> m = new HashMap<String,String>();

	private Menu menu=new Menu();
	private Treatment treat=new Treatment();
	private JPanel down = new JPanel(new GridLayout(0,1));
	private JPanel optionBox = new JPanel();
	private JPanel buttonBar = new JPanel();
	private JButton btZoomToFit = new JButton("Zoom Off");
	private JButton btDisplay=new JButton("Display");
	
	private mxGraph graph = new mxGraph();
	private Object parent = graph.getDefaultParent();
	private mxGraphComponent graphComponent ;

	
	
	
	private SearchFile searchFile ;
	private List<Cell> listCells;
	private ImageIcon img = new ImageIcon(img_default);
	private HashMap<String,JCheckBox> checkBoxes = new HashMap<String,JCheckBox>();
	
	
	
	

	public View(Controller controller)  {
		super("Frame Cell!");
		this.controller = controller;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setVisible(true);

		//Create a list of Cell
		listCells = new ArrayList<Cell>();
  
		//Create mxgraphComponent with properties
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setBounds(0, 0, (int)(img.getIconWidth()*0.4), (int)(img.getIconHeight()*0.4));
		graphComponent.setPreferredSize(new Dimension( (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4)));
		graphComponent.setGridVisible(true);
		graphComponent.setGridColor(Color.BLACK);
		graphComponent.setConnectable(false);
		graphComponent.getViewport().setOpaque(true);

		//Options of mxGraph
		graph.setCellsCloneable(false);
		graph.setCellsDeletable(false);
		graph.setCellsMovable(false);
		graph.setCellsSelectable(false);
		graph.setCellsResizable(false);

		/*
		listCells = setListCell(path_current);

		//create color of cell
		MapColorCell();
*/
		
		optionBox.setLayout(new BorderLayout());   	
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

	

		//Ada ButtonDisplay in  down  JPanel
		down.add(btDisplay,BorderLayout.CENTER);

		//Ada JPanel down ie check box in OptionBox JPanel
		optionBox.add(down);
		optionBox.add(buttonBar,BorderLayout.CENTER);//because Zoom is on NORTH
		
		getContentPane().add(optionBox, BorderLayout.EAST);

		setJMenuBar(menu.buildMenu());

		//Add ActionListener elements				
		menu.getExit().addActionListener(this);
		menu.getChangeColor().addActionListener(this);
		btZoomToFit.addActionListener(this);
		btDisplay.addActionListener(this);
		
		
		treat.addCellWithMap(menu);
		getContentPane().add(graphComponent);
		
		

	
	}

	@Override
	public void update(Observable o, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.getExit() ){
			this.setVisible(false);
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
						this.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(graphComponent, "File .jpn not found ! Default image is image0046 ",
								"avertissement",
								JOptionPane.ERROR_MESSAGE);
						System.out.println("Ko not found .jpg ");
						path_image = img_default;
						this.setVisible(true);
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
					this.setVisible(false);


				}

			} 

		}
		
	}

	
}
